package br.com.orlandoburli.euvouromper.model.be.ecommerce.cliente;

import java.math.BigDecimal;
import java.util.List;

import br.com.orlandoburli.euvouromper.model.be.admin.LoginInvalidoException;
import br.com.orlandoburli.euvouromper.model.be.ecommerce.EmailBe;
import br.com.orlandoburli.euvouromper.model.be.ecommerce.exceptions.ClienteInexistenteException;
import br.com.orlandoburli.euvouromper.model.be.ecommerce.exceptions.EmailException;
import br.com.orlandoburli.euvouromper.model.dao.ecommerce.cliente.ClienteDao;
import br.com.orlandoburli.euvouromper.model.domains.SimNao;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.TipoCadastro;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.cliente.ClienteSaldoVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.cliente.ClienteVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.InsertBeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.SaveBeException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.utils.Utils;

public class ClienteBe extends BaseBe<ClienteVo, ClienteDao> {

	public ClienteBe(DAOManager manager) {
		super(manager);
	}

	public ClienteVo login(String email, String senha) throws ListException, LoginInvalidoException {

		ClienteVo cliente = getByEmail(email);

		if (cliente != null) {
			if (cliente.getEmail().equalsIgnoreCase(email) && cliente.getSenha().equals(senha)) {
				return cliente;
			}
		}

		throw new LoginInvalidoException("Email / Senha inválidos!", "email");
	}

	@Override
	public void doBeforeSave(ClienteVo vo) throws BeException {
		super.doBeforeSave(vo);

		if (vo.getTipoCadastro().equals(TipoCadastro.EMAIL)) {
			if (vo.getSenha() == null || vo.getSenha().trim().equals("")) {
				throw new SaveBeException("Campo senha é obrigatório!", "senha");
			} else if (vo.getSenha().trim().length() < 3) {
				throw new SaveBeException("Campo senha deve ter pelo menos 3 caracteres!", "senha");
			}
		}
	}

	@Override
	public void doBeforeInsert(ClienteVo vo) throws BeException {
		super.doBeforeInsert(vo);

		// Verifica se ja existe email com esse cadastro

		ClienteVo temp;
		try {
			temp = getByEmail(vo.getEmail());

			if (temp != null) {
				throw new InsertBeException("Já existe o email " + vo.getEmail() + " cadastrado!", "email");
			}
		} catch (ListException e) {
			Log.error(e);
			throw new InsertBeException(e.getMessage(), e.getField());
		}

		if (vo.getTipoCadastro().equals(TipoCadastro.EMAIL)) {
			if (vo.getConfSenha() == null || vo.getConfSenha().trim().equals("")) {
				throw new InsertBeException("Campo confirmação senha é obrigatório!", "confSenha");
			}

			if (vo.getSenha() != null) {
				if (!vo.getSenha().equals(vo.getConfSenha())) {
					throw new InsertBeException("Campo senha e confirmação da senha devem ser iguais!", "senha");
				}
			}
		}

		// Seta o hash do cliente
		vo.setHash(Utils.toSHA1(vo.getEmail()));
	}

	@Override
	public void doAfterInsert(ClienteVo vo) throws InsertBeException {
		super.doAfterInsert(vo);

		try {
			new EmailBe(getManager()).sendEmailConfirmacaoCadastro(vo);
		} catch (ListException | EmailException e) {
			Log.error(e);
			throw new InsertBeException("Erro após o cadastro do cliente. Erro: " + e.getMessage(), null);
		}
	}

	/**
	 * Retorna o saldo do cliente
	 * 
	 * @param cliente
	 *            Cliente a verificar o saldo
	 * @return Saldo
	 * @throws BeException
	 */
	public BigDecimal saldo(ClienteVo cliente) throws BeException {
		ClienteSaldoVo clienteSaldo = new ClienteSaldoBe(getManager()).get(cliente);

		return clienteSaldo.getSaldo();
	}

	public ClienteVo loginFacebook(String nome, String email) throws BeException {

		ClienteVo cliente = getByEmail(email);

		if (cliente == null) {
			cliente = new ClienteVo();
			cliente.setNome(nome);
			cliente.setEmail(email);
			cliente.setSenha("");
			cliente.setTipoCadastro(TipoCadastro.FACEBOOK);
			cliente.setFlagEmailConfirmado(SimNao.SIM);

			save(cliente);
		}

		return cliente;
	}

	/**
	 * Cadastra rapidamente um cliente
	 * 
	 * @param nome
	 *            Nome do Cliente
	 * @param email
	 *            Email do cliente
	 * @param senha
	 *            Senha do cliente
	 * @param confSenha
	 *            Confirmação de senha do cliente
	 * @return Cliente cadastrado
	 * @throws BeException
	 */
	public ClienteVo cadastrar(String nome, String email, String senha, String confSenha) throws BeException {

		ClienteVo cliente = new ClienteVo();

		cliente.setNome(nome);
		cliente.setEmail(email);
		cliente.setSenha(senha);
		cliente.setConfSenha(confSenha);
		cliente.setTipoCadastro(TipoCadastro.EMAIL);
		cliente.setFlagEmailConfirmado(SimNao.NAO);

		save(cliente);

		return cliente;
	}

	public ClienteVo getByEmail(String email) throws ListException {
		ClienteVo filter = new ClienteVo();
		filter.setEmail(email);

		List<ClienteVo> list = getList(filter);

		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public void resetarSenha(String email) throws BeException {
		if (email == null || email.trim().equals("")) {
			throw new SaveBeException("Informe o email!", "email");
		}
		ClienteVo cliente = getByEmail(email);

		if (cliente == null) {
			throw new ClienteInexistenteException("Email não cadastrado!", "email");
		}

		// Gera uma nova senha
		cliente.setSenha(Utils.geraCadeiaString(10).toUpperCase());

		// Salva a nova senha
		save(cliente);

		// Envia um email com a nova senha
		new EmailBe(getManager()).sendEmailNovaSenha(cliente);
	}

	public void alterarSenha(ClienteVo cliente, String senha, String novaSenha, String confNovaSenha) throws BeException {

		if (senha == null || !cliente.getSenha().equals(senha)) {
			throw new SaveBeException("Senha atual incorreta!", "senha");
		}

		if (confNovaSenha == null || confNovaSenha.trim().equals("")) {
			throw new SaveBeException("Campo confirmação senha é obrigatório!", "confNovaSenha");
		}

		if (novaSenha != null) {
			if (!novaSenha.equals(confNovaSenha)) {
				throw new SaveBeException("Campo senha e confirmação da senha devem ser iguais!", "novaSenha");
			}
		}

		// Seta a nova senha
		cliente.setSenha(novaSenha);
		cliente.setConfSenha(confNovaSenha);

		// Salva o cliente
		save(cliente);
	}

}

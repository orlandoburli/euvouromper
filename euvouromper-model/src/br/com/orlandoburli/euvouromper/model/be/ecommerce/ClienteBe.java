package br.com.orlandoburli.euvouromper.model.be.ecommerce;

import java.util.List;

import br.com.orlandoburli.euvouromper.model.be.admin.LoginInvalidoException;
import br.com.orlandoburli.euvouromper.model.be.ecommerce.exceptions.ClienteInexistenteException;
import br.com.orlandoburli.euvouromper.model.dao.ecommerce.ClienteDao;
import br.com.orlandoburli.euvouromper.model.domains.SimNao;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ClienteVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.TipoCadastro;
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

		throw new LoginInvalidoException("Email / Senha inválidos!");
	}

	@Override
	public void doBeforeSave(ClienteVo vo) throws BeException {
		super.doBeforeSave(vo);

		if (vo.getTipoCadastro().equals(TipoCadastro.EMAIL)) {
			if (vo.getSenha() == null || vo.getSenha().trim().equals("")) {
				throw new SaveBeException("Campo senha é obrigatório!");
			} else if (vo.getSenha().trim().length() < 3) {
				throw new SaveBeException("Campo senha deve ter pelo menos 3 caracteres!");
			}
		}
	}

	@Override
	public void doBeforeInsert(ClienteVo vo) throws InsertBeException {
		super.doBeforeInsert(vo);
		
		// Verifica se ja existe email com esse cadastro
		
		ClienteVo temp;
		try {
			temp = getByEmail(vo.getEmail());
			
			if (temp != null) {
				throw new InsertBeException("Já existe o email " + vo.getEmail() + " cadastrado!");
			}
		} catch (ListException e) {
			Log.error(e);
			throw new InsertBeException(e.getMessage());
		}
		
		

		if (vo.getTipoCadastro().equals(TipoCadastro.EMAIL)) {
			if (vo.getConfSenha() == null || vo.getConfSenha().trim().equals("")) {
				throw new InsertBeException("Campo confirmação senha é obrigatório!");
			}

			if (vo.getSenha() != null) {
				if (!vo.getSenha().equals(vo.getConfSenha())) {
					throw new InsertBeException("Campo senha e confirmação da senha devem ser iguais!");
				}
			}
		}
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

		// if (senha != null && confSenha != null) {
		// if (!senha.equals(confSenha)) {
		// throw new
		// SaveBeException("Senha e confirmação de senha devem ser iguais!");
		// }
		// }

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
			throw new SaveBeException("Informe o email!");
		}
		ClienteVo cliente = getByEmail(email);
		
		if (cliente == null) {
			throw new ClienteInexistenteException("Email não cadastrado!");
		}
		
		// Gera uma nova senha
		cliente.setSenha(Utils.geraCadeiaString(10).toUpperCase());
		
		// Salva a nova senha
		save(cliente);
		
		// TODO envia um email com a nova senha
	}

}

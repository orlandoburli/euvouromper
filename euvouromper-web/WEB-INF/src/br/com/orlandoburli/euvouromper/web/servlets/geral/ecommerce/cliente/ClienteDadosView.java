package br.com.orlandoburli.euvouromper.web.servlets.geral.ecommerce.cliente;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.ecommerce.ClienteBe;
import br.com.orlandoburli.euvouromper.model.be.ecommerce.MensagemLidaBe;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ClienteVo;
import br.com.orlandoburli.euvouromper.web.servlets.utils.WebUtils;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.utils.Constants;

@WebServlet("/aluno/dados")
public class ClienteDadosView extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ClienteVo cliente = (ClienteVo) req.getSession().getAttribute(Constants.Session.CLIENTE);

		if (cliente == null) {
			WebUtils.goTo(req, resp, "/entrar?redir=/aluno/dados");
			return;
		}

		DAOManager manager = DAOManager.getDAOManager();

		try {

			// Menus

			WebUtils.buildMenus(req, manager);

			// Novas Mensagens

			req.setAttribute("novasMensagens", new MensagemLidaBe(manager).getNovasMensagensCount(cliente));

			// Saldo

			req.setAttribute("saldo", new ClienteBe(manager).saldo(cliente));

		} catch (ListException e) {
			Log.error(e);
		} finally {
			manager.commit();
		}

		req.getRequestDispatcher("../web/pages/ecommerce/cliente/cliente_dados.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Salvar os dados

		ClienteVo cliente = (ClienteVo) req.getSession().getAttribute(Constants.Session.CLIENTE);

		if (cliente == null) {
			doGet(req, resp);
			return;
		}

		DAOManager manager = DAOManager.getDAOManager();
		try {

			if (req.getParameter("btnSalvarDados") != null) {

				cliente.setNome(req.getParameter("nome"));
				cliente.setCpf(req.getParameter("cpf"));
				cliente.setCep(req.getParameter("cep"));
				cliente.setEndereco(req.getParameter("endereco"));
				try {
					cliente.setNumero(Integer.parseInt(req.getParameter("numero")));
				} catch (NumberFormatException e) {
				}
				cliente.setBairro(req.getParameter("bairro"));
				cliente.setComplemento(req.getParameter("complemento"));
				cliente.setUf(req.getParameter("uf"));
				cliente.setCidade(req.getParameter("cidade"));
				cliente.setFone1(req.getParameter("fone1"));
				cliente.setFone2(req.getParameter("fone2"));

				try {
					new ClienteBe(manager).save(cliente);

					req.setAttribute("sucessoCadastro", "Dados alterados com sucesso!");
				} catch (BeException e) {
					req.setAttribute("erroCadastro", e.getMessage());
				}
			} else if (req.getParameter("btnAlterarSenha") != null) {
				String senha = req.getParameter("senha");
				String novaSenha = req.getParameter("novaSenha");
				String confNovaSenha = req.getParameter("confNovaSenha");

				try {
					new ClienteBe(manager).alterarSenha(cliente, senha, novaSenha, confNovaSenha);

					req.setAttribute("sucessoSenha", "Senha alterada com sucesso!");
				} catch (BeException e) {
					req.setAttribute("erroSenha", e.getMessage());
				}
			}

		} finally {
			manager.commit();
		}

		doGet(req, resp);
	}
}

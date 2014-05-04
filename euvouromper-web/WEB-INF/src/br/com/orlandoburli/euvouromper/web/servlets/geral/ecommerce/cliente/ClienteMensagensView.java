package br.com.orlandoburli.euvouromper.web.servlets.geral.ecommerce.cliente;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.ecommerce.MensagemBe;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ClienteVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.MensagemVo;
import br.com.orlandoburli.euvouromper.web.servlets.utils.WebUtils;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.utils.Constants;

@WebServlet("/aluno/mensagens")
public class ClienteMensagensView extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ClienteVo cliente = (ClienteVo) req.getSession().getAttribute(Constants.Session.CLIENTE);

		if (cliente == null) {
			WebUtils.goTo(req, resp, "/entrar?redir=/aluno/mensagens");
			return;
		}

		DAOManager manager = DAOManager.getDAOManager();
		try {
			// Menus

			WebUtils.buildMenus(req, manager);

			// Mensagens

			List<MensagemVo> mensagens = new MensagemBe(manager).getList(cliente, 10);

			req.setAttribute("mensagens", mensagens);

			int novasMensagens = 0;
			for (MensagemVo mensagem : mensagens) {
				if (!mensagem.isLida()) {
					novasMensagens++;
				}
			}
			
			req.setAttribute("novasMensagens", novasMensagens);
			
		} catch (ListException e) {
			e.printStackTrace();
		}

		req.getRequestDispatcher("../web/pages/ecommerce/cliente/cliente_mensagens.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	};
}

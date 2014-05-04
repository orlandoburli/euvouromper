package br.com.orlandoburli.euvouromper.web.servlets.geral.site.contato;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.ecommerce.EmailBe;
import br.com.orlandoburli.euvouromper.model.be.site.ContatoBe;
import br.com.orlandoburli.euvouromper.model.be.site.DepartamentoBe;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Departamento;
import br.com.orlandoburli.euvouromper.model.vo.site.ContatoVo;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;

@WebServlet("/contato")
public class ContatoView extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		DAOManager manager = DAOManager.getDAOManager();

		try {
			req.setAttribute("departamentos", new DepartamentoBe(manager).getList(null, null, Departamento.TABELA_DEPARTAMENTO + "." + Departamento.Colunas.NOME));
		} catch (ListException e) {
			Log.error(e);
		} finally {
			manager.commit();
		}

		req.getRequestDispatcher("web/pages/site/contato/contato.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		req.setCharacterEncoding("UTF-8");

		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String fone = req.getParameter("fone");
		String assunto = req.getParameter("assunto");
		String mensagem = req.getParameter("mensagem");
		Integer idDepartamento = null;

		try {
			idDepartamento = Integer.parseInt(req.getParameter("idDepartamento"));
		} catch (NullPointerException | NumberFormatException e) {
			idDepartamento = null;
		}

		DAOManager manager = DAOManager.getDAOManager();

		try {
			ContatoVo contato = new ContatoVo();
			
			contato.setNome(nome);
			contato.setEmail(email);
			contato.setFone(fone);
			contato.setAssunto(assunto);
			contato.setMensagem(mensagem);
			contato.setIdDepartamento(idDepartamento);

			ContatoBe contatoBe = new ContatoBe(manager);
			contatoBe.save(contato);
			contato = contatoBe.get(contato);
			
			new EmailBe(manager).sendEmailContato(contato);

			req.setAttribute("sucesso", "Obrigado pelo contato. Estaremos respondendo em breve!");
		} catch (BeException e) {
			req.setAttribute("erro", e.getMessage());
			
			req.setAttribute("nome", nome);
			req.setAttribute("email", email);
			req.setAttribute("fone", fone);
			req.setAttribute("assunto", assunto);
			req.setAttribute("mensagem", mensagem);
			req.setAttribute("idDepartamento", idDepartamento);
		} finally {
			manager.commit();
		}
		doGet(req, resp);
	}
}

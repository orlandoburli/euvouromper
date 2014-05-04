package br.com.orlandoburli.euvouromper.web.servlets.geral.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/teste")
public class TesteView extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// String nome = "Orlando Burli Junior";
		// String email = "orlando.developermaster@gmail.com";
		// String senha = "123";
		// String confSenha = "123";
		//
		// DAOManager manager = DAOManager.getDAOManager();
		//
		// try {
		// ClienteBe clienteBe = new ClienteBe(manager);
		//
		// ClienteVo temp = clienteBe.getByEmail(email);
		//
		// if (temp != null) {
		// clienteBe.remove(temp);
		// manager.commit();
		// }
		//
		// ClienteVo cliente = clienteBe.cadastrar(nome, email, senha,
		// confSenha);
		//
		// resp.getOutputStream().write(cliente.toString().getBytes());
		//
		// } catch (BeException e) {
		// resp.getOutputStream().write(e.getMessage().getBytes());
		// } finally {
		// manager.commit();
		// }

//		DAOManager manager = DAOManager.getDAOManager();
//		try {
//			PedidoVo pedido = new PedidoBe(manager).get(37);
//
//			new EmailBe(manager).sendEmailPedidoPago(pedido);
//		} catch (ListException | EmailException e) {
//			e.printStackTrace();
//		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

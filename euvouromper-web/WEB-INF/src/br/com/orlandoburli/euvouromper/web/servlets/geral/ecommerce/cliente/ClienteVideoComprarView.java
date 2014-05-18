package br.com.orlandoburli.euvouromper.web.servlets.geral.ecommerce.cliente;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.ecommerce.ProdutoBe;
import br.com.orlandoburli.euvouromper.model.be.ecommerce.cliente.ClienteBe;
import br.com.orlandoburli.euvouromper.model.be.ecommerce.cliente.ClienteSaldoBe;
import br.com.orlandoburli.euvouromper.model.be.online.VideoBe;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ProdutoVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.cliente.ClienteVo;
import br.com.orlandoburli.euvouromper.model.vo.online.VideoVo;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.utils.Constants;
import br.com.orlandoburli.framework.core.utils.Utils;
import br.com.orlandoburli.framework.core.web.retorno.RetornoAction;

@WebServlet("/aluno.video.comprar.page")
public class ClienteVideoComprarView extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ClienteVo cliente = (ClienteVo) req.getSession().getAttribute(Constants.Session.CLIENTE);

		if (cliente == null) {
			return;
		}

		Integer idVideo = null;
		try {
			idVideo = Integer.parseInt(req.getParameter("idVideo"));
		} catch (NullPointerException | NumberFormatException e) {
			return;
		}

		DAOManager manager = DAOManager.getDAOManager();

		try {
			// Video

			req.setAttribute("video", new VideoBe(manager).get(idVideo));

			// Saldo

			BigDecimal saldo = new ClienteBe(manager).saldo(cliente);

			req.setAttribute("saldo", saldo);

			// Produto video individual
			ProdutoVo produto = new ProdutoBe(manager).getProdutoVideoIndividual();

			req.setAttribute("produto", produto);

			// Saldo Previsto

			BigDecimal saldoPrevisto = saldo.subtract(produto.getValor());

			req.setAttribute("saldoPrevisto", saldoPrevisto);

			if (saldoPrevisto.compareTo(BigDecimal.ZERO) < 0) {
				req.setAttribute("erro", "Saldo insuficiente para comprar esta aula!");
			}

		} catch (BeException e) {
			Log.error(e);
		} finally {
			manager.commit();
		}

		req.getRequestDispatcher("/web/pages/ecommerce/cliente/cliente_video_individual_comprar.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ClienteVo cliente = (ClienteVo) req.getSession().getAttribute(Constants.Session.CLIENTE);

		if (cliente == null) {
			return;
		}

		Integer idVideo = null;
		try {
			idVideo = Integer.parseInt(req.getParameter("idVideo"));
		} catch (NullPointerException | NumberFormatException e) {
			return;
		}

		DAOManager manager = DAOManager.getDAOManager();

		try {
			// Video

			VideoVo video = new VideoBe(manager).get(idVideo);
			
			req.setAttribute("video", video);

			// Saldo

			BigDecimal saldo = new ClienteBe(manager).saldo(cliente);

			req.setAttribute("saldo", saldo);

			// Consumir saldo
			new ClienteSaldoBe(manager).consumirSaldo(cliente, video);
			
			// Mensagem de sucesso
			resp.getWriter().write(Utils.voToJson(new RetornoAction(true, "Vídeo adquirido com sucesso!")));

		} catch (BeException e) {
			resp.getWriter().write(Utils.voToJson(new RetornoAction(false, e.getMessage())));
		} finally {
			manager.commit();
		}
	}
}

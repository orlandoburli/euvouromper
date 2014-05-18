package br.com.orlandoburli.euvouromper.web.servlets.geral.ecommerce.cliente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.ecommerce.ItemPedidoBe;
import br.com.orlandoburli.euvouromper.model.be.ecommerce.MensagemLidaBe;
import br.com.orlandoburli.euvouromper.model.be.ecommerce.ProdutoBe;
import br.com.orlandoburli.euvouromper.model.be.ecommerce.cliente.ClienteBe;
import br.com.orlandoburli.euvouromper.model.be.ecommerce.cliente.ClienteSaldoBe;
import br.com.orlandoburli.euvouromper.model.be.ecommerce.cliente.LogVideoBe;
import br.com.orlandoburli.euvouromper.model.be.online.ModuloBe;
import br.com.orlandoburli.euvouromper.model.be.online.VideoBe;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ProdutoVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.TipoProduto;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.cliente.ClienteVo;
import br.com.orlandoburli.euvouromper.model.vo.online.ModuloVo;
import br.com.orlandoburli.euvouromper.web.servlets.utils.WebUtils;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.utils.Constants;

@WebServlet("/aluno.curso.page")
public class ClienteCursoView extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// URL do produto
		String urlProduto = req.getParameter("produto");

		// Se o ID for nulo ou invalido, volta para a lista
		if (urlProduto == null || urlProduto.trim().equals("")) {
			Log.info("URL do produto nula ou vazia");
			WebUtils.goTo(req, resp, "/aluno/cursos");
			return;
		}

		ClienteVo cliente = (ClienteVo) req.getSession().getAttribute(Constants.Session.CLIENTE);

		if (cliente == null) {
			WebUtils.goTo(req, resp, "/entrar?redir=/aluno/curso/" + urlProduto);
			return;
		}

		DAOManager manager = DAOManager.getDAOManager();

		try {
			// Busca o produto
			ProdutoVo produto = new ProdutoBe(manager).getByUrl(urlProduto);

			if (produto == null) {
				Log.info("Produto não encontrado");
				manager.commit();
				WebUtils.goTo(req, resp, "/aluno/cursos");
				return;
			}

			List<ProdutoVo> produtosTemp = new ArrayList<ProdutoVo>();
			produtosTemp.add(produto);

			// Verifica se este item foi comprado
			new ItemPedidoBe(manager).checkComprado(produtosTemp, cliente);

			// Busca os dados do produto

			if (produto.getTipoProduto().equals(TipoProduto.PACOTE)) {
				// Carrega os modulos desse pacote
				produto.getPacote().setModulos(new ModuloBe(manager).getByPacote(produto.getPacote()));

				// Carrega os videos de cada modulo
				for (ModuloVo modulo : produto.getPacote().getModulos()) {
					modulo.setVideos(new VideoBe(manager).getByModulo(modulo));
				}

			} else if (produto.getTipoProduto().equals(TipoProduto.MODULO)) {
				// Carrega os videos deste modulo
				produto.getModulo().setVideos(new VideoBe(manager).getByModulo(produto.getModulo()));
			} else {
				// Se nao e pacote nem modulo, voce nao deveria estar aqui!
				WebUtils.goTo(req, resp, "/aluno/cursos");
				return;
			}

			if (produto.getItem() == null) {
				// Se o produto nao estiver comprado, verifica se cada video foi
				// comprado individualmente.
				if (produto.getTipoProduto().equals(TipoProduto.MODULO)) {
					new ClienteSaldoBe(manager).checkVideos(cliente, produto.getModulo().getVideos());
				} else if (produto.getTipoProduto().equals(TipoProduto.PACOTE)) {
					for (ModuloVo modulo : produto.getPacote().getModulos()) {
						new ClienteSaldoBe(manager).checkVideos(cliente, modulo.getVideos());
					}
				}
			}
			
			// Log dos videos
			if (produto.getTipoProduto().equals(TipoProduto.MODULO)) {
				new LogVideoBe(manager).checkLog(cliente, produto.getModulo().getVideos());
			} else if (produto.getTipoProduto().equals(TipoProduto.PACOTE)) {
				for (ModuloVo modulo : produto.getPacote().getModulos()) {
					new LogVideoBe(manager).checkLog(cliente, modulo.getVideos());
				}
			}

			req.setAttribute("produto", produto);

			// Menus

			WebUtils.buildMenus(req, manager);

			// Novas Mensagens

			req.setAttribute("novasMensagens", new MensagemLidaBe(manager).getNovasMensagensCount(cliente));

			// Saldo

			req.setAttribute("saldo", new ClienteBe(manager).saldo(cliente));

			// Tipos de produto

			WebUtils.sendDomain(req, new TipoProduto());

		} catch (BeException e) {
			Log.error(e);
		} finally {
			manager.commit();
		}

		req.getRequestDispatcher("/web/pages/ecommerce/cliente/cliente_curso_ver.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

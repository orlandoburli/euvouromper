package br.com.orlandoburli.euvouromper.web.servlets.geral.ecommerce.cliente;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.SimpleDateFormat;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.ecommerce.ItemPedidoBe;
import br.com.orlandoburli.euvouromper.model.be.online.VideoBe;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ClienteVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ItemPedidoVo;
import br.com.orlandoburli.euvouromper.model.vo.online.VideoVo;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.utils.Constants;
import br.com.orlandoburli.framework.core.utils.Criptografia;
import br.com.orlandoburli.framework.core.utils.Utils;

@WebServlet("/aluno.video.page")
public class ClienteVideoPlayerView extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ClienteVo cliente = (ClienteVo) req.getSession().getAttribute(Constants.Session.CLIENTE);

		if (cliente == null) {
			// Não precisa redirecionar, so na faz nada.
			Log.debug("Cliente não logado.");
			return;
		}

		Integer idVideo = null;
		try {
			idVideo = Integer.parseInt(req.getParameter("v"));
		} catch (NumberFormatException | NullPointerException e) {
			idVideo = null;
		}

		if (idVideo == null) {
			Log.warning("Parametro [v] está vazio.");
			return;
		}

		Integer idItemPedido = null;
		try {
			idItemPedido = Integer.parseInt(req.getParameter("i"));
		} catch (NumberFormatException | NullPointerException e) {
			idItemPedido = null;
		}

		if (idItemPedido == null) {
			Log.warning("Parametro [i] está vazio.");
			return;
		}

		DAOManager manager = DAOManager.getDAOManager();

		try {

			VideoVo video = new VideoBe(manager).get(idVideo);

			ItemPedidoVo item = new ItemPedidoBe(manager).get(idItemPedido, cliente);

			if (video != null && item != null) {

				// Gera URL Temporaria na sessao

				String dataHoraVideo = new SimpleDateFormat("ddMMyyyy-hhmmss").format(Utils.getNow());
				String codigoItem = Utils.fillString(video.getIdVideo(), "0", 20, 1);
				String itemPedido = Utils.fillString(item.getIdItemPedido(), "0", 20, 1);

				String url = dataHoraVideo + "-" + codigoItem + "-" + itemPedido;

				String urlCripto = Utils.toBase64(Criptografia.newInstance(Constants.CHAVE_CRIPTO).cripto(url));

				req.getSession().setAttribute(url, urlCripto);

				req.setAttribute("urlVideo", urlCripto);

				req.setAttribute("item", item.getIdItemPedido());

				req.setAttribute("nomeCliente64", Utils.toBase64(cliente.getNome()));

				req.setAttribute("cpfCliente64", Utils.toBase64(cliente.getCpf()));

			} else {
				if (video == null) {
					Log.warning("Video de id " + idVideo + " não encontrado!");
				}
				if (item == null) {
					Log.warning("Item pedido id " + idItemPedido + " não encontrado!");
				}
			}
		} catch (ListException e) {
			Log.error(e);
		} catch (InvalidKeyException e) {
			Log.critical(e);
		} catch (IllegalBlockSizeException e) {
			Log.critical(e);
		} catch (BadPaddingException e) {
			Log.critical(e);
		} catch (NoSuchAlgorithmException e) {
			Log.critical(e);
		} catch (NoSuchPaddingException e) {
			Log.critical(e);
		} catch (InvalidKeySpecException e) {
			Log.critical(e);
		} finally {
			manager.commit();
		}

		req.getRequestDispatcher("/web/pages/ecommerce/cliente/cliente_video_ver.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

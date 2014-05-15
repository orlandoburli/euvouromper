package br.com.orlandoburli.euvouromper.web.servlets.geral.ecommerce.cliente;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;

import br.com.orlandoburli.euvouromper.model.be.admin.ParametroBe;
import br.com.orlandoburli.euvouromper.model.be.ecommerce.ItemPedidoBe;
import br.com.orlandoburli.euvouromper.model.be.online.VideoBe;
import br.com.orlandoburli.euvouromper.model.domains.SimNao;
import br.com.orlandoburli.euvouromper.model.vo.admin.ParametroVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ItemPedidoVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.cliente.ClienteVo;
import br.com.orlandoburli.euvouromper.model.vo.online.VideoVo;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.utils.Constants;
import br.com.orlandoburli.framework.core.utils.Criptografia;
import br.com.orlandoburli.framework.core.utils.Utils;

@WebServlet("/aluno.video.get")
public class ClienteViewGet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Verifica se existe cliente logado
		ClienteVo cliente = (ClienteVo) req.getSession().getAttribute(Constants.Session.CLIENTE);

		if (cliente == null || cliente.getIdCliente() == null) {
			return;
		}
		String urlCripto = req.getParameter("v");

		String url;

		try {

			Log.info("v=" + urlCripto);
			Log.info("v2=" + Utils.fromBase64(urlCripto));

			url = Criptografia.newInstance(Constants.CHAVE_CRIPTO).decripto(Utils.fromBase64(urlCripto));

			Log.info("url=" + url);

			String urlSessao = (String) req.getSession().getAttribute(url);

			if (urlSessao == null || !urlCripto.equals(urlSessao)) {
				Log.warning("URL não é mais válida! Possível tentativa de furto de vídeo do cliente " + cliente.getIdCliente() + " Nome: " + cliente.getNome());
				return;
			}

			req.getSession().removeAttribute(url);

		} catch (Exception e1) {
			e1.printStackTrace();
			return;
		}

		Integer idVideo = null;

		try {
			idVideo = Integer.parseInt(url.substring(16, 36));
		} catch (NumberFormatException | NullPointerException e) {
			Log.error("idVideo invalido!");
			return;
		}

		Integer idItemPedido = null;

		try {
			idItemPedido = Integer.parseInt(url.substring(37, 57));
		} catch (NumberFormatException | NullPointerException e) {
			Log.error("idItemPedido invalido!");
			return;
		}

		if (idVideo != null) {
			DAOManager manager = DAOManager.getDAOManager();

			try {

				VideoVo video = new VideoBe(manager).get(idVideo);

				if (video != null) {
					if (!video.getGratuito().equals(SimNao.SIM)) {
						ItemPedidoBe itemPedidoBe = new ItemPedidoBe(manager);

						ItemPedidoVo item = itemPedidoBe.get(idItemPedido);

						if (!(itemPedidoBe.checkItemAcessoTotal(item) || itemPedidoBe.checkItem(item))) {
							manager.commit();
							return;
						}
					}

					ParametroVo parametroPathVideos = new ParametroBe(manager).get(Constants.Parameters.PATH_ARQUIVOS);

					if (parametroPathVideos == null) {
						Log.error("Parâmetro " + Constants.Parameters.PATH_ARQUIVOS + " não definido!");
						return;
					}

					String pathVideos = parametroPathVideos.getValor();

					// Pega o arquivo
					try {
						ServletOutputStream out = resp.getOutputStream();
						File fileVideo = new File(pathVideos + File.separator + "videos" + File.separator + video.getPathVideo());
						FileInputStream input = new FileInputStream(fileVideo);

						byte[] buffer = new byte[1024];
						int i;

						while ((i = input.read(buffer)) != -1) {
							out.write(buffer, 0, i);
						}

						out.flush();
						input.close();
						out.close();
					} catch (FileNotFoundException e) {
						Log.error("Arquivo de vídeo " + pathVideos + File.separator + "videos" + File.separator + video.getPathVideo() + " não encontrado!");
					}

				} else {
					Log.error("Vídeo de id " + idVideo + " não encontrado!");
				}

			} catch (ListException e) {
				Log.error(e);
			} finally {
				try {
					// TODO Log de visualizacao
				} catch (Exception e) {
					Log.error(e);
				}

				manager.commit();
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

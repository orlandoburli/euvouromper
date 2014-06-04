package br.com.orlandoburli.euvouromper.web.servlets.geral.ecommerce.cliente;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.admin.ParametroBe;
import br.com.orlandoburli.euvouromper.model.be.online.MaterialApoioBe;
import br.com.orlandoburli.euvouromper.model.vo.admin.ParametroVo;
import br.com.orlandoburli.euvouromper.model.vo.online.MaterialApoioVo;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.utils.Constants;

@WebServlet("/materialapoio.get")
public class ClienteMaterialApoioGet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idMaterialApoio = null;

		try {
			idMaterialApoio = Integer.parseInt(req.getParameter("idMaterialApoio"));
		} catch (NumberFormatException | NullPointerException e) {
			idMaterialApoio = null;
		}

		if (idMaterialApoio != null) {
			DAOManager manager = DAOManager.getDAOManager();

			try {
				MaterialApoioVo material = new MaterialApoioBe(manager).get(idMaterialApoio);

				ParametroVo parametroPathMaterialApoio = new ParametroBe(manager).get(Constants.Parameters.PATH_ARQUIVOS);

				if (parametroPathMaterialApoio == null) {
					Log.error("Parâmetro " + Constants.Parameters.PATH_ARQUIVOS + " não definido!");
					return;
				}

				String pathMaterialApoio = parametroPathMaterialApoio.getValor();

				// Pega o arquivo
				try {
					ServletOutputStream out = resp.getOutputStream();
					File fileVideo = new File(pathMaterialApoio + File.separator + "materialapoio" + File.separator + material.getArquivo());
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
					Log.error("Arquivo de vídeo " + pathMaterialApoio + File.separator + "materialapoio" + File.separator + material.getArquivo() + " não encontrado!");
				}

			} catch (ListException e) {
				Log.error(e);
			} finally {
				manager.commit();
			}
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	};
}

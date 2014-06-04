package br.com.orlandoburli.euvouromper.admin.web.servlets.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

import br.com.orlandoburli.euvouromper.model.be.admin.ParametroBe;
import br.com.orlandoburli.euvouromper.model.vo.admin.ParametroVo;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.utils.Constants;
import br.com.orlandoburli.framework.core.utils.Utils;

@WebServlet("/upload/materialapoio")
public class UploadMaterialApoioServlet extends HttpServlet {

	private static final long serialVersionUID = 3447685998419256747L;
	private static final String RESP_SUCCESS = "{\"jsonrpc\" : \"2.0\", \"result\" : \"success\", \"id\" : \"id\", \"arquivo\": [arquivo]}";
	private static final String RESP_ERROR = "{\"jsonrpc\" : \"2.0\", \"error\" : {\"code\": 101, \"message\": \"Failed to open input stream.\"}, \"id\" : \"id\"}";
	public static final String JSON = "application/json";
	public static final int BUF_SIZE = 2 * 1024;

	private int chunk;
	private int chunks;
	private String name;
	private String user;
	private String time;

	/**
	 * Handles an HTTP POST request from Plupload.
	 * 
	 * @param req
	 *            The HTTP request
	 * @param resp
	 *            The HTTP response
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DAOManager manager = DAOManager.getDAOManager();

		try {
			ParametroVo parametro;
			try {
				parametro = new ParametroBe(manager).get(Constants.Parameters.PATH_ARQUIVOS);

				if (parametro == null) {
					Log.warning("Parametro " + Constants.Parameters.PATH_ARQUIVOS + " nao definido!");
					return;
				}
			} catch (ListException e1) {
				Log.critical(e1.getStackTrace());
				return;
			}

			String responseString = RESP_SUCCESS;

			boolean isMultipart = ServletFileUpload.isMultipartContent(req);

			if (isMultipart) {

				ServletFileUpload upload = new ServletFileUpload();

				try {

					FileItemIterator iter = upload.getItemIterator(req);

					while (iter.hasNext()) {

						FileItemStream item = iter.next();
						InputStream input = item.openStream();

						// Handle a form field.
						if (item.isFormField()) {
							String fileName = item.getFieldName();
							String value = Streams.asString(input);

							if ("name".equals(fileName)) {
								this.setName(value);
							} else if ("chunks".equals(fileName)) {
								this.setChunks(Integer.parseInt(value));
							} else if ("chunk".equals(fileName)) {
								this.setChunk(Integer.parseInt(value));
							} else if ("user".equals(fileName)) {
								this.setUser(value);
							} else if ("time".equals(fileName)) {
								this.setTime(value);
							}
						} else {
							// Handle a multi-part MIME encoded file.

							String diretorioImagens = parametro.getValor() + File.separator + "materialapoio";
							File dstFile = new File(diretorioImagens);
							if (!dstFile.exists()) {
								dstFile.mkdirs();
							}

							String nomeArquivo = Utils.geraCadeiaString(20).toUpperCase();

							File dst = new File(dstFile.getPath() + "/" + nomeArquivo);

							saveUploadFile(input, dst);

							responseString = RESP_SUCCESS;
							responseString = responseString.replace("[arquivo]", "\"" + nomeArquivo + "\"");
							
							Log.info("Nome Arquivo Upload: " + nomeArquivo);
						}
					}
				} catch (Exception e) {
					responseString = RESP_ERROR;
					Log.critical(e);
				}
			} else {
				// Not a multi-part MIME request.
				responseString = RESP_ERROR;
			}

			resp.setContentType(JSON);
			byte[] responseBytes = responseString.getBytes();
			resp.setContentLength(responseBytes.length);
			ServletOutputStream output = resp.getOutputStream();
			output.write(responseBytes);
			output.flush();

			Log.debug("Upload do video finalizado! ");

		} finally {
			manager.commit();
		}
	}

	/**
	 * Saves the given file item (using the given input stream) to the web
	 * server's local temp directory.
	 * 
	 * @param input
	 *            The input stream to read the file from
	 * @param dst
	 *            The dir of upload
	 */
	private void saveUploadFile(InputStream input, File dst) throws IOException {
		OutputStream out = null;
		try {
			if (dst.exists()) {
				out = new BufferedOutputStream(new FileOutputStream(dst, true), BUF_SIZE);
			} else {
				out = new BufferedOutputStream(new FileOutputStream(dst), BUF_SIZE);
			}

			byte[] buffer = new byte[BUF_SIZE];
			int len = 0;
			while ((len = input.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != input) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public int getChunk() {
		return chunk;
	}

	public void setChunk(int chunk) {
		this.chunk = chunk;
	}

	public int getChunks() {
		return chunks;
	}

	public void setChunks(int chunks) {
		this.chunks = chunks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}

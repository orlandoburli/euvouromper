package br.com.orlandoburli.euvouromper.admin.utils;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.com.orlandoburli.euvouromper.model.be.admin.ParametroBe;
import br.com.orlandoburli.euvouromper.model.vo.admin.ParametroVo;
import br.com.orlandoburli.euvouromper.model.vo.utils.FileVo;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.utils.Constants;

public final class FileUtils {

	public static final String[] EXTENSOES_IMAGENS = { "jpg", "png", "jpeg", "gif" };

	
	public static void listaImagens(DAOManager manager, HttpServletRequest request) {
		try {
			ParametroVo parametroPath = new ParametroBe(manager).get(Constants.Parameters.PATH_ARQUIVOS);
			if (parametroPath == null) {
				Log.warning("Parametro " + Constants.Parameters.PATH_ARQUIVOS + " nao definido!");
				return;
			}

			List<FileVo> files = FileUtils.listaImagens(parametroPath.getValor());
			
			for (FileVo f : files) {
				Log.info("File: " + f.getFileName());
			}
			
			request.setAttribute("files", files);
		} catch (ListException e) {
			e.printStackTrace();
		}

	}
	
	public static List<FileVo> listaImagens(String path) {
		Log.debug("Inicio listagem de imagens");

		File dir = new File(path);

		if (!dir.exists()) {
			Log.error("Diretorio " + path + " nao existe!");
			return null;
		}

		// Diretorio das imagens
		File dirImagens = new File(dir.getAbsolutePath() + File.separator + "imagens");

		if (!dirImagens.exists()) {
			dirImagens.mkdir();
		}

		List<FileVo> files = new ArrayList<FileVo>();

		for (File f : dirImagens.listFiles()) {
			String fileName = f.getName();

			Log.info("FileName: " + fileName);

			if (f.isFile() && fileName.indexOf(".") >= 0) {

				String extensao = fileName.substring(fileName.lastIndexOf(".") + 1);

				// Lista somente as extensoes permitidas
				if (isInArray(extensao, EXTENSOES_IMAGENS)) {

					FileVo file = new FileVo();

					file.setFileName(f.getName());
					file.setWebPath("/imagens/" + f.getName());
					file.setFullFileName(f.getAbsolutePath());
					file.setExtension(extensao.toLowerCase());
					file.setSize(new BigDecimal(f.length()));

					// Data / Hora da ultima modificacao
					Calendar lastModification = Calendar.getInstance();
					lastModification.setTimeInMillis(f.lastModified());

					file.setLastModification(lastModification);

					files.add(file);
				} else {
					Log.fine("File " + f.getName() + " com extensao nao permitida! Extensoes permitidas: " + toFormatedString(EXTENSOES_IMAGENS));
				}
			}
		}

		Log.debug("Fim do load das imagens");

		return files;
	}

	public static String toFormatedString(String[] values) {
		String retorno = "";

		for (String v : values) {
			retorno += v + ", ";
		}

		if (retorno.length() >= 2) {
			retorno = retorno.substring(0, retorno.length() - 2);
		}

		return retorno;
	}

	public static boolean isInArray(String search, String[] source) {
		return isInArray(search, source, false);
	}

	public static boolean isInArray(String search, String[] source, boolean caseSensitive) {
		for (String s : source) {
			if (caseSensitive && s.equals(search)) {
				return true;
			} else if (s.equalsIgnoreCase(search)) {
				return true;
			}
		}
		return false;
	}

}

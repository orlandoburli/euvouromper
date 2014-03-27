package br.com.orlandoburli.euvouromper.model.utils;

import br.com.orlandoburli.euvouromper.model.dao.admin.PerfilAdminDao;
import br.com.orlandoburli.euvouromper.model.dao.admin.UsuarioDao;
import br.com.orlandoburli.euvouromper.model.dao.cadastros.DisciplinaDao;
import br.com.orlandoburli.euvouromper.model.dao.online.ModuloDao;
import br.com.orlandoburli.euvouromper.model.dao.online.ModuloVideoDao;
import br.com.orlandoburli.euvouromper.model.dao.online.PacoteDao;
import br.com.orlandoburli.euvouromper.model.dao.online.PacoteModuloDao;
import br.com.orlandoburli.euvouromper.model.dao.online.VideoDao;
import br.com.orlandoburli.framework.core.dao.BaseCadastroDao;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.dao.exceptions.DAOException;

public final class DBUtils {

	public static void checkDaos() {
		DAOManager manager = new DAOManager();

		try {
			BaseCadastroDao.clearBuffer();
			new PerfilAdminDao(manager).checkTable();
			new UsuarioDao(manager).checkTable();
			new DisciplinaDao(manager).checkTable();
			new VideoDao(manager).checkTable();
			new ModuloDao(manager).checkTable();
			new ModuloVideoDao(manager).checkTable();
			new PacoteDao(manager).checkTable();
			new PacoteModuloDao(manager).checkTable();
		} catch (DAOException e) {
			e.printStackTrace();
		}

		manager.commit();

	}
}

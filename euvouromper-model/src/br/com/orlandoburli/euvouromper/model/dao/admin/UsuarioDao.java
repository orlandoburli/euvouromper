package br.com.orlandoburli.euvouromper.model.dao.admin;

import br.com.orlandoburli.euvouromper.model.vo.admin.UsuarioVo;
import br.com.orlandoburli.framework.core.dao.BaseCadastroDao;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class UsuarioDao extends BaseCadastroDao<UsuarioVo> {

	public UsuarioDao(DAOManager manager) {
		super(manager);
	}

}

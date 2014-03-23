package br.com.orlandoburli.euvouromper.model.be.admin;

import br.com.orlandoburli.euvouromper.model.dao.admin.PerfilAdminDao;
import br.com.orlandoburli.euvouromper.model.vo.admin.PerfilAdminVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class PerfilAdminBe extends BaseBe<PerfilAdminVo, PerfilAdminDao>{

	public PerfilAdminBe(DAOManager manager) {
		super(manager);
	}

}

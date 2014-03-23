package br.com.orlandoburli.euvouromper.model.be.admin;

import br.com.orlandoburli.euvouromper.model.dao.admin.ParametroDao;
import br.com.orlandoburli.euvouromper.model.vo.admin.ParametroVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class ParametroBe extends BaseBe<ParametroVo, ParametroDao>{

	public ParametroBe(DAOManager manager) {
		super(manager);
	}

}

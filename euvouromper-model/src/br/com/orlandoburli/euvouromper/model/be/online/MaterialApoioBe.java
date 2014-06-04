package br.com.orlandoburli.euvouromper.model.be.online;

import br.com.orlandoburli.euvouromper.model.dao.online.MaterialApoioDao;
import br.com.orlandoburli.euvouromper.model.vo.online.MaterialApoioVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class MaterialApoioBe extends BaseBe<MaterialApoioVo, MaterialApoioDao> {

	public MaterialApoioBe(DAOManager manager) {
		super(manager);
	}

}

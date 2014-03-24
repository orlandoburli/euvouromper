package br.com.orlandoburli.euvouromper.model.be.online;

import br.com.orlandoburli.euvouromper.model.dao.online.ModuloDao;
import br.com.orlandoburli.euvouromper.model.vo.online.ModuloVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class ModuloBe extends BaseBe<ModuloVo, ModuloDao>{

	public ModuloBe(DAOManager manager) {
		super(manager);
	}

}

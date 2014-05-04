package br.com.orlandoburli.euvouromper.model.be.site;

import br.com.orlandoburli.euvouromper.model.dao.site.DepartamentoDao;
import br.com.orlandoburli.euvouromper.model.vo.site.DepartamentoVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class DepartamentoBe extends BaseBe<DepartamentoVo, DepartamentoDao>{

	public DepartamentoBe(DAOManager manager) {
		super(manager);
	}

}

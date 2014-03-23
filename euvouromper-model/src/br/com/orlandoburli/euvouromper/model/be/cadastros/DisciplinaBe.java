package br.com.orlandoburli.euvouromper.model.be.cadastros;

import br.com.orlandoburli.euvouromper.model.dao.cadastros.DisciplinaDao;
import br.com.orlandoburli.euvouromper.model.vo.cadastros.DisciplinaVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class DisciplinaBe extends BaseBe<DisciplinaVo, DisciplinaDao>{

	public DisciplinaBe(DAOManager manager) {
		super(manager);
	}

}

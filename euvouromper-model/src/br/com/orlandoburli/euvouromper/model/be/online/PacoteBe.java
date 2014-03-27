package br.com.orlandoburli.euvouromper.model.be.online;

import br.com.orlandoburli.euvouromper.model.dao.online.PacoteDao;
import br.com.orlandoburli.euvouromper.model.vo.online.PacoteVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class PacoteBe extends BaseBe<PacoteVo, PacoteDao>{

	public PacoteBe(DAOManager manager) {
		super(manager);
	}

}

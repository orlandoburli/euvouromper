package br.com.orlandoburli.euvouromper.model.be.site;

import br.com.orlandoburli.euvouromper.model.dao.site.ContatoDao;
import br.com.orlandoburli.euvouromper.model.vo.site.ContatoVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class ContatoBe extends BaseBe<ContatoVo, ContatoDao>{

	public ContatoBe(DAOManager manager) {
		super(manager);
	}

}

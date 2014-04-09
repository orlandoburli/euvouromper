package br.com.orlandoburli.euvouromper.model.be.ecommerce;

import br.com.orlandoburli.euvouromper.model.dao.ecommerce.CupomDescontoDao;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.CupomDescontoVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class CupomDescontoBe extends BaseBe<CupomDescontoVo, CupomDescontoDao>{

	public CupomDescontoBe(DAOManager manager) {
		super(manager);
	}

}

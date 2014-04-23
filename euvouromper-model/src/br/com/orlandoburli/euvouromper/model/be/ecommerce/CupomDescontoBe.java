package br.com.orlandoburli.euvouromper.model.be.ecommerce;

import java.util.List;

import br.com.orlandoburli.euvouromper.model.dao.ecommerce.CupomDescontoDao;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.CupomDescontoVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class CupomDescontoBe extends BaseBe<CupomDescontoVo, CupomDescontoDao> {

	public CupomDescontoBe(DAOManager manager) {
		super(manager);
	}

	public CupomDescontoVo getByChave(String chaveCupom) throws ListException {

		CupomDescontoVo filter = new CupomDescontoVo();

		filter.setChave(chaveCupom);

		List<CupomDescontoVo> list = getList(filter);

		if (list.size() > 0) {
			return list.get(0);
		}

		return null;
	}

}

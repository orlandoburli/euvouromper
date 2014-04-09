package br.com.orlandoburli.euvouromper.model.be.ecommerce;

import br.com.orlandoburli.euvouromper.model.dao.ecommerce.PedidoDao;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.PedidoVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class PedidoBe extends BaseBe<PedidoVo, PedidoDao> {

	public PedidoBe(DAOManager manager) {
		super(manager);
	}

}

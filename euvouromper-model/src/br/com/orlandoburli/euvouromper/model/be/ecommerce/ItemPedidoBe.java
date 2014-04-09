package br.com.orlandoburli.euvouromper.model.be.ecommerce;

import br.com.orlandoburli.euvouromper.model.dao.ecommerce.ItemPedidoDao;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ItemPedidoVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class ItemPedidoBe extends BaseBe<ItemPedidoVo, ItemPedidoDao>{

	public ItemPedidoBe(DAOManager manager) {
		super(manager);
	}

}

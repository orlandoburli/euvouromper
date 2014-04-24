package br.com.orlandoburli.euvouromper.model.be.ecommerce;

import java.util.List;

import br.com.orlandoburli.euvouromper.model.dao.ecommerce.ItemPedidoDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.ItemPedido;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ItemPedidoVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.PedidoVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class ItemPedidoBe extends BaseBe<ItemPedidoVo, ItemPedidoDao> {

	public ItemPedidoBe(DAOManager manager) {
		super(manager);
	}

	public List<ItemPedidoVo> getList(PedidoVo pedido) throws ListException {
		ItemPedidoVo filter = new ItemPedidoVo();
		filter.setPedido(pedido);

		return getList(filter, null, ItemPedido.TABELA_ITEM_PEDIDO + "." + ItemPedido.Colunas.ID_ITEM_PEDIDO);
	}

}

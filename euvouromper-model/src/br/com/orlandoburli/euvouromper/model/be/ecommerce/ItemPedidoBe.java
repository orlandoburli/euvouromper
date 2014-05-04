package br.com.orlandoburli.euvouromper.model.be.ecommerce;

import java.util.List;

import br.com.orlandoburli.euvouromper.model.dao.ecommerce.ItemPedidoDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.ItemPedido;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Pedido;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ClienteVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ItemPedidoVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.PedidoVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.StatusPedido;
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

	public List<ItemPedidoVo> getList(ClienteVo cliente) throws ListException {
		StringBuilder sb = new StringBuilder();

		sb.append(ItemPedido.TABELA_ITEM_PEDIDO + "." + ItemPedido.Colunas.ID_PEDIDO + " IN (");
		sb.append(" SELECT " + Pedido.TABELA_PEDIDO + "." + Pedido.Colunas.ID_PEDIDO + " FROM " + Pedido.TABELA_PEDIDO);
		sb.append(" WHERE " + Pedido.TABELA_PEDIDO + "." + Pedido.Colunas.ID_CLIENTE + " = " + cliente.getIdCliente());
		sb.append(" AND " + Pedido.TABELA_PEDIDO + "." + Pedido.Colunas.STATUS_PEDIDO + " = '" + StatusPedido.PAGO + "' ");
		sb.append(")");
		
		return getList(null, sb.toString(), null);
	}
}

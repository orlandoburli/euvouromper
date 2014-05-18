package br.com.orlandoburli.euvouromper.model.be.ecommerce;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import br.com.orlandoburli.euvouromper.model.dao.ecommerce.ItemPedidoDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.ItemPedido;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Pedido;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ItemPedidoVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.PedidoVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ProdutoVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.StatusPedido;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.TipoProduto;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.TipoValidade;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.cliente.ClienteVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;

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

	public ItemPedidoVo get(Integer idItemPedido, ClienteVo cliente) throws ListException {
		if (idItemPedido == null || idItemPedido == 0) {
			return null;
		}
		
		ItemPedidoVo filter = new ItemPedidoVo();
		filter.setPedido(new PedidoVo());
		filter.getPedido().setStatusPedido(StatusPedido.PAGO);
		filter.setIdItemPedido(idItemPedido);

		List<ItemPedidoVo> list = getList(filter);

		if (list.size() > 0) {
			
			ItemPedidoVo item = list.get(0);
			
			if (checkItemAcessoTotal(item) || checkItem(item)) {
				return item;
			}
		}

		return null;
	}

	/**
	 * Verifica quais destes produtos o cliente já comprou
	 * 
	 * @param produtos
	 *            Lista de produtos a verificar
	 * @param cliente
	 * @throws ListException
	 */
	public void checkComprado(List<ProdutoVo> produtos, ClienteVo cliente) throws ListException {
		// Primeiro, verifica se ele tem o pacote full comprado.
		ItemPedidoVo filterTotal = new ItemPedidoVo();

		filterTotal.setTipoProduto(TipoProduto.TOTAL);
		filterTotal.setPedido(new PedidoVo());
		filterTotal.getPedido().setIdCliente(cliente.getIdCliente());
		filterTotal.getPedido().setStatusPedido(StatusPedido.PAGO);

		List<ItemPedidoVo> itensTotal = getList(filterTotal);

		for (ItemPedidoVo item : itensTotal) {

			if (checkItemAcessoTotal(item)) {
				// Seta o item em todos os produtos
				for (ProdutoVo produto : produtos) {
					produto.setItem(item);
				}

				// Sai do loop, pois nao hà necessidade de checar outros itens
				return;
			}
		}

		for (ProdutoVo produto : produtos) {
			ItemPedidoVo filter = new ItemPedidoVo();
			filter.setIdProduto(produto.getIdProduto());

			filter.setPedido(new PedidoVo());
			filter.getPedido().setIdCliente(cliente.getIdCliente());
			filter.getPedido().setStatusPedido(StatusPedido.PAGO);

			List<ItemPedidoVo> itens = getList(filter);

			for (ItemPedidoVo item : itens) {
				if (checkItem(item)) {
					// Se ja achou um acesso válido para o item, sai do loop
					produto.setItem(item);
					break;
				}
			}
		}
	}

	public boolean checkItem(ItemPedidoVo item) {
		// Verifica se nao está vencido
		Calendar hoje = Calendar.getInstance();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		if (item.getTipoValidade().equals(TipoValidade.DATA)) {
			if (!hoje.after(item.getDataValidade())) {
				// Se nao esta vencido, pode liberar.
				Log.debug("Item de pedido encontrado para o produto " + item.getNome());
				return true;
			} else {
				Log.debug("Item encontrado, mas vencido para o produto " + item.getNome() + " Hoje: " + sdf.format(hoje.getTime()) + " Validade: " + sdf.format(item.getDataValidade().getTime()));
			}
		} else if (item.getTipoValidade().equals(TipoValidade.DIAS)) {
			Calendar validade = item.getPedido().getDataHoraLiberacao();
			validade.add(Calendar.DAY_OF_MONTH, item.getDiasValidade());

			if (!hoje.after(validade)) {
				// Se nao esta vencido, pode liberar.
				Log.debug("Item de pedido encontrado para o produto " + item.getNome());
				return true;
			} else {
				Log.debug("Item encontrado, mas vencido para o produto " + item.getNome() + " Hoje: " + sdf.format(hoje.getTime()) + " Validade: " + sdf.format(validade.getTime()));
			}
		}

		return false;
	}

	public boolean checkItemAcessoTotal(ItemPedidoVo item) {
		
		if (!item.getTipoProduto().equals(TipoProduto.TOTAL)) {
			return false;
		}
		
		// Verifica se nao está vencido
		Calendar hoje = Calendar.getInstance();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		if (item.getTipoValidade().equals(TipoValidade.DATA)) {
			if (!hoje.after(item.getDataValidade())) {
				// Se nao esta vencido, pode liberar.
				Log.debug("Item de pedido encontrado para o produto ACESSO TOTAL");

				return true;
			} else {
				Log.debug("Item encontrado, mas vencido para o produto ACESSO TOTAL Hoje: " + sdf.format(hoje.getTime()) + " Validade: " + sdf.format(item.getDataValidade().getTime()));
			}
		} else if (item.getTipoValidade().equals(TipoValidade.DIAS)) {
			Calendar validade = item.getPedido().getDataHoraLiberacao();
			validade.add(Calendar.DAY_OF_MONTH, item.getDiasValidade());

			if (!hoje.after(validade)) {
				// Se nao esta vencido, pode liberar.
				Log.debug("Item de pedido encontrado para o produto ACESSO TOTAL");

				return true;
			} else {
				Log.debug("Item encontrado, mas vencido para o produto ACESSO TOTAL Hoje: " + sdf.format(hoje.getTime()) + " Validade: " + sdf.format(item.getDataValidade().getTime()));
			}
		}

		return false;
	}
}

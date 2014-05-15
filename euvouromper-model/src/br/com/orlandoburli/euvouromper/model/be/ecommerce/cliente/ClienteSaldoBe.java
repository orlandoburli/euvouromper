package br.com.orlandoburli.euvouromper.model.be.ecommerce.cliente;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.orlandoburli.euvouromper.model.dao.ecommerce.cliente.ClienteSaldoDao;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ItemPedidoVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.TipoProduto;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.cliente.ClienteMovimentacaoVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.cliente.ClienteSaldoVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.cliente.ClienteVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.cliente.TipoMovimentacao;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.SaveBeException;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class ClienteSaldoBe extends BaseBe<ClienteSaldoVo, ClienteSaldoDao> {

	public ClienteSaldoBe(DAOManager manager) {
		super(manager);
	}

	public ClienteSaldoVo get(ClienteVo cliente) throws BeException {
		ClienteSaldoVo clienteSaldo = new ClienteSaldoVo();
		clienteSaldo.setIdCliente(cliente.getIdCliente());

		clienteSaldo = get(clienteSaldo);

		if (clienteSaldo == null) {
			clienteSaldo = new ClienteSaldoVo();
			clienteSaldo.setIdCliente(cliente.getIdCliente());
			clienteSaldo.setSaldo(BigDecimal.ZERO);

			save(clienteSaldo);
		}

		return clienteSaldo;
	}

	/**
	 * Adiciona saldo à conta do cliente.
	 * 
	 * @param cliente
	 *            Cliente que tera o saldo adicionado
	 * @param item
	 *            Item de pedido do saldo
	 * @throws BeException
	 */
	public void adicionarSaldo(ClienteVo cliente, ItemPedidoVo item) throws BeException {
		if (cliente == null) {
			throw new SaveBeException("Cliente não pode ser nulo!");
		}

		if (item == null) {
			throw new SaveBeException("Item do pedido não pode ser nulo!");
		}

		if (!item.getTipoProduto().equals(TipoProduto.CREDITO)) {
			throw new SaveBeException("Item do pedido não é do tipo crédito!");
		}

		ClienteSaldoVo saldo = get(cliente);

		ClienteMovimentacaoVo mov = new ClienteMovimentacaoVo();
		mov.setIdCliente(cliente.getIdCliente());
		mov.setTipoMovimentacao(TipoMovimentacao.CREDITO);
		mov.setDataHora(Calendar.getInstance());
		mov.setHistorico("Crédito pelo pedido de número " + item.getIdPedido() + " item número " + item.getIdItemPedido());

		mov.setValor(item.getValor());
		mov.setSaldoAnterior(saldo.getSaldo());
		mov.setSaldoAtual(saldo.getSaldo().add(item.getValor()));

		mov.setIdItemPedido(item.getIdItemPedido());

		new ClienteMovimentacaoBe(getManager()).save(mov);

		saldo.setSaldo(mov.getSaldoAtual());

		save(saldo);

	}
}

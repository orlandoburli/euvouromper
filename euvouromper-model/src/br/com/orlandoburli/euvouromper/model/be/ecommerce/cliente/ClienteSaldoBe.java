package br.com.orlandoburli.euvouromper.model.be.ecommerce.cliente;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import br.com.orlandoburli.euvouromper.model.be.ecommerce.ProdutoBe;
import br.com.orlandoburli.euvouromper.model.dao.ecommerce.cliente.ClienteSaldoDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.ClienteMovimentacao;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ItemPedidoVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ProdutoVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.TipoProduto;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.cliente.ClienteMovimentacaoVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.cliente.ClienteSaldoVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.cliente.ClienteVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.cliente.TipoMovimentacao;
import br.com.orlandoburli.euvouromper.model.vo.online.VideoVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
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
			throw new SaveBeException("Cliente não pode ser nulo!", "idCliente");
		}

		if (item == null) {
			throw new SaveBeException("Item do pedido não pode ser nulo!", "item");
		}

		if (!item.getTipoProduto().equals(TipoProduto.CREDITO)) {
			throw new SaveBeException("Item do pedido não é do tipo crédito!", null);
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

	/**
	 * Estorna o saldo de um pedido cancelado.
	 * 
	 * @param cliente
	 *            Cliente que tera o saldo adicionado
	 * @param item
	 *            Item de pedido do saldo
	 * @throws BeException
	 */
	public void estornarSaldo(ClienteVo cliente, ItemPedidoVo item) throws BeException {
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
		mov.setTipoMovimentacao(TipoMovimentacao.DEBITO);
		mov.setDataHora(Calendar.getInstance());
		mov.setHistorico("Débito pelo estorno pedido de número " + item.getIdPedido() + " item número " + item.getIdItemPedido());

		mov.setValor(item.getValor());
		mov.setSaldoAnterior(saldo.getSaldo());
		mov.setSaldoAtual(saldo.getSaldo().subtract(item.getValor()));

		mov.setIdItemPedido(item.getIdItemPedido());

		new ClienteMovimentacaoBe(getManager()).save(mov);

		saldo.setSaldo(mov.getSaldoAtual());

		save(saldo);
	}

	public void consumirSaldo(ClienteVo cliente, VideoVo video) throws BeException {
		if (cliente == null) {
			throw new SaveBeException("Cliente não pode ser nulo!");
		}

		ClienteSaldoVo saldo = get(cliente);

		ProdutoVo produto = new ProdutoBe(getManager()).getProdutoVideoIndividual();

		BigDecimal saldoPrevisto = saldo.getSaldo().subtract(produto.getValor());

		if (saldoPrevisto.compareTo(BigDecimal.ZERO) < 0) {
			throw new SaveBeException("Saldo insuficiente para comprar este vídeo!");
		}

		ClienteMovimentacaoVo mov = new ClienteMovimentacaoVo();
		mov.setIdCliente(cliente.getIdCliente());
		mov.setTipoMovimentacao(TipoMovimentacao.DEBITO);
		mov.setDataHora(Calendar.getInstance());
		mov.setHistorico("Débito pela compra do vídeo " + video.getNome() + " Aula " + video.getAula() + " Bloco " + video.getBloco() + " Professor " + video.getProfessor().getNome() + " Disciplina " + video.getDisciplina().getNome() + " Id " + video.getIdVideo());

		mov.setValor(produto.getValor());
		mov.setSaldoAnterior(saldo.getSaldo());

		mov.setSaldoAtual(saldoPrevisto);
		mov.setIdVideo(video.getIdVideo());

		new ClienteMovimentacaoBe(getManager()).save(mov);

		saldo.setSaldo(mov.getSaldoAtual());

		save(saldo);
	}

	public ClienteMovimentacaoVo checkIndividual(ClienteVo cliente, VideoVo video) throws ListException {
		// Verifica se o video foi comprado individualmente
		ClienteMovimentacaoVo filter = new ClienteMovimentacaoVo();
		filter.setIdCliente(cliente.getIdCliente());
		filter.setTipoMovimentacao(TipoMovimentacao.DEBITO);
		filter.setIdVideo(video.getIdVideo());

		List<ClienteMovimentacaoVo> list = new ClienteMovimentacaoBe(getManager()).getList(filter, null, ClienteMovimentacao.TABELA_CLIENTE_MOVIMENTACAO + "." + ClienteMovimentacao.Colunas.ID_MOVIMENTACAO + " DESC");

		ProdutoVo produto = new ProdutoBe(getManager()).getProdutoVideoIndividual();

		for (ClienteMovimentacaoVo item : list) {
			// Verifica se o item nao esta vencido, e se ele pode continuar
			// assistindo
			Calendar dataCompra = item.getDataHora();

			Calendar dataFinal = item.getDataHora();
			dataFinal.add(Calendar.DAY_OF_MONTH, produto.getDiasValidade());

			if (!dataCompra.after(dataFinal)) {
				return item;
			}
		}

		return null;
	}

	public void checkVideos(ClienteVo cliente, List<VideoVo> videos) throws ListException {
		for (VideoVo video : videos) {
			video.setMov(checkIndividual(cliente, video));
		}
	}
}

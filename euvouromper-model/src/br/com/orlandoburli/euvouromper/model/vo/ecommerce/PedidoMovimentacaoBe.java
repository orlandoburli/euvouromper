package br.com.orlandoburli.euvouromper.model.vo.ecommerce;

import java.util.Calendar;
import java.util.List;

import br.com.orlandoburli.euvouromper.model.utils.Dicionario.PedidoMovimentacao;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class PedidoMovimentacaoBe extends BaseBe<PedidoMovimentacaoVo, PedidoMovimentadaoDao> {

	public PedidoMovimentacaoBe(DAOManager manager) {
		super(manager);
	}

	public void geraMovimentacao(PedidoVo pedido) throws BeException {
		// Verifica se houve mudanca no status, de acordo com a ultima
		// movimentacao deste pedido
		PedidoMovimentacaoVo filter = new PedidoMovimentacaoVo();
		filter.setIdPedido(pedido.getIdPedido());

		// Queremos somente a ultima movimentacao
		List<PedidoMovimentacaoVo> list = getList(filter, null, PedidoMovimentacao.TABELA_PEDIDO_MOVIMENTACAO + "." + PedidoMovimentacao.Colunas.ID_MOVIMENTACAO + " DESC", 1, 1);
		if (list.size() > 0) {
			PedidoMovimentacaoVo i = list.get(0);
			if (i.getStatusPedido().equals(pedido.getStatusPedido())) {
				// Se o status da ultima movimentacao for igual, pode sair. Nao
				// precisa gerar outro log.
				return;
			}
		}

		PedidoMovimentacaoVo mov = new PedidoMovimentacaoVo();

		mov.setDataHora(Calendar.getInstance());
		mov.setIdPedido(pedido.getIdPedido());
		mov.setStatusPedido(pedido.getStatusPedido());

		if (pedido.getUsuario() != null) {
			mov.setIdUsuario(pedido.getUsuario().getIdUsuario());
		}

		save(mov);
	}

	public List<PedidoMovimentacaoVo> getList(PedidoVo pedido) throws ListException {
		PedidoMovimentacaoVo filter = new PedidoMovimentacaoVo();
		filter.setIdPedido(pedido.getIdPedido());
		List<PedidoMovimentacaoVo> list = getList(filter, null, PedidoMovimentacao.TABELA_PEDIDO_MOVIMENTACAO + "." + PedidoMovimentacao.Colunas.DATA_HORA + " DESC");
		return list;
	}

}

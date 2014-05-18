package br.com.orlandoburli.euvouromper.model.be.ecommerce.cliente;

import java.util.Calendar;
import java.util.List;

import br.com.orlandoburli.euvouromper.model.dao.ecommerce.cliente.LogVideoDao;
import br.com.orlandoburli.euvouromper.model.domains.SimNao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.LogVideo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ItemPedidoVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ProdutoVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.TipoProduto;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.cliente.ClienteMovimentacaoVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.cliente.ClienteVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.cliente.LogVideoVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.cliente.TipoVisualizacao;
import br.com.orlandoburli.euvouromper.model.vo.online.VideoVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.SaveBeException;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class LogVideoBe extends BaseBe<LogVideoVo, LogVideoDao> {

	public LogVideoBe(DAOManager manager) {
		super(manager);
	}

	public void log(ClienteVo cliente, VideoVo video, ItemPedidoVo item, ProdutoVo produto, String ip, ClienteMovimentacaoVo mov) throws BeException {
		LogVideoVo log = new LogVideoVo();
		log.setIdCliente(cliente.getIdCliente());
		log.setIdVideo(video.getIdVideo());
		log.setEnderecoIp(ip);
		log.setDataHora(Calendar.getInstance());

		if (item != null) {
			log.setIdItemPedido(item.getIdItemPedido());

			if (item.getTipoProduto().equals(TipoProduto.TOTAL)) {
				log.setTipoVisualizacao(TipoVisualizacao.TOTAL);
			} else if (item.getTipoProduto().equals(TipoProduto.PACOTE)) {
				log.setTipoVisualizacao(TipoVisualizacao.PACOTE);
			} else if (item.getTipoProduto().equals(TipoProduto.MODULO)) {
				log.setTipoVisualizacao(TipoVisualizacao.MODULO);
			} else {
				throw new SaveBeException("Tipo de produto " + new TipoProduto().getDescription(item.getTipoProduto()) + " não libera para assistir o Vídeo de ID " + video.getIdVideo() + "! Id do Item: " + item.getIdItemPedido());
			}
		} else if (mov != null) {
			log.setTipoVisualizacao(TipoVisualizacao.INDIVIDUAL);
			log.setIdMovimentacao(mov.getIdMovimentacao());
		} else {
			if (!video.getGratuito().equals(SimNao.SIM)) {
				// Se o video não for gratuito, dispara excecao!
				throw new SaveBeException("Vídeo de ID " + video.getIdVideo() + " não é gratuito! Necessário informar o item de pedido ou a movimentação do cliente.");
			}
			log.setTipoVisualizacao(TipoVisualizacao.GRATUITA);
		}

		if (produto != null) {
			log.setIdProduto(produto.getIdProduto());
		}

		save(log);
	}

	public void checkLog(ClienteVo cliente, List<VideoVo> videos) throws ListException {
		for (VideoVo video : videos) {
			LogVideoVo filter = new LogVideoVo();
			filter.setIdCliente(cliente.getIdCliente());
			filter.setIdVideo(video.getIdVideo());

			List<LogVideoVo> list = getList(filter, null, LogVideo.TABELA_LOG_VIDEO + "." + LogVideo.Colunas.ID_LOG + " DESC", 1, 1);
			if (list.size() > 0) {
				video.setLog(list.get(0));
			}
		}
	}

	public List<LogVideoVo> getUltimasAulas() throws ListException {

		String sql = " log_video.id_produto is not null and log_video.id_log = (select max(l2.id_log) from log_video l2 where l2.id_produto = log_video.id_produto)";

		return getList(null, sql, LogVideo.TABELA_LOG_VIDEO + "." + LogVideo.Colunas.ID_LOG + " DESC", 1, 3);
	}
}

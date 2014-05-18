package br.com.orlandoburli.euvouromper.model.vo.ecommerce.cliente;

import java.util.Calendar;

import br.com.orlandoburli.euvouromper.model.utils.Dicionario.ClienteMovimentacao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.ItemPedido;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.LogVideo;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Produto;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Video;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ItemPedidoVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ProdutoVo;
import br.com.orlandoburli.euvouromper.model.vo.online.VideoVo;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.Domain;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Join;
import br.com.orlandoburli.framework.core.dao.annotations.JoinWhen;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import static br.com.orlandoburli.euvouromper.model.utils.Dicionario.LogVideo.Colunas.*;

@Table(LogVideo.TABELA_LOG_VIDEO)
public class LogVideoVo extends BaseVo {

	@Column(name = ID_LOG, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	private Integer idLog;

	@Column(name = ID_CLIENTE, dataType = DataType.INT, isNotNull = true)
	@NotNull
	@NotEmpty
	private Integer idCliente;

	@Column(name = ID_VIDEO, dataType = DataType.INT, isNotNull = true)
	@NotNull
	@NotEmpty
	private Integer idVideo;

	@Column(name = DATA_HORA, dataType = DataType.DATETIME, isNotNull = true)
	@NotNull
	@NotEmpty
	private Calendar dataHora;

	@Column(name = ENDERECO_IP, dataType = DataType.VARCHAR, isNotNull = true)
	@NotNull
	@NotEmpty
	private String enderecoIp;

	@Column(name = TIPO_VISUALIZACAO, dataType = DataType.CHAR, maxSize = 1, isNotNull = true)
	@NotNull
	@NotEmpty
	@Domain(TipoVisualizacao.class)
	private String tipoVisualizacao;

	@Column(name = ID_ITEM_PEDIDO, dataType = DataType.INT)
	private Integer idItemPedido;

	@Column(name = ID_MOVIMENTACAO, dataType = DataType.INT)
	private Integer idMovimentacao;

	@Column(name = ID_PRODUTO, dataType = DataType.INT)
	private Integer idProduto;

	@Join(columnsLocal = { ID_ITEM_PEDIDO }, columnsRemote = { ItemPedido.Colunas.ID_ITEM_PEDIDO }, joinWhen = JoinWhen.REQUESTED)
	private ItemPedidoVo item;

	@Join(columnsLocal = { ID_MOVIMENTACAO }, columnsRemote = { ClienteMovimentacao.Colunas.ID_MOVIMENTACAO }, joinWhen = JoinWhen.REQUESTED)
	private ClienteMovimentacaoVo mov;

	@Join(columnsLocal = { ID_PRODUTO }, columnsRemote = { Produto.Colunas.ID_PRODUTO }, joinWhen = JoinWhen.ALWAYS)
	private ProdutoVo produto;

	@Join(columnsLocal = { ID_VIDEO }, columnsRemote = { Video.Colunas.ID_VIDEO }, joinWhen = JoinWhen.ALWAYS)
	private VideoVo video;

	public Integer getIdLog() {
		return idLog;
	}

	public void setIdLog(Integer idLog) {
		this.idLog = idLog;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Calendar getDataHora() {
		return dataHora;
	}

	public void setDataHora(Calendar dataHora) {
		this.dataHora = dataHora;
	}

	public String getEnderecoIp() {
		return enderecoIp;
	}

	public void setEnderecoIp(String enderecoIp) {
		this.enderecoIp = enderecoIp;
	}

	public String getTipoVisualizacao() {
		return tipoVisualizacao;
	}

	public void setTipoVisualizacao(String tipoVisualizacao) {
		this.tipoVisualizacao = tipoVisualizacao;
	}

	public Integer getIdItemPedido() {
		return idItemPedido;
	}

	public void setIdItemPedido(Integer idItemPedido) {
		this.idItemPedido = idItemPedido;
	}

	public Integer getIdMovimentacao() {
		return idMovimentacao;
	}

	public void setIdMovimentacao(Integer idMovimentacao) {
		this.idMovimentacao = idMovimentacao;
	}

	public ItemPedidoVo getItem() {
		return item;
	}

	public void setItem(ItemPedidoVo item) {
		this.item = item;
	}

	public ClienteMovimentacaoVo getMov() {
		return mov;
	}

	public void setMov(ClienteMovimentacaoVo mov) {
		this.mov = mov;
	}

	public Integer getIdVideo() {
		return idVideo;
	}

	public void setIdVideo(Integer idVideo) {
		this.idVideo = idVideo;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public ProdutoVo getProduto() {
		return produto;
	}

	public void setProduto(ProdutoVo produto) {
		this.produto = produto;
	}

	public VideoVo getVideo() {
		return video;
	}

	public void setVideo(VideoVo video) {
		this.video = video;
	}
}

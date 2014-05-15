package br.com.orlandoburli.euvouromper.model.vo.ecommerce.cliente;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Cliente;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.ClienteMovimentacao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.ItemPedido;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Video;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ItemPedidoVo;
import br.com.orlandoburli.euvouromper.model.vo.online.VideoVo;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.Precision;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.Domain;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNegative;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Join;
import br.com.orlandoburli.framework.core.dao.annotations.JoinWhen;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import static br.com.orlandoburli.euvouromper.model.utils.Dicionario.ClienteMovimentacao.Colunas.*;

@Table(ClienteMovimentacao.TABELA_CLIENTE_MOVIMENTACAO)
public class ClienteMovimentacaoVo extends BaseVo {

	@Column(name = ID_MOVIMENTACAO, dataType = DataType.INT, isNotNull = true, isKey = true, isAutoIncrement = true)
	private Integer idMovimentacao;

	@Column(name = ID_CLIENTE, dataType = DataType.INT, isNotNull = true)
	@NotNull
	@NotEmpty
	private Integer idCliente;

	@Column(name = DATA_HORA, dataType = DataType.DATETIME, isNotNull = true)
	@NotNull
	private Calendar dataHora;

	@Column(name = TIPO_MOVIMENTACAO, dataType = DataType.CHAR, maxSize = 1, isNotNull = true)
	@NotNull
	@NotEmpty
	@Domain(TipoMovimentacao.class)
	private String tipoMovimentacao;

	@Column(name = HISTORICO, dataType = DataType.VARCHAR, maxSize = 200)
	private String historico;

	@Column(name = VALOR, dataType = DataType.NUMERIC, maxSize = 10, precision = 2)
	@NotNull
	@NotEmpty
	@NotNegative
	@Precision(2)
	private BigDecimal valor;

	@Column(name = SALDO_ANTERIOR, dataType = DataType.NUMERIC, maxSize = 10, precision = 2)
	@NotNull
	@NotEmpty
	@NotNegative
	@Precision(2)
	private BigDecimal saldoAnterior;

	@Column(name = SALDO_ATUAL, dataType = DataType.NUMERIC, maxSize = 10, precision = 2)
	@NotNull
	@NotEmpty
	@NotNegative
	@Precision(2)
	private BigDecimal saldoAtual;

	@Column(name = ID_ITEM_PEDIDO, dataType = DataType.INT)
	private Integer idItemPedido;

	@Column(name = ID_VIDEO, dataType = DataType.INT)
	private Integer idVideo;

	@Join(columnsLocal = { ID_ITEM_PEDIDO }, columnsRemote = { ItemPedido.Colunas.ID_ITEM_PEDIDO }, joinWhen = JoinWhen.REQUESTED)
	private ItemPedidoVo itemPedido;

	@Join(columnsLocal = { ID_VIDEO }, columnsRemote = { Video.Colunas.ID_VIDEO })
	private VideoVo video;

	@Join(columnsLocal = { ID_CLIENTE }, columnsRemote = { Cliente.Colunas.ID_CLIENTE }, joinWhen = JoinWhen.REQUESTED)
	private ClienteVo cliente;

	public Integer getIdMovimentacao() {
		return idMovimentacao;
	}

	public void setIdMovimentacao(Integer idMovimentacao) {
		this.idMovimentacao = idMovimentacao;
	}

	public Calendar getDataHora() {
		return dataHora;
	}

	public void setDataHora(Calendar dataHora) {
		this.dataHora = dataHora;
	}

	public String getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(String tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getSaldoAnterior() {
		return saldoAnterior;
	}

	public void setSaldoAnterior(BigDecimal saldoAnterior) {
		this.saldoAnterior = saldoAnterior;
	}

	public BigDecimal getSaldoAtual() {
		return saldoAtual;
	}

	public void setSaldoAtual(BigDecimal saldoAtual) {
		this.saldoAtual = saldoAtual;
	}

	public Integer getIdItemPedido() {
		return idItemPedido;
	}

	public void setIdItemPedido(Integer idItemPedido) {
		this.idItemPedido = idItemPedido;
	}

	public Integer getIdVideo() {
		return idVideo;
	}

	public void setIdVideo(Integer idVideo) {
		this.idVideo = idVideo;
	}

	public ItemPedidoVo getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(ItemPedidoVo itemPedido) {
		this.itemPedido = itemPedido;
	}

	public VideoVo getVideo() {
		return video;
	}

	public void setVideo(VideoVo video) {
		this.video = video;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public ClienteVo getCliente() {
		return cliente;
	}

	public void setCliente(ClienteVo cliente) {
		this.cliente = cliente;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}
}

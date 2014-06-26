package br.com.orlandoburli.euvouromper.model.vo.ecommerce;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.orlandoburli.euvouromper.model.domains.SimNao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Modulo;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Pacote;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Pedido;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Produto;
import br.com.orlandoburli.euvouromper.model.vo.online.ModuloVo;
import br.com.orlandoburli.euvouromper.model.vo.online.PacoteVo;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.Domain;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MaxSize;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MinSize;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNegative;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Join;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import static br.com.orlandoburli.euvouromper.model.utils.Dicionario.ItemPedido.Colunas.*;

@Table(Dicionario.ItemPedido.TABELA_ITEM_PEDIDO)
public class ItemPedidoVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	@Column(name = ID_ITEM_PEDIDO, dataType = DataType.INT, isNotNull = true, isKey = true, isAutoIncrement = true)
	private Integer idItemPedido;

	@Column(name = ID_PEDIDO, dataType = DataType.INT, isNotNull = true)
	@NotNull
	@Description("Pedido")
	private Integer idPedido;

	@Column(name = ID_PRODUTO, dataType = DataType.INT, isNotNull = true)
	@NotNull
	private Integer idProduto;

	@Column(name = NOME, dataType = DataType.VARCHAR, maxSize = 100, isNotNull = true)
	@NotNull
	@NotEmpty
	@MinSize(4)
	@MaxSize(100)
	@Description("Nome")
	private String nome;

	@Column(name = TIPO_PRODUTO, dataType = DataType.CHAR, maxSize = 1, isNotNull = true)
	@NotNull
	@NotEmpty
	@MinSize(1)
	@MaxSize(1)
	@Domain(TipoProduto.class)
	@Description("Tipo de Produto")
	private String tipoProduto;

	@Column(name = VALOR, dataType = DataType.NUMERIC, maxSize = 10, precision = 2, isNotNull = true)
	@NotNull
	@NotNegative
	@Description("Valor")
	private BigDecimal valor;

	@Column(name = ID_PACOTE, dataType = DataType.INT)
	private Integer idPacote;

	@Column(name = ID_MODULO, dataType = DataType.INT)
	private Integer idModulo;

	@Column(name = TIPO_VALIDADE, dataType = DataType.CHAR, maxSize = 1, isNotNull = true)
	@NotNull
	@NotEmpty
	@MaxSize(1)
	@MinSize(1)
	@Domain(TipoValidade.class)
	@Description("Tipo de Validade")
	private String tipoValidade;

	@Column(name = DIAS_VALIDADE, dataType = DataType.INT)
	@Description("Dias")
	private Integer diasValidade;

	@Column(name = DATA_VALIDADE, dataType = DataType.DATE)
	@Description("Data de Validade")
	private Calendar dataValidade;

	@Column(name = RECORRENTE, dataType = DataType.CHAR, maxSize = 1, isNotNull = true)
	@NotNull
	@NotEmpty
	@MinSize(1)
	@MaxSize(1)
	@Domain(SimNao.class)
	@Description("Recorrente")
	private String recorrente;

	@Column(name = DIAS_RECORRENCIA, dataType = DataType.INT)
	@Description("Dias recorrência")
	private Integer diasRecorrencia;

	@Join(columnsLocal = { ID_MODULO }, columnsRemote = { Modulo.Colunas.ID_MODULO })
	private ModuloVo modulo;

	@Join(columnsLocal = { ID_PACOTE }, columnsRemote = { Pacote.Colunas.ID_PACOTE })
	private PacoteVo pacote;

	@Join(columnsLocal = { ID_PEDIDO }, columnsRemote = { Pedido.Colunas.ID_PEDIDO })
	private PedidoVo pedido;

	@Join(columnsLocal = { ID_PRODUTO }, columnsRemote = { Produto.Colunas.ID_PRODUTO })
	private ProdutoVo produto;

	public PedidoVo getPedido() {
		return pedido;
	}

	public void setPedido(PedidoVo pedido) {
		this.pedido = pedido;
	}

	public Integer getIdItemPedido() {
		return idItemPedido;
	}

	public void setIdItemPedido(Integer idItemPedido) {
		this.idItemPedido = idItemPedido;
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getIdPacote() {
		return idPacote;
	}

	public void setIdPacote(Integer idPacote) {
		this.idPacote = idPacote;
	}

	public Integer getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(Integer idModulo) {
		this.idModulo = idModulo;
	}

	public String getTipoValidade() {
		return tipoValidade;
	}

	public void setTipoValidade(String tipoValidade) {
		this.tipoValidade = tipoValidade;
	}

	public Integer getDiasValidade() {
		return diasValidade;
	}

	public void setDiasValidade(Integer diasValidade) {
		this.diasValidade = diasValidade;
	}

	public Calendar getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Calendar dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String getRecorrente() {
		return recorrente;
	}

	public void setRecorrente(String recorrente) {
		this.recorrente = recorrente;
	}

	public Integer getDiasRecorrencia() {
		return diasRecorrencia;
	}

	public void setDiasRecorrencia(Integer diasRecorrencia) {
		this.diasRecorrencia = diasRecorrencia;
	}

	public ModuloVo getModulo() {
		return modulo;
	}

	public void setModulo(ModuloVo modulo) {
		this.modulo = modulo;
	}

	public PacoteVo getPacote() {
		return pacote;
	}

	public void setPacote(PacoteVo pacote) {
		this.pacote = pacote;
	}

	public ProdutoVo getProduto() {
		return produto;
	}

	public void setProduto(ProdutoVo produto) {
		this.produto = produto;
	}
}

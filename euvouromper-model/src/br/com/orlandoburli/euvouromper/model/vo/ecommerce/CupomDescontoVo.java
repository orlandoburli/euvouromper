package br.com.orlandoburli.euvouromper.model.vo.ecommerce;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Cliente;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Produto;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.Precision;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.Domain;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MinSize;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNegative;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MaxSize;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotZero;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Join;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import static br.com.orlandoburli.euvouromper.model.utils.Dicionario.CupomDesconto.Colunas.*;

@Table(Dicionario.CupomDesconto.TABELA_CUPOM_DESCONTO)
public class CupomDescontoVo extends BaseVo {

	@Column(name = ID_CUPOM, dataType = DataType.INT, isNotNull = true, isKey = true, isAutoIncrement = true)
	private Integer idCupom;

	@Column(name = DESCRICAO, dataType = DataType.VARCHAR, maxSize = 100)
	@MaxSize(100)
	@NotNull
	@NotEmpty
	@Description("Descrição")
	private String descricao;

	@Column(name = CHAVE, dataType = DataType.VARCHAR, maxSize = 20, isNotNull = true)
	@MaxSize(20)
	@MinSize(4)
	@Description("Chave")
	private String chave;

	@Column(name = ID_PRODUTO_DESTINO, dataType = DataType.INT)
	private Integer idProdutoDestino;

	@Column(name = TIPO_DESCONTO, dataType = DataType.CHAR, maxSize = 1, isNotNull = true)
	@MaxSize(1)
	@MinSize(1)
	@NotNull
	@NotEmpty
	@Domain(TipoDesconto.class)
	@Description("Tipo de desconto")
	private String tipoDesconto;

	@Column(name = ID_CLIENTE, dataType = DataType.INT)
	private Integer idCliente;

	@Column(name = DATA_VALIDADE, dataType = DataType.DATE)
	private Calendar dataValidade;
	
	@Column(name  = VALOR, dataType = DataType.NUMERIC, maxSize = 10, precision = 2)
	@Precision(2)
	@NotNull
	@NotEmpty
	@NotZero
	@NotNegative
	@Description("Valor do desconto")
	private BigDecimal valor;

	@Join(columnsLocal = { ID_PRODUTO_DESTINO }, columnsRemote = { Produto.Colunas.ID_PRODUTO })
	private ProdutoVo produto;

	@Join(columnsLocal = { ID_CLIENTE }, columnsRemote = { Cliente.Colunas.ID_CLIENTE })
	private ClienteVo cliente;

	public Integer getIdCupom() {
		return idCupom;
	}

	public void setIdCupom(Integer idCupom) {
		this.idCupom = idCupom;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public Integer getIdProdutoDestino() {
		return idProdutoDestino;
	}

	public void setIdProdutoDestino(Integer idProdutoDestino) {
		this.idProdutoDestino = idProdutoDestino;
	}

	public String getTipoDesconto() {
		return tipoDesconto;
	}

	public void setTipoDesconto(String tipoDesconto) {
		this.tipoDesconto = tipoDesconto;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Calendar getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Calendar dataValidade) {
		this.dataValidade = dataValidade;
	}

	public ProdutoVo getProduto() {
		return produto;
	}

	public void setProduto(ProdutoVo produto) {
		this.produto = produto;
	}

	public ClienteVo getCliente() {
		return cliente;
	}

	public void setCliente(ClienteVo cliente) {
		this.cliente = cliente;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}

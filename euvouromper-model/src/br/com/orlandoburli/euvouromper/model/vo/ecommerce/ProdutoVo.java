package br.com.orlandoburli.euvouromper.model.vo.ecommerce;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.orlandoburli.euvouromper.model.domains.SimNao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Modulo;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Pacote;
import br.com.orlandoburli.euvouromper.model.vo.online.ModuloVo;
import br.com.orlandoburli.euvouromper.model.vo.online.PacoteVo;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.FilterOnly;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.FullTrim;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.Lower;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.NoAccents;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.SpaceToUnderline;
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
import static br.com.orlandoburli.euvouromper.model.utils.Dicionario.Produto.Colunas.*;

@Table(Dicionario.Produto.TABELA_PRODUTO)
public class ProdutoVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	@Column(name = ID_PRODUTO, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	private Integer idProduto;

	@Column(name = NOME, dataType = DataType.VARCHAR, maxSize = 100, isNotNull = true)
	@NotNull
	@NotEmpty
	@MinSize(4)
	@MaxSize(100)
	@Description("Nome")
	private String nome;

	@Column(name = DESCRICAO, dataType = DataType.TEXT)
	private String descricao;

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

	@Column(name = ATIVO, dataType = DataType.CHAR, maxSize = 1, isNotNull = true)
	@NotNull
	@NotEmpty
	@MinSize(1)
	@MaxSize(1)
	@Domain(SimNao.class)
	@Description("Ativo")
	private String ativo;

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

	@Column(name = URL, dataType = DataType.VARCHAR, maxSize = 300)
	@FullTrim
	@Lower
	@NoAccents
	@FilterOnly("abcdefghijhlmnopqrstuvxzwyk1234567890_ ")
	@SpaceToUnderline
	@Description("URL")
	private String url;

	@Column(name = PATH_FOTO, maxSize = 100, dataType = DataType.VARCHAR)
	private String pathFoto;

	@Join(columnsLocal = { ID_MODULO }, columnsRemote = { Modulo.Colunas.ID_MODULO })
	private ModuloVo modulo;

	@Join(columnsLocal = { ID_PACOTE }, columnsRemote = { Pacote.Colunas.ID_PACOTE })
	private PacoteVo pacote;
	
	/**
	 * Item do pedido, apenas para referencia.
	 */
	private ItemPedidoVo item;

	public String getAtivoDescritivo() {
		return new SimNao().getDescription(getAtivo());
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
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

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
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

	public String getPathFoto() {
		return pathFoto;
	}

	public void setPathFoto(String pathFoto) {
		this.pathFoto = pathFoto;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ItemPedidoVo getItem() {
		return item;
	}

	public void setItem(ItemPedidoVo item) {
		this.item = item;
	}
}

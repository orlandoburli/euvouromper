package br.com.orlandoburli.euvouromper.model.vo.ecommerce;

import static br.com.orlandoburli.euvouromper.model.utils.Dicionario.CupomDesconto.Colunas.ID_CUPOM;
import static br.com.orlandoburli.euvouromper.model.utils.Dicionario.Pedido.Colunas.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Cliente;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.CupomDesconto;
import br.com.orlandoburli.euvouromper.model.vo.admin.UsuarioVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.cliente.ClienteVo;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.FilterOnly;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.NoSpace;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.Precision;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.Domain;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.Email;
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

@Table(Dicionario.Pedido.TABELA_PEDIDO)
public class PedidoVo extends BaseVo {

	@Column(name = ID_PEDIDO, dataType = DataType.INT, isNotNull = true, isAutoIncrement = true, isKey = true)
	private Integer idPedido;

	@Column(name = ID_CLIENTE, dataType = DataType.INT, isNotNull = true)
	@NotNull
	@Description("Cliente")
	private Integer idCliente;

	@Column(name = STATUS_PEDIDO, dataType = DataType.CHAR, maxSize = 1, isNotNull = true)
	@NotNull
	@NotEmpty
	@MinSize(1)
	@MaxSize(1)
	@Domain(StatusPedido.class)
	@Description("Status do Pedido")
	private String statusPedido;

	@Column(name = ID_PAGSEGURO, dataType = DataType.VARCHAR, maxSize = 100)
	@MaxSize(100)
	@Description("Id do PagSeguro")
	private String idPagSeguro;

	@Column(name = ID_CUPOM, dataType = DataType.INT)
	private Integer idCupom;

	@Column(name = DATA_HORA_LIBERACAO, dataType = DataType.DATETIME)
	@Description("Data / Hora da Liberação")
	private Calendar dataHoraLiberacao;

	@Column(name = DATA_HORA_PEDIDO, dataType = DataType.DATETIME, isNotNull = true)
	@NotNull
	@NotEmpty
	@Description("Data / Hora do pedido")
	private Calendar dataHoraPedido;

	@Column(name = NOME, dataType = DataType.VARCHAR, maxSize = 100, isNotNull = true)
	@NotNull
	@NotEmpty
	@MinSize(5)
	@Description("Nome do Cliente")
	private String nome;

	@Column(name = EMAIL, dataType = DataType.VARCHAR, maxSize = 300, isNotNull = true)
	@Email
	@NotNull
	@NotEmpty
	private String email;

	@Column(name = CPF, dataType = DataType.VARCHAR, maxSize = 15, isNotNull = true)
	@NotNull
	@NotEmpty
	@Description("CPF")
	private String cpf;

	@Column(name = CEP, dataType = DataType.VARCHAR, maxSize = 8)
	@NotNull
	@NotEmpty
	@MinSize(8)
	@MaxSize(8)
	@NoSpace
	@FilterOnly("1234567890")
	private String cep;

	@Column(name = ENDERECO, dataType = DataType.VARCHAR, maxSize = 100)
	@NotNull
	@NotEmpty
	@Description("Endereço")
	private String endereco;

	@Column(name = NUMERO, dataType = DataType.INT)
	@NotNull
	@NotEmpty
	@Description("Número")
	private Integer numero;

	@Column(name = BAIRRO, dataType = DataType.VARCHAR, maxSize = 100)
	private String bairro;

	@Column(name = COMPLEMENTO, dataType = DataType.VARCHAR, maxSize = 150)
	@Description("Complemento")
	private String complemento;

	@Column(name = UF, dataType = DataType.VARCHAR, maxSize = 2)
	@MinSize(2)
	@MaxSize(2)
	@Description("UF")
	private String uf;

	@Column(name = CIDADE, dataType = DataType.VARCHAR, maxSize = 100)
	private String cidade;

	@Column(name = FONE1, dataType = DataType.VARCHAR, maxSize = 20)
	private String fone1;

	@Column(name = FONE2, dataType = DataType.VARCHAR, maxSize = 20)
	private String fone2;

	@Column(name = VALOR_BRUTO, dataType = DataType.NUMERIC, maxSize = 10, precision = 2)
	@NotNull
	@NotEmpty
	@NotNegative
	@Description("Valor Bruto")
	@Precision(2)
	private BigDecimal valorBruto;

	@Column(name = VALOR_DESCONTO, dataType = DataType.NUMERIC, maxSize = 10, precision = 2)
	@NotNull
	@NotEmpty
	@NotNegative
	@Description("Valor Desconto")
	@Precision(2)
	private BigDecimal valorDesconto;

	@Column(name = VALOR_LIQUIDO, dataType = DataType.NUMERIC, maxSize = 10, precision = 2)
	@NotNull
	@NotEmpty
	@NotNegative
	@Description("Valor Líquido")
	@Precision(2)
	private BigDecimal valorLiquido;

	@Join(columnsLocal = { ID_CLIENTE }, columnsRemote = { Cliente.Colunas.ID_CLIENTE })
	private ClienteVo cliente;

	@Join(columnsLocal = { ID_CUPOM }, columnsRemote = { CupomDesconto.Colunas.ID_CUPOM })
	private CupomDescontoVo cupom;

	@Column(name = URL_PAG_SEGURO, dataType = DataType.VARCHAR, maxSize = 300)
	private String urlPagSeguro;

	private List<ItemPedidoVo> itens;
	
	/**
	 * Este usuario é meramente para transporte de dados.
	 */
	private UsuarioVo usuario;
	
	public String getStatusPedidoDescritivo() {
		return new StatusPedido().getDescription(this.getStatusPedido());
	}

	public Integer getQuantidadeItens() {
		return getItens().size();
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(String statusPedido) {
		this.statusPedido = statusPedido;
	}

	public String getIdPagSeguro() {
		return idPagSeguro;
	}

	public void setIdPagSeguro(String idPagSeguro) {
		this.idPagSeguro = idPagSeguro;
	}

	public Calendar getDataHoraLiberacao() {
		return dataHoraLiberacao;
	}

	public void setDataHoraLiberacao(Calendar dataHoraLiberacao) {
		this.dataHoraLiberacao = dataHoraLiberacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getFone1() {
		return fone1;
	}

	public void setFone1(String fone1) {
		this.fone1 = fone1;
	}

	public String getFone2() {
		return fone2;
	}

	public void setFone2(String fone2) {
		this.fone2 = fone2;
	}

	public BigDecimal getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(BigDecimal valorBruto) {
		this.valorBruto = valorBruto;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public BigDecimal getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(BigDecimal valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	public ClienteVo getCliente() {
		return cliente;
	}

	public void setCliente(ClienteVo cliente) {
		this.cliente = cliente;
	}

	public Integer getIdCupom() {
		return idCupom;
	}

	public void setIdCupom(Integer idCupom) {
		this.idCupom = idCupom;
	}

	public CupomDescontoVo getCupom() {
		return cupom;
	}

	public void setCupom(CupomDescontoVo cupom) {
		this.cupom = cupom;
	}

	public List<ItemPedidoVo> getItens() {
		if (itens == null) {
			itens = new ArrayList<ItemPedidoVo>();
		}
		return itens;
	}

	public void setItens(List<ItemPedidoVo> itens) {
		this.itens = itens;
	}

	public String getUrlPagSeguro() {
		return urlPagSeguro;
	}

	public void setUrlPagSeguro(String urlPagSeguro) {
		this.urlPagSeguro = urlPagSeguro;
	}

	public Calendar getDataHoraPedido() {
		return dataHoraPedido;
	}

	public void setDataHoraPedido(Calendar dataHoraPedido) {
		this.dataHoraPedido = dataHoraPedido;
	}

	public UsuarioVo getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioVo usuario) {
		this.usuario = usuario;
	}
}

package br.com.orlandoburli.euvouromper.model.vo.ecommerce;

import java.util.Calendar;

import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Cliente;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Produto;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.cliente.ClienteVo;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.Domain;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MaxSize;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Join;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import static br.com.orlandoburli.euvouromper.model.utils.Dicionario.Mensagem.Colunas.*;

@Table(Dicionario.Mensagem.TABELA_MENSAGEM)
public class MensagemVo extends BaseVo {

	@Column(name = ID_MENSAGEM, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	private Integer idMensagem;

	@Column(name = ASSUNTO, dataType = DataType.VARCHAR, maxSize = 200)
	@NotNull
	@NotEmpty
	@MaxSize(200)
	@Description("Assunto")
	private String assunto;

	@Column(name = DESTINO, maxSize = 1, dataType = DataType.CHAR, isNotNull = true)
	@NotNull
	@NotEmpty
	@Domain(TipoDestinoMensagens.class)
	@Description("Destino")
	private String destino;

	@Column(name = REMETENTE, maxSize = 200, dataType = DataType.VARCHAR)
	@NotNull
	@NotEmpty
	@Description("Remetente")
	private String remetente;

	@Column(name = DATA_INICIAL, dataType = DataType.DATE)
	private Calendar dataInicial;

	@Column(name = DATA_FINAL, dataType = DataType.DATE)
	private Calendar dataFinal;

	@Column(name = ID_CLIENTE, dataType = DataType.INT)
	@Description("Cliente")
	private Integer idCliente;

	@Column(name = ID_PRODUTO, dataType = DataType.INT)
	@Description("Produto")
	private Integer idProduto;

	@Column(name = STATUS, dataType = DataType.CHAR, maxSize = 1, isNotNull = true)
	@NotNull
	@NotEmpty
	@Domain(StatusMensagem.class)
	@Description("Status")
	private String status;

	@Column(name = MENSAGEM, dataType = DataType.TEXT)
	@Description("Mensagem")
	private String mensagem;

	@Join(columnsLocal = { ID_CLIENTE }, columnsRemote = { Cliente.Colunas.ID_CLIENTE })
	private ClienteVo cliente;

	@Join(columnsLocal = { ID_PRODUTO }, columnsRemote = { Produto.Colunas.ID_PRODUTO })
	private ProdutoVo produto;

	private boolean lida = false;

	public String getDestinoDescritivo() {
		return new TipoDestinoMensagens().getDescription(getDestino());
	}

	public String getStatusDescritivo() {
		return new StatusMensagem().getDescription(getStatus());
	}

	public Integer getIdMensagem() {
		return idMensagem;
	}

	public void setIdMensagem(Integer idMensagem) {
		this.idMensagem = idMensagem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public ClienteVo getCliente() {
		return cliente;
	}

	public void setCliente(ClienteVo cliente) {
		this.cliente = cliente;
	}

	public ProdutoVo getProduto() {
		return produto;
	}

	public void setProduto(ProdutoVo produto) {
		this.produto = produto;
	}

	public Calendar getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Calendar dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Calendar getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Calendar dataFinal) {
		this.dataFinal = dataFinal;
	}

	public String getRemetente() {
		return remetente;
	}

	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}

	/**
	 * Indica se a mensagem ja foi lida.
	 * 
	 * @return Booleano que indica se a mensagem ja foi lida.
	 */
	public boolean isLida() {
		return lida;
	}

	/**
	 * Indica se a mensagem ja foi lida.
	 * 
	 * @param lida
	 *            Booleano que indica se a mensagem ja foi lida.
	 */
	public void setLida(boolean lida) {
		this.lida = lida;
	}
}

package br.com.orlandoburli.euvouromper.model.vo.ecommerce.cliente;

import java.math.BigDecimal;

import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Cliente;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.ClienteMovimentacao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.ClienteSaldo;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.Precision;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNegative;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Join;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import static br.com.orlandoburli.euvouromper.model.utils.Dicionario.ClienteSaldo.Colunas.*;

@Table(ClienteSaldo.TABELA_CLIENTE_SALDO)
public class ClienteSaldoVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	@Column(name = ID_CLIENTE, dataType = DataType.INT, isNotNull = true, isKey = true)
	private Integer idCliente;

	@Column(name = SALDO, dataType = DataType.NUMERIC, maxSize = 10, precision = 2, isNotNull = true)
	@NotNull
	@NotEmpty
	@NotNegative
	@Precision(2)
	private BigDecimal saldo;

	@Column(name = ID_ULTIMA_MOVIMENTACAO, dataType = DataType.INT)
	private Integer idUltimaMovimentacao;

	@Join(columnsLocal = { ID_CLIENTE }, columnsRemote = { Cliente.Colunas.ID_CLIENTE })
	private ClienteVo cliente;

	// ultima movimentacao
	@Join(columnsLocal = { ID_ULTIMA_MOVIMENTACAO }, columnsRemote = { ClienteMovimentacao.Colunas.ID_MOVIMENTACAO })
	private ClienteMovimentacaoVo ultimaMovimentacao;

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public Integer getIdUltimaMovimentacao() {
		return idUltimaMovimentacao;
	}

	public void setIdUltimaMovimentacao(Integer idUltimaMovimentacao) {
		this.idUltimaMovimentacao = idUltimaMovimentacao;
	}

	public ClienteVo getCliente() {
		return cliente;
	}

	public void setCliente(ClienteVo cliente) {
		this.cliente = cliente;
	}

	public ClienteMovimentacaoVo getUltimaMovimentacao() {
		return ultimaMovimentacao;
	}

	public void setUltimaMovimentacao(ClienteMovimentacaoVo ultimaMovimentacao) {
		this.ultimaMovimentacao = ultimaMovimentacao;
	}
}

package br.com.orlandoburli.euvouromper.model.vo.ecommerce;

import java.util.Calendar;

import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Cliente;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Mensagem;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.MensagemLida;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.cliente.ClienteVo;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Join;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.dao.annotations.UniqueConstraint;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import static br.com.orlandoburli.euvouromper.model.utils.Dicionario.MensagemLida.Colunas.*;

@Table(value = Dicionario.MensagemLida.TABELA_MENSAGEM_LIDA, constraints = { @UniqueConstraint(columns = { ID_MENSAGEM, ID_CLIENTE }, constraintName = MensagemLida.UNIQUE_MENSAGEM_LIDA) })
public class MensagemLidaVo extends BaseVo {

	@Column(name = ID_MENSAGEM_LIDA, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	private Integer idMensagemLida;

	@Column(name = ID_MENSAGEM, dataType = DataType.INT, isNotNull = true)
	@NotNull
	@NotEmpty
	private Integer idMensagem;

	@Column(name = ID_CLIENTE, dataType = DataType.INT, isNotNull = true)
	@NotNull
	@NotEmpty
	private Integer idCliente;
	
	@Column(name = DATA_HORA, dataType = DataType.DATETIME, isNotNull = true)
	@NotNull
	@NotEmpty
	private Calendar dataHora;

	@Join(columnsLocal = { ID_MENSAGEM }, columnsRemote = { Mensagem.Colunas.ID_MENSAGEM })
	private MensagemVo mensagem;

	@Join(columnsLocal = { ID_CLIENTE }, columnsRemote = { Cliente.Colunas.ID_CLIENTE })
	private ClienteVo cliente;

	public Integer getIdMensagemLida() {
		return idMensagemLida;
	}

	public void setIdMensagemLida(Integer idMensagemLida) {
		this.idMensagemLida = idMensagemLida;
	}

	public Integer getIdMensagem() {
		return idMensagem;
	}

	public void setIdMensagem(Integer idMensagem) {
		this.idMensagem = idMensagem;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public MensagemVo getMensagem() {
		return mensagem;
	}

	public void setMensagem(MensagemVo mensagem) {
		this.mensagem = mensagem;
	}

	public ClienteVo getCliente() {
		return cliente;
	}

	public void setCliente(ClienteVo cliente) {
		this.cliente = cliente;
	}

	public Calendar getDataHora() {
		return dataHora;
	}

	public void setDataHora(Calendar dataHora) {
		this.dataHora = dataHora;
	}
}

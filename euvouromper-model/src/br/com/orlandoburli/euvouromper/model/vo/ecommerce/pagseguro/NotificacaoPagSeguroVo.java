package br.com.orlandoburli.euvouromper.model.vo.ecommerce.pagseguro;

import java.util.Calendar;

import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MaxSize;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import static br.com.orlandoburli.euvouromper.model.utils.Dicionario.NotificacaoPagSeguro.Colunas.*;

@Table(Dicionario.NotificacaoPagSeguro.TABELA_NOTIFICACAO_PAGSEGURO)
public class NotificacaoPagSeguroVo extends BaseVo {

	@Column(name = ID_NOTIFICACAO, dataType = DataType.INT, isNotNull = true, isKey = true, isAutoIncrement = true)
	private Integer idNotificacao;

	@Column(name = CODIGO_NOTIFICACAO, dataType = DataType.VARCHAR, maxSize = 50, isNotNull = true)
	@NotNull
	@NotEmpty
	@MaxSize(50)
	private String codigoNotificacao;

	@Column(name = DATA_HORA, dataType = DataType.DATETIME, isNotNull = true)
	private Calendar dataHora;

	@Column(name = STATUS, dataType = DataType.INT)
	private Integer status;

	public Integer getIdNotificacao() {
		return idNotificacao;
	}

	public void setIdNotificacao(Integer idNotificacao) {
		this.idNotificacao = idNotificacao;
	}

	public String getCodigoNotificacao() {
		return codigoNotificacao;
	}

	public void setCodigoNotificacao(String codigoNotificacao) {
		this.codigoNotificacao = codigoNotificacao;
	}

	public Calendar getDataHora() {
		return dataHora;
	}

	public void setDataHora(Calendar dataHora) {
		this.dataHora = dataHora;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}

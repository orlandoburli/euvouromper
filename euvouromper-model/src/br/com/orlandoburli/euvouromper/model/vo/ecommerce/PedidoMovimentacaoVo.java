package br.com.orlandoburli.euvouromper.model.vo.ecommerce;

import java.util.Calendar;

import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Pedido;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.PedidoMovimentacao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Usuario;
import br.com.orlandoburli.euvouromper.model.vo.admin.UsuarioVo;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.Domain;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Join;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import static br.com.orlandoburli.euvouromper.model.utils.Dicionario.PedidoMovimentacao.Colunas.*;

@Table(PedidoMovimentacao.TABELA_PEDIDO_MOVIMENTACAO)
public class PedidoMovimentacaoVo extends BaseVo {

	@Column(name = ID_MOVIMENTACAO, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	private Integer idMovimentacao;

	@Column(name = ID_PEDIDO, dataType = DataType.INT, isNotNull = true)
	@NotNull
	@NotEmpty
	private Integer idPedido;

	@Column(name = DATA_HORA, dataType = DataType.DATETIME, isNotNull = true)
	@NotNull
	@NotEmpty
	private Calendar dataHora;

	@Column(name = STATUS_PEDIDO, dataType = DataType.CHAR, maxSize = 1, isNotNull = true)
	@NotNull
	@NotEmpty
	@Domain(StatusPedido.class)
	private String statusPedido;

	@Column(name = ID_USUARIO, dataType = DataType.INT)
	private Integer idUsuario;

	@Join(columnsLocal = { ID_USUARIO }, columnsRemote = { Usuario.Colunas.ID_USUARIO })
	private UsuarioVo usuario;

	@Join(columnsLocal = { ID_PEDIDO }, columnsRemote = { Pedido.Colunas.ID_PEDIDO })
	private PedidoVo pedido;
	
	public String getStatusDescritivo() {
		return new StatusPedido().getDescription(getStatusPedido());
	}

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

	public String getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(String statusPedido) {
		this.statusPedido = statusPedido;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public UsuarioVo getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioVo usuario) {
		this.usuario = usuario;
	}

	public PedidoVo getPedido() {
		return pedido;
	}

	public void setPedido(PedidoVo pedido) {
		this.pedido = pedido;
	}
}

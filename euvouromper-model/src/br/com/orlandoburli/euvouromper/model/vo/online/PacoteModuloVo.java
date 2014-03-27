package br.com.orlandoburli.euvouromper.model.vo.online;

import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Join;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import static br.com.orlandoburli.euvouromper.model.utils.Dicionario.PacoteModulo.Colunas.*;

@Table(Dicionario.PacoteModulo.TABELA_PACOTE_MODULO)
public class PacoteModuloVo extends BaseVo {

	@Column(name = ID_PACOTE_MODULO, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	private Integer idPacoteModulo;

	@Column(name = ID_PACOTE, dataType = DataType.INT, isNotNull = true)
	@NotNull
	@NotEmpty
	@Description("Pacote")
	private Integer idPacote;

	@Column(name = ID_MODULO, dataType = DataType.INT, isNotNull = true)
	@NotNull
	@NotEmpty
	@Description("Módulo")
	private Integer idModulo;

	@Join(columnsLocal = { ID_PACOTE }, columnsRemote = { Dicionario.Pacote.Colunas.ID_PACOTE })
	private PacoteVo pacote;
	
	@Join(columnsLocal = { ID_MODULO }, columnsRemote = { Dicionario.Modulo.Colunas.ID_MODULO })
	private ModuloVo modulo;

	public Integer getIdPacoteModulo() {
		return idPacoteModulo;
	}

	public void setIdPacoteModulo(Integer idPacoteModulo) {
		this.idPacoteModulo = idPacoteModulo;
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

	public PacoteVo getPacote() {
		return pacote;
	}

	public void setPacote(PacoteVo pacote) {
		this.pacote = pacote;
	}

	public ModuloVo getModulo() {
		return modulo;
	}

	public void setModulo(ModuloVo modulo) {
		this.modulo = modulo;
	}
}

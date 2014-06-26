package br.com.orlandoburli.euvouromper.model.vo.online;

import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotZero;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Join;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.dao.annotations.UniqueConstraint;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import static br.com.orlandoburli.euvouromper.model.utils.Dicionario.ModuloVideo.Colunas.*;

@Table(value = Dicionario.ModuloVideo.TABELA_MODULO_VIDEO, constraints = { @UniqueConstraint(columns = {ID_MODULO, ID_VIDEO}, constraintName = Dicionario.ModuloVideo.UK_MODULO_VIDEO) })
public class ModuloVideoVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	@Column(name = ID_MODULO_VIDEO, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	private Integer idModuloVideo;

	@Column(name = ID_MODULO, dataType = DataType.INT, isNotNull = true)
	@NotNull
	@NotZero
	@Description("Módulo")
	private Integer idModulo;

	@Column(name = ID_VIDEO, dataType = DataType.INT, isNotNull = true)
	@NotNull
	@NotZero
	@Description("Vídeo")
	private Integer idVideo;

	@Join(columnsLocal = { ID_MODULO }, columnsRemote = { Dicionario.Modulo.Colunas.ID_MODULO })
	private ModuloVo modulo;

	@Join(columnsLocal = { ID_VIDEO }, columnsRemote = { Dicionario.Video.Colunas.ID_VIDEO })
	private VideoVo video;

	public Integer getIdModuloVideo() {
		return idModuloVideo;
	}

	public void setIdModuloVideo(Integer idModuloVideo) {
		this.idModuloVideo = idModuloVideo;
	}

	public Integer getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(Integer idModulo) {
		this.idModulo = idModulo;
	}

	public Integer getIdVideo() {
		return idVideo;
	}

	public void setIdVideo(Integer idVideo) {
		this.idVideo = idVideo;
	}

	public ModuloVo getModulo() {
		return modulo;
	}

	public void setModulo(ModuloVo modulo) {
		this.modulo = modulo;
	}

	public VideoVo getVideo() {
		return video;
	}

	public void setVideo(VideoVo video) {
		this.video = video;
	}
}

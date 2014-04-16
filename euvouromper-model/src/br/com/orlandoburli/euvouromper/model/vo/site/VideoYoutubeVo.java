package br.com.orlandoburli.euvouromper.model.vo.site;

import br.com.orlandoburli.euvouromper.model.utils.Dicionario.VideoYoutube;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MaxSize;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import static br.com.orlandoburli.euvouromper.model.utils.Dicionario.VideoYoutube.Colunas.*;

@Table(VideoYoutube.TABELA_VIDEO_YOUTUBE)
public class VideoYoutubeVo extends BaseVo {

	@Column(name = ID_VIDEO_YOUTUBE, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	private Integer idVideoYoutube;

	@Column(name = DESCRICAO, dataType = DataType.VARCHAR, maxSize = 100, isNotNull = true)
	@NotNull
	@NotEmpty
	@MaxSize(100)
	@Description("Descrição")
	private String descricao;

	@Column(name = CHAVE, maxSize = 50, dataType = DataType.VARCHAR)
	@NotNull
	@NotEmpty
	@MaxSize(50)
	@Description("Chave")
	private String chave;

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

	public Integer getIdVideoYoutube() {
		return idVideoYoutube;
	}

	public void setIdVideoYoutube(Integer idVideoYoutube) {
		this.idVideoYoutube = idVideoYoutube;
	}
}

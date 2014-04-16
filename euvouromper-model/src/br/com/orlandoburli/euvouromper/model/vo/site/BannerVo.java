package br.com.orlandoburli.euvouromper.model.vo.site;

import br.com.orlandoburli.euvouromper.model.domains.SimNao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.Domain;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MaxSize;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MinSize;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import static br.com.orlandoburli.euvouromper.model.utils.Dicionario.Banner.Colunas.*;

@Table(Dicionario.Banner.TABELA_BANNER)
public class BannerVo extends BaseVo {

	@Column(name = ID_BANNER, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	private Integer idBanner;

	@Column(name = TITULO, dataType = DataType.VARCHAR, maxSize = 100, isNotNull = true)
	@NotNull
	@NotEmpty
	@Description("Título")
	private String titulo;

	@Column(name = SUBTITULO, dataType = DataType.VARCHAR, maxSize = 300)
	@NotNull
	@NotEmpty
	@Description("Sub Título")
	private String subTitulo;

	@Column(name = URL, dataType = DataType.VARCHAR, maxSize = 300)
	@NotNull
	@NotEmpty
	@Description("URL")
	private String url;

	@Column(name = ATIVO, dataType = DataType.CHAR, maxSize = 1, isNotNull = true)
	@NotNull
	@NotEmpty
	@MinSize(1)
	@MaxSize(1)
	@Domain(SimNao.class)
	@Description("Ativo")
	private String ativo;

	@Column(name = COR_TITULO, dataType = DataType.VARCHAR, maxSize = 10)
	private String corTitulo;

	@Column(name = COR_SUBTITULO, dataType = DataType.VARCHAR, maxSize = 10)
	private String corSubTitulo;

	@Column(name = PATH_IMAGEM, dataType = DataType.VARCHAR, maxSize = 300)
	private String pathImagem;

	public Integer getIdBanner() {
		return idBanner;
	}

	public void setIdBanner(Integer idBanner) {
		this.idBanner = idBanner;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubTitulo() {
		return subTitulo;
	}

	public void setSubTitulo(String subTitulo) {
		this.subTitulo = subTitulo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public String getPathImagem() {
		return pathImagem;
	}

	public void setPathImagem(String pathImagem) {
		this.pathImagem = pathImagem;
	}

	public String getCorTitulo() {
		return corTitulo;
	}

	public void setCorTitulo(String corTitulo) {
		this.corTitulo = corTitulo;
	}

	public String getCorSubTitulo() {
		return corSubTitulo;
	}

	public void setCorSubTitulo(String corSubTitulo) {
		this.corSubTitulo = corSubTitulo;
	}
}

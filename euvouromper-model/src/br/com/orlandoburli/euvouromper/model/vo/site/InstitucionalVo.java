package br.com.orlandoburli.euvouromper.model.vo.site;

import static br.com.orlandoburli.euvouromper.model.utils.Dicionario.Institucional.Colunas.*;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.FilterOnly;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.FullTrim;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.Lower;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.NoAccents;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.SpaceToUnderline;
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

@Table(Dicionario.Institucional.TABELA_INSTITUCIONAL)
public class InstitucionalVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	@Column(name = ID_INSTITUCIONAL, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	private Integer idInstitucional;

	@Column(name = TITULO, dataType = DataType.VARCHAR, maxSize = 100, isNotNull = true)
	@MaxSize(100)
	@NotNull
	@NotEmpty
	@Description("Título")
	private String titulo;

	@Column(name = TEXTO, dataType = DataType.TEXT)
	@Description("Texto")
	private String texto;

	@Column(name = URL, dataType = DataType.VARCHAR, maxSize = 200)
	@FullTrim
	@Lower
	@NoAccents
	@FilterOnly("abcdefghijhlmnopqrstuvxzwyk1234567890_ ")
	@SpaceToUnderline
	@Description("URL")
	private String url;

	@Column(name = STATUS, dataType = DataType.CHAR, maxSize = 1, isNotNull = true)
	@NotNull
	@NotEmpty
	@MinSize(1)
	@MaxSize(1)
	@Domain(StatusInstitucional.class)
	@Description("Status")
	private String status;

	public Integer getIdInstitucional() {
		return idInstitucional;
	}

	public void setIdInstitucional(Integer idInstitucional) {
		this.idInstitucional = idInstitucional;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

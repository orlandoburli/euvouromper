package br.com.orlandoburli.euvouromper.model.vo.site;

import static br.com.orlandoburli.euvouromper.model.utils.Dicionario.Artigo.Colunas.*;

import java.util.Calendar;

import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Artigo;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Professor;
import br.com.orlandoburli.euvouromper.model.vo.cadastros.ProfessorVo;
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
import br.com.orlandoburli.framework.core.dao.annotations.Join;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;

@Table(Artigo.TABELA_ARTIGO)
public class ArtigoVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	@Column(name = ID_ARTIGO, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	private Integer idArtigo;

	@Column(name = TITULO, dataType = DataType.VARCHAR, maxSize = 100, isNotNull = true)
	@MaxSize(100)
	@NotNull
	@NotEmpty
	@Description("Título")
	private String titulo;

	@Column(name = RESUMO, dataType = DataType.VARCHAR, maxSize = 100, isNotNull = true)
	@MaxSize(100)
	@NotNull
	@NotEmpty
	@Description("Resumo")
	private String resumo;

	@Column(name = TEXTO, dataType = DataType.TEXT)
	@Description("Texto")
	private String texto;

	@Column(name = DATA, dataType = DataType.DATE)
	@NotNull
	@Description("Data")
	private Calendar data;

	@Column(name = URL, dataType = DataType.VARCHAR, maxSize = 200)
	@FullTrim
	@Lower
	@FilterOnly("abcdefghijhlmnopqrstuvxzwyk1234567890_ ")
	@NoAccents
	@SpaceToUnderline
	@Description("URL")
	private String url;

	@Column(name = STATUS, dataType = DataType.CHAR, maxSize = 1, isNotNull = true)
	@NotNull
	@NotEmpty
	@MinSize(1)
	@MaxSize(1)
	@Domain(StatusArtigo.class)
	@Description("Status")
	private String status;

	@Column(name = ID_PROFESSOR, dataType = DataType.INT)
	@Description("Professor")
	private Integer idProfessor;

	@Join(columnsLocal = { ID_PROFESSOR }, columnsRemote = { Professor.Colunas.ID_PROFESSOR })
	private ProfessorVo professor;

	public Integer getIdArtigo() {
		return idArtigo;
	}

	public void setIdArtigo(Integer idArtigo) {
		this.idArtigo = idArtigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
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

	public Integer getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(Integer idProfessor) {
		this.idProfessor = idProfessor;
	}

	public ProfessorVo getProfessor() {
		return professor;
	}

	public void setProfessor(ProfessorVo professor) {
		this.professor = professor;
	}
}

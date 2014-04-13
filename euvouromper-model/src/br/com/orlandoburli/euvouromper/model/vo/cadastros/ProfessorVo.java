package br.com.orlandoburli.euvouromper.model.vo.cadastros;

import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.FilterOnly;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.FullTrim;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.Lower;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.NoAccents;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.SpaceToUnderline;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.Email;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MaxSize;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import static br.com.orlandoburli.euvouromper.model.utils.Dicionario.Noticia.Colunas.URL;
import static br.com.orlandoburli.euvouromper.model.utils.Dicionario.Professor.Colunas.*;

@Table(Dicionario.Professor.TABELA_PROFESSOR)
public class ProfessorVo extends BaseVo {

	@Column(name = ID_PROFESSOR, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	private Integer idProfessor;

	@Column(name = NOME, dataType = DataType.VARCHAR, maxSize = 100)
	@NotNull
	@NotEmpty
	@MaxSize(100)
	@Description("Nome")
	private String nome;

	@Column(name = EMAIL, dataType = DataType.VARCHAR, maxSize = 400)
	@Email
	@MaxSize(300)
	@Description("Email")
	private String email;

	@Column(name = TITULO, dataType = DataType.VARCHAR, maxSize = 100)
	@MaxSize(100)
	@Description("Título")
	private String titulo;

	@Column(name = PATH_FOTO, dataType = DataType.VARCHAR, maxSize = 500)
	@Description("Foto")
	private String pathFoto;

	@Column(name = URL, dataType = DataType.VARCHAR, maxSize = 200)
	@FullTrim
	@Lower
	@NoAccents
	@FilterOnly("abcdefghijhlmnopqrstuvxzwyk1234567890_ ")
	@SpaceToUnderline
	@Description("URL")
	private String url;

	public Integer getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(Integer idProfessor) {
		this.idProfessor = idProfessor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getPathFoto() {
		return pathFoto;
	}

	public void setPathFoto(String pathFoto) {
		this.pathFoto = pathFoto;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}

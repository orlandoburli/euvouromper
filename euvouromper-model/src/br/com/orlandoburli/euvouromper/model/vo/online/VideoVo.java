package br.com.orlandoburli.euvouromper.model.vo.online;

import br.com.orlandoburli.euvouromper.model.domains.SimNao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.vo.cadastros.DisciplinaVo;
import br.com.orlandoburli.euvouromper.model.vo.cadastros.ProfessorVo;
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
import static br.com.orlandoburli.euvouromper.model.utils.Dicionario.Video.Colunas.*;

@Table(Dicionario.Video.TABELA_VIDEO)
public class VideoVo extends BaseVo {

	@Column(name = ID_VIDEO, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	private Integer idVideo;

	@Column(name = NOME, dataType = DataType.VARCHAR, maxSize = 100, isNotNull = true)
	@MaxSize(100)
	@NotNull
	@NotEmpty
	@Description("Nome")
	private String nome;

	@Column(name = BLOCO, dataType = DataType.INT)
	@Description("Bloco")
	private Integer bloco;

	@Column(name = AULA, dataType = DataType.INT)
	@Description("Aula")
	private Integer aula;

	@Column(name = GRATUITO, dataType = DataType.CHAR, maxSize = 1, isNotNull = true)
	@NotNull
	@NotEmpty
	@MaxSize(1)
	@MinSize(1)
	@Domain(SimNao.class)
	@Description("Gratuito")
	private String gratuito;

	@Column(name = ID_PROFESSOR, dataType = DataType.INT)
	@Description("Professor")
	private Integer idProfessor;

	@Column(name = ID_DISCIPLINA, dataType = DataType.INT)
	@Description("Disciplina")
	private Integer idDisciplina;

	@Column(name = PATH_VIDEO, dataType = DataType.VARCHAR, maxSize = 300)
	@MaxSize(300)
	private String pathVideo;
	
	@Column(name = PATH_FOTO, dataType = DataType.VARCHAR, maxSize = 300)
	private String pathFoto;

	@Column(name = HASH, dataType = DataType.VARCHAR, maxSize = 100)
	@MaxSize(100)
	private String hash;

	@Join(columnsLocal = { ID_PROFESSOR }, columnsRemote = { Dicionario.Professor.Colunas.ID_PROFESSOR })
	private ProfessorVo professor;

	@Join(columnsLocal = { ID_DISCIPLINA }, columnsRemote = { Dicionario.Disciplina.Colunas.ID_DISCIPLINA })
	private DisciplinaVo disciplina;

	public Integer getIdVideo() {
		return idVideo;
	}

	public void setIdVideo(Integer idVideo) {
		this.idVideo = idVideo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getBloco() {
		return bloco;
	}

	public void setBloco(Integer bloco) {
		this.bloco = bloco;
	}

	public Integer getAula() {
		return aula;
	}

	public void setAula(Integer aula) {
		this.aula = aula;
	}

	public String getGratuito() {
		return gratuito;
	}

	public void setGratuito(String gratuito) {
		this.gratuito = gratuito;
	}

	public Integer getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(Integer idProfessor) {
		this.idProfessor = idProfessor;
	}

	public Integer getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(Integer idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getPathVideo() {
		return pathVideo;
	}

	public void setPathVideo(String pathVideo) {
		this.pathVideo = pathVideo;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public ProfessorVo getProfessor() {
		return professor;
	}

	public void setProfessor(ProfessorVo professor) {
		this.professor = professor;
	}

	public DisciplinaVo getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(DisciplinaVo disciplina) {
		this.disciplina = disciplina;
	}

	public String getPathFoto() {
		return pathFoto;
	}

	public void setPathFoto(String pathFoto) {
		this.pathFoto = pathFoto;
	}
}

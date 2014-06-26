package br.com.orlandoburli.euvouromper.model.vo.admin;

import br.com.orlandoburli.euvouromper.model.domains.SimNao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.PerfilAdmin;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Professor;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Usuario;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Usuario.Colunas;
import br.com.orlandoburli.euvouromper.model.vo.cadastros.ProfessorVo;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.Domain;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.Email;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MaxSize;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MinSize;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Join;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;

@Table(Usuario.TABELA_USUARIO)
public class UsuarioVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	@Column(name = Colunas.ID_USUARIO, isKey = true, isAutoIncrement = true, dataType = DataType.INT)
	private Integer idUsuario;

	@Column(name = Colunas.NOME, dataType = DataType.VARCHAR, maxSize = 100, isNotNull = true)
	@Description("Nome")
	@NotNull
	@NotEmpty
	@MinSize(3)
	@MaxSize(100)
	private String nome;

	@Column(name = Colunas.LOGIN, dataType = DataType.VARCHAR, maxSize = 50, isNotNull = true)
	@NotNull
	@NotEmpty
	@MinSize(3)
	@MaxSize(50)
	@Description("Login")
	private String login;

	@Column(name = Colunas.EMAIL, dataType = DataType.VARCHAR, maxSize = 200, isNotNull = true)
	@NotNull
	@NotEmpty
	@MaxSize(200)
	@Email
	@Description("Email")
	private String email;

	@Column(name = Colunas.SENHA, dataType = DataType.VARCHAR, maxSize = 100, isNotNull = true)
	@Description("Senha")
	@NotNull
	@NotEmpty
	@MinSize(5)
	@MaxSize(100)
	private String senha;

	@Column(name = Colunas.ATIVO, dataType = DataType.CHAR, maxSize = 1, isNotNull = true)
	@Domain(SimNao.class)
	@NotEmpty
	@NotNull
	@MinSize(1)
	@MaxSize(1)
	@Description("Ativo")
	private String ativo;

	@Column(name = Colunas.ID_PERFIL, dataType = DataType.INT, isNotNull = true)
	@NotEmpty
	@NotNull
	@Description("Perfil")
	private Integer idPerfil;

	@Column(name = Colunas.ID_PROFESSOR, dataType = DataType.INT)
	@Description("Professor")
	private Integer idProfessor;

	@Column(name = Colunas.PATH_FOTO, dataType = DataType.VARCHAR, maxSize = 500)
	private String pathFoto;

	@Join(columnsLocal = { Colunas.ID_PERFIL }, columnsRemote = { PerfilAdmin.Colunas.ID_PERFIL })
	private PerfilAdminVo perfil;

	@Join(columnsLocal = { Colunas.ID_PROFESSOR }, columnsRemote = { Professor.Colunas.ID_PROFESSOR })
	private ProfessorVo professor;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		Log.info("Setando ativo " + ativo);
		this.ativo = ativo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}

	public PerfilAdminVo getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilAdminVo perfil) {
		this.perfil = perfil;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPathFoto() {
		return pathFoto;
	}

	public void setPathFoto(String pathFoto) {
		this.pathFoto = pathFoto;
	}

	public String getAtivoDescricao() {
		return getAtivo() == null ? "" : getAtivo().equals("S") ? "Sim" : "Não";
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

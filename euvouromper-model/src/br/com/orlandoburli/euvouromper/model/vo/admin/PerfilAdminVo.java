package br.com.orlandoburli.euvouromper.model.vo.admin;

import br.com.orlandoburli.euvouromper.model.domains.SimNao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.PerfilAdmin;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.PerfilAdmin.Colunas;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.Domain;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MaxSize;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;

@Table(PerfilAdmin.TABELA_PERFIL_ADMIN)
public class PerfilAdminVo extends BaseVo {
	@Column(name = Colunas.ID_PERFIL, dataType = DataType.INT, isNotNull = true, isAutoIncrement = true, isKey = true)
	private Integer idPerfil;
	
	@Column(name = Colunas.NOME, dataType = DataType.VARCHAR, isNotNull = true, maxSize = 100)
	@NotEmpty
	@NotNull
	@MaxSize(100)
	@Description("Nome")
	private String nome;

	@Column(name = Colunas.P_PERFIL_VER, dataType = DataType.CHAR, maxSize = 1, isNotNull = true)
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoPerfilVer;

	@Column(name = Colunas.P_PERFIL_ALT, dataType = DataType.CHAR, maxSize = 1, isNotNull = true)
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoPerfilAlt;

	@Column(name = Colunas.P_USUARIO_VER, dataType = DataType.CHAR, maxSize = 1, isNotNull = true)
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoUsuarioVer;

	@Column(name = Colunas.P_USUARIO_ALT, dataType = DataType.CHAR, maxSize = 1, isNotNull = true)
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String permissaoUsuarioAlt;

	public Integer getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getPermissaoPerfilVer() {
		return permissaoPerfilVer;
	}

	public void setPermissaoPerfilVer(String permissaoPerfilVer) {
		this.permissaoPerfilVer = permissaoPerfilVer;
	}

	public String getPermissaoPerfilAlt() {
		return permissaoPerfilAlt;
	}

	public void setPermissaoPerfilAlt(String permissaoPerfilAlt) {
		this.permissaoPerfilAlt = permissaoPerfilAlt;
	}

	public String getPermissaoUsuarioVer() {
		return permissaoUsuarioVer;
	}

	public void setPermissaoUsuarioVer(String permissaoUsuarioVer) {
		this.permissaoUsuarioVer = permissaoUsuarioVer;
	}

	public String getPermissaoUsuarioAlt() {
		return permissaoUsuarioAlt;
	}

	public void setPermissaoUsuarioAlt(String permissaoUsuarioAlt) {
		this.permissaoUsuarioAlt = permissaoUsuarioAlt;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}

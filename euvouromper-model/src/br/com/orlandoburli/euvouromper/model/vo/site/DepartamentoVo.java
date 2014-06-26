package br.com.orlandoburli.euvouromper.model.vo.site;

import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Departamento;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.Email;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import static br.com.orlandoburli.euvouromper.model.utils.Dicionario.Departamento.Colunas.*;

@Table(Departamento.TABELA_DEPARTAMENTO)
public class DepartamentoVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	@Column(name = ID_DEPARTAMENTO, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	private Integer idDepartamento;

	@Column(name = NOME, dataType = DataType.VARCHAR, maxSize = 200, isNotNull = true)
	@NotNull
	@NotEmpty
	@Description("Nome")
	private String nome;

	@Column(name = EMAIL, dataType = DataType.VARCHAR, maxSize = 300, isNotNull = true)
	@NotNull
	@NotEmpty
	@Email
	@Description("Email")
	private String email;

	public Integer getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
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
}

package br.com.orlandoburli.euvouromper.model.vo.site;

import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Contato;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Departamento;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.Email;
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
import static br.com.orlandoburli.euvouromper.model.utils.Dicionario.Contato.Colunas.*;

@Table(Contato.TABELA_CONTATO)
public class ContatoVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	@Column(name = ID_CONTATO, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	private Integer idContato;

	@Column(name = NOME, dataType = DataType.VARCHAR, maxSize = 100, isNotNull = true)
	@NotNull
	@NotEmpty
	@MaxSize(100)
	@MinSize(3)
	@Description("Nome")
	private String nome;

	@Column(name = EMAIL, dataType = DataType.VARCHAR, maxSize = 300, isNotNull = true)
	@NotNull
	@NotEmpty
	@Email
	@Description("Email")
	private String email;

	@Column(name = ASSUNTO, dataType = DataType.VARCHAR, maxSize = 100)
	@NotNull
	@NotEmpty
	@MaxSize(100)
	@Description("Assunto")
	private String assunto;

	@Column(name = FONE, dataType = DataType.VARCHAR, maxSize = 30)
	@NotNull
	@NotEmpty
	@MaxSize(30)
	@MinSize(8)
	@Description("Fone")
	private String fone;

	@Column(name = ID_DEPARTAMENTO, dataType = DataType.INT, isNotNull = true)
	@NotNull
	@NotEmpty
	@Description("Departamento")
	private Integer idDepartamento;

	@Column(name = MENSAGEM, dataType = DataType.TEXT, isNotNull = true)
	@NotNull
	@NotEmpty
	@MinSize(10)
	@MaxSize(1000)
	@Description("Mensagem")
	private String mensagem;

	@Join(columnsLocal = { ID_DEPARTAMENTO }, columnsRemote = { Departamento.Colunas.ID_DEPARTAMENTO })
	private DepartamentoVo departamento;

	public String getNomeDepartamento() {
		if (getDepartamento() != null) {
			return getDepartamento().getNome();
		} else {
			return null;
		}
	}

	public Integer getIdContato() {
		return idContato;
	}

	public void setIdContato(Integer idContato) {
		this.idContato = idContato;
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

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public Integer getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public DepartamentoVo getDepartamento() {
		return departamento;
	}

	public void setDepartamento(DepartamentoVo departamento) {
		this.departamento = departamento;
	}
}

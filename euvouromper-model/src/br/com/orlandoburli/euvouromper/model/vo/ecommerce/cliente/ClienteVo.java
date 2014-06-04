package br.com.orlandoburli.euvouromper.model.vo.ecommerce.cliente;

import br.com.orlandoburli.euvouromper.model.domains.SimNao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.TipoCadastro;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.Lower;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.Upper;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.Domain;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.Email;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MaxSize;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.dao.annotations.UniqueConstraint;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import static br.com.orlandoburli.euvouromper.model.utils.Dicionario.Cliente.Colunas.*;

@Table(value = Dicionario.Cliente.TABELA_CLIENTE, constraints = { @UniqueConstraint(constraintName = Dicionario.Cliente.UK_EMAIL_CLIENTE, column = EMAIL) })
public class ClienteVo extends BaseVo {

	@Column(name = ID_CLIENTE, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	private Integer idCliente;

	@Column(name = NOME, dataType = DataType.VARCHAR, maxSize = 100, isNotNull = true)
	@MaxSize(100)
	@NotNull
	@NotEmpty
	@Description("Nome")
	@Upper
	private String nome;

	@Column(name = EMAIL, dataType = DataType.VARCHAR, maxSize = 300, isNotNull = true)
	@MaxSize(300)
	@NotNull
	@NotEmpty
	@Email
	@Description("Email")
	@Lower
	private String email;

	@Column(name = FLAG_EMAIL_CONFIRMADO, dataType = DataType.CHAR, maxSize = 1, isNotNull = true)
	@NotNull
	@NotEmpty
	@MaxSize(1)
	@Domain(SimNao.class)
	@Description("Email confirmado")
	private String flagEmailConfirmado;

	@Column(name = SENHA, maxSize = 50, dataType = DataType.VARCHAR)
	@Description("Senha")
	private String senha;

	private String confSenha;

	@Column(name = HASH, dataType = DataType.VARCHAR, maxSize = 100)
	private String hash;

	@Column(name = TIPO_CADASTRO, dataType = DataType.CHAR, maxSize = 1, isNotNull = true)
	@NotNull
	@NotEmpty
	@Domain(TipoCadastro.class)
	private String tipoCadastro;

	@Column(name = CPF, dataType = DataType.VARCHAR, maxSize = 15)
	private String cpf;

	@Column(name = CEP, dataType = DataType.VARCHAR, maxSize = 10)
	private String cep;

	@Column(name = ENDERECO, dataType = DataType.VARCHAR, maxSize = 100)
	private String endereco;

	@Column(name = NUMERO, dataType = DataType.INT)
	private Integer numero;

	@Column(name = BAIRRO, dataType = DataType.VARCHAR, maxSize = 100)
	private String bairro;

	@Column(name = COMPLEMENTO, dataType = DataType.VARCHAR, maxSize = 150)
	private String complemento;

	@Column(name = UF, dataType = DataType.VARCHAR, maxSize = 2)
	private String uf;

	@Column(name = CIDADE, dataType = DataType.VARCHAR, maxSize = 100)
	private String cidade;

	@Column(name = FONE1, dataType = DataType.VARCHAR, maxSize = 20)
	private String fone1;

	@Column(name = FONE2, dataType = DataType.VARCHAR, maxSize = 20)
	private String fone2;

	public String getPrimeiroNome() {
		return getNome().substring(0, getNome().indexOf(" ")).trim();
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
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

	public String getFlagEmailConfirmado() {
		return flagEmailConfirmado;
	}

	public void setFlagEmailConfirmado(String flagEmailConfirmado) {
		this.flagEmailConfirmado = flagEmailConfirmado;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfSenha() {
		return confSenha;
	}

	public void setConfSenha(String confSenha) {
		this.confSenha = confSenha;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getFone1() {
		return fone1;
	}

	public void setFone1(String fone1) {
		this.fone1 = fone1;
	}

	public String getFone2() {
		return fone2;
	}

	public void setFone2(String fone2) {
		this.fone2 = fone2;
	}

	public String getTipoCadastro() {
		return tipoCadastro;
	}

	public void setTipoCadastro(String tipoCadastro) {
		this.tipoCadastro = tipoCadastro;
	}
}

package br.com.orlandoburli.euvouromper.model.vo.ecommerce;

import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.Domain;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import static br.com.orlandoburli.euvouromper.model.utils.Dicionario.Email.Colunas.*;

@Table(Dicionario.Email.TABELA_EMAIL)
public class EmailVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	@Column(name = ID_EMAIL, dataType = DataType.VARCHAR, isKey = true)
	@NotNull
	@NotEmpty
	@Description("Tipo de Email")
	@Domain(TipoEmail.class)
	private String idEmail;
	
	@Column(name  = ASSUNTO, dataType = DataType.VARCHAR, maxSize = 200)
	@NotNull
	@NotEmpty
	private String assunto;

	@Column(name = REMETENTE_EMAIL, dataType = DataType.VARCHAR, maxSize = 200)
	@NotNull
	@NotEmpty
	@Description("Email do Rementente")
	private String remetenteEmail;

	@Column(name = REMETENTE_NOME, dataType = DataType.VARCHAR, maxSize = 200)
	@NotNull
	@NotEmpty
	@Description("Nome do Rementente")
	private String remetenteNome;

	@Column(name = CORPO, dataType = DataType.TEXT)
	@NotNull
	@NotEmpty
	@Description("Corpo")
	private String corpo;
	
	public String getTipoEmailDescritivo() {
		return new TipoEmail().getDescription(getIdEmail());
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}

	public String getIdEmail() {
		return idEmail;
	}

	public void setIdEmail(String idEmail) {
		this.idEmail = idEmail;
	}

	public String getRemetenteEmail() {
		return remetenteEmail;
	}

	public void setRemetenteEmail(String remetenteEmail) {
		this.remetenteEmail = remetenteEmail;
	}

	public String getRemetenteNome() {
		return remetenteNome;
	}

	public void setRemetenteNome(String remetenteNome) {
		this.remetenteNome = remetenteNome;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
}

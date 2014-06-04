package br.com.orlandoburli.euvouromper.model.vo.site;

import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.Email;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import static br.com.orlandoburli.euvouromper.model.utils.Dicionario.Newsletter.Colunas.*;

@Table(Dicionario.Newsletter.TABELA_NEWSLETTER)
public class NewsletterVo extends BaseVo {

	@Column(name = ID_NEWSLETTER, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	private Integer idNewsletter;

	@Column(name = EMAIL, dataType = DataType.VARCHAR, maxSize = 300, isNotNull = true)
	@NotNull
	@NotEmpty
	@Email
	@Description("Email")
	private String email;

	public Integer getIdNewsletter() {
		return idNewsletter;
	}

	public void setIdNewsletter(Integer idNewsletter) {
		this.idNewsletter = idNewsletter;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

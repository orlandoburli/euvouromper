package br.com.orlandoburli.euvouromper.model.vo.site;

import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Depoimento;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.Domain;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MaxSize;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MinSize;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import static br.com.orlandoburli.euvouromper.model.utils.Dicionario.Depoimento.Colunas.*;

@Table(Depoimento.TABELA_DEPOIMENTO)
public class DepoimentoVo extends BaseVo {

	@Column(name = ID_DEPOIMENTO, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	private Integer idDepoimento;

	@Column(name = NOME, dataType = DataType.VARCHAR, maxSize = 100)
	@MaxSize(100)
	@NotNull
	@NotEmpty
	@Description("Nome")
	private String nome;

	@Column(name = TEXTO, dataType = DataType.TEXT)
	@Description("Texto")
	private String texto;

	@Column(name = STATUS, dataType = DataType.CHAR, maxSize = 1, isNotNull = true)
	@NotNull
	@NotEmpty
	@MaxSize(1)
	@MinSize(1)
	@Domain(StatusDepoimento.class)
	private String status;

	public Integer getIdDepoimento() {
		return idDepoimento;
	}

	public void setIdDepoimento(Integer idDepoimento) {
		this.idDepoimento = idDepoimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

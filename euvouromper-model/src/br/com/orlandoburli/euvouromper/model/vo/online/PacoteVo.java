package br.com.orlandoburli.euvouromper.model.vo.online;

import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MaxSize;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import static br.com.orlandoburli.euvouromper.model.utils.Dicionario.Pacote.Colunas.*;

@Table(Dicionario.Pacote.TABELA_PACOTE)
public class PacoteVo extends BaseVo {

	@Column(name = ID_PACOTE, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	private Integer idPacote;

	@Column(name = NOME, dataType = DataType.VARCHAR, maxSize = 100, isNotNull = true)
	@NotNull
	@NotEmpty
	@MaxSize(100)
	@Description("Nome")
	private String nome;

	public Integer getIdPacote() {
		return idPacote;
	}

	public void setIdPacote(Integer idPacote) {
		this.idPacote = idPacote;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}

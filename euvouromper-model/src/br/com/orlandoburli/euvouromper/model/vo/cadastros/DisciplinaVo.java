package br.com.orlandoburli.euvouromper.model.vo.cadastros;

import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;

@Table(Dicionario.Disciplina.TABELA_DISCIPLINA)
public class DisciplinaVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	@Column(name = Dicionario.Disciplina.Colunas.ID_DISCIPLINA, dataType = DataType.INT, isAutoIncrement = true, isKey = true)
	private Integer idDisciplina;

	@Column(name = Dicionario.Disciplina.Colunas.NOME, dataType = DataType.VARCHAR, maxSize = 100)
	@NotEmpty
	@NotNull
	@Description("Nome")
	private String nome;

	public Integer getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(Integer idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}

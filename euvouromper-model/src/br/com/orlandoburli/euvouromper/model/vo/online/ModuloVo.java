package br.com.orlandoburli.euvouromper.model.vo.online;

import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.FullTrim;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.TransformateWhen;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.ZeroIfNull;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MaxSize;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotZero;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import static br.com.orlandoburli.euvouromper.model.utils.Dicionario.Modulo.Colunas.*;

@Table(Dicionario.Modulo.TABELA_MODULO)
public class ModuloVo extends BaseVo {

	@Column(name = ID_MODULO, dataType = DataType.INT, isAutoIncrement = true, isKey = true)
	private Integer idModulo;

	@Column(name = NOME, dataType = DataType.VARCHAR, maxSize = 100, isNotNull = true)
	@NotNull
	@NotEmpty
	@MaxSize(100)
	@FullTrim
	@Description("Nome")
	private String nome;

	@Column(name = DESCRICAO, dataType = DataType.VARCHAR, maxSize = 300)
	@NotNull
	@NotEmpty
	@MaxSize(300)
	@FullTrim
	@Description("Descrição")
	private String descricao;

	@Column(name = HORAS, dataType = DataType.INT)
	@NotNull
	@NotZero
	@ZeroIfNull(when = TransformateWhen.BEFORE_VALIDATE)
	@Description("Horas")
	private Integer horas;

	@Column(name = CONTEUDO_PROGRAMATICO, dataType = DataType.TEXT)
	@Description("Conteúdo programático")
	private String conteudoProgramatico;

	public Integer getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(Integer idModulo) {
		this.idModulo = idModulo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	public String getConteudoProgramatico() {
		return conteudoProgramatico;
	}

	public void setConteudoProgramatico(String conteudoProgramatico) {
		this.conteudoProgramatico = conteudoProgramatico;
	}
}

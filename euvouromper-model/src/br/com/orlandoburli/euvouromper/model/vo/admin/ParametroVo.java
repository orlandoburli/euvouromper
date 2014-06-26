package br.com.orlandoburli.euvouromper.model.vo.admin;

import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.FullTrim;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.NoSpace;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.Upper;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MaxSize;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MinSize;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import static br.com.orlandoburli.euvouromper.model.utils.Dicionario.Parametro.Colunas.*;

@Table(Dicionario.Parametro.TABELA_PARAMETRO)
public class ParametroVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	@Column(name = ID_PARAMETRO, dataType = DataType.VARCHAR, maxSize = 50, isKey = true)
	@NotEmpty
	@NotNull
	@MinSize(1)
	@MaxSize(50)
	@Description("Chave")
	@NoSpace
	@FullTrim
	@Upper
	private String idParametro;

	@Column(name = NOME, dataType = DataType.VARCHAR, maxSize = 100, isNotNull = true)
	@NotNull
	@NotEmpty
	@MinSize(3)
	@MaxSize(100)
	@Description("Nome")
	private String nome;

	@Column(name = VALOR, dataType = DataType.VARCHAR, maxSize = 300)
	@MaxSize(300)
	@Description("Valor")
	private String valor;

	public String getIdParametro() {
		return idParametro;
	}

	public void setIdParametro(String idParametro) {
		this.idParametro = idParametro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
}

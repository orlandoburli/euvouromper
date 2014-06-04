package br.com.orlandoburli.euvouromper.model.vo.online;

import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Modulo;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MaxSize;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Join;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import static br.com.orlandoburli.euvouromper.model.utils.Dicionario.MaterialApoio.Colunas.*;

@Table(Dicionario.MaterialApoio.TABELA_MATERIAL_APOIO)
public class MaterialApoioVo extends BaseVo {

	@Column(name = ID_MATERIAL_APOIO, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	private Integer idMaterialApoio;

	@Column(name = NOME, dataType = DataType.VARCHAR, maxSize = 100, isNotNull = true)
	@NotNull
	@NotEmpty
	@MaxSize(100)
	@Description("Nome")
	private String nome;

	@Column(name = ARQUIVO, dataType = DataType.VARCHAR, maxSize = 200)
	private String arquivo;

	@Column(name = ID_MODULO, dataType = DataType.INT)
	private Integer idModulo;

	@Join(columnsLocal = { ID_MODULO }, columnsRemote = { Modulo.Colunas.ID_MODULO })
	private ModuloVo modulo;

	public Integer getIdMaterialApoio() {
		return idMaterialApoio;
	}

	public void setIdMaterialApoio(Integer idMaterialApoio) {
		this.idMaterialApoio = idMaterialApoio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	public Integer getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(Integer idModulo) {
		this.idModulo = idModulo;
	}

	public ModuloVo getModulo() {
		return modulo;
	}

	public void setModulo(ModuloVo modulo) {
		this.modulo = modulo;
	}
}

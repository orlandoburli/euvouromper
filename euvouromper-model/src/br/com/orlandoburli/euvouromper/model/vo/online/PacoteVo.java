package br.com.orlandoburli.euvouromper.model.vo.online;

import java.util.List;

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

	private static final long serialVersionUID = 1L;

	@Column(name = ID_PACOTE, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	private Integer idPacote;

	@Column(name = NOME, dataType = DataType.VARCHAR, maxSize = 100, isNotNull = true)
	@NotNull
	@NotEmpty
	@MaxSize(100)
	@Description("Nome")
	private String nome;

	@Column(name = CONTEUDO, dataType = DataType.TEXT)
	private String conteudo;

	@Column(name = OBJETIVO, dataType = DataType.TEXT)
	private String objetivo;
	
	private List<ModuloVo> modulos;

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

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public List<ModuloVo> getModulos() {
		return modulos;
	}

	public void setModulos(List<ModuloVo> modulos) {
		this.modulos = modulos;
	}
}

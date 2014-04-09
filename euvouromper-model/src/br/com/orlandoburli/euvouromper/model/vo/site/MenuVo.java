package br.com.orlandoburli.euvouromper.model.vo.site;

import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.Domain;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MaxSize;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MinSize;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import static br.com.orlandoburli.euvouromper.model.utils.Dicionario.Menu.Colunas.*;

@Table(Dicionario.Menu.TABELA_MENU)
public class MenuVo extends BaseVo {

	@Column(name = ID_MENU, dataType = DataType.INT, isNotNull = true, isKey = true, isAutoIncrement = true)
	private Integer idMenu;

	@Column(name = NOME, dataType = DataType.VARCHAR, maxSize = 150, isNotNull = true)
	@NotNull
	@NotEmpty
	@Description("Nome")
	private String nome;

	@Column(name = URL, dataType = DataType.VARCHAR, maxSize = 100)
	private String url;

	@Column(name = ORDEM, dataType = DataType.INT)
	private Integer ordem;

	@Column(name = GRUPO, dataType = DataType.CHAR, maxSize = 1, isNotNull = true)
	@NotNull
	@NotEmpty
	@MinSize(1)
	@MaxSize(1)
	@Domain(GrupoMenu.class)
	private String grupo;

	public Integer getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
}

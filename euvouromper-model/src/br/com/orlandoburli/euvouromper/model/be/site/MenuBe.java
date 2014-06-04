package br.com.orlandoburli.euvouromper.model.be.site;

import java.util.List;

import br.com.orlandoburli.euvouromper.model.dao.site.MenuDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Menu;
import br.com.orlandoburli.euvouromper.model.vo.site.GrupoMenu;
import br.com.orlandoburli.euvouromper.model.vo.site.MenuVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class MenuBe extends BaseBe<MenuVo, MenuDao> {

	public MenuBe(DAOManager manager) {
		super(manager);
	}

	public List<MenuVo> getListGrupo(String grupo) throws ListException {
		MenuVo filter = new MenuVo();

		filter.setGrupo(grupo);

		List<MenuVo> list = getList(filter, null, Menu.TABELA_MENU + "." + Menu.Colunas.ORDEM);

		return list;
	}

	public List<MenuVo> getListTopo1() throws ListException {
		return getListGrupo(GrupoMenu.TOPO1);
	}

	public List<MenuVo> getListTopo2() throws ListException {
		return getListGrupo(GrupoMenu.TOPO2);
	}

	public List<MenuVo> getListRodape1() throws ListException {
		return getListGrupo(GrupoMenu.RODAPE1);
	}

	public List<MenuVo> getListRodape2() throws ListException {
		return getListGrupo(GrupoMenu.RODAPE2);
	}

	public List<MenuVo> getListRodape3() throws ListException {
		return getListGrupo(GrupoMenu.RODAPE3);
	}

	public List<MenuVo> getListLateral1() throws ListException {
		return getListGrupo(GrupoMenu.LATERAL1);
	}

}

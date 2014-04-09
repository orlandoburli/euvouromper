package br.com.orlandoburli.euvouromper.model.dao.site;

import br.com.orlandoburli.euvouromper.model.vo.site.MenuVo;
import br.com.orlandoburli.framework.core.dao.BaseCadastroDao;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class MenuDao extends BaseCadastroDao<MenuVo>{

	public MenuDao(DAOManager manager) {
		super(manager);
	}

}

package br.com.orlandoburli.euvouromper.model.be.site;

import br.com.orlandoburli.euvouromper.model.dao.site.MenuDao;
import br.com.orlandoburli.euvouromper.model.vo.site.MenuVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class MenuBe extends BaseBe<MenuVo, MenuDao>{

	public MenuBe(DAOManager manager) {
		super(manager);
	}

}

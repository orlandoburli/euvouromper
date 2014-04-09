package br.com.orlandoburli.euvouromper.admin.web.actions.site.menu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.site.MenuBe;
import br.com.orlandoburli.euvouromper.model.dao.site.MenuDao;
import br.com.orlandoburli.euvouromper.model.vo.site.GrupoMenu;
import br.com.orlandoburli.euvouromper.model.vo.site.MenuVo;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;

public class MenuCadastroAction extends BaseCadastroAction<MenuVo, MenuDao, MenuBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspCadastro() {
		return "web/pages/site/menu/menucadastro.jsp";
	}

	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, MenuVo vo, MenuBe be, DAOManager manager) {
		super.doBeforeVisualizar(request, response, vo, be, manager);

		getRequest().setAttribute("titulo", "Cadastro de Menus");
		getRequest().setAttribute("subtitulo", "Cadastro de Menus do Site");
		getRequest().setAttribute("submenu", "Site");
		getRequest().setAttribute("menuAtivo", "Menu");

		getRequest().setAttribute("grupos", new GrupoMenu().getList());
	}
}

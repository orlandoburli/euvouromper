package br.com.orlandoburli.euvouromper.admin.web.actions.home;

import java.util.List;

import br.com.orlandoburli.euvouromper.admin.utils.Versao;
import br.com.orlandoburli.euvouromper.model.be.admin.UsuarioBe;
import br.com.orlandoburli.euvouromper.model.vo.admin.MenuVo;
import br.com.orlandoburli.euvouromper.model.vo.admin.UsuarioVo;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.web.BaseAction;
import br.com.orlandoburli.framework.core.web.filters.IgnoreMethodAuthentication;

public class HomeAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private UsuarioVo usuario;

	private String term;

	@IgnoreMethodAuthentication
	public void execute() {
		// Monta menu html
		String menuString = "";

		DAOManager manager = new DAOManager();

		try {
			UsuarioBe usuarioBe = new UsuarioBe(manager);

			List<MenuVo> menus = usuarioBe.buildMenuUsuario(getUsuario());

			for (MenuVo menu : menus) {
				menuString += buildMenu(menu, true);
			}
		} finally {
			manager.commit();
		}

		getRequest().setAttribute("versao", Versao.getInstance());

		getRequest().setAttribute("menuString", menuString);
		
		getRequest().setAttribute("titulo", "Home");
		
		getRequest().setAttribute("subtitulo", "Painel de Administração");

		forward("web/home.jsp");
	}

	private String buildMenu(MenuVo menu, boolean topLevel) {
		StringBuilder sb = new StringBuilder();

		sb.append("<li data-top-level=\"" + (topLevel ? "true" : "false") + "\">");

		if (menu.getTipoMenu() != null && menu.getTipoMenu().equals("separator")) {
			// Separador
			sb.append("-");
		} else {
			sb.append("<a href=\"#\" data-nav=\"" + menu.getNomeObjeto() + "\" data-link=\"" + menu.getNomeObjeto() + "\" >" + menu.getNomeMenu() + "</a>");

			if (menu.getSubMenus() != null && menu.getSubMenus().size() > 0) {
				sb.append("<ul>");
				for (MenuVo sub : menu.getSubMenus()) {
					sb.append(buildMenu(sub, false));
				}
				sb.append("</ul>");
			}
		}
		sb.append("</li>");

		return sb.toString();
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public UsuarioVo getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioVo usuario) {
		this.usuario = usuario;
	}

}
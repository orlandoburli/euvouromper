package br.com.orlandoburli.euvouromper.admin.web.actions.site.menu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.site.MenuBe;
import br.com.orlandoburli.euvouromper.model.dao.site.MenuDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.vo.site.MenuVo;
import br.com.orlandoburli.framework.core.web.BaseConsultaAction;

public class MenuConsultaAction extends BaseConsultaAction<MenuVo, MenuDao, MenuBe>{

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspConsulta() {
		return "web/pages/site/menu/menuconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/site/menu/menuconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return Dicionario.Menu.TABELA_MENU + "." + Dicionario.Menu.Colunas.NOME;
	}

	@Override
	public void doBeforeExecute() {
		super.doBeforeExecute();
		getRequest().setAttribute("titulo", "Consulta de Menus");
		getRequest().setAttribute("subtitulo", "Consulta de Menus do Site");
		getRequest().setAttribute("submenu", "Cadastros");
		getRequest().setAttribute("menuAtivo", "Menus");
	}

	@Override
	public void doBeforeFilter(MenuVo filter, MenuBe be, HttpServletRequest request, HttpServletResponse response) {
		if (getParametroPesquisa() != null) {
			if (getParametroPesquisa().equalsIgnoreCase("Codigo")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdMenu(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("Nome")) {
				filter.setNome("%" + getPesquisarPor() + "%");
			}
		} else {
			filter.setNome("%" + getPesquisarPor() + "%");
		}
	}

}

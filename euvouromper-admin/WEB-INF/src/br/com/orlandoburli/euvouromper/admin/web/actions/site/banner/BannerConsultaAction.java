package br.com.orlandoburli.euvouromper.admin.web.actions.site.banner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.site.BannerBe;
import br.com.orlandoburli.euvouromper.model.dao.site.BannerDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.vo.site.BannerVo;
import br.com.orlandoburli.framework.core.web.BaseConsultaAction;

public class BannerConsultaAction extends BaseConsultaAction<BannerVo, BannerDao, BannerBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspConsulta() {
		return "web/pages/site/banner/bannerconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/site/banner/bannerconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return Dicionario.Banner.TABELA_BANNER + "." + Dicionario.Banner.Colunas.ID_BANNER + " DESC ";
	}

	@Override
	public void doBeforeExecute() {
		super.doBeforeExecute();
		getRequest().setAttribute("titulo", "Consulta de Banners");
		getRequest().setAttribute("subtitulo", "Consulta de Banners do Site");
		getRequest().setAttribute("submenu", "Site");
		getRequest().setAttribute("menuAtivo", "Banners");
	}

	@Override
	public void doBeforeFilter(BannerVo filter, BannerBe be, HttpServletRequest request, HttpServletResponse response) {
		if (getParametroPesquisa() != null) {
			if (getParametroPesquisa().equalsIgnoreCase("Codigo")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdBanner(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("Titulo")) {
				filter.setTitulo("%" + getPesquisarPor() + "%");
			}
		} else {
			filter.setTitulo("%" + getPesquisarPor() + "%");
		}
	}

}

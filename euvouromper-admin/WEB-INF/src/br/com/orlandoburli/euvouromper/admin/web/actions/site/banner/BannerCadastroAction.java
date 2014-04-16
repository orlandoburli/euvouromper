package br.com.orlandoburli.euvouromper.admin.web.actions.site.banner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.site.BannerBe;
import br.com.orlandoburli.euvouromper.model.dao.site.BannerDao;
import br.com.orlandoburli.euvouromper.model.domains.SimNao;
import br.com.orlandoburli.euvouromper.model.vo.site.BannerVo;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;

public class BannerCadastroAction extends BaseCadastroAction<BannerVo, BannerDao, BannerBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspCadastro() {
		return "web/pages/site/banner/bannercadastro.jsp";
	}
	
	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, BannerVo vo, BannerBe be, DAOManager manager) {
		super.doBeforeVisualizar(request, response, vo, be, manager);
		
		getRequest().setAttribute("titulo", "Cadastro de Banners");
		getRequest().setAttribute("subtitulo", "Cadastro de Banners do Site");
		getRequest().setAttribute("submenu", "Site");
		getRequest().setAttribute("menuAtivo", "Banner");

		getRequest().setAttribute("simNaoList", new SimNao().getList());
	}

}

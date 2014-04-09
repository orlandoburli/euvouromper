package br.com.orlandoburli.euvouromper.admin.web.actions.site.institucional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.site.InstitucionalBe;
import br.com.orlandoburli.euvouromper.model.dao.site.InstitucionalDao;
import br.com.orlandoburli.euvouromper.model.vo.site.InstitucionalVo;
import br.com.orlandoburli.euvouromper.model.vo.site.StatusInstitucional;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;

public class InstitucionalCadastroAction extends BaseCadastroAction<InstitucionalVo, InstitucionalDao, InstitucionalBe>{

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspCadastro() {
		return "web/pages/site/institucional/institucionalcadastro.jsp";
	}

	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, InstitucionalVo vo, InstitucionalBe be, DAOManager manager) {
		super.doBeforeVisualizar(request, response, vo, be, manager);

		getRequest().setAttribute("titulo", "Cadastro de Páginas Institucionais");
		getRequest().setAttribute("subtitulo", "Cadastro de Páginas Institucionais do Site");
		getRequest().setAttribute("submenu", "Site");
		getRequest().setAttribute("menuAtivo", "Páginas Institucionais");
		
		getRequest().setAttribute("statusInstitucionalList", new StatusInstitucional().getList());
	}

}

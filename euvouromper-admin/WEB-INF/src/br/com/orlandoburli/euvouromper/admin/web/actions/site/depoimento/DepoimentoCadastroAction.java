package br.com.orlandoburli.euvouromper.admin.web.actions.site.depoimento;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.site.DepoimentoBe;
import br.com.orlandoburli.euvouromper.model.dao.site.DepoimentoDao;
import br.com.orlandoburli.euvouromper.model.vo.site.DepoimentoVo;
import br.com.orlandoburli.euvouromper.model.vo.site.StatusDepoimento;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;

public class DepoimentoCadastroAction extends BaseCadastroAction<DepoimentoVo, DepoimentoDao, DepoimentoBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspCadastro() {
		return "web/pages/site/depoimento/depoimentocadastro.jsp";
	}
	
	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, DepoimentoVo vo, DepoimentoBe be, DAOManager manager) {
		super.doBeforeVisualizar(request, response, vo, be, manager);
		
		getRequest().setAttribute("titulo", "Cadastro de Depoimentos");
		getRequest().setAttribute("subtitulo", "Cadastro de Depoimentos do Site");
		getRequest().setAttribute("submenu", "Site");
		getRequest().setAttribute("menuAtivo", "Depoimento");
		
		getRequest().setAttribute("statusDepoimentoList", new StatusDepoimento().getList());
	}
}
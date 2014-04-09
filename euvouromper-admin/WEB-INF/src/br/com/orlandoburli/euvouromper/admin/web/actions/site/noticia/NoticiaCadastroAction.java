package br.com.orlandoburli.euvouromper.admin.web.actions.site.noticia;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.site.NoticiaBe;
import br.com.orlandoburli.euvouromper.model.dao.site.NoticiaDao;
import br.com.orlandoburli.euvouromper.model.vo.site.NoticiaVo;
import br.com.orlandoburli.euvouromper.model.vo.site.StatusNoticia;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;

public class NoticiaCadastroAction extends BaseCadastroAction<NoticiaVo, NoticiaDao, NoticiaBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspCadastro() {
		return "web/pages/site/noticia/noticiacadastro.jsp";
	}

	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, NoticiaVo vo, NoticiaBe be, DAOManager manager) {
		super.doBeforeVisualizar(request, response, vo, be, manager);

		getRequest().setAttribute("titulo", "Cadastro de Noticias");
		getRequest().setAttribute("subtitulo", "Cadastro de Noticias do Site");
		getRequest().setAttribute("submenu", "Site");
		getRequest().setAttribute("menuAtivo", "Noticia");
		
		getRequest().setAttribute("statusNoticiaList", new StatusNoticia().getList());
	}

}

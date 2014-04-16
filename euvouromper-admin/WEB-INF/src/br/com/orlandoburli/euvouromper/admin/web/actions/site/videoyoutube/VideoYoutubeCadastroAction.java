package br.com.orlandoburli.euvouromper.admin.web.actions.site.videoyoutube;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.site.VideoYoutubeBe;
import br.com.orlandoburli.euvouromper.model.dao.site.VideoYoutubeDao;
import br.com.orlandoburli.euvouromper.model.vo.site.VideoYoutubeVo;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;

public class VideoYoutubeCadastroAction extends BaseCadastroAction<VideoYoutubeVo, VideoYoutubeDao, VideoYoutubeBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspCadastro() {
		return "web/pages/site/videoyoutube/videoyoutubecadastro.jsp";
	}

	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, VideoYoutubeVo vo, VideoYoutubeBe be, DAOManager manager) {
		super.doBeforeVisualizar(request, response, vo, be, manager);
		
		getRequest().setAttribute("titulo", "Cadastro de Videos do Youtube");
		getRequest().setAttribute("subtitulo", "Cadastro de Videos do Youtube do Site");
		getRequest().setAttribute("submenu", "Site");
		getRequest().setAttribute("menuAtivo", "VideoYoutube");
	}

}

package br.com.orlandoburli.euvouromper.admin.web.actions.site.videoyoutube;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.site.VideoYoutubeBe;
import br.com.orlandoburli.euvouromper.model.dao.site.VideoYoutubeDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.vo.site.VideoYoutubeVo;
import br.com.orlandoburli.framework.core.web.BaseConsultaAction;

public class VideoYoutubeConsultaAction extends BaseConsultaAction<VideoYoutubeVo, VideoYoutubeDao, VideoYoutubeBe>{

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspConsulta() {
		return "web/pages/site/videoyoutube/videoyoutubeconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/site/videoyoutube/videoyoutubeconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return Dicionario.VideoYoutube.TABELA_VIDEO_YOUTUBE + "." + Dicionario.VideoYoutube.Colunas.ID_VIDEO_YOUTUBE + " DESC";
	}

	@Override
	public void doBeforeExecute() {
		super.doBeforeExecute();
		getRequest().setAttribute("titulo", "Consulta de Videos do Youtube");
		getRequest().setAttribute("subtitulo", "Consulta de Videos do Youtube do Site");
		getRequest().setAttribute("submenu", "Site");
		getRequest().setAttribute("menuAtivo", "VideoYoutubes");
	}

	@Override
	public void doBeforeFilter(VideoYoutubeVo filter, VideoYoutubeBe be, HttpServletRequest request, HttpServletResponse response) {
		if (getParametroPesquisa() != null) {
			if (getParametroPesquisa().equalsIgnoreCase("Codigo")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdVideoYoutube(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("Nome")) {
				filter.setDescricao("%" + getPesquisarPor() + "%");
			}
		} else {
			filter.setDescricao("%" + getPesquisarPor() + "%");
		}
	}
}

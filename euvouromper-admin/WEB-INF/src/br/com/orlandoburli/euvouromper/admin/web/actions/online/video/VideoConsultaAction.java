package br.com.orlandoburli.euvouromper.admin.web.actions.online.video;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.online.VideoBe;
import br.com.orlandoburli.euvouromper.model.dao.online.VideoDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.vo.online.VideoVo;
import br.com.orlandoburli.framework.core.web.BaseConsultaAction;

public class VideoConsultaAction extends BaseConsultaAction<VideoVo, VideoDao, VideoBe>{

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspConsulta() {
		return "web/pages/online/video/videoconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/online/video/videoconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return Dicionario.Video.TABELA_VIDEO + "." + Dicionario.Video.Colunas.NOME + ", " + Dicionario.Video.TABELA_VIDEO + "." + Dicionario.Video.Colunas.AULA + ", " + Dicionario.Video.TABELA_VIDEO + "." + Dicionario.Video.Colunas.BLOCO;
	}
	
	@Override
	public void doBeforeExecute() {
		super.doBeforeExecute();
		getRequest().setAttribute("titulo", "Consulta de Vídeos");
		getRequest().setAttribute("subtitulo", "Consulta de Vídeos do Site");
		getRequest().setAttribute("submenu", "Online");
		getRequest().setAttribute("menuAtivo", "Vídeos");
	}

	@Override
	public void doBeforeFilter(VideoVo filter, VideoBe be, HttpServletRequest request, HttpServletResponse response) {
		if (getParametroPesquisa() != null) {
			if (getParametroPesquisa().equalsIgnoreCase("Codigo")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdVideo(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("Nome")) {
				filter.setNome("%" + getPesquisarPor() + "%");
			} else if (getParametroPesquisa().equalsIgnoreCase("Professor")) {
				filter.getProfessor().setNome("%" + getPesquisarPor() + "%");
			} else if (getParametroPesquisa().equalsIgnoreCase("Disciplina")) {
				filter.getDisciplina().setNome("%" + getPesquisarPor() + "%");
			}
		} else {
			filter.setNome("%" + getPesquisarPor() + "%");
		}
	}

}

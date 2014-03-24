package br.com.orlandoburli.euvouromper.admin.web.actions.online.video;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.cadastros.DisciplinaBe;
import br.com.orlandoburli.euvouromper.model.be.cadastros.ProfessorBe;
import br.com.orlandoburli.euvouromper.model.be.online.VideoBe;
import br.com.orlandoburli.euvouromper.model.dao.online.VideoDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.vo.online.VideoVo;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;

public class VideoCadastroAction extends BaseCadastroAction<VideoVo, VideoDao, VideoBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspCadastro() {
		return "web/pages/online/video/videocadastro.jsp";
	}

	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, VideoVo vo, VideoBe be, DAOManager manager) {
		super.doBeforeVisualizar(request, response, vo, be, manager);

		getRequest().setAttribute("titulo", "Cadastro de Vídeos");
		getRequest().setAttribute("subtitulo", "Cadastro de Vídeos do Site");
		getRequest().setAttribute("submenu", "Online");
		getRequest().setAttribute("menuAtivo", "Vídeos");

		try {
			getRequest().setAttribute("professores", new ProfessorBe(manager).getList(null, null, Dicionario.Professor.TABELA_PROFESSOR + "." + Dicionario.Professor.Colunas.NOME));
			getRequest().setAttribute("disciplinas", new DisciplinaBe(manager).getList(null, null, Dicionario.Disciplina.TABELA_DISCIPLINA + "." + Dicionario.Disciplina.Colunas.NOME));
		} catch (ListException e) {
			e.printStackTrace();
		}
	}

}

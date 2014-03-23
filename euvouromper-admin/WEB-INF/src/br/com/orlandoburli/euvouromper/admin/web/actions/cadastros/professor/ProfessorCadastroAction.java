package br.com.orlandoburli.euvouromper.admin.web.actions.cadastros.professor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.cadastros.ProfessorBe;
import br.com.orlandoburli.euvouromper.model.dao.cadastros.ProfessorDao;
import br.com.orlandoburli.euvouromper.model.vo.cadastros.ProfessorVo;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;

public class ProfessorCadastroAction extends BaseCadastroAction<ProfessorVo, ProfessorDao, ProfessorBe>{

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspCadastro() {
		return "web/pages/cadastros/professor/professorcadastro.jsp";
	}


	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, ProfessorVo vo, ProfessorBe be, DAOManager manager) {
		super.doBeforeVisualizar(request, response, vo, be, manager);
		
		getRequest().setAttribute("titulo", "Cadastro de Professores");
		getRequest().setAttribute("subtitulo", "Cadastro de Professores do Site");
		getRequest().setAttribute("submenu", "Cadastros");
		getRequest().setAttribute("menuAtivo", "Professores");
	}
}

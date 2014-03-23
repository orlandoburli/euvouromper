package br.com.orlandoburli.euvouromper.admin.web.actions.cadastros.disciplina;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.cadastros.DisciplinaBe;
import br.com.orlandoburli.euvouromper.model.dao.cadastros.DisciplinaDao;
import br.com.orlandoburli.euvouromper.model.vo.cadastros.DisciplinaVo;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;

public class DisciplinaCadastroAction extends BaseCadastroAction<DisciplinaVo, DisciplinaDao, DisciplinaBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspCadastro() {
		return "web/pages/cadastros/disciplina/disciplinacadastro.jsp";
	}

	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, DisciplinaVo vo, DisciplinaBe be, DAOManager manager) {
		super.doBeforeVisualizar(request, response, vo, be, manager);
		
		getRequest().setAttribute("titulo", "Cadastro de Disciplinas");
		getRequest().setAttribute("subtitulo", "Cadastro de Disciplinas do Site");
		getRequest().setAttribute("submenu", "Cadastros");
		getRequest().setAttribute("menuAtivo", "Disciplina");
	}
}

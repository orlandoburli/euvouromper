package br.com.orlandoburli.euvouromper.admin.web.actions.cadastros.professor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.cadastros.ProfessorBe;
import br.com.orlandoburli.euvouromper.model.dao.cadastros.ProfessorDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.vo.cadastros.ProfessorVo;
import br.com.orlandoburli.framework.core.web.BaseConsultaAction;

public class ProfessorConsultaAction extends BaseConsultaAction<ProfessorVo, ProfessorDao, ProfessorBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspConsulta() {
		return "web/pages/cadastros/professor/professorconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/cadastros/professor/professorconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return Dicionario.Professor.TABELA_PROFESSOR + "." + Dicionario.Professor.Colunas.NOME;
	}

	@Override
	public void doBeforeExecute() {
		super.doBeforeExecute();
		getRequest().setAttribute("titulo", "Consulta de Professores");
		getRequest().setAttribute("subtitulo", "Consulta de Professores do Site");
		getRequest().setAttribute("submenu", "Cadastros");
		getRequest().setAttribute("menuAtivo", "Professores");
	}

	@Override
	public void doBeforeFilter(ProfessorVo filter, ProfessorBe be, HttpServletRequest request, HttpServletResponse response) {
		if (getParametroPesquisa() != null) {
			if (getParametroPesquisa().equalsIgnoreCase("Codigo")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdProfessor(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("Nome")) {
				filter.setNome("%" + getPesquisarPor() + "%");
			}
		} else {
			filter.setNome("%" + getPesquisarPor() + "%");
		}
	}

}

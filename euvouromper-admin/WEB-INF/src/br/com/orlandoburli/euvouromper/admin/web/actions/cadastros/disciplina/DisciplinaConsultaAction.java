package br.com.orlandoburli.euvouromper.admin.web.actions.cadastros.disciplina;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.cadastros.DisciplinaBe;
import br.com.orlandoburli.euvouromper.model.dao.cadastros.DisciplinaDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.vo.cadastros.DisciplinaVo;
import br.com.orlandoburli.framework.core.web.BaseConsultaAction;

public class DisciplinaConsultaAction extends BaseConsultaAction<DisciplinaVo, DisciplinaDao, DisciplinaBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspConsulta() {
		return "web/pages/cadastros/disciplina/disciplinaconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/cadastros/disciplina/disciplinaconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return Dicionario.Disciplina.TABELA_DISCIPLINA + "." + Dicionario.Disciplina.Colunas.NOME;
	}

	@Override
	public void doBeforeExecute() {
		super.doBeforeExecute();
		getRequest().setAttribute("titulo", "Consulta de Disciplinas");
		getRequest().setAttribute("subtitulo", "Consulta de Disciplinas do Site");
		getRequest().setAttribute("submenu", "Cadastros");
		getRequest().setAttribute("menuAtivo", "Disciplinas");
	}

	@Override
	public void doBeforeFilter(DisciplinaVo filter, DisciplinaBe be, HttpServletRequest request, HttpServletResponse response) {
		if (getParametroPesquisa() != null) {
			if (getParametroPesquisa().equalsIgnoreCase("Codigo")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdDisciplina(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("Nome")) {
				filter.setNome("%" + getPesquisarPor() + "%");
			}
		} else {
			filter.setNome("%" + getPesquisarPor() + "%");
		}
	}

}

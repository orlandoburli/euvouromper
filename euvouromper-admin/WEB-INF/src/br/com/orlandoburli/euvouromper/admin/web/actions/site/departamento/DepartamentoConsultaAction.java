package br.com.orlandoburli.euvouromper.admin.web.actions.site.departamento;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.site.DepartamentoBe;
import br.com.orlandoburli.euvouromper.model.dao.site.DepartamentoDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.vo.site.DepartamentoVo;
import br.com.orlandoburli.framework.core.web.BaseConsultaAction;

public class DepartamentoConsultaAction extends BaseConsultaAction<DepartamentoVo, DepartamentoDao, DepartamentoBe>{

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspConsulta() {
		return "web/pages/site/departamento/departamentoconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/site/departamento/departamentoconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return Dicionario.Departamento.TABELA_DEPARTAMENTO + "." + Dicionario.Departamento.Colunas.NOME;
	}

	@Override
	public void doBeforeExecute() {
		super.doBeforeExecute();
		getRequest().setAttribute("titulo", "Consulta de Departamentos");
		getRequest().setAttribute("subtitulo", "Consulta de Departamentos do Site");
		getRequest().setAttribute("submenu", "Site");
		getRequest().setAttribute("menuAtivo", "Departamentos");
	}

	@Override
	public void doBeforeFilter(DepartamentoVo filter, DepartamentoBe be, HttpServletRequest request, HttpServletResponse response) {
		if (getParametroPesquisa() != null) {
			if (getParametroPesquisa().equalsIgnoreCase("Codigo")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdDepartamento(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("Nome")) {
				filter.setNome("%" + getPesquisarPor() + "%");
			}
		} else {
			filter.setNome("%" + getPesquisarPor() + "%");
		}
	}

}

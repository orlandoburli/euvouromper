package br.com.orlandoburli.euvouromper.admin.web.actions.site.depoimento;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.site.DepoimentoBe;
import br.com.orlandoburli.euvouromper.model.dao.site.DepoimentoDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.vo.site.DepoimentoVo;
import br.com.orlandoburli.framework.core.web.BaseConsultaAction;

public class DepoimentoConsultaAction extends BaseConsultaAction<DepoimentoVo, DepoimentoDao, DepoimentoBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspConsulta() {
		return "web/pages/site/depoimento/depoimentoconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/site/depoimento/depoimentoconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return Dicionario.Depoimento.TABELA_DEPOIMENTO + "." + Dicionario.Depoimento.Colunas.NOME;
	}

	@Override
	public void doBeforeExecute() {
		super.doBeforeExecute();
		getRequest().setAttribute("titulo", "Consulta de Depoimentos");
		getRequest().setAttribute("subtitulo", "Consulta de Depoimentos do Site");
		getRequest().setAttribute("submenu", "Site");
		getRequest().setAttribute("menuAtivo", "Depoimentos");
	}

	@Override
	public void doBeforeFilter(DepoimentoVo filter, DepoimentoBe be, HttpServletRequest request, HttpServletResponse response) {
		if (getParametroPesquisa() != null) {
			if (getParametroPesquisa().equalsIgnoreCase("Codigo")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdDepoimento(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("Nome")) {
				filter.setNome("%" + getPesquisarPor() + "%");
			}
		} else {
			filter.setNome("%" + getPesquisarPor() + "%");
		}
	}

}

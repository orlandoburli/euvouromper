package br.com.orlandoburli.euvouromper.admin.web.actions.ecommerce.cupomdesconto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.ecommerce.CupomDescontoBe;
import br.com.orlandoburli.euvouromper.model.dao.ecommerce.CupomDescontoDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.CupomDescontoVo;
import br.com.orlandoburli.framework.core.web.BaseConsultaAction;

public class CupomDescontoConsultaAction extends BaseConsultaAction<CupomDescontoVo, CupomDescontoDao, CupomDescontoBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspConsulta() {
		return "web/pages/ecommerce/cupomdesconto/cupomdescontoconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/ecommerce/cupomdesconto/cupomdescontoconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return Dicionario.CupomDesconto.TABELA_CUPOM_DESCONTO + "." + Dicionario.CupomDesconto.Colunas.DESCRICAO;
	}

	@Override
	public void doBeforeExecute() {
		super.doBeforeExecute();

		getRequest().setAttribute("titulo", "Consulta de Cupons de Desconto");
		getRequest().setAttribute("subtitulo", "Consulta de Cupons de Desconto do Site");
		getRequest().setAttribute("submenu", "e-Commerce");
		getRequest().setAttribute("menuAtivo", "Cupons de Desconto");
	}

	@Override
	public void doBeforeFilter(CupomDescontoVo filter, CupomDescontoBe be, HttpServletRequest request, HttpServletResponse response) {
		if (getParametroPesquisa() != null) {
			if (getParametroPesquisa().equalsIgnoreCase("Codigo")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdCupom(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("Descricao")) {
				filter.setDescricao("%" + getPesquisarPor() + "%");
			} else if (getParametroPesquisa().equalsIgnoreCase("Chave")) {
				filter.setChave("%" + getPesquisarPor() + "%");
			}
		} else {
			filter.setDescricao("%" + getPesquisarPor() + "%");
		}
	}

}

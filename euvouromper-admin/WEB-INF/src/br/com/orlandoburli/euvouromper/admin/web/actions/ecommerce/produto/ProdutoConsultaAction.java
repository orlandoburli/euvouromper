package br.com.orlandoburli.euvouromper.admin.web.actions.ecommerce.produto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.ecommerce.ProdutoBe;
import br.com.orlandoburli.euvouromper.model.dao.ecommerce.ProdutoDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ProdutoVo;
import br.com.orlandoburli.framework.core.web.BaseConsultaAction;

public class ProdutoConsultaAction extends BaseConsultaAction<ProdutoVo, ProdutoDao, ProdutoBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspConsulta() {
		return "web/pages/ecommerce/produto/produtoconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/ecommerce/produto/produtoconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return Dicionario.Produto.TABELA_PRODUTO + "." + Dicionario.Produto.Colunas.NOME;
	}

	@Override
	public void doBeforeExecute() {
		super.doBeforeExecute();

		getRequest().setAttribute("titulo", "Consulta de Produtos");
		getRequest().setAttribute("subtitulo", "Consulta de Produtos do Site");
		getRequest().setAttribute("submenu", "e-Commerce");
		getRequest().setAttribute("menuAtivo", "Produtos");
	}

	@Override
	public void doBeforeFilter(ProdutoVo filter, ProdutoBe be, HttpServletRequest request, HttpServletResponse response) {
		if (getParametroPesquisa() != null) {
			if (getParametroPesquisa().equalsIgnoreCase("Codigo")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdProduto(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("Nome")) {
				filter.setNome("%" + getPesquisarPor() + "%");
			}
		} else {
			filter.setNome("%" + getPesquisarPor() + "%");
		}
	}

}

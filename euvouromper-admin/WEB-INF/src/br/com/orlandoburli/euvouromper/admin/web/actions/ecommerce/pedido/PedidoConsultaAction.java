package br.com.orlandoburli.euvouromper.admin.web.actions.ecommerce.pedido;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.ecommerce.PedidoBe;
import br.com.orlandoburli.euvouromper.model.dao.ecommerce.PedidoDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.PedidoVo;
import br.com.orlandoburli.framework.core.web.BaseConsultaAction;

public class PedidoConsultaAction extends BaseConsultaAction<PedidoVo, PedidoDao, PedidoBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspConsulta() {
		return "web/pages/ecommerce/pedido/pedidoconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/ecommerce/pedido/pedidoconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return Dicionario.Pedido.TABELA_PEDIDO + "." + Dicionario.Pedido.Colunas.ID_PEDIDO + " DESC";
	}

	@Override
	public void doBeforeExecute() {
		super.doBeforeExecute();
		getRequest().setAttribute("titulo", "Consulta de Pedidos");
		getRequest().setAttribute("subtitulo", "Consulta de Pedidos do Site");
		getRequest().setAttribute("submenu", "e-Commerce");
		getRequest().setAttribute("menuAtivo", "Pedidos");
	}

	@Override
	public void doBeforeFilter(PedidoVo filter, PedidoBe be, HttpServletRequest request, HttpServletResponse response) {
		if (getParametroPesquisa() != null) {
			if (getParametroPesquisa().equalsIgnoreCase("Codigo")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdPedido(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("Nome")) {
				filter.setNome("%" + getPesquisarPor() + "%");
			} else if (getParametroPesquisa().equalsIgnoreCase("Nome")) {
				filter.setEmail("%" + getPesquisarPor() + "%");
			}
		} else {
			filter.setNome("%" + getPesquisarPor() + "%");
		}
	}
}

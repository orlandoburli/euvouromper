package br.com.orlandoburli.euvouromper.admin.web.actions.ecommerce.pedido;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.ecommerce.ItemPedidoBe;
import br.com.orlandoburli.euvouromper.model.be.ecommerce.PedidoBe;
import br.com.orlandoburli.euvouromper.model.dao.ecommerce.PedidoDao;
import br.com.orlandoburli.euvouromper.model.vo.admin.UsuarioVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.PedidoMovimentacaoBe;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.PedidoVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.StatusPedido;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.utils.Constants;
import br.com.orlandoburli.framework.core.utils.Utils;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;
import br.com.orlandoburli.framework.core.web.retorno.RetornoAction;

public class PedidoCadastroAction extends BaseCadastroAction<PedidoVo, PedidoDao, PedidoBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspCadastro() {
		return "web/pages/ecommerce/pedido/pedidocadastro.jsp";
	}

	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, PedidoVo vo, PedidoBe be, DAOManager manager) {
		super.doBeforeVisualizar(request, response, vo, be, manager);

		try {
			request.setAttribute("itens", new ItemPedidoBe(manager).getList(vo));
			request.setAttribute("movimentacoes", new PedidoMovimentacaoBe(manager).getList(vo));
		} catch (ListException e) {
			Log.error(e);
		}

		getRequest().setAttribute("titulo", "Cadastro de Pedidos");
		getRequest().setAttribute("subtitulo", "Cadastro de Pedidos do Site");
		getRequest().setAttribute("submenu", "e-Commerce");
		getRequest().setAttribute("menuAtivo", "Pedido");
	}

	public void pagar() {
		alterarPedido(StatusPedido.PAGO);
	}

	public void cancelar() {
		alterarPedido(StatusPedido.CANCELADO);
	}

	private void alterarPedido(String status) {
		DAOManager manager = DAOManager.getDAOManager();
		try {
			manager.begin();

			PedidoVo vo = (PedidoVo) getRequest().getSession().getAttribute(getVoSessionId()); // getNewVo();
			PedidoBe be = new PedidoBe(manager);
			
			vo = be.get(vo);

			doBeforeAlterar(vo, manager);
			doBeforeSalvar(vo, manager);

			UsuarioVo usuario = (UsuarioVo) getRequest().getSession().getAttribute(Constants.Session.SESSION_USUARIO);
			vo.setUsuario(usuario);

			doAfterAlterar(vo, manager);
			doAfterSalvar(vo, manager);

			if (status.equals(StatusPedido.PAGO)) {
				be.pagar(vo);
			} else if (status.equals(StatusPedido.CANCELADO)) {
				be.cancelar(vo);
			}

			manager.commit();

			write(Utils.voToJson(new RetornoAction(true, "Pedido " + new StatusPedido().getDescription(status) + " com sucesso!", "")));

		} catch (BeException e) {
			manager.rollback();
			write(Utils.voToJson(new RetornoAction(false, e.getMessage())));
		} finally {
			manager.commit();
		}
	}

	@Override
	public void alterar() {
		acaoNaoPermitida();
	}

	@Override
	public void excluir() {
		acaoNaoPermitida();
	}

	@Override
	public void inserir() {
		acaoNaoPermitida();
	}

	private void acaoNaoPermitida() {
		write(Utils.voToJson(new RetornoAction(false, "Ação não permitida!", "")));
	}
}

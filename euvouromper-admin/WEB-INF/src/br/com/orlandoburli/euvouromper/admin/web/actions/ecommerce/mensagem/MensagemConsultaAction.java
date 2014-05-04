package br.com.orlandoburli.euvouromper.admin.web.actions.ecommerce.mensagem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.ecommerce.MensagemBe;
import br.com.orlandoburli.euvouromper.model.dao.ecommerce.MensagemDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.MensagemVo;
import br.com.orlandoburli.framework.core.web.BaseConsultaAction;

public class MensagemConsultaAction extends BaseConsultaAction<MensagemVo, MensagemDao, MensagemBe>{

	private static final long serialVersionUID = 1L;


	@Override
	public String getJspConsulta() {
		return "web/pages/ecommerce/mensagem/mensagemconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/ecommerce/mensagem/mensagemconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return Dicionario.Mensagem.TABELA_MENSAGEM + "." + Dicionario.Mensagem.Colunas.ID_MENSAGEM + " DESC";
	}

	@Override
	public void doBeforeExecute() {
		super.doBeforeExecute();
		getRequest().setAttribute("titulo", "Consulta de Mensagens");
		getRequest().setAttribute("subtitulo", "Consulta de Mensagens do Site");
		getRequest().setAttribute("submenu", "e-Commerce");
		getRequest().setAttribute("menuAtivo", "Mensagens");
	}

	@Override
	public void doBeforeFilter(MensagemVo filter, MensagemBe be, HttpServletRequest request, HttpServletResponse response) {
		if (getParametroPesquisa() != null) {
			if (getParametroPesquisa().equalsIgnoreCase("Codigo")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdMensagem(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("Assunto")) {
				filter.setAssunto("%" + getPesquisarPor() + "%");
			}
		} else {
			filter.setAssunto("%" + getPesquisarPor() + "%");
		}
	}

}

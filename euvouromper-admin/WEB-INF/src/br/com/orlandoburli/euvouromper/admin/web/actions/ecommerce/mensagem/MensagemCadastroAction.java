package br.com.orlandoburli.euvouromper.admin.web.actions.ecommerce.mensagem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.ecommerce.MensagemBe;
import br.com.orlandoburli.euvouromper.model.be.ecommerce.ProdutoBe;
import br.com.orlandoburli.euvouromper.model.be.ecommerce.cliente.ClienteBe;
import br.com.orlandoburli.euvouromper.model.dao.ecommerce.MensagemDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Cliente;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Produto;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.MensagemVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.StatusMensagem;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.TipoDestinoMensagens;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;

public class MensagemCadastroAction extends BaseCadastroAction<MensagemVo, MensagemDao, MensagemBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspCadastro() {
		return "web/pages/ecommerce/mensagem/mensagemcadastro.jsp";
	}

	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, MensagemVo vo, MensagemBe be, DAOManager manager) {
		super.doBeforeVisualizar(request, response, vo, be, manager);

		getRequest().setAttribute("titulo", "Cadastro de Mensagens");
		getRequest().setAttribute("subtitulo", "Cadastro de Mensagens do Site");
		getRequest().setAttribute("submenu", "e-Commerce");
		getRequest().setAttribute("menuAtivo", "Mensagem");

		getRequest().setAttribute("tipoDestinoMensagens", new TipoDestinoMensagens().getList());
		getRequest().setAttribute("statusMensagens", new StatusMensagem().getList());

		try {
			getRequest().setAttribute("clientes", new ClienteBe(getManager()).getList(null, null, Cliente.TABELA_CLIENTE + "." + Cliente.Colunas.NOME));
			getRequest().setAttribute("produtos", new ProdutoBe(getManager()).getList(null, null, Produto.TABELA_PRODUTO + "." + Produto.Colunas.NOME));
		} catch (ListException e) {
			e.printStackTrace();
		}
	}

}

package br.com.orlandoburli.euvouromper.admin.web.actions.ecommerce.cupomdesconto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.ecommerce.ClienteBe;
import br.com.orlandoburli.euvouromper.model.be.ecommerce.CupomDescontoBe;
import br.com.orlandoburli.euvouromper.model.be.ecommerce.ProdutoBe;
import br.com.orlandoburli.euvouromper.model.dao.ecommerce.CupomDescontoDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Cliente;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Produto;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.CupomDescontoVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.TipoDesconto;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.utils.Utils;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;
import br.com.orlandoburli.framework.core.web.filters.IgnoreMethodAuthentication;

public class CupomDescontoCadastroAction extends BaseCadastroAction<CupomDescontoVo, CupomDescontoDao, CupomDescontoBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspCadastro() {
		return "web/pages/ecommerce/cupomdesconto/cupomdescontocadastro.jsp";
	}

	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, CupomDescontoVo vo, CupomDescontoBe be, DAOManager manager) {
		super.doBeforeVisualizar(request, response, vo, be, manager);

		getRequest().setAttribute("titulo", "Cadastro de Cupons de Desconto");
		getRequest().setAttribute("subtitulo", "Cadastro de Cupons de Desconto do Site");
		getRequest().setAttribute("submenu", "e-Commerce");
		getRequest().setAttribute("menuAtivo", "Cupons de Desconto");

		getRequest().setAttribute("tipoDescontoList", new TipoDesconto().getList());

		try {
			getRequest().setAttribute("produtos", new ProdutoBe(getManager()).getList(null, null, Produto.TABELA_PRODUTO + "." + Produto.Colunas.NOME));
			getRequest().setAttribute("clientes", new ClienteBe(getManager()).getList(null, null, Cliente.TABELA_CLIENTE + "." + Cliente.Colunas.NOME));
		} catch (ListException e) {
			e.printStackTrace();
		}
	}
	
	@IgnoreMethodAuthentication
	public void geracadeia() {
		write(Utils.geraCadeiaString(8).toUpperCase());
	}
}

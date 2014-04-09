package br.com.orlandoburli.euvouromper.admin.web.actions.ecommerce.produto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.ecommerce.ProdutoBe;
import br.com.orlandoburli.euvouromper.model.be.online.ModuloBe;
import br.com.orlandoburli.euvouromper.model.be.online.PacoteBe;
import br.com.orlandoburli.euvouromper.model.dao.ecommerce.ProdutoDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Modulo;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Pacote;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ProdutoVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.TipoProduto;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.TipoValidade;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;

public class ProdutoCadastroAction extends BaseCadastroAction<ProdutoVo, ProdutoDao, ProdutoBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspCadastro() {
		return "web/pages/ecommerce/produto/produtocadastro.jsp";
	}

	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, ProdutoVo vo, ProdutoBe be, DAOManager manager) {
		super.doBeforeVisualizar(request, response, vo, be, manager);

		getRequest().setAttribute("titulo", "Cadastro de Produtos");
		getRequest().setAttribute("subtitulo", "Cadastro de Produtos do Site");
		getRequest().setAttribute("submenu", "e-Commerce");
		getRequest().setAttribute("menuAtivo", "Produto");

		getRequest().setAttribute("tipoProdutoList", new TipoProduto().getList());
		getRequest().setAttribute("tipoValidadeList", new TipoValidade().getList());
		
		try {
			getRequest().setAttribute("pacotes", new PacoteBe(getManager()).getList(null, null, Pacote.Colunas.NOME));
			getRequest().setAttribute("modulos", new ModuloBe(getManager()).getList(null, null, Modulo.Colunas.NOME));
		} catch (ListException e) {
			e.printStackTrace();
		}
	}

}

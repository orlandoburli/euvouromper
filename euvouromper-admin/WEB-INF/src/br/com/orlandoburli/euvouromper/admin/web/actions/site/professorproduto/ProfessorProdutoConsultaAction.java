package br.com.orlandoburli.euvouromper.admin.web.actions.site.professorproduto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.cadastros.ProfessorBe;
import br.com.orlandoburli.euvouromper.model.be.cadastros.ProfessorProdutoBe;
import br.com.orlandoburli.euvouromper.model.dao.cadastros.ProfessorProdutoDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.vo.cadastros.ProfessorProdutoVo;
import br.com.orlandoburli.euvouromper.model.vo.cadastros.ProfessorVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ProdutoVo;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.web.BaseConsultaAction;
import br.com.orlandoburli.framework.core.web.filters.OutjectSession;

public class ProfessorProdutoConsultaAction extends BaseConsultaAction<ProfessorProdutoVo, ProfessorProdutoDao, ProfessorProdutoBe> {

	private static final long serialVersionUID = 1L;

	private Integer idProfessor;

	@OutjectSession("professorSelecionado")
	private ProfessorVo professorSelecionado;

	@Override
	public String getJspConsulta() {
		return "web/pages/site/professorproduto/professorprodutoconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/site/professorproduto/professorprodutoconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return Dicionario.ProfessorProduto.TABELA_PROFESSOR_PRODUTO + "_" + Dicionario.Produto.TABELA_PRODUTO + "." + Dicionario.Produto.Colunas.NOME;
	}

	@Override
	public void doBeforeExecute() {
		super.doBeforeExecute();

		if (getIdProfessor() != null) {
			setProfessorSelecionado(new ProfessorVo());
			getProfessorSelecionado().setIdProfessor(getIdProfessor());

			try {
				setProfessorSelecionado(new ProfessorBe(getManager()).get(getProfessorSelecionado()));
			} catch (ListException e) {
				e.printStackTrace();
			}
		}

		if (getProfessorSelecionado() == null) {
			return;
		}

		getRequest().setAttribute("titulo", "Consulta de Produtos do Professor <strong>" + getProfessorSelecionado().getNome() + "</strong>");
		getRequest().setAttribute("subtitulo", "Consulta de Produtos do Professor do Site");
		getRequest().setAttribute("submenu", "Site");
		getRequest().setAttribute("menuAtivo", "Produtos do Professor");
	}

	@Override
	public void doBeforeFilter(ProfessorProdutoVo filter, ProfessorProdutoBe be, HttpServletRequest request, HttpServletResponse response) {
		filter.setProduto(new ProdutoVo());
		filter.getProduto().setNome("%" + getPesquisarPor() + "%");
		filter.setIdProfessor(getProfessorSelecionado().getIdProfessor());
	}

	public ProfessorVo getProfessorSelecionado() {
		return professorSelecionado;
	}

	public void setProfessorSelecionado(ProfessorVo professorSelecionado) {
		this.professorSelecionado = professorSelecionado;
	}

	public Integer getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(Integer idProfessor) {
		this.idProfessor = idProfessor;
	}

}

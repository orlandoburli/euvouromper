package br.com.orlandoburli.euvouromper.admin.web.actions.site.professorproduto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.cadastros.ProfessorProdutoBe;
import br.com.orlandoburli.euvouromper.model.dao.cadastros.ProfessorProdutoDao;
import br.com.orlandoburli.euvouromper.model.vo.cadastros.ProfessorProdutoVo;
import br.com.orlandoburli.euvouromper.model.vo.cadastros.ProfessorVo;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;
import br.com.orlandoburli.framework.core.web.filters.OutjectSession;

public class ProfessorProdutoCadastroAction extends BaseCadastroAction<ProfessorProdutoVo, ProfessorProdutoDao, ProfessorProdutoBe> {

	private static final long serialVersionUID = 1L;

	private Integer idProfessor;

	@OutjectSession("professorSelecionado")
	private ProfessorVo professorSelecionado;

	@Override
	public String getJspCadastro() {
		return "web/pages/site/professorproduto/professorprodutocadastro.jsp";
	}

	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, ProfessorProdutoVo vo, ProfessorProdutoBe be, DAOManager manager) {
		super.doBeforeVisualizar(request, response, vo, be, manager);

		getRequest().setAttribute("titulo", "Cadastro de Produtos do Professor <strong>" + getProfessorSelecionado().getNome() + "</strong>");
		getRequest().setAttribute("subtitulo", "Cadastro de Produtos do Professor do Site");
		getRequest().setAttribute("submenu", "Site");
		getRequest().setAttribute("menuAtivo", "Produtos do Professor");

		try {
			getRequest().setAttribute("produtos", be.getListNotIn(getProfessorSelecionado()));
		} catch (ListException e) {
			e.printStackTrace();
		}
	}

	public Integer getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(Integer idProfessor) {
		this.idProfessor = idProfessor;
	}

	public ProfessorVo getProfessorSelecionado() {
		return professorSelecionado;
	}

	public void setProfessorSelecionado(ProfessorVo professorSelecionado) {
		this.professorSelecionado = professorSelecionado;
	}

}

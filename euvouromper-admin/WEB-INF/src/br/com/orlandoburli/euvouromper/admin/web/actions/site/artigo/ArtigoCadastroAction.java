package br.com.orlandoburli.euvouromper.admin.web.actions.site.artigo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.cadastros.ProfessorBe;
import br.com.orlandoburli.euvouromper.model.be.site.ArtigoBe;
import br.com.orlandoburli.euvouromper.model.dao.site.ArtigoDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Professor;
import br.com.orlandoburli.euvouromper.model.vo.site.ArtigoVo;
import br.com.orlandoburli.euvouromper.model.vo.site.StatusArtigo;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;

public class ArtigoCadastroAction extends BaseCadastroAction<ArtigoVo, ArtigoDao, ArtigoBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspCadastro() {
		return "web/pages/site/artigo/artigocadastro.jsp";
	}

	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, ArtigoVo vo, ArtigoBe be, DAOManager manager) {
		super.doBeforeVisualizar(request, response, vo, be, manager);

		getRequest().setAttribute("titulo", "Cadastro de Artigos");
		getRequest().setAttribute("subtitulo", "Cadastro de Artigos do Site");
		getRequest().setAttribute("submenu", "Site");
		getRequest().setAttribute("menuAtivo", "Artigo");

		getRequest().setAttribute("statusArtigoList", new StatusArtigo().getList());

		try {
			getRequest().setAttribute("professores", new ProfessorBe(manager).getList(null, null, Professor.TABELA_PROFESSOR + "." + Professor.Colunas.NOME));
		} catch (ListException e) {
			Log.error(e);
		}

	}
}

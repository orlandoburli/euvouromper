package br.com.orlandoburli.euvouromper.admin.web.actions.online.modulo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.cadastros.ProfessorBe;
import br.com.orlandoburli.euvouromper.model.be.online.ModuloBe;
import br.com.orlandoburli.euvouromper.model.dao.online.ModuloDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Professor;
import br.com.orlandoburli.euvouromper.model.vo.online.ModuloVo;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;

public class ModuloCadastroAction extends BaseCadastroAction<ModuloVo, ModuloDao, ModuloBe>{

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspCadastro() {
		return "web/pages/online/modulo/modulocadastro.jsp";
	}

	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, ModuloVo vo, ModuloBe be, DAOManager manager) {
		super.doBeforeVisualizar(request, response, vo, be, manager);
		
		getRequest().setAttribute("titulo", "Cadastro de Módulos");
		getRequest().setAttribute("subtitulo", "Cadastro de Módulos do Site");
		getRequest().setAttribute("submenu", "Online");
		getRequest().setAttribute("menuAtivo", "Módulos");
		
		try {
			getRequest().setAttribute("professores", new ProfessorBe(getManager()).getList(null, null, Professor.TABELA_PROFESSOR + "." + Professor.Colunas.NOME));
		} catch (ListException e) {
			Log.error(e);
		}
	}
}

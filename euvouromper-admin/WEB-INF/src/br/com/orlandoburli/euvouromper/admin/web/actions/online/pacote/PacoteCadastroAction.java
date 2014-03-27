package br.com.orlandoburli.euvouromper.admin.web.actions.online.pacote;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.online.PacoteBe;
import br.com.orlandoburli.euvouromper.model.dao.online.PacoteDao;
import br.com.orlandoburli.euvouromper.model.vo.online.PacoteVo;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;

public class PacoteCadastroAction extends BaseCadastroAction<PacoteVo, PacoteDao, PacoteBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspCadastro() {
		return "web/pages/online/pacote/pacotecadastro.jsp";
	}

	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, PacoteVo vo, PacoteBe be, DAOManager manager) {
		super.doBeforeVisualizar(request, response, vo, be, manager);

		getRequest().setAttribute("titulo", "Cadastro de Pacotes");
		getRequest().setAttribute("subtitulo", "Cadastro de Pacotes do Site");
		getRequest().setAttribute("submenu", "Online");
		getRequest().setAttribute("menuAtivo", "Pacotes");
	}

}

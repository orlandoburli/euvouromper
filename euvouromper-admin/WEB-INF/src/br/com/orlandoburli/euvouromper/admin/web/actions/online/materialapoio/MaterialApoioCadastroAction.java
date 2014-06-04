package br.com.orlandoburli.euvouromper.admin.web.actions.online.materialapoio;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.online.MaterialApoioBe;
import br.com.orlandoburli.euvouromper.model.be.online.ModuloBe;
import br.com.orlandoburli.euvouromper.model.dao.online.MaterialApoioDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.vo.online.MaterialApoioVo;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;

public class MaterialApoioCadastroAction extends BaseCadastroAction<MaterialApoioVo, MaterialApoioDao, MaterialApoioBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspCadastro() {
		return "web/pages/online/materialapoio/materialapoiocadastro.jsp";
	}

	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, MaterialApoioVo vo, MaterialApoioBe be, DAOManager manager) {
		super.doBeforeVisualizar(request, response, vo, be, manager);

		getRequest().setAttribute("titulo", "Cadastro de Materiais de Apoio");
		getRequest().setAttribute("subtitulo", "Cadastro de Materiais de Apoio do Site");
		getRequest().setAttribute("submenu", "Online");
		getRequest().setAttribute("menuAtivo", "Vídeos");

		try {
			getRequest().setAttribute("modulos", new ModuloBe(manager).getList(null, null, Dicionario.Modulo.TABELA_MODULO + "." + Dicionario.Modulo.Colunas.NOME));
		} catch (ListException e) {
			e.printStackTrace();
		}
	}
}

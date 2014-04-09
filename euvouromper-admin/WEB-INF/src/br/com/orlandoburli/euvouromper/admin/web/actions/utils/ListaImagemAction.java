package br.com.orlandoburli.euvouromper.admin.web.actions.utils;

import br.com.orlandoburli.euvouromper.admin.utils.FileUtils;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.web.BaseAction;
import br.com.orlandoburli.framework.core.web.filters.IgnoreMethodAuthentication;

public class ListaImagemAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	@IgnoreMethodAuthentication
	public void execute() {

		forward("web/pages/utils/lista_imagens.jsp");
	}

	@IgnoreMethodAuthentication
	public void datatable() {
		DAOManager manager = new DAOManager();

		try {
			FileUtils.listaImagens(manager, getRequest());
		} finally {
			manager.commit();
		}
		
		forward("web/pages/utils/lista_imagens_datatable.jsp");
	}
	
	@IgnoreMethodAuthentication
	public void upload() {
		forward("web/pages/utils/lista_imagens_upload.jsp");
	}

}

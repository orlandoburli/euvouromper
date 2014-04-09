package br.com.orlandoburli.euvouromper.admin.web.actions.home;

import br.com.orlandoburli.euvouromper.admin.utils.Versao;
import br.com.orlandoburli.euvouromper.model.vo.admin.UsuarioVo;
import br.com.orlandoburli.framework.core.web.BaseAction;
import br.com.orlandoburli.framework.core.web.filters.IgnoreMethodAuthentication;

public class HomeAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private UsuarioVo usuario;

	private String term;

	@IgnoreMethodAuthentication
	public void execute() {

		getRequest().setAttribute("versao", Versao.getInstance());
		getRequest().setAttribute("titulo", "Home");
		getRequest().setAttribute("subtitulo", "Painel de Administração");

		forward("web/home.jsp");
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public UsuarioVo getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioVo usuario) {
		this.usuario = usuario;
	}

}
package br.com.orlandoburli.euvouromper.admin.web.actions.online.modulovideo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.online.ModuloVideoBe;
import br.com.orlandoburli.euvouromper.model.dao.online.ModuloVideoDao;
import br.com.orlandoburli.euvouromper.model.vo.online.ModuloVideoVo;
import br.com.orlandoburli.euvouromper.model.vo.online.ModuloVo;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;

public class ModuloVideoCadastroAction extends BaseCadastroAction<ModuloVideoVo, ModuloVideoDao, ModuloVideoBe> {

	private static final long serialVersionUID = 1L;

	private Integer idModulo;

	private ModuloVo moduloSelecionado;

	@Override
	public String getJspCadastro() {
		return "web/pages/online/modulovideo/modulovideocadastro.jsp";
	}

	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, ModuloVideoVo vo, ModuloVideoBe be, DAOManager manager) {
		super.doBeforeVisualizar(request, response, vo, be, manager);

		getRequest().setAttribute("titulo", "Cadastro de Vídeos do Módulo <strong>" + getModuloSelecionado().getNome() + "</strong>");
		getRequest().setAttribute("subtitulo", "Cadastro de Vídeos do Módulo do Site");
		getRequest().setAttribute("submenu", "Online");
		getRequest().setAttribute("menuAtivo", "Vídeos do Módulo");
		
		try {
			getRequest().setAttribute("videos", be.getListNotIn(getModuloSelecionado()));
		} catch (ListException e) {
			e.printStackTrace();
		}
	}

	public Integer getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(Integer idModulo) {
		this.idModulo = idModulo;
	}

	public ModuloVo getModuloSelecionado() {
		return moduloSelecionado;
	}

	public void setModuloSelecionado(ModuloVo moduloSelecionado) {
		this.moduloSelecionado = moduloSelecionado;
	}
}

package br.com.orlandoburli.euvouromper.admin.web.actions.online.pacotemodulo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.online.PacoteModuloBe;
import br.com.orlandoburli.euvouromper.model.dao.online.PacoteModuloDao;
import br.com.orlandoburli.euvouromper.model.vo.online.PacoteModuloVo;
import br.com.orlandoburli.euvouromper.model.vo.online.PacoteVo;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;

public class PacoteModuloCadastroAction extends BaseCadastroAction<PacoteModuloVo, PacoteModuloDao, PacoteModuloBe>{

	private static final long serialVersionUID = 1L;

	private Integer idPacote;
	
	private PacoteVo pacoteSelecionado;
	
	@Override
	public String getJspCadastro() {
		return "web/pages/online/pacotemodulo/pacotemodulocadastro.jsp";
	}
	
	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, PacoteModuloVo vo, PacoteModuloBe be, DAOManager manager) {
		super.doBeforeVisualizar(request, response, vo, be, manager);
		
		getRequest().setAttribute("titulo", "Cadastro de Módulos do Pacote <strong>" + getPacoteSelecionado().getNome() + "</strong>");
		getRequest().setAttribute("subtitulo", "Cadastro de Módulos do Pacote do Site");
		getRequest().setAttribute("submenu", "Online");
		getRequest().setAttribute("menuAtivo", "Módulos do Pacote");
		
		try {
			getRequest().setAttribute("modulos", be.getListNotIn(getPacoteSelecionado()));
		} catch (ListException e) {
			e.printStackTrace();
		}
	}

	public Integer getIdPacote() {
		return idPacote;
	}

	public void setIdPacote(Integer idPacote) {
		this.idPacote = idPacote;
	}

	public PacoteVo getPacoteSelecionado() {
		return pacoteSelecionado;
	}

	public void setPacoteSelecionado(PacoteVo pacoteSelecionado) {
		this.pacoteSelecionado = pacoteSelecionado;
	}

}

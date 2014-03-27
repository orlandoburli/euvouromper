package br.com.orlandoburli.euvouromper.admin.web.actions.online.pacote;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.online.PacoteBe;
import br.com.orlandoburli.euvouromper.model.dao.online.PacoteDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.vo.online.PacoteVo;
import br.com.orlandoburli.framework.core.web.BaseConsultaAction;

public class PacoteConsultaAction extends BaseConsultaAction<PacoteVo, PacoteDao, PacoteBe>{

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspConsulta() {
		return "web/pages/online/pacote/pacoteconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/online/pacote/pacoteconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return Dicionario.Pacote.TABELA_PACOTE + "." + Dicionario.Pacote.Colunas.NOME;
	}
	
	@Override
	public void doBeforeExecute() {
		super.doBeforeExecute();
		
		getRequest().getSession().removeAttribute("pacoteSelecionado");
		
		getRequest().setAttribute("titulo", "Consulta de Pacotes");
		getRequest().setAttribute("subtitulo", "Consulta de Pacotes do Site");
		getRequest().setAttribute("submenu", "Online");
		getRequest().setAttribute("menuAtivo", "Pacotes");
	}

	@Override
	public void doBeforeFilter(PacoteVo filter, PacoteBe be, HttpServletRequest request, HttpServletResponse response) {
		if (getParametroPesquisa() != null) {
			if (getParametroPesquisa().equalsIgnoreCase("Codigo")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdPacote(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("Nome")) {
				filter.setNome("%" + getPesquisarPor() + "%");
			}
		} else {
			filter.setNome("%" + getPesquisarPor() + "%");
		}
	}

}

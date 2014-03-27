package br.com.orlandoburli.euvouromper.admin.web.actions.online.pacotemodulo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.online.PacoteBe;
import br.com.orlandoburli.euvouromper.model.be.online.PacoteModuloBe;
import br.com.orlandoburli.euvouromper.model.dao.online.PacoteModuloDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.vo.online.ModuloVo;
import br.com.orlandoburli.euvouromper.model.vo.online.PacoteModuloVo;
import br.com.orlandoburli.euvouromper.model.vo.online.PacoteVo;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.web.BaseConsultaAction;
import br.com.orlandoburli.framework.core.web.filters.OutjectSession;

public class PacoteModuloConsultaAction extends BaseConsultaAction<PacoteModuloVo, PacoteModuloDao, PacoteModuloBe> {

	private static final long serialVersionUID = 1L;

	private Integer idPacote;

	@OutjectSession("pacoteSelecionado")
	private PacoteVo pacoteSelecionado;

	@Override
	public String getJspConsulta() {
		return "web/pages/online/pacotemodulo/pacotemoduloconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/online/pacotemodulo/pacotemoduloconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return Dicionario.PacoteModulo.TABELA_PACOTE_MODULO + "_" + Dicionario.Modulo.TABELA_MODULO + "." + Dicionario.Modulo.Colunas.NOME;
	}

	@Override
	public void doBeforeExecute() {
		super.doBeforeExecute();

		if (getIdPacote() != null) {
			setPacoteSelecionado(new PacoteVo());
			getPacoteSelecionado().setIdPacote(getIdPacote());

			try {
				setPacoteSelecionado(new PacoteBe(getManager()).get(getPacoteSelecionado()));
			} catch (ListException e) {
				e.printStackTrace();
			}
		}

		if (getPacoteSelecionado() == null) {
			return;
		}

		getRequest().setAttribute("titulo", "Consulta de Módulos do Pacote <strong>" + getPacoteSelecionado().getNome() + "</strong>");
		getRequest().setAttribute("subtitulo", "Consulta de Módulos do Pacote do Site");
		getRequest().setAttribute("submenu", "Online");
		getRequest().setAttribute("menuAtivo", "Módulos do Pacote");
	}
	
	@Override
	public void doBeforeFilter(PacoteModuloVo filter, PacoteModuloBe be, HttpServletRequest request, HttpServletResponse response) {
		filter.setModulo(new ModuloVo());
		filter.getModulo().setNome("%" + getPesquisarPor() + "%");
		filter.setIdPacote(getPacoteSelecionado().getIdPacote());
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

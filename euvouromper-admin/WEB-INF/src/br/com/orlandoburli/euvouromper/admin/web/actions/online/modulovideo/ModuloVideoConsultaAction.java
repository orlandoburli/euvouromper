package br.com.orlandoburli.euvouromper.admin.web.actions.online.modulovideo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.online.ModuloBe;
import br.com.orlandoburli.euvouromper.model.be.online.ModuloVideoBe;
import br.com.orlandoburli.euvouromper.model.dao.online.ModuloVideoDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.vo.online.ModuloVideoVo;
import br.com.orlandoburli.euvouromper.model.vo.online.ModuloVo;
import br.com.orlandoburli.euvouromper.model.vo.online.VideoVo;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.web.BaseConsultaAction;
import br.com.orlandoburli.framework.core.web.filters.OutjectSession;

public class ModuloVideoConsultaAction extends BaseConsultaAction<ModuloVideoVo, ModuloVideoDao, ModuloVideoBe> {

	private static final long serialVersionUID = 1L;

	private Integer idModulo;

	@OutjectSession("moduloSelecionado")
	private ModuloVo moduloSelecionado;

	@Override
	public String getJspConsulta() {
		return "web/pages/online/modulovideo/modulovideoconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/online/modulovideo/modulovideoconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {

		String prefix = Dicionario.ModuloVideo.TABELA_MODULO_VIDEO + "_" + Dicionario.Video.TABELA_VIDEO + ".";

		String orderFields = prefix + Dicionario.Video.Colunas.NOME;
		orderFields += ", " + prefix + Dicionario.Video.Colunas.AULA;
		orderFields += ", " + prefix + Dicionario.Video.Colunas.BLOCO;

		return orderFields;
	}

	@Override
	public void doBeforeExecute() {
		super.doBeforeExecute();

		if (getIdModulo() != null) {
			setModuloSelecionado(new ModuloVo());
			getModuloSelecionado().setIdModulo(idModulo);

			try {
				setModuloSelecionado(new ModuloBe(getManager()).get(getModuloSelecionado()));
			} catch (ListException e) {
				e.printStackTrace();
			}
		}

		if (getModuloSelecionado() == null) {
			return;
		}

		getRequest().setAttribute("titulo", "Consulta de Vídeos do Módulo <strong>" + getModuloSelecionado().getNome() + "</strong>");
		getRequest().setAttribute("subtitulo", "Consulta de Vídeos do Módulo do Site");
		getRequest().setAttribute("submenu", "Online");
		getRequest().setAttribute("menuAtivo", "Vídeos do Módulo");
	}

	@Override
	public void doBeforeFilter(ModuloVideoVo filter, ModuloVideoBe be, HttpServletRequest request, HttpServletResponse response) {
		filter.setVideo(new VideoVo());
		filter.getVideo().setNome("%" + getPesquisarPor() + "%");
		filter.setIdModulo(getModuloSelecionado().getIdModulo());
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

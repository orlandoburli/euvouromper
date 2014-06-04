package br.com.orlandoburli.euvouromper.admin.web.actions.online.materialapoio;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.online.MaterialApoioBe;
import br.com.orlandoburli.euvouromper.model.dao.online.MaterialApoioDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.vo.online.MaterialApoioVo;
import br.com.orlandoburli.euvouromper.model.vo.online.ModuloVo;
import br.com.orlandoburli.framework.core.web.BaseConsultaAction;

public class MaterialApoioConsultaAction extends BaseConsultaAction<MaterialApoioVo, MaterialApoioDao, MaterialApoioBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspConsulta() {
		return "web/pages/online/materialapoio/materialapoioconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/online/materialapoio/materialapoioconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return Dicionario.MaterialApoio.TABELA_MATERIAL_APOIO + "." + Dicionario.MaterialApoio.Colunas.NOME;
	}

	@Override
	public void doBeforeExecute() {
		super.doBeforeExecute();
		getRequest().setAttribute("titulo", "Consulta de Materiais de Apoio");
		getRequest().setAttribute("subtitulo", "Consulta de Materiais de Apoio do Site");
		getRequest().setAttribute("submenu", "Online");
		getRequest().setAttribute("menuAtivo", "Vídeos");
	}

	@Override
	public void doBeforeFilter(MaterialApoioVo filter, MaterialApoioBe be, HttpServletRequest request, HttpServletResponse response) {
		if (getParametroPesquisa() != null) {
			if (getParametroPesquisa().equalsIgnoreCase("Codigo")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdMaterialApoio(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("Nome")) {
				filter.setNome("%" + getPesquisarPor() + "%");
			} else if (getParametroPesquisa().equalsIgnoreCase("Modulo")) {
				filter.setModulo(new ModuloVo());
				filter.getModulo().setNome("%" + getPesquisarPor() + "%");
			}
		} else {
			filter.setNome("%" + getPesquisarPor() + "%");
		}
	}

}

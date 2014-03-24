package br.com.orlandoburli.euvouromper.admin.web.actions.online.modulo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.online.ModuloBe;
import br.com.orlandoburli.euvouromper.model.dao.online.ModuloDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.vo.online.ModuloVo;
import br.com.orlandoburli.framework.core.web.BaseConsultaAction;

public class ModuloConsultaAction extends BaseConsultaAction<ModuloVo, ModuloDao, ModuloBe> {

	private static final long serialVersionUID = 1L;


	@Override
	public String getJspConsulta() {
		return "web/pages/online/modulo/moduloconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/online/modulo/moduloconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return Dicionario.Modulo.TABELA_MODULO + "." + Dicionario.Modulo.Colunas.NOME;
	}
	
	@Override
	public void doBeforeExecute() {
		super.doBeforeExecute();
		getRequest().setAttribute("titulo", "Consulta de Módulos");
		getRequest().setAttribute("subtitulo", "Consulta de Módulos do Site");
		getRequest().setAttribute("submenu", "Online");
		getRequest().setAttribute("menuAtivo", "Módulos");
	}

	@Override
	public void doBeforeFilter(ModuloVo filter, ModuloBe be, HttpServletRequest request, HttpServletResponse response) {
		if (getParametroPesquisa() != null) {
			if (getParametroPesquisa().equalsIgnoreCase("Codigo")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdModulo(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("Nome")) {
				filter.setNome("%" + getPesquisarPor() + "%");
			}
		} else {
			filter.setNome("%" + getPesquisarPor() + "%");
		}
	}

}

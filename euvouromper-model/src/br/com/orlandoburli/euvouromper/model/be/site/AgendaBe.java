package br.com.orlandoburli.euvouromper.model.be.site;

import java.util.List;

import br.com.orlandoburli.euvouromper.model.dao.site.AgendaDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Agenda;
import br.com.orlandoburli.euvouromper.model.vo.site.AgendaVo;
import br.com.orlandoburli.euvouromper.model.vo.site.StatusAgenda;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class AgendaBe extends BaseBe<AgendaVo, AgendaDao> {

	private static final Integer TAMANHO_PAGINA_AGENDA = 6;

	public AgendaBe(DAOManager manager) {
		super(manager);
	}

	@Override
	public void doBeforeSave(AgendaVo vo) throws BeException {
		if (vo.getTitulo() != null && !vo.getTitulo().trim().equals("")) {
			vo.setUrl(vo.getTitulo().toLowerCase());
		}

		super.doBeforeSave(vo);
	}

	public AgendaVo getByUrl(String url) throws ListException {
		AgendaVo filter = new AgendaVo();

		filter.setUrl(url);
		filter.setStatus(StatusAgenda.PUBLICADO);

		List<AgendaVo> list = getList(filter);

		if (list.size() > 0) {
			return list.get(0);
		}

		return null;
	}

	public List<AgendaVo> getListaHome() throws ListException {
		AgendaVo filter = new AgendaVo();
		filter.setStatus(StatusAgenda.PUBLICADO);

		return getList(filter, null, Agenda.TABELA_AGENDA + "." + Agenda.Colunas.DATA + " DESC", 1, 3);
	}

	/**
	 * Retorna a lista de agendas de uma pagina
	 * 
	 * @param pagina
	 *            Numero da pagina
	 * @return Lista com as agendas
	 * @throws ListException
	 */
	public List<AgendaVo> getPaginaAgendas(int pagina) throws ListException {

		AgendaVo filter = new AgendaVo();

		filter.setStatus(StatusAgenda.PUBLICADO);

		return getList(filter, null, Agenda.TABELA_AGENDA + "." + Agenda.Colunas.DATA + " DESC", pagina, TAMANHO_PAGINA_AGENDA);
	}

	/**
	 * Retorna o numero de paginas
	 * 
	 * @return Numero de paginas de agendas
	 * @throws ListException
	 */
	public Integer getQuantidadePaginasAgendas() throws ListException {

		AgendaVo filter = new AgendaVo();

		filter.setStatus(StatusAgenda.PUBLICADO);

		return getPageCount(filter, null, TAMANHO_PAGINA_AGENDA);
	}
}

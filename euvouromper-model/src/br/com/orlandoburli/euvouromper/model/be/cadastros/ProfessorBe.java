package br.com.orlandoburli.euvouromper.model.be.cadastros;

import java.util.List;

import br.com.orlandoburli.euvouromper.model.dao.cadastros.ProfessorDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Professor;
import br.com.orlandoburli.euvouromper.model.vo.cadastros.ProfessorVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class ProfessorBe extends BaseBe<ProfessorVo, ProfessorDao> {

	private static final Integer TAMANHO_PAGINA_PROFESSORES = 6;

	public ProfessorBe(DAOManager manager) {
		super(manager);
	}

	@Override
	public void doBeforeSave(ProfessorVo vo) throws BeException {
		if (vo.getUrl() == null || vo.getUrl().trim().equals("")) {
			vo.setUrl(vo.getNome().toLowerCase());
		}

		super.doBeforeSave(vo);
	}

	public ProfessorVo getByUrl(String url) throws ListException {

		ProfessorVo filter = new ProfessorVo();
		filter.setUrl(url);

		List<ProfessorVo> list = getList(filter);

		if (list.size() > 0) {
			return list.get(0);
		}

		return null;
	}

	public Integer getQuantidadePaginasProfessores() throws ListException {
		ProfessorVo filter = new ProfessorVo();

		return getPageCount(filter, null, TAMANHO_PAGINA_PROFESSORES);
	}

	public List<ProfessorVo> getPaginaProfessores(Integer pagina) throws ListException {
		ProfessorVo filter = new ProfessorVo();

		return getList(filter, null, Professor.TABELA_PROFESSOR + "." + Professor.Colunas.NOME, pagina, TAMANHO_PAGINA_PROFESSORES);
	}
}

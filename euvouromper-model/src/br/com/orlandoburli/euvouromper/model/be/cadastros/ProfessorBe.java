package br.com.orlandoburli.euvouromper.model.be.cadastros;

import br.com.orlandoburli.euvouromper.model.dao.cadastros.ProfessorDao;
import br.com.orlandoburli.euvouromper.model.vo.cadastros.ProfessorVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class ProfessorBe extends BaseBe<ProfessorVo, ProfessorDao> {

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
}

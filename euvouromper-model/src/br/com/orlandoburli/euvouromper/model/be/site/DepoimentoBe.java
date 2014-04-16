package br.com.orlandoburli.euvouromper.model.be.site;

import java.util.List;

import br.com.orlandoburli.euvouromper.model.dao.site.DepoimentoDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Depoimento;
import br.com.orlandoburli.euvouromper.model.vo.site.DepoimentoVo;
import br.com.orlandoburli.euvouromper.model.vo.site.StatusDepoimento;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class DepoimentoBe extends BaseBe<DepoimentoVo, DepoimentoDao> {

	public DepoimentoBe(DAOManager manager) {
		super(manager);
	}

	public DepoimentoVo getDepoimentoHome() throws ListException {

		DepoimentoVo filter = new DepoimentoVo();
		filter.setStatus(StatusDepoimento.PUBLICADO);

		List<DepoimentoVo> list = getList(filter, null, Depoimento.TABELA_DEPOIMENTO + "." + Depoimento.Colunas.ID_DEPOIMENTO + " DESC ", 1, 1);

		if (list.size() > 0) {
			return list.get(0);
		}
		
		return null;
	}

}

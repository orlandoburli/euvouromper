package br.com.orlandoburli.euvouromper.model.be.site;

import java.util.List;

import br.com.orlandoburli.euvouromper.model.dao.site.BannerDao;
import br.com.orlandoburli.euvouromper.model.domains.SimNao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.vo.site.BannerVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class BannerBe extends BaseBe<BannerVo, BannerDao> {

	public BannerBe(DAOManager manager) {
		super(manager);
	}

	public List<BannerVo> getListAtivos() throws ListException {
		BannerVo filter = new BannerVo();

		filter.setAtivo(SimNao.SIM);

		return getList(filter, null, Dicionario.Banner.TABELA_BANNER + "." + Dicionario.Banner.Colunas.ID_BANNER + " DESC");
	}

}

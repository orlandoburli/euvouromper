package br.com.orlandoburli.euvouromper.model.be.online;

import br.com.orlandoburli.euvouromper.model.dao.online.VideoProdutoDao;
import br.com.orlandoburli.euvouromper.model.vo.online.VideoProdutoVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class VideoProdutoBe extends BaseBe<VideoProdutoVo, VideoProdutoDao>{

	public VideoProdutoBe(DAOManager manager) {
		super(manager);
	}

}

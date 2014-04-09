package br.com.orlandoburli.euvouromper.model.dao.ecommerce;

import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ProdutoVo;
import br.com.orlandoburli.framework.core.dao.BaseCadastroDao;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class ProdutoDao extends BaseCadastroDao<ProdutoVo>{

	public ProdutoDao(DAOManager manager) {
		super(manager);
	}

}

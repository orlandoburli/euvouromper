package br.com.orlandoburli.euvouromper.model.dao.ecommerce;

import br.com.orlandoburli.euvouromper.model.vo.ecommerce.PedidoVo;
import br.com.orlandoburli.framework.core.dao.BaseCadastroDao;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class PedidoDao extends BaseCadastroDao<PedidoVo>{

	public PedidoDao(DAOManager manager) {
		super(manager);
	}

}

package br.com.orlandoburli.euvouromper.model.dao.ecommerce.cliente;

import br.com.orlandoburli.euvouromper.model.vo.ecommerce.cliente.ClienteVo;
import br.com.orlandoburli.framework.core.dao.BaseCadastroDao;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class ClienteDao extends BaseCadastroDao<ClienteVo>{

	public ClienteDao(DAOManager manager) {
		super(manager);
	}

}

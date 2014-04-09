package br.com.orlandoburli.euvouromper.model.be.ecommerce;

import br.com.orlandoburli.euvouromper.model.dao.ecommerce.ClienteDao;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ClienteVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class ClienteBe extends BaseBe<ClienteVo, ClienteDao>{

	public ClienteBe(DAOManager manager) {
		super(manager);
	}

}

package br.com.orlandoburli.euvouromper.model.dao.ecommerce;

import br.com.orlandoburli.euvouromper.model.vo.ecommerce.EmailVo;
import br.com.orlandoburli.framework.core.dao.BaseCadastroDao;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class EmailDao extends BaseCadastroDao<EmailVo>{

	public EmailDao(DAOManager manager) {
		super(manager);
	}

}

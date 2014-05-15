package br.com.orlandoburli.euvouromper.model.be.ecommerce.cliente;

import br.com.orlandoburli.euvouromper.model.dao.ecommerce.cliente.ClienteMovimentacaoDao;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.cliente.ClienteMovimentacaoVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class ClienteMovimentacaoBe extends BaseBe<ClienteMovimentacaoVo, ClienteMovimentacaoDao> {

	public ClienteMovimentacaoBe(DAOManager manager) {
		super(manager);
	}

}
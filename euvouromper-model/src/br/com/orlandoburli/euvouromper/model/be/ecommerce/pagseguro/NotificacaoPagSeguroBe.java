package br.com.orlandoburli.euvouromper.model.be.ecommerce.pagseguro;

import java.util.Calendar;

import br.com.orlandoburli.euvouromper.model.dao.ecommerce.pagseguro.NotificacaoPagSeguroDao;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.pagseguro.NotificacaoPagSeguroVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class NotificacaoPagSeguroBe extends BaseBe<NotificacaoPagSeguroVo, NotificacaoPagSeguroDao> {

	public NotificacaoPagSeguroBe(DAOManager manager) {
		super(manager);
	}

	public void registrar(String codigoNotificacao, Integer status) throws BeException {
		NotificacaoPagSeguroVo vo = new NotificacaoPagSeguroVo();

		vo.setCodigoNotificacao(codigoNotificacao);
		vo.setStatus(status);
		vo.setDataHora(Calendar.getInstance());
		
		save(vo);
	}

}

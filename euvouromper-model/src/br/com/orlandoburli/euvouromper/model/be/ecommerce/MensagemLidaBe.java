package br.com.orlandoburli.euvouromper.model.be.ecommerce;

import java.util.Calendar;
import java.util.List;

import br.com.orlandoburli.euvouromper.model.dao.ecommerce.MensagemLidaDao;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.MensagemLidaVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.MensagemVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.cliente.ClienteVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.dao.exceptions.DAOException;

public class MensagemLidaBe extends BaseBe<MensagemLidaVo, MensagemLidaDao> {

	public MensagemLidaBe(DAOManager manager) {
		super(manager);
	}

	/**
	 * Marca a mensagem como lida
	 * 
	 * @param mensagem
	 *            Mensagem lida
	 * @param cliente
	 *            Cliente que leu a mensagem
	 * @throws BeException
	 */
	public void lida(MensagemVo mensagem, ClienteVo cliente) throws BeException {

		if (getLida(mensagem, cliente) != null) {
			return;
		}

		MensagemLidaVo ml = new MensagemLidaVo();

		ml.setIdMensagem(mensagem.getIdMensagem());
		ml.setIdCliente(cliente.getIdCliente());

		ml.setDataHora(Calendar.getInstance());

		save(ml);
	}

	/**
	 * Identifica se a mensagem ja foi lida.
	 * 
	 * @param mensagem
	 *            Mensagem a ser verificada
	 * @param cliente
	 *            Cliente a verificar
	 * @return Objeto com os dados da leitura
	 * @throws ListException
	 */
	public MensagemLidaVo getLida(MensagemVo mensagem, ClienteVo cliente) throws ListException {
		MensagemLidaVo filter = new MensagemLidaVo();

		filter.setIdMensagem(mensagem.getIdMensagem());
		filter.setIdCliente(cliente.getIdCliente());

		List<MensagemLidaVo> list = getList(filter);

		if (list.size() > 0) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Seta a lista de mensagens como lida ou não lida, busca no banco de dados.
	 * 
	 * @param mensagens
	 * @param cliente
	 * @throws ListException
	 */
	public void listLida(List<MensagemVo> mensagens, ClienteVo cliente) throws ListException {
		MensagemLidaDao dao = new MensagemLidaDao(getManager());

		try {
			List<MensagemLidaVo> list = dao.getList(mensagens);

			if (list != null && list.size() > 0) {
				
				// Percorre a lista de mensagens lidas e marca um flag de lida.
				for (MensagemLidaVo ml : list) {
					for (MensagemVo m : mensagens) {
						if (ml.getIdMensagem().equals(m.getIdMensagem())) {
							m.setLida(true);
						}
					}
				}
			}

		} catch (DAOException e) {
			throw new ListException();
		}
	}
	
	public int getNovasMensagensCount(ClienteVo cliente) throws ListException {
		List<MensagemVo> mensagens = new MensagemBe(getManager()).getList(cliente, 10);

		int novasMensagens = 0;
		for (MensagemVo mensagem : mensagens) {
			if (!mensagem.isLida()) {
				novasMensagens++;
			}
		}
		return novasMensagens;
	}

}

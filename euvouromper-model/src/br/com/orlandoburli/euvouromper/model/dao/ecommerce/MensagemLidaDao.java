package br.com.orlandoburli.euvouromper.model.dao.ecommerce;

import java.util.List;

import br.com.orlandoburli.euvouromper.model.utils.Dicionario.MensagemLida;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.MensagemLidaVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.MensagemVo;
import br.com.orlandoburli.framework.core.dao.BaseCadastroDao;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.dao.exceptions.DAOException;

public class MensagemLidaDao extends BaseCadastroDao<MensagemLidaVo> {

	public MensagemLidaDao(DAOManager manager) {
		super(manager);
	}

	public List<MensagemLidaVo> getList(List<MensagemVo> mensagens) throws DAOException {

		if (mensagens.size() <= 0) {
			return null;
		}

		StringBuilder sb = new StringBuilder();

		sb.append(MensagemLida.TABELA_MENSAGEM_LIDA + "." + MensagemLida.Colunas.ID_MENSAGEM + " IN (");

		for (MensagemVo mensagem : mensagens) {
			sb.append(mensagem.getIdMensagem() + ", ");
		}

		// Remove a ultima virgula e espaco
		sb.delete(sb.length() - 2, sb.length());

		sb.append(")");

		return getList(null, sb.toString(), null, null, null);
	}

}

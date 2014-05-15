package br.com.orlandoburli.euvouromper.model.dao.ecommerce;

import java.util.List;

import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Mensagem;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.MensagemVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ProdutoVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.StatusMensagem;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.TipoDestinoMensagens;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.cliente.ClienteVo;
import br.com.orlandoburli.framework.core.dao.BaseCadastroDao;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.dao.exceptions.DAOException;

public class MensagemDao extends BaseCadastroDao<MensagemVo> {

	public MensagemDao(DAOManager manager) {
		super(manager);
	}

	public List<MensagemVo> getList(ClienteVo cliente, List<ProdutoVo> produtos, int max) throws DAOException {
		return getList(cliente, produtos, max, null);
	}

	public List<MensagemVo> getList(ClienteVo cliente, List<ProdutoVo> produtos, int max, Integer idMensagem) throws DAOException {

		StringBuilder sb = new StringBuilder();

		String produtosIn = "";
		for (ProdutoVo produto : produtos) {
			produtosIn += produto.getIdProduto() + ", ";
		}

		if (produtosIn.length() > 2) {
			produtosIn = produtosIn.substring(0, produtosIn.length() - 2);
		}

		sb.append("(\n");

		sb.append("(" + Mensagem.TABELA_MENSAGEM + "." + Mensagem.Colunas.DESTINO + " = '" + TipoDestinoMensagens.TODOS + "' ) \n");

		sb.append(" OR \n");

		sb.append("(" + Mensagem.TABELA_MENSAGEM + "." + Mensagem.Colunas.DESTINO + " = '" + TipoDestinoMensagens.CLIENTE + "' AND " + Mensagem.TABELA_MENSAGEM + "." + Mensagem.Colunas.ID_CLIENTE + " = " + cliente.getIdCliente() + ") \n");

		if (produtosIn != null && produtosIn.length() > 0) {
			sb.append(" OR \n");
			sb.append("(" + Mensagem.TABELA_MENSAGEM + "." + Mensagem.Colunas.DESTINO + " = '" + TipoDestinoMensagens.PRODUTO + "' AND " + Mensagem.TABELA_MENSAGEM + "." + Mensagem.Colunas.ID_PRODUTO + " IN (" + produtosIn + ")) \n");
		}
		sb.append(")\n");

		MensagemVo filter = new MensagemVo();
		
		filter.setIdMensagem(idMensagem);

		filter.setStatus(StatusMensagem.PUBLICADO);

		return getList(filter, sb.toString(), Mensagem.TABELA_MENSAGEM + "." + Mensagem.Colunas.ID_MENSAGEM + " DESC", 1, max);

	}

}

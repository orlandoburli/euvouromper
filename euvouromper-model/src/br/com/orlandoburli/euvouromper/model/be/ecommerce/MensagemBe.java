package br.com.orlandoburli.euvouromper.model.be.ecommerce;

import java.util.ArrayList;
import java.util.List;

import br.com.orlandoburli.euvouromper.model.dao.ecommerce.MensagemDao;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ItemPedidoVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.MensagemVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ProdutoVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.TipoDestinoMensagens;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.cliente.ClienteVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.SaveBeException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.dao.exceptions.DAOException;
import br.com.orlandoburli.framework.core.log.Log;

public class MensagemBe extends BaseBe<MensagemVo, MensagemDao> {

	public MensagemBe(DAOManager manager) {
		super(manager);
	}

	@Override
	public void doBeforeSave(MensagemVo vo) throws BeException {
		if (vo.getDestino() != null) {
			if (vo.getDestino().equals(TipoDestinoMensagens.CLIENTE)) {
				if (vo.getIdCliente() == null) {
					throw new SaveBeException("Informe o cliente!");
				}
				vo.setIdProduto(null);
			} else if (vo.getDestino().equals(TipoDestinoMensagens.PRODUTO)) {
				if (vo.getIdProduto() == null) {
					throw new SaveBeException("Informe o produto!");
				}
				vo.setIdCliente(null);
			} else if (vo.getDestino().equals(TipoDestinoMensagens.TODOS)) {
				vo.setIdProduto(null);
				vo.setIdCliente(null);
			}
		}

		super.doBeforeSave(vo);

	}

	public List<MensagemVo> getList(ClienteVo cliente, int max) throws ListException {
		return getList(cliente, max, null);
	}

	public List<MensagemVo> getList(ClienteVo cliente, int max, Integer idMensagem) throws ListException {

		MensagemDao dao = new MensagemDao(getManager());

		List<ProdutoVo> produtos = new ArrayList<ProdutoVo>();

		try {
			// Itens comprados
			List<ItemPedidoVo> itens = new ItemPedidoBe(getManager()).getList(cliente);

			for (ItemPedidoVo item : itens) {
				ProdutoVo p = new ProdutoVo();
				p.setIdProduto(item.getIdProduto());
				produtos.add(p);
			}

			List<MensagemVo> list = dao.getList(cliente, produtos, max, idMensagem);

			// Flag de mensagem lida
			new MensagemLidaBe(getManager()).listLida(list, cliente);

			return list;

		} catch (DAOException e) {
			Log.critical(e);
			throw new ListException("Erro ao retornar dados. Consulte o administrador do sistema");
		}
	}

	public MensagemVo get(ClienteVo cliente, Integer idMensagem) throws ListException {
		List<MensagemVo> list = getList(cliente, 1, idMensagem);

		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}

package br.com.orlandoburli.euvouromper.model.be.ecommerce;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.orlandoburli.euvouromper.model.be.admin.ParametroBe;
import br.com.orlandoburli.euvouromper.model.be.ecommerce.exceptions.CheckPedidoException;
import br.com.orlandoburli.euvouromper.model.be.ecommerce.exceptions.CupomBeException;
import br.com.orlandoburli.euvouromper.model.be.ecommerce.exceptions.EmailException;
import br.com.orlandoburli.euvouromper.model.be.ecommerce.exceptions.FinalizarPedidoException;
import br.com.orlandoburli.euvouromper.model.be.ecommerce.pagseguro.NotificacaoPagSeguroBe;
import br.com.orlandoburli.euvouromper.model.dao.ecommerce.PedidoDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Pedido;
import br.com.orlandoburli.euvouromper.model.vo.admin.ParametroVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ClienteVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.CupomDescontoVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ItemPedidoVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.PedidoVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ProdutoVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.StatusPedido;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.TipoDesconto;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.utils.Constants;
import br.com.uol.pagseguro.domain.AccountCredentials;
import br.com.uol.pagseguro.domain.Credentials;
import br.com.uol.pagseguro.domain.PaymentRequest;
import br.com.uol.pagseguro.domain.Transaction;
import br.com.uol.pagseguro.enums.Currency;
import br.com.uol.pagseguro.enums.DocumentType;
import br.com.uol.pagseguro.enums.ShippingType;
import br.com.uol.pagseguro.enums.TransactionStatus;
import br.com.uol.pagseguro.exception.PagSeguroServiceException;
import br.com.uol.pagseguro.properties.PagSeguroConfig;
import br.com.uol.pagseguro.service.NotificationService;

public class PedidoBe extends BaseBe<PedidoVo, PedidoDao> {

	static {
		PagSeguroConfig.setProductionEnvironment();
	}

	public PedidoBe(DAOManager manager) {
		super(manager);
	}

	public void adicionarItem(PedidoVo pedido, Integer idProduto) throws ListException {
		ProdutoVo produto = new ProdutoVo();
		produto.setIdProduto(idProduto);
		produto = new ProdutoBe(getManager()).get(produto);

		if (produto == null) {
			return;
		}

		// Verifica se o produto ja nao esta na lista
		for (ItemPedidoVo item : pedido.getItens()) {
			if (item.getProduto().getIdProduto().equals(produto.getIdProduto())) {
				// Se ja encontrou o item, nao faz nada.
				return;
			}
		}

		ItemPedidoVo item = new ItemPedidoVo();

		item.setIdProduto(produto.getIdProduto());
		item.setProduto(produto);

		item.setNome(produto.getNome());
		item.setValor(produto.getValor());
		item.setTipoProduto(produto.getTipoProduto());
		item.setIdPacote(produto.getIdPacote());
		item.setIdModulo(produto.getIdModulo());
		item.setPacote(produto.getPacote());
		item.setModulo(item.getModulo());
		item.setTipoValidade(produto.getTipoValidade());
		item.setDiasValidade(produto.getDiasValidade());
		item.setDataValidade(produto.getDataValidade());
		item.setRecorrente(produto.getRecorrente());
		item.setDiasRecorrencia(produto.getDiasRecorrencia());
		item.setPedido(pedido);

		pedido.getItens().add(item);

		calculaTotal(pedido);
	}

	public void removerItem(PedidoVo pedido, Integer idProduto) {

		ItemPedidoVo[] itens = pedido.getItens().toArray(new ItemPedidoVo[0]);

		for (ItemPedidoVo item : itens) {
			if (item.getIdProduto().equals(idProduto)) {
				pedido.getItens().remove(item);
				break;
			}
		}

		calculaTotal(pedido);
	}

	public void adicionarCupom(PedidoVo pedido, String chaveCupom) throws ListException, CupomBeException {
		CupomDescontoVo cupom = new CupomDescontoBe(getManager()).getByChave(chaveCupom);

		if (cupom != null) {

			// Valida se o cupom pode ser aplicado

			// Checa a validade

			if (cupom.getDataValidade() != null && cupom.getDataValidade().compareTo(Calendar.getInstance()) < 0) {
				throw new CupomBeException("Este cupom já está vencido!");
			}

			// Checa o cliente
			if (cupom.getIdCliente() != null) {
				if (!cupom.getIdCliente().equals(pedido.getCliente().getIdCliente())) {
					throw new CupomBeException("Este cupom não é para este cliente!");
				}
			}

			pedido.setCupom(cupom);
			pedido.setIdCupom(cupom.getIdCupom());
		} else {
			throw new CupomBeException("Cupom inválido!");
		}

		calculaTotal(pedido);
	}

	public void removerCupom(PedidoVo pedido) {
		pedido.setCupom(null);
		pedido.setIdCupom(null);

		calculaTotal(pedido);
	}

	public void calculaTotal(PedidoVo pedido) {
		BigDecimal total = BigDecimal.ZERO;

		// Soma dos itens
		for (ItemPedidoVo item : pedido.getItens()) {
			total = total.add(item.getValor());
		}

		pedido.setValorBruto(total);
		pedido.setValorDesconto(BigDecimal.ZERO);
		pedido.setValorLiquido(total);

		// Cupom de desconto

		if (pedido.getCupom() != null) {
			BigDecimal desconto = BigDecimal.ZERO;

			if (pedido.getCupom().getTipoDesconto().equals(TipoDesconto.PERCENTUAL)) {
				// Desconto em percentual
				BigDecimal cem = new BigDecimal(100);

				desconto = total.multiply(pedido.getCupom().getValor()).divide(cem).setScale(2, BigDecimal.ROUND_CEILING);

			} else if (pedido.getCupom().getTipoDesconto().equals(TipoDesconto.VALOR)) {

				// Desconto em valor

				desconto = pedido.getCupom().getValor();

			}

			total = total.subtract(desconto);

			if (total.compareTo(BigDecimal.ZERO) <= 0) {
				total = BigDecimal.ZERO;
			}

			pedido.setValorDesconto(desconto);
			pedido.setValorLiquido(total);
		}

	}

	public void finalizar(PedidoVo pedido) throws BeException {
		// Calcula o pedido
		calculaTotal(pedido);

		if (pedido.getItens().size() <= 0) {
			throw new FinalizarPedidoException("Nenhum item no carrinho!");
		}

		// Seta status do pedido como aberto
		pedido.setStatusPedido(StatusPedido.ABERTO);

		// Data / hora do pedido corrente
		Calendar c = new GregorianCalendar();
		pedido.setDataHoraPedido(c);

		// Salva o pedido
		save(pedido);

		// Salva os itens de pedido
		ItemPedidoBe itemBe = new ItemPedidoBe(getManager());

		for (ItemPedidoVo item : pedido.getItens()) {
			item.setIdPedido(pedido.getIdPedido());
			item.setPedido(pedido);

			itemBe.save(item);
		}

		// Salva o pedido
		getManager().commit();

		// Gera compra do pagseguro
		geraPagSeguro(pedido);

		// Atualiza os dados do cliente com os dados do pedido
		ClienteVo cliente = pedido.getCliente();

		cliente.setNome(pedido.getNome());
		cliente.setEmail(pedido.getEmail());
		cliente.setCpf(pedido.getCpf());
		cliente.setCep(pedido.getCep());
		cliente.setEndereco(pedido.getEndereco());
		cliente.setNumero(pedido.getNumero());
		cliente.setBairro(pedido.getBairro());
		cliente.setComplemento(pedido.getComplemento());
		cliente.setUf(pedido.getUf());
		cliente.setCidade(pedido.getCidade());
		cliente.setFone1(pedido.getFone1());
		cliente.setFone2(pedido.getFone2());

		new ClienteBe(getManager()).save(cliente);
	}

	public void geraPagSeguro(PedidoVo pedido) throws BeException {
		// Busca credenciais nos parametros
		ParametroVo emailPagSeguro = new ParametroBe(getManager()).get(Constants.Parameters.EMAIL_PAGSEGURO);

		if (emailPagSeguro == null) {
			throw new FinalizarPedidoException("Parametro " + Constants.Parameters.EMAIL_PAGSEGURO + " não definido!");
		}

		ParametroVo chavePagSeguro = new ParametroBe(getManager()).get(Constants.Parameters.CHAVE_PAGSEGURO);

		if (chavePagSeguro == null) {
			throw new FinalizarPedidoException("Parametro " + Constants.Parameters.CHAVE_PAGSEGURO + " não definido!");
		}

		// Gera pedido do pagseguro
		PaymentRequest paymentRequest = new PaymentRequest();

		// Seta o ID do pedido como referencia
		paymentRequest.setReference(pedido.getIdPedido().toString());

		// Endereço de entrega / endereço do cliente
		paymentRequest.setShippingAddress("BRA", pedido.getUf(), pedido.getCidade(), pedido.getBairro(), pedido.getCep(), pedido.getEndereco(), pedido.getNumero().toString(), pedido.getComplemento());

		// Sem tipo de entrega
		paymentRequest.setShippingType(ShippingType.NOT_SPECIFIED);

		// Adiciona os itens
		for (ItemPedidoVo item : pedido.getItens()) {
			paymentRequest.addItem(item.getIdItemPedido().toString(), item.getNome(), Integer.valueOf(1), item.getValor(), new Long(0), BigDecimal.ZERO.setScale(2));
		}

		// Desconto
		paymentRequest.setExtraAmount(pedido.getValorDesconto().multiply(new BigDecimal(-1)));

		// Dados do comprador
		paymentRequest.setSender(pedido.getNome(), pedido.getEmail(), null, null, DocumentType.CPF, pedido.getCpf());

		// Seta moeda (Real - pra que se só tem essa merda?)
		paymentRequest.setCurrency(Currency.BRL);

		// URL para onde o comprador será redirecionado (GET) após o fluxo de
		// pagamento
		paymentRequest.setRedirectURL("http://www.euvouromper.com.br/aluno/pedidos");

		// URL para onde serão enviadas notificações (POST) indicando alterações
		// no status da transação
		paymentRequest.setNotificationURL("http://www.euvouromper.com.br/retornopagseguro");

		try {

			String response = paymentRequest.register(new AccountCredentials(emailPagSeguro.getValor(), chavePagSeguro.getValor()));

			pedido.setUrlPagSeguro(response);

			// Salva novamente o pedido, com dados do pagseguro
			save(pedido);

			// Commita os dados ate aqui, depois disso e so o email.
			getManager().commit();

		} catch (PagSeguroServiceException e) {
			throw new FinalizarPedidoException("Erro ao gerar pagamento no pagseguro - " + e.getMessage());
		}

		// Dispara o email
		try {
			new EmailBe(getManager()).sendEmailPedidoRecebido(pedido);
		} catch (ListException | EmailException e) {
			Log.critical(e);
		}
	}

	public Integer getPedidosAbertos(ClienteVo cliente) throws ListException {
		PedidoVo filter = new PedidoVo();

		filter.setIdCliente(cliente.getIdCliente());
		filter.setStatusPedido(StatusPedido.ABERTO);

		return getListCount(filter, null);
	}

	public List<PedidoVo> getList(ClienteVo cliente) throws ListException {
		PedidoVo filter = new PedidoVo();
		filter.setIdCliente(cliente.getIdCliente());

		return getList(filter, null, Pedido.TABELA_PEDIDO + "." + Pedido.Colunas.ID_PEDIDO + " DESC");
	}

	public PedidoVo getPedido(ClienteVo cliente, Integer idPedido) throws ListException {

		PedidoVo filter = new PedidoVo();
		filter.setIdCliente(cliente.getIdCliente());
		filter.setIdPedido(idPedido);

		List<PedidoVo> list = getList(filter);

		if (list.size() > 0) {
			PedidoVo pedido = list.get(0);

			// Busca os itens
			pedido.setItens(new ItemPedidoBe(getManager()).getList(pedido));

			return pedido;
		}

		return null;
	}

	public void checkByNotificationCode(String notificationCode) throws BeException {

		try {
			Log.debug("Checando codigo de notificacao pagseguro " + notificationCode);

			// Busca credenciais nos parametros
			ParametroVo emailPagSeguro = new ParametroBe(getManager()).get(Constants.Parameters.EMAIL_PAGSEGURO);

			if (emailPagSeguro == null) {
				throw new CheckPedidoException("Parametro " + Constants.Parameters.EMAIL_PAGSEGURO + " não definido!");
			}

			ParametroVo chavePagSeguro = new ParametroBe(getManager()).get(Constants.Parameters.CHAVE_PAGSEGURO);

			if (chavePagSeguro == null) {
				throw new CheckPedidoException("Parametro " + Constants.Parameters.CHAVE_PAGSEGURO + " não definido!");
			}

			Credentials credentials = new AccountCredentials(emailPagSeguro.getValor(), chavePagSeguro.getValor());

			Transaction transaction = NotificationService.checkTransaction(credentials, notificationCode);

			// Registra o retorno
			new NotificacaoPagSeguroBe(getManager()).registrar(notificationCode, transaction.getStatus().getValue());

			PedidoVo pedido = get(Integer.parseInt(transaction.getReference()));

			if (pedido != null) {
				if (transaction.getStatus().equals(TransactionStatus.PAID)) {
					pagar(pedido);
				} else if (transaction.getStatus().equals(TransactionStatus.CANCELLED)) {
					cancelar(pedido);
				} else if (transaction.getStatus().equals(TransactionStatus.REFUNDED)) {
					cancelar(pedido);
				}
			}

		} catch (PagSeguroServiceException e) {
			throw new CheckPedidoException("Erro ao buscar transação do pagseguro - " + e.getMessage());
		}
	}

	public void cancelar(PedidoVo pedido) throws BeException {
		pedido.setStatusPedido(StatusPedido.CANCELADO);
		save(pedido);

		try {
			new EmailBe(getManager()).sendEmailPedidoCancelado(pedido);
		} catch (ListException | EmailException e) {
			Log.critical(e);
		}
	}

	public void pagar(PedidoVo pedido) throws BeException {
		pedido.setStatusPedido(StatusPedido.PAGO);
		pedido.setDataHoraLiberacao(Calendar.getInstance());
		save(pedido);

		try {
			new EmailBe(getManager()).sendEmailPedidoPago(pedido);
		} catch (ListException | EmailException e) {
			Log.critical(e);
		}
	}

}

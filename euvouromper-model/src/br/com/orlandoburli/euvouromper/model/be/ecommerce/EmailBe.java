package br.com.orlandoburli.euvouromper.model.be.ecommerce;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.commons.mail.HtmlEmail;

import br.com.orlandoburli.euvouromper.model.be.admin.ParametroBe;
import br.com.orlandoburli.euvouromper.model.be.ecommerce.exceptions.EmailException;
import br.com.orlandoburli.euvouromper.model.dao.ecommerce.EmailDao;
import br.com.orlandoburli.euvouromper.model.vo.admin.ParametroVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ClienteVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.EmailVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.PedidoVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.TipoEmail;
import br.com.orlandoburli.euvouromper.model.vo.site.ContatoVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.dao.DaoUtils;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.utils.Constants;
import br.com.orlandoburli.framework.core.vo.BaseVo;

public class EmailBe extends BaseBe<EmailVo, EmailDao> {

	private EmailVo email;

	private ParametroVo smtpHost;
	private ParametroVo smtpPort;
	private ParametroVo smtpUser;
	private ParametroVo smtpPassword;
	private ParametroVo smtpSsl;

	public EmailBe(DAOManager manager) {
		super(manager);
	}

	public void sendEmailConfirmacaoCadastro(ClienteVo cliente) throws ListException, EmailException {
		// Email de confirmação de cadastro
		readParameters(TipoEmail.CONFIRMACAO_CADASTRO);

		String mensagem = email.getCorpo();

		// Replace dos atributos
		mensagem = replaceTags2(mensagem, cliente);

		buildMail(cliente.getNome(), cliente.getEmail(), mensagem);
	}

	public void sendEmailNovaSenha(ClienteVo cliente) throws ListException, EmailException {
		// Email de nova senha
		readParameters(TipoEmail.NOVA_SENHA);

		String mensagem = email.getCorpo();

		// Replace dos atributos
		mensagem = replaceTags2(mensagem, cliente);

		buildMail(cliente.getNome(), cliente.getEmail(), mensagem);
	}

	public void sendEmailPedidoRecebido(PedidoVo pedido) throws ListException, EmailException {
		// Email de pedido
		readParameters(TipoEmail.PEDIDO_RECEBIDO);

		String mensagem = email.getCorpo();

		// Replace dos atributos
		mensagem = replaceTags2(mensagem, pedido);

		buildMail(pedido.getCliente().getNome(), pedido.getCliente().getEmail(), mensagem);
	}

	public void sendEmailPedidoPago(PedidoVo pedido) throws ListException, EmailException {
		// Email de pedido pago
		readParameters(TipoEmail.PEDIDO_LIBERADO);

		String mensagem = email.getCorpo();

		// Replace dos atributos
		mensagem = replaceTags2(mensagem, pedido);

		buildMail(pedido.getCliente().getNome(), pedido.getCliente().getEmail(), mensagem);
	}

	public void sendEmailPedidoCancelado(PedidoVo pedido) throws ListException, EmailException {
		// Email de pedido cancelado
		readParameters(TipoEmail.PEDIDO_CANCELADO);

		String mensagem = email.getCorpo();

		// Replace dos atributos
		mensagem = replaceTags2(mensagem, pedido);

		buildMail(pedido.getCliente().getNome(), pedido.getCliente().getEmail(), mensagem);
	}

	public void sendEmailContato(ContatoVo contato) throws ListException, EmailException {
		// Email de Contato
		readParameters(TipoEmail.CONTATO);

		String mensagem = email.getCorpo();

		// Replace dos atributos
		mensagem = replaceTags2(mensagem, contato);

		buildMail(contato.getDepartamento().getNome(), contato.getDepartamento().getEmail(), mensagem);
	}

//	@Deprecated
//	private String replaceTagsx(String mensagem, BaseVo objeto) {
//		String retorno = mensagem;
//
//		// Cria o mapa com todos os valores
//		HashMap<String, Field> map = new LinkedHashMap<>();
//		Field[] fields = objeto.getClass().getDeclaredFields();
//
//		for (Field f : fields) {
//			map.put(f.getName(), f);
//		}
//
//		// Substitui as tags na mensagem
//		for (String chave : map.keySet()) {
//			Field f = map.get(chave);
//			Column c = f.getAnnotation(Column.class);
//
//			Object valor = DaoUtils.getValue(DaoUtils.getGetterMethod(objeto.getClass(), f), objeto);
//
//			if (valor != null) {
//				String valorStr = "";
//
//				if (valor instanceof BaseVo) {
//					// recursividade? Nao agora...
//				} else if (valor instanceof Calendar) {
//					Calendar cal = (Calendar) valor;
//
//					String format = "";
//
//					if (c.dataType() == DataType.DATE) {
//						format = "dd/MM/yyyy";
//					} else if (c.dataType() == DataType.DATETIME) {
//						format = "dd/MM/yyyy hh24:mm:ss";
//					}
//
//					SimpleDateFormat sdf = new SimpleDateFormat(format);
//
//					valorStr = sdf.format(cal.getTime());
//				} else if (valor instanceof BigDecimal) {
//
//					NumberFormat nf = NumberFormat.getNumberInstance();
//					nf.setMaximumFractionDigits(c.precision());
//					nf.setMinimumFractionDigits(c.precision());
//
//					valorStr = nf.format(valor);
//
//				} else {
//					valorStr = valor.toString();
//				}
//
//				retorno = retorno.replace("@" + chave, valorStr);
//				Log.info("Chave: @" + chave + ", valor: " + valorStr);
//			} else {
//				retorno = retorno.replace("@" + chave, "");
//			}
//		}
//
//		return retorno;
//	}

	private String replaceTags2(String mensagem, BaseVo objeto) {
		String retorno = mensagem;

		// Cria o mapa com todos os valores
		HashMap<String, Method> map = new LinkedHashMap<>();
		Method[] methods = objeto.getClass().getMethods();

		for (Method m : methods) {
			if (m.getName().startsWith("get")) {
				String fieldName = m.getName().substring(3, 4).toLowerCase() + m.getName().substring(4);
				map.put(fieldName, m);
			}
		}

		// Substitui as tags na mensagem
		for (String chave : map.keySet()) {
			// Field f = map.get(chave);
			Method m = map.get(chave);
			String fieldName = m.getName().substring(3, 4).toLowerCase() + m.getName().substring(4);
			Field f = null;

			try {
				f = objeto.getClass().getField(fieldName);
			} catch (NoSuchFieldException | SecurityException e) {
				// Faz nada...
			}

			Column c = null;
			if (f != null) {
				c = f.getAnnotation(Column.class);
			}

			Object valor = DaoUtils.getValue(m, objeto);

			if (valor != null) {
				String valorStr = "";

				if (valor instanceof BaseVo) {
					// recursividade? Nao agora...
				} else if (valor instanceof Calendar) {
					Calendar cal = (Calendar) valor;

					String format = "";

					if (c != null) {
						if (c.dataType() == DataType.DATE) {
							format = "dd/MM/yyyy";
						} else if (c.dataType() == DataType.DATETIME) {
							format = "dd/MM/yyyy hh24:mm:ss";
						}
					}

					SimpleDateFormat sdf = new SimpleDateFormat(format);

					valorStr = sdf.format(cal.getTime());
				} else if (valor instanceof BigDecimal) {

					NumberFormat nf = NumberFormat.getNumberInstance();
					if (c != null) {
						nf.setMaximumFractionDigits(c.precision());
						nf.setMinimumFractionDigits(c.precision());
					}

					valorStr = nf.format(valor);

				} else {
					valorStr = valor.toString();
				}

				retorno = retorno.replace("@" + chave, valorStr);
				Log.info("Chave: @" + chave + ", valor: " + valorStr);
			} else {
				retorno = retorno.replace("@" + chave, "");
			}
		}

		return retorno;
	}

	private void buildMail(String pNome, String pEmail, String mensagem) throws EmailException {
		HtmlEmail htmlEmail = new HtmlEmail();

		try {

			// destinatário
			htmlEmail.addTo(pEmail, pNome);

			// remetente
			htmlEmail.setFrom(email.getRemetenteEmail(), email.getRemetenteNome());

			// assunto do e-mail
			htmlEmail.setSubject(email.getAssunto());

			// Corpo do email
			htmlEmail.setHtmlMsg(mensagem);

			htmlEmail.setDebug(true);
			htmlEmail.setSocketConnectionTimeout(600000000);

			// Propriedades do servidor
			htmlEmail.setHostName(smtpHost.getValor());
			htmlEmail.setAuthentication(smtpUser.getValor(), smtpPassword.getValor());
			htmlEmail.setSmtpPort(Integer.parseInt(smtpPort.getValor()));
			htmlEmail.setSSLOnConnect(Boolean.parseBoolean(smtpSsl.getValor()));

			// Envia o email
			htmlEmail.send();
		} catch (org.apache.commons.mail.EmailException e) {
			Log.critical(e);
			throw new EmailException("Erro ao enviar email. Consulte o administrador do sistema.");
		}
	}

	private void readParameters(String tipoEmail) throws ListException, EmailException {
		ParametroBe parametroBe = new ParametroBe(getManager());
		smtpHost = parametroBe.get(Constants.Parameters.SMTP_HOST);

		if (smtpHost == null) {
			throw new EmailException("Parâmetro " + Constants.Parameters.SMTP_HOST + " não definido!");
		}

		smtpPort = parametroBe.get(Constants.Parameters.SMTP_PORT);

		if (smtpPort == null) {
			throw new EmailException("Parâmetro " + Constants.Parameters.SMTP_PORT + " não definido!");
		}

		smtpUser = parametroBe.get(Constants.Parameters.SMTP_USER);

		if (smtpUser == null) {
			throw new EmailException("Parâmetro " + Constants.Parameters.SMTP_USER + " não definido!");
		}

		smtpPassword = parametroBe.get(Constants.Parameters.SMTP_PASSWORD);

		if (smtpPassword == null) {
			throw new EmailException("Parâmetro " + Constants.Parameters.SMTP_PASSWORD + " não definido!");
		}

		smtpSsl = parametroBe.get(Constants.Parameters.SMTP_SSL);

		if (smtpSsl == null) {
			throw new EmailException("Parâmetro " + Constants.Parameters.SMTP_SSL + " não definido!");
		}

		email = get(tipoEmail);

		if (email == null) {
			throw new EmailException("Parâmetro de Email [" + new TipoEmail().getDescription(tipoEmail) + "] não definido!");
		}
	}

}

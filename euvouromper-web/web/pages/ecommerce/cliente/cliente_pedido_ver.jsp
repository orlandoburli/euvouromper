<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<%@include file="../../geral/header-includes.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<fmt:setLocale value="pt-BR" />

<body class="metro" style="">

	<%@include file="../../geral/header-geral.jsp"%>

	<div class="container" style="padding: 10px">
		<div class="metro one-column">

			<%@include file="header-aluno.jsp"%>

			<div class="clear margin-top">
				<div id="tabela-mensagens" class="panel margin-top">
					<div class="panel-header bg-lightBlue fg-white">PEDIDO Nº. <fmt:formatNumber minIntegerDigits="6" value="${pedido.idPedido}"/> </div>
					<div class="panel-content">
						<div class="span5">
							<table class="table">
								<tbody>
									<tr>
										<td class="text-right span10">STATUS:</td>
										<td class="text-left"><b> ${pedido.statusPedidoDescritivo }</b></td>
									</tr>
									<tr>
										<td class="text-right">NOME:</td>
										<td class="text-left"><b> ${pedido.nome}</b></td>
									</tr>
									<tr>
										<td class="text-right">DATA/HORA DO PEDIDO:</td>
										<fmt:formatDate value="${pedido.dataHoraPedido.time}" pattern="dd/MM/yyyy HH:mm:ss" var="dataFormatada" />
										<td class="text-left"><b>${dataFormatada}</b></td>
									</tr>
									<tr>
										<td class="text-right">CPF:</td>
										<td class="text-left"><b> ${pedido.cpf}</b></td>
									</tr>
									<tr>
										<td class="text-right">E-MAIL:</td>
										<td class="text-left"><b> ${pedido.email}</b></td>
									</tr>
									<tr>
										<td class="text-right">CEP:</td>
										<td class="text-left"><b> ${pedido.cep }</b></td>
									</tr>
									<tr>
										<td class="text-right">LOGRADOURO:</td>
										<td class="text-left"><b> ${pedido.endereco }</b></td>
									</tr>
									<tr>
										<td class="text-right">NÚMERO:</td>
										<td class="text-left"><b> ${pedido.numero }</b></td>
									</tr>
									<tr>
										<td class="text-right">BAIRRO:</td>
										<td class="text-left"><b> ${pedido.bairro }</b></td>
									</tr>
									<tr>
										<td class="text-right">UF:</td>
										<td class="text-left"><b> ${pedido.uf}</b></td>
									</tr>
									<tr>
										<td class="text-right">CIDADE:</td>
										<td class="text-left"><b>${pedido.cidade}</b></td>
									</tr>
									<tr>
										<td class="text-left">VALE DESCONTO:</td>
										<td class="text-left"><b> ${pedido.cupom.descricao }</b></td>
									</tr>

								</tbody>
								<tfoot></tfoot>
							</table>
						</div>

						<div class="panel-header bg-lightBlue fg-white">DETALHES DO PEDIDO</div>
						<div class="panel-content" style="overflow: auto;">
							<table class="table">
								<thead>
									<tr>
										<th class="text-left">Código</th>
										<th class="text-left">Nome Produto</th>
										<th class="text-right">Valor</th>
									</tr>
								</thead>

								<tbody>
									<c:forEach items="${pedido.itens}" var="item">
										<tr>
											<td class="text-left"><fmt:formatNumber minIntegerDigits="3" value="${item.idProduto}"/></td>
											<td class="text-left">${item.nome}</td>
											<fmt:formatNumber value="${item.valor}" minFractionDigits="2" type="currency" var="valor" />
											<td class="text-right">${valor}</td>
										</tr>
									</c:forEach>
									<c:if test="${not empty pedido.cupom }">
										<tr>
											<td class="text-left">${pedido.cupom.chave}</td>
											<td class="text-left">${pedido.cupom.descricao}</td>
											
											<c:if test="${pedido.cupom.tipoDesconto eq VALOR}">
												<fmt:formatNumber value="${pedido.cupom.valor}" minFractionDigits="2" type="currency" var="valor" />
												<td class="text-right">${valor}</td>
											</c:if>
											
											<c:if test="${pedido.cupom.tipoDesconto eq PERCENTUAL}">
												<fmt:formatNumber value="${pedido.cupom.valor / 100}" minFractionDigits="2" type="percent" var="valor" />
												<td class="text-right">${valor}</td>
											</c:if>
										</tr>
									</c:if>
								</tbody>
								<tfoot></tfoot>
							</table>
							<div class="span3 floatright text-right">
								<div id="total-pedido">
									<div class="label-total-pedido">
										<b>Total</b>
									</div>
									<div class="total-pedido-valor">
										<b><fmt:formatNumber value="${pedido.valorLiquido}" minFractionDigits="2" type="currency" /></b>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>



		</div>
		<!-- end noticias -->
	</div>
	<!-- end container -->

	<%@include file="../../geral/footer.jsp"%>

</body>
</html>
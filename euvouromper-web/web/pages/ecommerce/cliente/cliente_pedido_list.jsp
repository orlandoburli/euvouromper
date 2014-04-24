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
					<div class="panel-header bg-lightBlue fg-white">Meus Pedidos</div>
					<div class="panel-content">
						<table class="table">
							<thead>
								<tr>
									<th class="text-left">Código</th>
									<th class="text-left">Data</th>
									<th class="text-left">Total</th>
									<th class="text-left">Satus</th>
									<th class="text-left">Info pedido</th>
									<th class="text-left"></th>
								</tr>
							</thead>

							<tbody>
								<c:forEach items="${pedidos}" var="pedido">
									<tr>
										<td class="right">${pedido.idPedido }</td>

										<fmt:formatDate value="${pedido.dataHoraPedido.time}" pattern="dd/MM/yyyy" var="dataFormatada" />
										<td class="right">${dataFormatada}</td>

										<fmt:formatNumber value="${pedido.valorLiquido}" minFractionDigits="2" type="currency" var="valor" />
										<td class="right">${valor}</td>

										<td class="right">${pedido.statusPedidoDescritivo}</td>

										<td class="right"><a href="${root}/aluno/pedido/${pedido.idPedido}">Detalhes do pedido</a></td>

										<td class="text-right"><a href="${pedido.urlPagSeguro}" target="_blank" title=""><img src="${root}/web/assets/imgs/180x25-pagar.gif" alt=""></a></td>
									</tr>
								</c:forEach>

							</tbody>

						</table>
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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<fmt:setLocale value="pt-BR" />

<style type="text/css">
table thead td:nth-child(1) {
	width: 60px;
}

table thead td:nth-child(1), table thead td:nth-child(5) {
	text-align: right;
}

table tbody tr td:nth-child(1), table tbody tr td:nth-child(5) {
	text-align: right;
}
</style>

<table data-page-count="${pageCount}" class="table">
	<thead>
		<tr>
			<td>C&oacute;digo</td>
			<td>Cliente</td>
			<td>Email</td>
			<td>Data</td>
			<td>Valor</td>
			<td>Status</td>
		</tr>
	</thead>

	<tfoot>
		<tr>
			<td colspan="4">P&aacute;gina ${pageNumber} de ${pageCount}</td>
		</tr>
	</tfoot>

	<tbody>
		<c:forEach items="${listSource}" var="pedido">
			<tr
				data-id="idPedido=${pedido.idPedido}">
				<td>${pedido.idPedido }</td>
				<td>${pedido.nome }</td>
				<td>${pedido.email }</td>
				<fmt:formatDate value="${pedido.dataHoraPedido.time}" pattern="dd/MM/yyyy" var="dataFormatada" />
				<td>${dataFormatada}</td>
				<fmt:formatNumber value="${pedido.valorLiquido}" minFractionDigits="2" type="currency" var="valor" />
				<td class="right">${valor}</td>
				<td>${pedido.statusPedidoDescritivo }</td>
			</tr>
		</c:forEach>
	</tbody>

</table>



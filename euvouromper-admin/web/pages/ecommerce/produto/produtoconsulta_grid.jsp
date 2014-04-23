<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="pt-BR" />

<style type="text/css">
table thead td:nth-child(1) {
	width: 60px;
}

table thead td:nth-child(1) {
	text-align: right;
}

table tbody tr td:nth-child(1) {
	text-align: right;
}
</style>


<table data-page-count="${pageCount}" class="table">
	<thead>
		<tr>
			<td>C&oacute;digo</td>
			<td>Nome</td>
			<td>Ativo</td>
			<td>Valor</td>
			<td>URL</td>
		</tr>
	</thead>

	<tfoot>
		<tr>
			<td colspan="4">P&aacute;gina ${pageNumber} de ${pageCount}</td>
		</tr>
	</tfoot>

	<tbody>
		<c:forEach items="${listSource}" var="produto">
			<tr data-id="idProduto=${produto.idProduto}">
				<td>${produto.idProduto}</td>
				<td>${produto.nome}</td>
				<td>${produto.ativoDescritivo}</td>
				<fmt:formatNumber value="${produto.valor}" minFractionDigits="2" type="currency" var="valor"/>
				<td>${valor}</td>
				<td>/produto/${produto.url}</td>
			</tr>
		</c:forEach>
	</tbody>

</table>



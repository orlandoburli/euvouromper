<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table data-page-count="${pageCount}" class="table">
	<thead>
		<tr>
			<td>C&oacute;digo</td>
			<td>Nome</td>
			<td>Valor</td>
		</tr>
	</thead>

	<tfoot>
		<tr>
			<td colspan="4">P&aacute;gina ${pageNumber} de ${pageCount}</td>
		</tr>
	</tfoot>

	<tbody>
		<c:forEach items="${listSource}" var="parametro">
			<tr
				data-id="idParametro=${parametro.idParametro}">
				<td>${parametro.idParametro }</td>
				<td>${parametro.nome }</td>
				<td>${parametro.valor }</td>
			</tr>
		</c:forEach>
	</tbody>

</table>



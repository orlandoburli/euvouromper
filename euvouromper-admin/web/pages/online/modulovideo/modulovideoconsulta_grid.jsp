<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style type="text/css">
table thead td:nth-child(1), table thead td:nth-child(3), table thead td:nth-child(4) {
	width: 60px;
}

table thead td:nth-child(1), table thead td:nth-child(3), table thead td:nth-child(4) {
	text-align: right;
}

table tbody tr td:nth-child(1), table tbody tr td:nth-child(3), table tbody tr td:nth-child(4) {
	text-align: right;
}
</style>


<table data-page-count="${pageCount}" class="table">
	<thead>
		<tr>
			<td>C&oacute;digo</td>
			<td>V�deo</td>
			<td>Aula</td>
			<td>Bloco</td>
		</tr>
	</thead>

	<tfoot>
		<tr>
			<td colspan="4">P&aacute;gina ${pageNumber} de ${pageCount}</td>
		</tr>
	</tfoot>

	<tbody>
		<c:forEach items="${listSource}" var="modulovideo">
			<tr
				data-id="idModuloVideo=${modulovideo.idModuloVideo}">
				<td>${modulovideo.idModuloVideo }</td>
				<td>${modulovideo.video.nome }</td>
				<td>${modulovideo.video.aula }</td>
				<td>${modulovideo.video.bloco }</td>
			</tr>
		</c:forEach>
	</tbody>

</table>



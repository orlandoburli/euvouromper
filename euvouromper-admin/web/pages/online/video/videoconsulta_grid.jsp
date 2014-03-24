<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style type="text/css">
table thead td:nth-child(1) {
	width: 60px;
}

table thead td:nth-child(3), table thead td:nth-child(4) {
	width: 30px;
	direction: rtl;
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
			<td>Aula</td>
			<td>Bloco</td>
			<td>Professor</td>
			<td>Disciplina</td>
		</tr>
	</thead>

	<tfoot>
		<tr>
			<td colspan="4">P&aacute;gina ${pageNumber} de ${pageCount}</td>
		</tr>
	</tfoot>

	<tbody>
		<c:forEach items="${listSource}" var="video">
			<tr data-id="idVideo=${video.idVideo}">
				<td>${video.idVideo }</td>
				<td>${video.nome }</td>
				<td>${video.aula }</td>
				<td>${video.bloco }</td>
				<td>${video.professor.nome }</td>
				<td>${video.disciplina.nome }</td>
			</tr>
		</c:forEach>
	</tbody>

</table>



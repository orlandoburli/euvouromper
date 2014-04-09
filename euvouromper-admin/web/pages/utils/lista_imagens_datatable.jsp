<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="panel">
<div class="datatable-images">
	<table class="table">
		<thead>
			<tr>
				<th>Imagem</th>
				<th>Nome</th>
				<th>Tipo</th>
				<th>Tamanho</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="file" items="${files}">
				<tr>
					<td><img alt="" src="${file.webPath}" class="img-thumbnail" style="max-height: 90px; max-width: 120px; width: auto; height: auto;"></td>
					<td>${file.fileName }</td>
					<td>${file.extension }</td>
					<td>${file.longSize }</td>
					<td><button data-image-value="${file.webPath}" type="button" class="BotaoRetornarImagem btn btn-primary btn-xs">
							<i class="icon-image2"></i> Selecionar
						</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</div>
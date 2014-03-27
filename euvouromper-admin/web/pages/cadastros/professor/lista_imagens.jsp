<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contador" value="-1" />

<div class="row">
	<c:forEach var="file" items="${files}">

		<c:set var="contador" value="${contador + 1 }" />

		<c:if test="${contador eq 3}">
			<c:set var="contador" value="0" />
</div>
<div class="row">
	</c:if>

	<div class="col-lg-4 col-md-3 col-sm-3">
		<div class="block">
			<div class="thumbnail thumbnail-boxed">
				<div class="thumb">
					<img alt="" src="${file.webPath}" class="img-thumbnail" style="max-height: 90px;">
				</div>
				<div class="caption">
					<span class="caption-title"> ${file.fileName}</span> 
					<span><strong>Tamanho:</strong> ${file.longSize }</span> 
					<span><strong>Formato:</strong> ${file.extension}</span> 
					<span><strong>Dimensões:</strong> ${file.width } px x ${file.height} px</span>
				</div>
			</div>
		</div>
	</div>
	</c:forEach>
</div>
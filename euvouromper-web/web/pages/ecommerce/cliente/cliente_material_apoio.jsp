<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:set var="root" value="<%=request.getServletContext().getContextPath()%>" />

<h3 style="text-align: center">Materiais de apoio para esta aula</h3>


<table class="table striped">
	
	<c:forEach items="${materiais}" var="material">
	<tr>
		<td>
			<a href="${root}/materialapoio.get?idMaterialApoio=${material.idMaterialApoio}" target="_blank"> ${material.nome}</a>
		</td>
	</tr>
		
	</c:forEach>
	
</table>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Footer -->
<div class="footer clearfix">
	<div class="pull-center">&copy; 2014 | Vers�o : ${versao}
	
	<c:if test="${not empty usuario}">
		| Usu�rio: ${usuario.nome}
	</c:if>	
	</div>
</div>
<!-- /footer -->
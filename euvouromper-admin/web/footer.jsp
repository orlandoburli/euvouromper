<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Footer -->
<div class="footer clearfix">
	<div class="pull-center">&copy; 2014. Orlando Burli Projetos de TI Personalizados. | Versão : ${versao.numeroVersao} ${versao.dataVersaoFormatada }
	
	<c:if test="${not empty usuario}">
		| Usuário: ${usuario.nome}
	</c:if>	
	</div>
</div>
<!-- /footer -->
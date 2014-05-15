
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<fmt:setLocale value="pt-BR" />

<c:set var="root" value="<%=request.getServletContext().getContextPath()%>" />

<div class="panel">
	<div class="panel-content">
		<div class="">
			<h1 class="">Ops... =/</h1>
			<p>Você ainda não adquiriu este curso.</p>
			<p>Compre este vídeo individualmente ou em Adicionar ao carrinho acima para comprar o curso completo.</p>

			<c:if test="${not empty produto}">
				<a style="float: none; width: 300px;" href="${root}/carrinho/adicionar/${produto.idProduto}" title="Comprar curso completo" class="adicionar-carrinho ">Comprar video individual</a>
				<fmt:formatNumber value="${produto.valor}" minFractionDigits="2" type="currency" var="valor" />
				<span class="label-valor">${valor}</span>
			</c:if>
			<%-- <a href="${root}/home" title="" class="continuar-comprando margin-top" style="display: block; width: 55%;">Voltar para página inicial</a> --%>
		</div>
	</div>
</div>

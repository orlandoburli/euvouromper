<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<%@include file="../../geral/header-includes.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<fmt:setLocale value="pt-BR" />

<body class="metro" style="">

	<%@include file="../../geral/header-geral.jsp"%>


	<div class="container" style="padding: 10px">
		<div class="metro one-column">
			<nav class="breadcrumbs mini">
				<ul>
					<li><a href="${root}/home"><i class="icon-home"></i></a></li>
					<li><a href="${root}/home">Home</a></li>
					<li class="active"><a href="${root}/produto/lista">Cursos</a></li>
				</ul>
			</nav>

			<h2 class="titles-big title-cursos">Cursos</h2>

			<c:forEach var="produto" items="${produtos}">

				<article class="cursos-item">
					<figure>
						<img src="${produto.pathFoto}" alt="">
						<figcaption></figcaption>
					</figure>
					<div class="title-curso-item">
						<h5>${produto.nome}</h5>
					</div>
					<div class="footer-curso">
						<fmt:formatNumber value="${produto.valor}" minFractionDigits="2" type="currency" var="valor"/>
						<span>${valor}</span> <a href="${root}/produto/${produto.url}" class="saiba-mais-curso" title="Saiba mais">saiba mais</a>
					</div>
				</article>

			</c:forEach>

		</div>
		<!-- end cursos -->
		
		<c:set var="tipo" value="produto" />

		<%@include file="../../geral/paginador.jsp"%>

	</div>
	<!-- end container -->

	

	<%@include file="../../geral/footer.jsp"%>

</body>
</html>
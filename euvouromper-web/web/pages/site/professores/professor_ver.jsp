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
					<li><a href="${root}/home">Professores</a></li>
					<li class="active"><a href="#">${professor.nome}</a></li>
				</ul>
			</nav>
			
			<h2 class="titles-big title-professores">${professor.nome}</h2>
			
			<div id="desc-prof">
				<figure id="foto-professor">
					<img class="cycle polaroid shadow" style="width: 180px; height: 180px;"  src="${professor.pathFoto}" alt="${professor.nome}" />
					<figcaption>
						<h5 class="cycle">${professor.nome}</h5>
					</figcaption>
				</figure>
				<p>${professor.curriculo}</p>
			</div>
			
			
			<div class="tile-group">
					<h2 class="titles-big linha-h2">
						<i class="icon-cube"></i> Cursos deste professor
					</h2>
					
					<c:forEach items="${produtos}" var="produto">
						<a class="tile double bd-lightBlue" data-click="transform" href="${root}/produto/${produto.url}">

							<div class="tile-content image">
								<img src="${produto.pathFoto }">
							</div>

							<div class="tile-content icon">
								<i class="icon-play-alt"></i>
							</div>

							<div class="brand bg-dark opacity">
								<fmt:formatNumber value="${produto.valor}" minFractionDigits="2" type="currency" var="valor"/>
								<span class="label fg-white">${produto.nome} - ${valor}</span>
							</div>

						</a>
					</c:forEach>
				</div>

		</div>
		<!-- end noticias -->
	</div>
	<!-- end container -->

	<%@include file="../../geral/footer.jsp"%>

</body>
</html>
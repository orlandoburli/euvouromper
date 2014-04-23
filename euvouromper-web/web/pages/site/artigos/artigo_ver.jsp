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
					<li><a href="${root}/artigo/lista">Artigos</a></li>
					<li class="active"><a href="${root}/artigo/${artigo.url}">${artigo.titulo}</a></li>
				</ul>
			</nav>
			<h2 class="titles-big linha-h2">${artigo.titulo}</h2>

			<div style="text-align: justify;">
				<p>${artigo.texto}</p>
			</div>
			
			<fmt:formatDate value="${artigo.data.time}" pattern="dd/MM/yyyy" var="dataFormatada" />

			<p style="text-align: right;">Publicado em ${dataFormatada}</p>
			
			<div id="autor-artigo">
				<div>
					<figure>
						<img style="width: 180px; height: 110px;" src="${artigo.professor.pathFoto}" alt="" class="cycle polaroid shadow">
					</figure>
					<h5>${artigo.professor.nome}</h5>
					<p>${artigo.professor.miniCurriculo}</p>
				</div>
			</div>

			<div id="ultimas-noticias">
				<h2 class="titles-big linha-h2">Últimos artigos</h2>
				<ul id="lista-noticias">
					<c:forEach items="${artigos}" var="item">
						<li>
							<a href="${root}/artigo/${item.url}" title="${item.titulo }">
									<h5>&#8594; ${item.titulo }</h5>
							</a>
						</li>
					</c:forEach>
				</ul>
			</div>
			<!-- end ultimas-noticias -->

		</div>
		<!-- end noticias -->
	</div>
	<!-- end container -->

	<%@include file="../../geral/footer.jsp"%>

</body>
</html>
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
					<li><a href="${root}/noticia/lista">Notícias</a></li>
					<li class="active"><a href="${root}/noticia/${noticia.url}">${noticia.titulo}</a></li>
				</ul>
			</nav>
			
			<h2 class="titles-big linha-h2">${noticia.titulo}</h2>

			<div style="text-align: justify;">
				<p>${noticia.texto}</p>
			</div>
			
			<fmt:formatDate value="${noticia.data.time}" pattern="dd/MM/yyyy" var="dataFormatada" />

			<p style="text-align: right;">Publicada em ${dataFormatada}</p>

			<div id="ultimas-noticias">
				<h2 class="titles-big linha-h2">Últimas notícias</h2>
				<ul id="lista-noticias">
					<c:forEach items="${noticias}" var="item">
						<li>
							<a href="${root}/noticia/${item.url}" title="${item.titulo }">
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
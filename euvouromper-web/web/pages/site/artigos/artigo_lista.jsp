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
				</ul>
			</nav>
			
			<h2 class="titles-big title-noticias">Artigos</h2>

			<c:forEach items="${artigos}" var="artigo">

				<a href="${root}/artigo/${artigo.url}" title="" class="article-lista-noticias">
					<article class="">
						<aside class="span1 data-noticias left">
							<fmt:formatDate value="${artigo.data.time}" pattern="dd" var="diaNoticia" />
							<fmt:formatDate value="${artigo.data.time}" pattern="MMM" var="mesNoticia" />
							<span class="dia clear">${diaNoticia}</span>
							<span class="mes clear">${fn:toUpperCase(mesNoticia)}</span>
						</aside>
						<aside class="right">
							<h4>${artigo.titulo}</h4>
							<p>${artigo.resumo}</p>
						</aside>
					</article>
				</a>

			</c:forEach>
		</div>

		<!-- end noticias -->

		<c:set var="tipo" value="artigo"/>
		
		<%@include file="../../geral/paginador.jsp"%>
	</div>
	<!-- end container -->

	<%@include file="../../geral/footer.jsp"%>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<%@include file="../geral/header-includes.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<fmt:setLocale value="pt-BR" />

<body class="metro" style="">

	<%@include file="../geral/header-geral.jsp"%>

	<div class="container" style="padding: 10px">
		<div class="metro one-column">
			<nav class="breadcrumbs mini">
				<ul>
					<li><a href="${root}/home"><i class="icon-home"></i></a></li>
					<li><a href="${root}/home">Home</a></li>
					<li class="active"><a href="${root}/">Busca</a></li>
				</ul>
			</nav>
			<h2 class="titles-big linha-h2">Resultados da pesquisa</h2>

			<c:forEach items="${resultado}" var="item">

				<c:if test="${item.voName eq 'NoticiaVo'}">
					<a href="${root}/noticia/${item.url}">
						<div style="text-align: justify;">
							<h3>Notícia: ${item.titulo}</h3>
							<p>${item.resumo}</p>
						</div>
					</a>
				</c:if>
				
				<c:if test="${item.voName eq 'ArtigoVo'}">
					<a href="${root}/artigo/${item.url}">
						<div style="text-align: justify;">
							<h3>Artigo: ${item.titulo}</h3>
							<p>${item.resumo}</p>
						</div>
					</a>
				</c:if>
				
				<c:if test="${item.voName eq 'InstitucionalVo'}">
					<a href="${root}/institucional/${item.url}">
						<div style="text-align: justify;">
							<h3>Institucional: ${item.titulo}</h3>
						</div>
					</a>
				</c:if>
				
				<c:if test="${item.voName eq 'ProdutoVo'}">
					<a href="${root}/produto/${item.url}">
						<div style="text-align: justify;">
							<h3>Produto: ${item.nome}</h3>
							<p>${item.descricao}</p>
						</div>
					</a>
				</c:if>
				
				<c:if test="${item.voName eq 'ProfessorVo'}">
					<a href="${root}/professor/${item.url}">
						<div style="text-align: justify;">
							<h3>Professor: ${item.nome}</h3>
						</div>
					</a>
				</c:if>
				
				<br/>

			</c:forEach>

		</div>
		<!-- end noticias -->
	</div>
	<!-- end container -->

	<%@include file="../geral/footer.jsp"%>

</body>
</html>
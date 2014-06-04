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
			
			<c:if test="${empty tipo || tipo eq TOTAL}">
				<div class="tile-group">
					<h2 class="titles-big linha-h2">
						<i class="icon-cube"></i> Acesso Total
					</h2>
					
					<c:forEach items="${produtos}" var="produto">
						<c:if test="${produto.tipoProduto eq TOTAL}">
							<a class="tile double bd-lightBlue ${selecionado}" data-click="transform" href="${root}/produto/${produto.url}">
	
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
						</c:if>
					</c:forEach>
				</div>
			</c:if>
			
			<c:if test="${empty tipo || tipo eq PACOTE}">
				<div class="tile-group">
					<h2 class="titles-big linha-h2">
						<i class="icon-cube-2"></i> Pacotes completos
					</h2>
					
					<c:forEach items="${produtos}" var="produto">
						<c:if test="${produto.tipoProduto eq PACOTE}">
							<a class="tile double bd-lightBlue ${selecionado}" data-click="transform" href="${root}/produto/${produto.url}">
	
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
						</c:if>
					</c:forEach>
				</div>
			</c:if>
			
			<c:if test="${empty tipo || tipo eq MODULO}">
				<div class="tile-group">
					<h2 class="titles-big linha-h2">
						<i class="icon-puzzle"></i> Cursos modulares
					</h2>
					
					<c:forEach items="${produtos}" var="produto">
						<c:if test="${produto.tipoProduto eq MODULO}">
							<a class="tile double bd-lightBlue ${selecionado}" data-click="transform" href="${root}/produto/${produto.url}">
	
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
						</c:if>
					</c:forEach>
				</div>
			</c:if>
			
			<c:if test="${empty tipo || tipo eq CREDITO}">
				<div class="tile-group">
					<h2 class="titles-big linha-h2">
						<i class="icon-coins"></i> Créditos
					</h2>
					
					<c:forEach items="${produtos}" var="produto">
						<c:if test="${produto.tipoProduto eq CREDITO}">
							<a class="tile double bd-lightBlue" data-click="transform" href="${root}/produto/${produto.url}">
	
								<div class="tile-content image">
									<img src="${produto.pathFoto }">
								</div>
	
								<div class="tile-content icon">
									<i class="icon-play-alt"></i>
								</div>
	
								<div class="brand bg-dark opacity">
									<fmt:formatNumber value="${produto.valor}" minFractionDigits="2" type="currency" var="valor"/>
									<span class="label fg-white">${produto.nome}</span>
								</div>
	
							</a>
						</c:if>
					</c:forEach>
				</div>
			</c:if>

		</div>
		<!-- end cursos -->
		
	</div>
	<!-- end container -->

	<%@include file="../../geral/footer.jsp"%>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<%@include file="header-includes.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<fmt:setLocale value="pt-BR" />

<body class="metro" style="">

	<%@include file="header-geral.jsp"%>

	<div class="container" style="padding: 10px">
		<div class="metro one-column">
			<nav class="breadcrumbs mini">
				<ul>
					<li><a href="${root}/home"><i class="icon-home"></i></a></li>
					<li><a href="${root}/home">Home</a></li>
					<li><a href="${root}/pagina_nao_encontrada">404 Error</a></li>
				</ul>
			</nav>
			<h2 class="titles-big linha-h2">HTTP 404 ERROR</h2>
			<div class="span5 left">
				<figure>
					<img src="${root}/web/assets/imgs/404-icon.png" alt="">
				</figure>
			</div>

			<div class="span6 left">
				<h1 class="">Ops... =/</h1>
				<p>
					Esta página não existe ou não foi movida daqui.
					<p>Desculpe-nos pelo transtorno.</p>
				<a href="${root}/home" title="" class="continuar-comprando margin-top" style="display: block; width: 55%;">Voltar para página inicial</a>
    		</div>
			
    	</div>
		<!-- end noticias -->
	</div>
	<!-- end container -->

	<%@include file="footer.jsp"%></
				body>
</html>
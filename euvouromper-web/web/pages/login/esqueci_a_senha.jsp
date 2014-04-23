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
					<li><a href="${root}/esqueci_a_senha">Esqueci minha senha</a></li>
				</ul>
			</nav>
			<h2 class="titles-big linha-h2">Esqueci minha Senha</h2>
			<p>Uma nova senha será enviada para o email informado.</p>
			<div class="span6 left">
				<form method="post" accept-charset="utf-8">
					<div class="input-control text">
						<input id="email" name="email" type="text" value="" placeholder="Insira o e-mail cadastrado " autofocus="autofocus" />
						<button class="btn-clear"></button>
					</div>
					<input type="submit" value="Enviar">
				</form>
				
				<c:if test="${not empty erro}">
					<div class="notice marker-on-top bg-crimson fg-white">
						${erro}
					</div>
				</c:if>
				<c:if test="${not empty sucesso}">
					<div class="notice marker-on-top bg-emerald fg-white">
						${sucesso}
					</div>
				</c:if>
			</div>
		</div>
		<!-- end noticias -->
	</div>
	<!-- end container -->

	<%@include file="../geral/footer.jsp"%>

</body>
</html>
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
					<li><a href="${root}/contato">Contato</a></li>
				</ul>
			</nav>

			<h2 class="titles-big linha-h2">Contato</h2>

			<form action="" method="post">

				<label>Nome:</label>
				<div class="input-control text">
					<input id="nome" name="nome" type="text" value="${nome}" placeholder="Seu nome" />
					<button class="btn-clear"></button>
				</div>

				<label>E-mail</label>
				<div class="input-control text">
					<input id="email" name="email" type="text" value="${email}" placeholder="Seu email" />
					<button class="btn-clear"></button>
				</div>

				<label>Telefone:</label>
				<div class="input-control text">
					<input id="fone" name="fone" type="text" value="${fone}" placeholder="Seu telefone" />
					<button class="btn-clear"></button>
				</div>

				<label>Assunto</label>
				<div class="input-control text">
					<input id="assunto" name="assunto" type="text" value="${assunto}" placeholder="Qual o assunto?" />
					<button class="btn-clear"></button>
				</div>

				<label>Departamento</label>
				<div class="input-control select">
					<select id="idDepartamento" name="idDepartamento">
						<option>[SELECIONE O DEPARTAMENTO]</option>

						<c:forEach items="${departamentos}" var="departamento">
							<c:set var="selecionado" value=""/>
							
							<c:if test="${departamento.idDepartamento eq idDepartamento }">
								<c:set var="selecionado" value="selected='selected'"/>
							</c:if>
						
							<option ${selecionado} value="${departamento.idDepartamento}">${departamento.nome}</option>
						</c:forEach>
					</select>
				</div>

				<label>Mensagem:</label>
				<div class="input-control textarea">
					<textarea id="mensagem" name="mensagem" placeholder="Digite sua mensagem">${mensagem}</textarea>
				</div>
				
				<c:if test="${not empty erro}">
					<div class="notice marker-on-top bg-crimson fg-white">${erro}</div>
					<br/>
				</c:if>

				<c:if test="${not empty sucesso}">
					<div class="notice marker-on-top bg-emerald fg-white">${sucesso}</div>
					<br/>
				</c:if>

				<input type="submit" value="Enviar contato">
			</form>



		</div>
		<!-- end noticias -->
	</div>
	<!-- end container -->

	<%@include file="../../geral/footer.jsp"%>

</body>
</html>
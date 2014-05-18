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

			<%@include file="header-aluno.jsp"%>

			<div class="clear margin-top">
				<div id="tabela-mensagens" class="panel margin-top" style="overflow: auto">
					<div class="panel-header bg-lightBlue fg-white">Meus Cursos</div>
					<div class="panel-content">

						<label>Pesquisar</label>

						<div class="input-control text text-right">
							<form method="post">
								<input id="assunto" name="assunto" type="text" value="${assunto}" placeholder="Digite aqui o assunto que você deseja pesquisar" />
								<button class="btn-search"></button>
							</form>
						</div>

						<div class="tile-group">
							<h2 class="titles-big linha-h2">
								<i class="icon-cube-2"></i> Pacotes completos
							</h2>
							<c:forEach items="${produtos}" var="produto">
								<c:set var="selecionado" value="" />

								<c:if test="${not empty produto.item}">
									<c:set var="selecionado" value="selected" />
								</c:if>

								<c:if test="${produto.tipoProduto eq PACOTE}">
									<a class="tile double bd-lightBlue ${selecionado}" data-click="transform" href="${root}/aluno/curso/${produto.url}">

										<div class="tile-content image">
											<img src="${produto.pathFoto }">
										</div>

										<div class="tile-content icon">
											<i class="icon-play-alt"></i>
										</div>

										<div class="brand bg-dark opacity">
											<span class="label fg-white">${produto.pacote.nome}</span>
										</div>

									</a>
								</c:if>
							</c:forEach>
						</div>


						<div class="tile-group">
							<h2 class="titles-big linha-h2">
								<i class="icon-puzzle"></i> Cursos modulares
							</h2>

							<c:forEach items="${produtos}" var="produto">
								<c:if test="${produto.tipoProduto eq MODULO}">
									<c:set var="selecionado" value="" />
									
									<c:if test="${not empty produto.item}">
										<c:set var="selecionado" value="selected" />
									</c:if>
									<a class="tile double bd-lightBlue ${selecionado}" data-click="transform" href="${root}/aluno/curso/${produto.url}">

										<div class="tile-content image">
											<img src="${produto.pathFoto }">
										</div>

										<div class="tile-content icon">
											<i class="icon-play-alt"></i>
										</div>

										<div class="brand bg-dark opacity">
											<span class="label fg-white">${produto.modulo.nome}</span>
										</div>

									</a>
								</c:if>
							</c:forEach>
						</div>

					</div>
				</div>
			</div>





		</div>


		<!-- end noticias -->
	</div>
	<!-- end container -->
	<%@include file="../../geral/footer.jsp"%>

</body>
</html>
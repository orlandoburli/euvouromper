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
		<div class="metro one-column" style="text-align: justify;">
			<nav class="breadcrumbs mini">
				<ul>
					<li><a href="${root}/home"><i class="icon-home"></i></a></li>
					<li><a href="${root}/home">Home</a></li>
					<li><a href="${root}/produto/lista">Cursos</a></li>
					<li class="active"><a href="${root}/produto/${produto.url}">${produto.nome }</a></li>
				</ul>
			</nav>
			<div class="metro one-column">
				<a href="${root}/carrinho/adicionar/${produto.idProduto}" title="Adicionar no carrinho" class="adicionar-carrinho">Adicionar no carrinho</a>
			</div>
			<h2 class="titles-big linha-h2">${produto.nome}</h2>
			<p>${produto.descricao}</p>
			<div class="panel margin-top" style="overflow: auto;">
				<div class="panel-content">

					<div class="span6 left" style="">
						<div class="panel-header bg-transparent">Objetivo</div>
						<div class="panel-content">
							<c:if test="${produto.tipoProduto eq PACOTE}">
								${produto.pacote.objetivo}
							</c:if>

							<c:if test="${produto.tipoProduto eq MODULO}">
								${produto.modulo.objetivo}
							</c:if>
						</div>
					</div>

					<div class="span7 floatright" style="">
						<div class="panel-header bg-transparent">Conteúdo</div>
						<div class="panel-content">
							<c:if test="${produto.tipoProduto eq PACOTE}">
								${produto.pacote.conteudo}
							</c:if>

							<c:if test="${produto.tipoProduto eq MODULO}">
								${produto.modulo.conteudoProgramatico}
							</c:if>
						</div>
					</div>


				</div>
			</div>
			<!-- end descricao produto -->
			<c:if test="${produto.tipoProduto eq PACOTE}">

				<div class="panel" style="margin-top: 25px;">
					<div class="panel-header bg-transparent">Compre individualmente</div>
					<span style="margin-left: 10px; font-style: italic;">Clique sobre a disciplina para ver o conteúdo programático de cada uma</span>
					<script>
						$(function() {

							$(".createWindow").click(function(e) {
								$.Dialog({
									shadow : true,
									overlay : true,
									flat: true,
									icon : '',
									title : 'Conteúdo programático',
									width : 500,
									padding : 20,
									content : '<div style="max-width: 500px; text-align: justify">' + $(this).attr("data-title") + '</div>'
								});
							});

						})
					</script>
					<div id="painelItens" class="panel-content">
						<table class="table hovered">
							<thead>
								<tr>
									<th class="text-left">Disciplina</th>
									<th class="text-left">Professor</th>
									<th class="text-left">Duração</th>
									<th class="text-left">Valor</th>
									<th class="text-left"></th>
								</tr>
							</thead>

							<tbody>
								<c:forEach items="${produto.pacote.modulos}" var="modulo">
									<tr>
										<td><a href="#painelItens" data-title="${modulo.conteudoProgramatico}" id="" class="createWindow">${modulo.nome}</a></td>
										<td class="right">${modulo.professor.nome}</td>
										<td class="right">${modulo.horas}h</td>
										<fmt:formatNumber value="${modulo.produto.valor}" minFractionDigits="2" type="currency" var="valor" />
										<td class="right">${valor}</td>

										<td class="right"><c:if test="${!empty modulo.produto}">
												<a href="${root}/carrinho/adicionar/${modulo.produto.idProduto}" title=""><img src="${root}/web/assets/imgs/carrinho-item.png" alt=""></a>
											</c:if></td>
									</tr>
								</c:forEach>
							</tbody>

							<tfoot></tfoot>
						</table>
					</div>
				</div>
			</c:if>

		</div>
		<!-- end cursos -->

	</div>
	<!-- end container -->
	<%@include file="../../geral/footer.jsp"%>

</body>
</html>
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
			<div class="panel" style="overflow: auto;">
				<div class="panel-header bg-lightBlue fg-white">
					<h3 style="color: #fff;">${produto.nome}</h3>
				</div>
				<div class="panel-content" style="text-align: justify;">
					<p>${produto.descricao}</p>
					<a href="${root}/carrinho/adicionar/${produto.idProduto}">Adicionar ao carrinho</a>

					<div class="span6 left" style="margin-top: 55px;">
						<div class="panel-header bg-lightOlive  fg-white">Objetivo</div>
						<div class="panel-content">
							<c:if test="${produto.tipoProduto eq PACOTE}">
								${produto.pacote.objetivo}
							</c:if>
							
							<c:if test="${produto.tipoProduto eq MODULO}">
								${produto.modulo.objetivo}
							</c:if>
						</div>
					</div>

					<div class="span7 left" style="margin-top: 55px;">
						<div class="panel-header bg-lightRed  fg-white">Conteúdo</div>
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
					<div class="panel-header bg-darkViolet fg-white" style="">Compre individualmente</div>
					<div class="panel-content">
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
										<td><a href="" title="" id="" class="createWindow">${modulo.nome}</a></td>
										<td class="right">${modulo.professor.nome}</td>
										<td class="right">${modulo.horas}h</td>
										<fmt:formatNumber value="${modulo.produto.valor}" minFractionDigits="2" type="currency" var="valor"/>
										<td class="right">${valor}</td>
										
										<td class="right">
											<c:if test="${!empty modulo.produto}">
												<a href="${root}/carrinho/adicionar/${modulo.produto.idProduto}" title=""><img src="${root}/web/assets/imgs/carrinho-item.png" alt=""></a>
											</c:if>
										</td>
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
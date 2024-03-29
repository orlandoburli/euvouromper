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
					<li class="active"><a href="${root}/carrinho">Carrinho de Compras</a></li>
				</ul>
			</nav>
			<h2 class="titles-big linha-h2">Carrinho de Compras</h2>
			<table class="table">
				<thead>
					<tr>
						<th class="text-left">Item</th>
						<th class="text-right">Valor</th>
						<th class="text-left"></th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="item" items="${carrinho.itens}">
						<tr>
							<%-- <td><a href="${root}/produto/${item.produto.url}" title="" id="" class="createWindow">${item.produto.nome}</a></td>
							<fmt:formatNumber value="${item.produto.valor}" minFractionDigits="2" type="currency" var="valor" />
							<td class="right">${valor}</td>
							<td class="right"><a href="${root}/carrinho/remover/${item.produto.idProduto}" title="" class="deleta-item">Deletar</a></td> --%>
							
							<td><a href="${root}/produto/${item.produto.url}" title="" id="" class="createWindow">${item.produto.nome}</a></td>
							<fmt:formatNumber value="${item.produto.valor}" minFractionDigits="2" type="currency" var="valor" />
							<td class="text-right">${valor}</td>
							<td class="text-right"><a href="${root}/carrinho/remover/${item.produto.idProduto}" title="" class="deleta-item">Remover item</a></td>
							
						</tr>
					</c:forEach>

					<c:if test="${not empty carrinho.cupom }">
						<tr>
							<td><a title="" id="" class="createWindow">${carrinho.cupom.descricao}</a></td>

							<c:if test="${carrinho.cupom.tipoDesconto eq PERCENTUAL}">
								<fmt:formatNumber value="${carrinho.cupom.valor / 100}" minFractionDigits="2" type="percent" var="valor" />
							</c:if>
							<c:if test="${carrinho.cupom.tipoDesconto eq VALOR}">
								<fmt:formatNumber value="${carrinho.cupom.valor}" minFractionDigits="2" type="currency" var="valor" />
							</c:if>

							<td class="text-right">${valor}</td>
							<td class="text-right"><a href="${root}/carrinho.cupom.remover.page" title="" class="deleta-item">Remover Cupom</a></td>
						</tr>
					</c:if>
				</tbody>

				<tfoot></tfoot>
			</table>

			<div id="vale-cupom" class="metro one-column">
				<div class="span8 left">
					<p>Se você tem um cupom de desconto, insira-o ao lado:</p>
				</div>
				<div class="span6 floatright padding-left">
					<form method="post">
						<div class="input-control span4 text floatleft">
							<input id="cupom" name="cupom" type="text" value="" placeholder="" />
							<button class="btn-clear"></button>
						</div>
						<div class="floatleft">
							<input type="submit" id="botao-valida-cupom" value="Validar Cupom">
						</div>
					</form>
				</div>
			</div>

			<div id="total-carrinho" class="">
				<div class="span4 left">
					<span class="label-total">Total Itens</span>
					<fmt:formatNumber value="${carrinho.valorBruto}" minFractionDigits="2" type="currency" var="valorBruto" />
					<span class="label-valor">${valorBruto}</span>
				</div>
				<div class="span4 left">
					<span class="label-total">Desconto</span>
					<fmt:formatNumber value="${carrinho.valorDesconto}" minFractionDigits="2" type="currency" var="valorDesconto" />
					<span class="label-valor">${valorDesconto}</span>
				</div>
				<div class="span4 left">
					<span class="label-total">Total</span>
					<fmt:formatNumber value="${carrinho.valorLiquido}" minFractionDigits="2" type="currency" var="valorLiquido" />
					<span class="label-valor">${valorLiquido }</span>
				</div>

			</div>

			<div class="metro one-column margin-top">
				<div class="span5 left">
					<a href="${root}/produto/lista" title="Continuar Comprando" class="continuar-comprando">Continuar Comprando</a>
				</div>
				<div class="span5 floatright">
					<a href="${root}/carrinho/finalizar" title="Finalizar Compra" class="finalizar-compra">Finalizar Compra</a>
				</div>
			</div>

			<div class="metro one-column margin-top">
				<img src='https://p.simg.uol.com.br/out/pagseguro/i/banners/divulgacao/728x90_10X_pagseguro.gif' alt='' />
			</div>

			<c:if test="${not empty erro}">
				<br />
				<div class="notice marker-on-top bg-crimson fg-white">${erro}</div>
			</c:if>
		</div>
		<!-- end noticias -->
	</div>
	<!-- end container -->

	<%@include file="../../geral/footer.jsp"%>

</body>
</html>
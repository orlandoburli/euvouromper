<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<header id="content-header-home" class="">
	<div id="header-container" class="container">
		<a href="${root}/" id="logo"><img src="${root}/web/assets/imgs/logo-romper.png" alt=""></a>
		<section id="shopp-cart">
			<a href="javascript:void(0);" title="" id="carrinho-label"> 
				<span id="icon-carrinho"></span> 
				<span id="texto-carrinho">Ítens no carrinho: </span> 
				<span id="itens-carrinho">${carrinho.itens.size()}</span>
			</a>
			<div id="itens-do-carrinho">
				<ul id="" class="">
					<c:forEach var="item" items="${carrinho.itens}">
						<li><a href="javascript:void(0);" title="">${item.produto.nome}</a></li>
					</c:forEach>
				</ul>
				<a href="${root}/carrinho" title="" id="ir-para-carrinho">Ir para o carrinho</a>
			</div>
		</section>
		<section id="login-aluno">
			<!-- <a href="javascript:void(0);" id="button-area-aluno" class="login-button">área do aluno</a> -->
			<c:if test="${empty cliente}">
				<a href="${root}/entrar?redir=/aluno" id="button-area-aluno" class="login-button">área do aluno</a>
			</c:if>
			<c:if test="${not empty cliente}">
				<a href="${root}/aluno" id="button-area-aluno" class="login-button">Seja bem vindo, ${cliente.primeiroNome}</a>
			</c:if>
		</section>
		<div id="aside-header-right" class="">
			<div id="search" class="input-control text">
				<form action="${root}/buscar" method="get">
					<input type="text" placeholder="Busca" id="s" name="s"/>
					<button class="btn-search" type="submit"></button>
				</form>
			</div>
			<div id="redes-sociais">
				<ul class="">
					<li><a href="" title="" class="facebook">facebook</a></li>
					<li><a href="" title="" class="twitter">twitter</a></li>
					<li><a href="" title="" class="google">google +</a></li>
					<li><a href="" title="" class="youtube">youtube</a></li>
				</ul>
			</div>
			<!-- end redes-sociais -->
			<nav id="menu-header-first" class="horizontal-menu compact">
				<ul>
					<c:forEach items="${menusTopo}" var="menu">
						<li><a href="${root}/${menu.url}">${menu.nome}</a></li>
					</c:forEach>
					
					<!-- <li><a class="dropdown-toggle" href="#">Atendimento</a>
						<ul class="dropdown-menu" data-role="dropdown">
							<li><a href="#">Fale Conosco</a></li>
							<li><a href="#">Ouvidoria</a></li>
						</ul></li> -->
				</ul>
			</nav>
		</div>
		<nav id="menu-header-secund" class="horizontal-menu compact">
			<ul>
				<c:forEach items="${menusTopo2}" var="menu">
					<li><a href="${root}/${menu.url}">${menu.nome}</a></li>
				</c:forEach>
			</ul>
		</nav>
	</div>

</header>
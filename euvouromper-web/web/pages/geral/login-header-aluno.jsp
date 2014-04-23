<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="conteiner-area-aluno">
	<h3>Área do Aluno</h3>

	<div id="form-area-aluno">

		<c:if test="${empty cliente}">
			<form action="${root}/entrar" method="post" accept-charset="utf-8">
				<div class="input-control text">
					<input id="email" name="email" type="text" value="" placeholder="E-mail" />
					<button class="btn-clear"></button>
					<input type="hidden" id="redir" name="redir" value="${requestScope['javax.servlet.forward.servlet_path']}"/>
				</div>
				<div class="input-control password">
					<input id="senha" name="senha" type="password" value="" placeholder="Senha" />
					<button class="btn-reveal" type="submit"></button>
				</div>
				<div class="links-login">

					<a href="${root}/entrar" title="Crie uma conta" class="">Crie uma conta</a> <a href="${root}/esqueci_a_senha" title="Esqueceu senha?" class="esqueceu-senha">Esqueceu sua senha?</a>

					<!-- <div class="fb-login-button" data-max-rows="3" data-size="small" data-show-faces="true" data-auto-logout-link="false"></div> -->

					<%-- <a href="javascript:loginWithFacebook();"><img src="${root}/web/assets/imgs/facebook.gif"/></a> --%>
				</div>

				<input id="btnEntrar" name="btnEntrar" type="submit" value="Entrar">
			</form>
		</c:if>

		<c:if test="${not empty cliente}">

			<div>
				<span class="white">Usuário:</span>
				<p class="white">
					<b>${cliente.email}</b>
				</p>
			</div>
			<div id="carrinho-compras">
				<a href="${root}/carrinho">
					<img src="${root}/web/assets/imgs/carrinho.png" alt=""> <span class="white">Total itens no carrinho:</span> 
					<a title="${root}/carrinho" class="quantidade-carrinho">${carrinho.quantidadeItens}</a>
				</a>
			</div>

			<div class="links-login">
				<a href="${root}/alterar_senha" title="Alterar Senha" class="left">Alterar senha</a> 
				<a href="${root}/sair?redir=${requestScope['javax.servlet.forward.servlet_path']}" title="Sair" class="left">Sair</a>
			</div>

		</c:if>
	</div>


</div>
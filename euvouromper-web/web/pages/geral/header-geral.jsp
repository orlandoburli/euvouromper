<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<header id="content-header">

	<nav class="horizontal-menu-top compact">
		<ul class="">
			<c:forEach items="${menusTopo}" var="menu">
				<li><a href="${menu.url}">${menu.nome}</a></li>
			</c:forEach>
		</ul>
	</nav>

	<div id="conteiner-area-aluno">
		<h3>Área do Aluno</h3>

		<div id="form-area-aluno">
			<form action="" method="get" accept-charset="utf-8">
				<div class="input-control text">
					<input type="text" value="" placeholder="E-mail" />
					<button class="btn-clear"></button>
				</div>
				<div class="input-control password">
					<input type="password" value="" placeholder="Senha" />
					<button class="btn-reveal"></button>
				</div>
				<div class="links-login">
					<a href="#" title="Crie uma conta" class="">Crie uma conta</a> <a href="#" title="Esqueceu senha?" class="esqueceu-senha">Esqueceu sua senha?</a>
				</div>

				<input type="submit" value="Entrar">
			</form>
		</div>

	</div>

</header>
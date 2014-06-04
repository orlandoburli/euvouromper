<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<nav id="nav-area-aluno">
	<ul id="menu-aluno">
		<li><a href="${root}/aluno" class="aluno ativo">Painel do Aluno</a></li>
		<li><a href="${root}/aluno/cursos" class="cursos">Meus Cursos</a></li>
		<li><a href="${root}/aluno/mensagens" class="mensagens">Mensagens<span class="numeros">${novasMensagens}</span></a></li>
		<li><a href="${root}/aluno/dados" class="dados">Meus Dados</a></li>
		<li><a href="${root}/aluno/pedidos" class="preferencias">Meus Pedidos</a></li>
		<li><a href="${root}/aluno" class="credito"> <fmt:formatNumber value="${saldo}" minFractionDigits="2" type="currency" /> <span>saldo </span></a></li>
		<li><a href="${root}/sair" class="preferencias">Sair</a></li>
	</ul>
</nav>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<header id="content-header">

	<nav class="horizontal-menu-top compact">
		<ul class="">
			<c:forEach items="${menusTopo}" var="menu">
				<li><a href="${root}/${menu.url}">${menu.nome}</a></li>
			</c:forEach>
		</ul>
	</nav>

	<%@include file="login-header-aluno.jsp" %>
	
</header>
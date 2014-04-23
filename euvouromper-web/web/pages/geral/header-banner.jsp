<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<header id="content-header-home">

	<nav class="horizontal-menu-top-home compact">
		<ul class="">
			<c:forEach items="${menusTopo}" var="menu">
				<li><a href="${root}/${menu.url}">${menu.nome}</a></li>
			</c:forEach>
		</ul>
	</nav>

	<%@include file="login-header-aluno.jsp" %>

	<div class="sliders hidden-phone">
		<div id="slider" class="rev_slider fullwidthabanner">
			<ul>
				<c:forEach items="${banners}" var="banner">
					<li data-transition="papercut" data-slotamount="8" data-masterspeed="300">
					
						<img src="${banner.pathImagem}" data-fullwidthcentering="on" alt="${banner.titulo}">
	
						<div class="tp-caption slider-title lfb" data-x="20" data-y="70" data-speed="800" data-start="800" data-easing="easeOutBack" style="color: #363636 !important;">
							${banner.titulo}
						</div>
	
						<div class="tp-caption slider-paragraph lft" data-x="20" data-y="160" data-speed="600" data-start="1000" data-easing="easeOutBack" style="color: #363636 !important;">
							${banner.subTitulo}
						</div>

						<div class="tp-caption lfb" data-x="20" data-y="230" data-speed="450" data-start="1200" data-easing="easeOutBack">
							<button class="btn btn-primary btn-large btn-largexyyy" onclick="javascript:window.location='${banner.url}'">Saiba Mais</button>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</header>
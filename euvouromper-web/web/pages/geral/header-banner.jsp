<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<header id="content-header-home">

	<nav class="horizontal-menu-top-home compact">
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

	<div class="sliders hidden-phone">
		<div id="slider" class="rev_slider fullwidthabanner">
			<ul>
				<li data-transition="papercut" data-slotamount="8" data-masterspeed="300"><img src="http://www.iped.com.br/img/cursos/imagens-destaques/direito-administrativo.jpg" data-fullwidthcentering="on" alt="Curso de Direito Administrativo">

					<div class="tp-caption slider-title lfb" data-x="20" data-y="70" data-speed="800" data-start="800" data-easing="easeOutBack" style="color: #363636 !important;">
						Curso de Direito<br />Administrativo
					</div>

					<div class="tp-caption slider-paragraph lft" data-x="20" data-y="160" data-speed="600" data-start="1000" data-easing="easeOutBack" style="color: #363636 !important;">
						O objetivo desse curso é ensinar sobre a obrigatoriedade e<br />dispensa da licitação, sobre os sistemas administrativos,...
					</div>

					<div class="tp-caption lfb" data-x="20" data-y="230" data-speed="450" data-start="1200" data-easing="easeOutBack">
						<button class="btn btn-primary btn-large btn-largexyyy" onclick="javascript:window.location='/direito/curso/direito-administrativo'">Saiba Mais</button>
					</div></li>
				<li data-transition="papercut" data-slotamount="8" data-masterspeed="300"><img src="http://www.iped.com.br/img/cursos/imagens-destaques/direito-do-trabalho.jpg" data-fullwidthcentering="on" alt="Curso de Direito do Trabalho">

					<div class="tp-caption slider-title lfb" data-x="20" data-y="100" data-speed="800" data-start="800" data-easing="easeOutBack" style="color: #363636 !important;">Curso de Direito do Trabalho</div>

					<div class="tp-caption slider-paragraph lft" data-x="20" data-y="160" data-speed="600" data-start="1000" data-easing="easeOutBack" style="color: #363636 !important;">
						O objetivo desse curso é ensinar sobre a evolução do direito<br />do trabalho, o conceito de empregador e empregado, a...
					</div>

					<div class="tp-caption lfb" data-x="20" data-y="230" data-speed="450" data-start="1200" data-easing="easeOutBack">
						<button class="btn btn-primary btn-large btn-largex" onclick="javascript:window.location='/direito/curso/direito-do-trabalho'">Saiba Mais</button>
					</div></li>
				<li data-transition="papercut" data-slotamount="8" data-masterspeed="300"><img src="http://www.iped.com.br/img/cursos/imagens-destaques/direito-constitucional.jpg" data-fullwidthcentering="on" alt="Curso de Direito Constitucional">

					<div class="tp-caption slider-title lfb" data-x="20" data-y="70" data-speed="800" data-start="800" data-easing="easeOutBack" style="color: #363636 !important;">
						Curso de Direito<br />Constitucional
					</div>

					<div class="tp-caption slider-paragraph lft" data-x="20" data-y="160" data-speed="600" data-start="1000" data-easing="easeOutBack" style="color: #363636 !important;">
						O objetivo desse curso é ensinar sobre os conceitos de<br />constituição, os princípios e objetivos fundamentais,<br />direitos...
					</div>

					<div class="tp-caption lfb" data-x="20" data-y="230" data-speed="450" data-start="1200" data-easing="easeOutBack">
						<button class="btn btn-primary btn-large btn-largex" onclick="javascript:window.location='/direito/curso/direito-constitucional'">Saiba Mais</button>
					</div></li>
			</ul>
		</div>
	</div>
</header>
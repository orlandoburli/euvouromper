<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<%@include file="geral/header-includes.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<fmt:setLocale value="pt-BR" />

<body class="metro" style="">

	<%@include file="geral/header-geral.jsp"%>

	<div class="container" style="overflow: auto;">
    	<aside id="aside-left" class="">
			<div class="sliders hidden-phone clear">
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
			</div><!-- end sliders-->
			<section id="aula-experimental" class="" style="overflow: auto;">
				<h2 class="titulo-padrao" title="Aula Experimental">Aula Experimental</h2>
				
				<c:forEach items="${videos}" var="video">
					<a class="aula-item" href="javascript:void(0)">
						<figure>
							<img src="${video.pathFoto}" alt="" align="middle" height="150">
							<figcaption> 
								<span> ${video.nome} Aula ${video.aula} Bloco ${video.bloco} - ${video.disciplina.nome } - ${video.professor.nome}</span>
								</figcaption>
						</figure>
					</a>
				</c:forEach>
				
			</section><!-- end section aulas -->
			<section id="noticias" class="span5">
					<h2 class="titulo-padrao" title="Notícias">Notícias</h2>
					<c:forEach items="${noticias}" var="noticia">
						
						<article class="noticias-item">
							<a href="${root}/noticia/${noticia.url}" title="${noticia.titulo}">
								<div class="side-left-article">
									<fmt:formatDate value="${noticia.data.time}" pattern="dd" var="diaNoticia" />
									<fmt:formatDate value="${noticia.data.time}" pattern="MMM" var="mesNoticia" />
									<span class="dia clear">${diaNoticia}</span> <span class="mes clear">${fn:toUpperCase(mesNoticia)}</span>
								</div>
								<div class="side-right-article">
									<h4>${noticia.titulo}</h4>
									<p>${noticia.resumo}</p>
								</div>
							</a>
						</article>
					</c:forEach>
					
					<a href="${root}/noticia/lista" title="Ver Todos" id="ver-noticias">Ver Todas</a>
			</section>
			<section id="concursos" class="span5">
				<h2 class="titulo-padrao" title="Agenda">Agenda</h2>
				
				<c:forEach items="${agendas}" var="agenda">
					<article class="noticias-item">
						<a href="${root}/agenda/${agenda.url}" title="${agenda.titulo }">
							<div class="side-right-article">
								<p>${agenda.titulo}</p>
								<h4>${agenda.resumo}</h4>
							</div>
						</a>
					</article>
				</c:forEach>

				<a href="teste" title="Ver Todos" id="ver-noticias">Ver Todos</a>
			</section>
			<section id="noticias" class="span5">
					<h2 class="titulo-padrao" title="Artigos">Artigos</h2>
					
					<c:forEach items="${artigos}" var="artigo">
						
						<article class="noticias-item">
							<a href="${root}/artigo/${artigo.url}" title="${artigo.titulo}">
								<div class="side-left-article">
									<fmt:formatDate value="${artigo.data.time}" pattern="dd" var="diaNoticia" />
									<fmt:formatDate value="${artigo.data.time}" pattern="MMM" var="mesNoticia" />
									<span class="dia clear">${diaNoticia}</span> <span class="mes clear">${fn:toUpperCase(mesNoticia)}</span>
								</div>
								<div class="side-right-article">
									<h4>${artigo.titulo}</h4>
									<p>${artigo.resumo}</p>
								</div>
							</a>
						</article>
					</c:forEach>
				
					<a href="${root}/artigos/lista" title="Ver Todos" id="ver-noticias">Ver Todos</a>
			</section>
			<section id="concursos" class="span5">
				<h2 class="titulo-padrao" title="Rompendo no Twitter">Rompendo no Twitter</h2>
				<div class="twitter-widget">
					<div id="tweecool"></div>
				</div>

				<a href="http://twitter.com/@gsarruda" target="_blank" title="Seguir" id="ver-noticias">Seguir</a>
			</section>
		</aside>
		<aside id="aside-right" class="" style="overflow:auto">
			<section id="box-tools">
				<h2 class="titulo-rompendo" title="Rompendo com você">Rompendo com você</h2>
				<p>Entre agora e construa aqui o seu sucesso!</p>
				
				<c:forEach items="${menusLateral1}" var="menu">
					<a href="${menu.url }" class="link-oab">${menu.nome }</a>
				</c:forEach>
				
				<%-- <a href="" class="link-oab">oab</a>
				<a href="${root}/produto/lista" class="link-cursos">cursos</a>
				<a href="" class="link-concursos">concursos</a> --%>
				
			</section>
			<section id="romper-tv">
				<h2 class="titulo-padrao" title="TV Romper">TV Romper</h2>
				<iframe width="340" height="150" src="//www.youtube.com/embed/${youtube.chave}" frameborder="0" allowfullscreen></iframe>
			</section>
			<section id="corpo-docente" class="">
				<h2 class="titulo-padrao" title="Corpo Docente">Corpo Docente</h2>
				<script type="text/javascript">
				jQuery(function($) {
					$('ul#items').easyPaginate({
						step : 3,
						auto : false,
						loop : false,
						clickstop : false,
						pause : 8000
					});
				});
				</script>

				<ul id="items" class="">
				    <c:forEach items="${professores}" var="professor">
						<li>
							<p class="image">
								<a href="professor/${professor.url}"> <img src="${professor.pathFoto}" alt="${professor.nome}" class="cycle polaroid shadow" style="width: 125px; height: 125px;" />
								</a>
							</p>
							<h3>${professor.nome}</h3>
						</li>
					</c:forEach>
				</ul>
			</section>
			<section id="facebook">
				<h2 class="titulo-padrao" title="Rompendo no Facebook">Facebook</h2>
				<div id="fb-root"></div>
					<script>(function(d, s, id) {
		  			var js, fjs = d.getElementsByTagName(s)[0];
		  			if (d.getElementById(id)) {return;}
		  			js = d.createElement(s); js.id = id;
		  			js.src = "//connect.facebook.net/pt_BR/all.js#xfbml=1";
		  			fjs.parentNode.insertBefore(js, fjs);
					}(document, 'script', 'facebook-jssdk'));
					</script>
				<div class="fb-like-box" data-href="http://www.facebook.com/McProjota" data-width="338" data-height="422" data-show-faces="true" data-border-color="#cccccc" data-stream="false" data-header="false"></div>
	      </section><!-- end facebook -->

		</aside><!-- /end aside-right -->
	</div><!-- end container -->

	<%@include file="geral/footer.jsp"%>

</body>
</html>
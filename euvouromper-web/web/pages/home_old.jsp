<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<%@include file="geral/header-includes.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<fmt:setLocale value="pt-BR" />

<body class="metro" style="">

	<%@include file="geral/header-banner.jsp"%>

	<div class="container" style="padding: 10px">
		<div class="metro one-column">
			<h2 class="titles-big title-professores">Professores</h2>
			<script type="text/javascript">
				jQuery(function($) {
					$('ul#items').easyPaginate({
						step : 5,
						auto : true,
						loop : true,
						clickstop : false,
						pause : 8000
					});
				});
			</script>

			<div id="container" class="clear">
				<ul id="items" class="">
					<c:forEach items="${professores}" var="professor">
						<li>
							<p class="image">
								<a href="professor/${professor.url}"> <img src="${professor.pathFoto}" alt="${professor.nome}" class="cycle polaroid shadow" style="width: 180px; height: 180px;" />
								</a>
							</p>
							<h3>${professor.nome}</h3>
						</li>
					</c:forEach>
				</ul>
			</div>
			<!-- end professores -->

			<div class="metro four-column clear">
				<h2 class="titles-big title-cursos">Cursos</h2>

				<c:forEach items="${produtos}" var="produto">

					<article class="cursos-item">
						<figure>
							<img src="${produto.pathFoto}" alt="${produto.nome}" class="">
							<figcaption></figcaption>
						</figure>
						<div class="title-curso-item">
							<h5>${produto.nome}</h5>
						</div>
						<div class="footer-curso">
							<span><fmt:formatNumber value="${produto.valor}" minFractionDigits="2" type="currency" /></span> 
							<a href="${root}/produto/${produto.url}" class="saiba-mais-curso" title="Saiba mais">saiba mais</a>
						</div>
					</article>
				</c:forEach>

			</div>
			<!-- end cursos -->

			<hr class="line"></hr>

			<div class="metro one-column clear">
				<h2 class="titles-big title-aulas-gratuitas">Aula experimental</h2>

				<c:forEach items="${videos}" var="video">
					<article class="aulas-item">
						<a href="" title=""><img src="${video.pathFoto}" width="220" height="136" alt="" style="max-height: 160px;"></a>
						<div class="aulas-content">
							<h4>${video.nome} Aula ${video.aula} Bloco ${video.bloco}</h4>
							<a href="#" class="assistir" title="Assistir à aula">Assistir à aula</a>
						</div>
					</article>
				</c:forEach>
			</div>
			<!-- end Aulas -->

			<div class="metro one-column clear last-box">

				<section id="noticias" class="box3">
					<h2 class="titles-big title-noticias">Notícias</h2>

					<c:forEach items="${noticias}" var="noticia">
						<article>
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
					
				</section>
				
				<!-- end noticias -->

				<section id="noticias" class="box3">
					<h2 class="titles-big title-depoimentos">Depoimentos</h2>

					<div id="depoimentos">
						<div class="content-depoimentos">
							<p>${depoimento.texto}</p>
							<h5 class="autor">${depoimento.nome}</h5>
						</div>
					</div>

				</section>
				<!-- end noticias -->

				<section id="noticias" class="box3">
					<h2 class="titles-big title-tv">TV</h2>
					<iframe width="347" height="248" src="https://www.youtube.com/embed/${youtube.chave}?rel=0" frameborder="0" allowfullscreen></iframe>
				</section>
				<!-- end noticias -->
			</div>
		</div>
	</div>
	<!-- end container -->

	<%@include file="geral/footer.jsp"%>

</body>
</html>
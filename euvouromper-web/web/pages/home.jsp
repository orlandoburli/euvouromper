<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<%@include file="geral/header-includes.jsp"%>

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
								<a href="professor/${professor.url}">
									<img src="${professor.pathFoto}" alt="${professor.nome}" class="cycle polaroid shadow" style="width: 180px; height: 180px;" />
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

				<article class="cursos-item">
					<figure>
						<img src="web/assets/imgs/figure.png" alt="">
						<figcaption></figcaption>
					</figure>
					<div class="title-curso-item">
						<h5>Concurso - Polícia Rodoviária Federal Ag. Adm</h5>
					</div>
					<div class="footer-curso">
						<span>R$ 1.200,00</span> <a href="#" class="saiba-mais-curso" title="Saiba mais">saiba mais</a>
					</div>
				</article>

				<article class="cursos-item">
					<figure>
						<img src="web/assets/imgs/figure.png" alt="">
						<figcaption></figcaption>
					</figure>
					<div class="title-curso-item">
						<h5>Concurso - Polícia Rodoviária Federal Ag. Adm</h5>
					</div>
					<div class="footer-curso">
						<span>R$ 1.200,00</span> <a href="#" class="saiba-mais-curso" title="Saiba mais">saiba mais</a>
					</div>
				</article>

				<article class="cursos-item">
					<figure>
						<img src="web/assets/imgs/figure.png" alt="">
						<figcaption></figcaption>
					</figure>
					<div class="title-curso-item">
						<h5>Concurso - Polícia Rodoviária Federal Ag. Adm</h5>
					</div>
					<div class="footer-curso">
						<span>R$ 1.200,00</span> <a href="#" class="saiba-mais-curso" title="Saiba mais">saiba mais</a>
					</div>
				</article>

				<article class="cursos-item">
					<figure>
						<img src="web/assets/imgs/figure.png" alt="">
						<figcaption></figcaption>
					</figure>
					<div class="title-curso-item">
						<h5>Concurso - Polícia Rodoviária Federal Ag. Adm</h5>
					</div>
					<div class="footer-curso">
						<span>R$ 1.200,00</span> <a href="#" class="saiba-mais-curso" title="Saiba mais">saiba mais</a>
					</div>
				</article>
			</div>
			<!-- end cursos -->

			<hr class="line"></hr>

			<div class="metro one-column clear">
				<h2 class="titles-big title-aulas-gratuitas">Aulas gratuitas</h2>

				<article class="aulas-item">
					<a href="" title=""><img src="web/assets/imgs/example-videos.jpg" width="220" height="136" alt=""></a>
					<div class="aulas-content">
						<h4>Direito Constitucional Aplicado</h4>
						<a href="#" class="assistir" title="Assistir à aula">Assistir à aula</a>
					</div>
				</article>

				<article class="aulas-item">
					<a href="" title=""><img src="web/assets/imgs/example-videos.jpg" width="220" height="136" alt=""></a>
					<div class="aulas-content">
						<h4>Direito Constitucional Aplicado</h4>
						<a href="#" class="assistir" title="Assistir à aula">Assistir à aula</a>
					</div>
				</article>

				<article class="aulas-item">
					<a href="" title=""><img src="web/assets/imgs/example-videos.jpg" width="220" height="136" alt=""></a>
					<div class="aulas-content">
						<h4>Direito Constitucional Aplicado</h4>
						<a href="#" class="assistir" title="Assistir à aula">Assistir à aula</a>
					</div>
				</article>

				<article class="aulas-item">
					<a href="" title=""><img src="web/assets/imgs/example-videos.jpg" width="220" height="136" alt=""></a>
					<div class="aulas-content">
						<h4>Direito Constitucional Aplicado</h4>
						<a href="#" class="assistir" title="Assistir à aula">Assistir à aula</a>
					</div>
				</article>

			</div>
			<!-- end Aulas -->

			<div class="metro one-column clear last-box">

				<section id="noticias" class="box3">
					<h2 class="titles-big title-noticias">Notícias</h2>
					<article>
						<a href="#" title="ADVOGADO LANÇA LIVRO DE 7,5 METROS">
							<div class="side-left-article">
								<span class="dia clear">06</span> <span class="mes clear">NOV</span>
							</div>
							<div class="side-right-article">
								<h4>ADVOGADO LANÇA LIVRO DE 7,5 METROS</h4>
								<p>Em protesto advogado lança livro gigante. Ele dedicou 23 anos na obra.</p>
							</div>
						</a>
					</article>


					<article>
						<a href="#" title="ADVOGADO LANÇA LIVRO DE 7,5 METROS">
							<div class="side-left-article">
								<span class="dia clear">06</span> <span class="mes clear">NOV</span>
							</div>
							<div class="side-right-article">
								<h4>ADVOGADO LANÇA LIVRO DE 7,5 METROS</h4>
								<p>Em protesto advogado lança livro gigante. Ele dedicou 23 anos na obra.</p>
							</div>
						</a>
					</article>


				</section>
				<!-- end noticias -->

				<section id="noticias" class="box3">
					<h2 class="titles-big title-depoimentos">Depoimentos</h2>

					<div id="depoimentos">
						<div class="content-depoimentos">
							<p>"É um fato conhecido de todos que um leitor se distrairá com o conteúdo de texto legível de uma página quando estiver examinando sua diagramação. A vantagem de usar Lorem Ipsum é que ele tem uma distribuição normal de letras, ao contrário de “Conteúdo aqui, conteúdo aqui...”.</p>

							<h5 class="autor">Gustavo Santos Arruda, Analista de Sistemas - Ábaco Tecnologia de Informação</h5>
						</div>
					</div>

				</section>
				<!-- end noticias -->

				<section id="noticias" class="box3">
					<h2 class="titles-big title-tv">TV</h2>
					<iframe width="347" height="248" src="https://www.youtube.com/embed/kGgTuEcuOoI?rel=0" frameborder="0" allowfullscreen></iframe>
				</section>
				<!-- end noticias -->
			</div>
		</div>
	</div>
	<!-- end container -->

	<%@include file="geral/footer.jsp"%>

</body>
</html>
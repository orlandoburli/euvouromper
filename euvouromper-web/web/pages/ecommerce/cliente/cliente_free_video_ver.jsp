<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:set var="root" value="<%=request.getServletContext().getContextPath()%>" />

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<%@include file="../../geral/header-includes.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<fmt:setLocale value="pt-BR" />

<body class="metro" style="">

	<%@include file="../../geral/header-geral.jsp"%>

	<div class="container" style="padding: 10px">
		<div class="metro one-column">
			
			<h2 class="titles-big linha-h2">${video.nome}</h2>

			<div style="text-align: center;">
				<iframe src="<%= request.getContextPath() %>/flex/index.html?v=${urlVideo}&i=${item}&nome=${nomeCliente64}&cpf=${cpfCliente64}" frameborder="0" width="500" height="300"> </iframe>
			</div>
			
			<blockquote>
				<div class="input-control text size4 ">
					<div class="input-control text size4">
						<span class="item-title-secondary">${video.nome} Aula ${video.aula} Bloco ${video.bloco}</span>
					</div>
				</div>
				
				<div class="input-control text size4 block">
					<p>Professor: ${video.professor.nome}</p>
				</div>
				
				<div class="input-control text size4 block">
					<p>Disciplina: ${video.disciplina.nome}</p>
				</div>
				
			</blockquote>
						
			
			
			<section id="aula-experimental" class="" style="overflow: auto;">
				<h2 class="titulo-padrao" title="Aula Experimental">Outras aulas experimentais</h2>
				
				<c:forEach items="${videos}" var="video">
					<a class="aula-item" href="${root}/video/free/${video.idVideo}">
						<figure>
							<img src="${video.pathFoto}" alt="" align="middle" height="150">
							<figcaption> 
								<span> ${video.nome} Aula ${video.aula} Bloco ${video.bloco} - ${video.disciplina.nome } - ${video.professor.nome}</span>
								</figcaption>
						</figure>
					</a>
				</c:forEach>
				
			</section><!-- end section aulas -->		
		</div>
		<!-- end  -->
	</div>
	<!-- end container -->
	
	

	<%@include file="../../geral/footer.jsp"%>

</body>
</html>
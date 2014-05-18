
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<fmt:setLocale value="pt-BR" />

<c:set var="root" value="<%=request.getServletContext().getContextPath()%>" />

<div class="panel">
	<div class="panel-header">Compra individual</div>

	<div class="panel-content">
		<div class="grid">
			<div class="row">
				<div class="input-control text size4 ">
					<div class="input-control text size4">
						<span class="item-title-secondary">Título: ${video.nome} Aula ${video.aula} Bloco ${video.bloco}</span>
					</div>
				</div>

				<div class="input-control text size4 block">
					<p>Professor: ${video.professor.nome}</p>
				</div>

				<div class="input-control text size4 block">
					<p>Disciplina: ${video.disciplina.nome}</p>
				</div>
			</div>

			<div class="row">
				<span class="span3 text-right item-title">Seu saldo:</span> <span class="span3 text-left item-title"><fmt:formatNumber value="${saldo}" minFractionDigits="2" type="currency" /></span>
			</div>
			<div class="row">
				<span class="span3 text-right item-title">Valor do vídeo:</span> <span class="span3 text-left item-title"><fmt:formatNumber value="${produto.valor}" minFractionDigits="2" type="currency" /></span>
			</div>
			
			<c:if test="${not empty erro}">
				<c:set var="classe" value="fg-crimson"/>
			</c:if>
			
			<div class="row">
				<span class="span3 text-right item-title ${classe}">Saldo final:</span> 
				<span class="span3 text-left item-title ${classe}"><fmt:formatNumber value="${saldoPrevisto}" minFractionDigits="2" type="currency" /></span>
			</div>

			<div class="row">
				<div class="span6 right final">
					<c:if test="${empty erro }">
						<a style="" href="#" title="Comprar vídeo individual" class="adicionar-carrinho confirmar-compra-video">Confirmar compra</a>
					</c:if>

					<c:if test="${not empty erro}">
						<div class="notice marker-on-top bg-crimson fg-white">${erro}</div>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</div>


<script type="text/javascript">
	$(".confirmar-compra-video").click(function(e) {
		// aluno.video.comprar.page
		
		$.ajax({
			url : '${root}/aluno.video.comprar.page?idVideo=${video.idVideo}',
			type : 'POST',
			success : function(data) {
				
				var retorno = $.parseJson(data);
				
				if (retorno.sucesso) {
					$.Dialog.close();
					window.location.href = window.location.href;
				} else {
					$(".final").append("<div class='notice marker-on-top bg-crimson fg-white'>"+retorno.mensagem+"</div>");
				}
			}
		});
	});
</script>
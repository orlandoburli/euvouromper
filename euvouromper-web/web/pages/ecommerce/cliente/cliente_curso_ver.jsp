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

			<%@include file="header-aluno.jsp"%>

			<div class="clear margin-top">
				<div id="tabela-mensagens" class="panel margin-top" style="overflow: auto">
					<div class="panel-header bg-lightBlue fg-white">
						<c:if test="${produto.tipoProduto eq PACOTE}">
							Pacote: ${produto.pacote.nome}	
						</c:if>
						<c:if test="${produto.tipoProduto eq MODULO}">
							Módulo: ${produto.modulo.nome}
						</c:if>

					</div>
					<div class="panel-content">
						<div class="grid">
							<div class="row">
								<div class="span6">

									<c:if test="${produto.tipoProduto eq PACOTE}">
										<div class="listview-outlook" data-role="listview">
											<h3>Conteúdo</h3>
											<c:forEach items="${produto.pacote.modulos}" var="modulo">
												<div class="list-group collapsed">
													<a href="" class="group-title ">${modulo.nome}</a>
													<div class="group-content">

														<c:set var="statusVideo" value="" />

														<c:if test="${not empty produto.item}">
															<c:set var="statusVideo" value="video-novo" />
														</c:if>

														<c:forEach items="${modulo.videos}" var="video">
															<a href="#conteudo-video" class="ver-video list ${statusVideo}" data-id-video="${video.idVideo}" data-id-item-pedido="${produto.item.idItemPedido}">
																<div class="list-content">
																	<span class="list-title">${video.nome} - Aula ${video.aula } Bloco ${video.bloco }</span>
																	<span class="list-subtitle">Disciplina: ${video.disciplina.nome }</span>
																	<span class="list-remark">Professor: ${video.professor.nome}</span>
																</div>
															</a>
														</c:forEach>
													</div>
												</div>
											</c:forEach>

										</div>
									</c:if>

								</div>

								<div class="span6">
									<h3>Vídeo</h3>
									
									<div id="conteudo-video">
										<!-- CONTEUDO DO PLAYER DINAMICO -->
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>

		<!-- end noticias -->
	</div>
	<!-- end container -->
	<%@include file="../../geral/footer.jsp"%>

	<script type="text/javascript">
	
		$(".ver-video").click(function(e) {
			var idVideo = $(this).attr("data-id-video");
			var idItemPedido = $(this).attr("data-id-item-pedido");
			var tempo = 250;
			
			console.log("Vídeo: " + idVideo);
			console.log("Item Pedido: " + idItemPedido);
			
			// Load ajax
			
			var params = {};
			
			$.ajax({
				url : '${root}/aluno.video.page?v=' + idVideo + '&i=' + idItemPedido,
				type : 'POST',
				data : params,
				beforeSend : function(data) {
					/* console.log("loading..."); */
				},
				success : function(data) {
					/* console.log("sucesso"); */
					
					/* console.log(data); */
					var tempo = 250;
					$("#conteudo-video").fadeOut(tempo);

					setTimeout(function() {
						$("#conteudo-video").html(data);
						$("#conteudo-video").fadeIn(tempo);
					}, tempo);
					
					/* console.log("carregou"); */
				},
				error : function(erro) {
					console.log("Erro no load ajax! " + erro);
				}
			});
			
			
		});
	
	</script>

</body>
</html>
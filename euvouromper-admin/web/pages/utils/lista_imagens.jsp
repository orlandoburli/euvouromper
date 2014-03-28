<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Formulario de imagens -->
<div id="selecao_imagem" class="modal fade" tabindex="-1" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title">
					<i class="icon-images"></i> Banco de imagens
				</h4>
			</div>

			<div class="modal-body with-padding">
				<div class="tabbable">
					<ul class="nav nav-tabs">
						<li class="active"><a href="tabListaImagens" data-toggle="tab"><i class="icon-download"></i>Lista de imagens</a></li>
						<li><a href="tabEnviarImagens" data-toggle="tab"><i class="icon-windows8"></i>Enviar imagens</a></li>
					</ul>

					<div class="tab-content">
						<div class="tab-pane fade in active" id="tabListaImagens">

							<c:set var="contador" value="-1" />

							<div class="row">
								<c:forEach var="file" items="${files}">

									<c:set var="contador" value="${contador + 1 }" />

									<c:if test="${contador eq 4}">
										<c:set var="contador" value="0" />
							</div>
							<div class="row">
								</c:if>

								<div class="ItemImagem col-lg-3 col-md-4 col-sm-4">
									<div class="block">
										<div class="thumbnail thumbnail-boxed">
											<div class="thumb" style="width: 120px; height: 90px;">
												<img alt="" src="${file.webPath}" class="img-thumbnail" style="max-height: 90px; max-width: 120px; width: auto; height: auto;">
											</div>
											<div class="caption">
												<span><strong>${file.fileName}</strong></span><br/> 
												<span><strong>Tamanho:</strong> ${file.longSize }</span><br/>
												<span><strong>Formato:</strong> ${file.extension}</span><br/>
												<button data-image-value="${file.webPath}" type="button" class="BotaoRetornarImagem btn btn-primary btn-xs"><i class="icon-image2"></i> Selecionar</button>
											</div>
										</div>
									</div>
									
								</div>
								</c:forEach>
							</div>
						</div>

						<div class="tab-pane body fade" id="tabEnviarImagens"></div>
					</div>
				</div>

				<div class="modal-footer">
					<button class="btn btn-warning" data-dismiss="modal">Fechar</button>
				</div>
			</div>
		</div>
	</div>
	<!-- /modal with tabs -->
</div>

<script type="text/javascript">
	$(".BotaoRetornarImagem").click(function(e) {
		var file         = $(e.currentTarget).attr("data-image-value")
		var imgRetorno   = $("#selecao_imagem").attr("data-image-retorno");
		var inputRetorno = $("#selecao_imagem").attr("data-input-retorno");
		
		console.log("Arquivo selecionado: " + file);
		console.log(imgRetorno);
		console.log(inputRetorno);
		
		$(imgRetorno).attr("src", file);
		$(inputRetorno).attr("value", file);
		
		// Forca esconder o modal
		$('#selecao_imagem').modal('hide');
	});
</script>
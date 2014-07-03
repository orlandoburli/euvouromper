<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
						<li class="active"><a id="listaImagensLink" href="#tabListaImagens" data-toggle="tab"><i class="icon-windows8"></i>Lista de imagens</a></li>
						<li><a id="listaImagensUpload" href="#tabEnviarImagens" data-toggle="tab"><i class="icon-cloud-upload"></i>Enviar imagens</a></li>
					</ul>

					<div class="tab-content">
						<div class="tab-pane fade in active" id="tabListaImagens">
							<!-- Load dinamico -->
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
	// Load da pagina no click
	$("#listaImagensLink").click(function(e) {
		loadImagens();
	});

	$("#listaImagensUpload").click(function(e) {
		$("#tabEnviarImagens").load("listaimagem.upload.admin");
		
		setTimeout(function() {
			$(".multiple-uploader-images").pluploadQueue({
				runtimes : 'html5, html4',
				url : 'upload/images',
				chunk_size : '1mb',
				unique_names : false,
				filters : {
					max_file_size : '10mb',
					mime_types : [ {
						title : "Image files",
						extensions : "jpg,gif,png,bmp"
					}, {
						title : "Zip files",
						extensions : "zip"
					} ]
				}
			});
		}, tempo * 5);
	});
	
	function loadImagens() {
		$("#tabListaImagens").load("listaimagem.datatable.admin", function(response, status, xhr) {
			oTable = $('.datatable-images table').dataTable({
				"bJQueryUI" : false,
				"bAutoWidth" : false,
				"iDisplayLength" : 5,
				"sPaginationType" : "full_numbers",
				"sDom" : '<"datatable-header"fl><"datatable-scroll"t><"datatable-footer"ip>',
				"oLanguage" : {
					"sSearch" : "<span>Filtrar:</span> _INPUT_",
					"sLengthMenu" : "",
					"oPaginate" : {
						"sFirst" : "Primeiro",
						"sLast" : "Último",
						"sNext" : ">",
						"sPrevious" : "<"
					}
				},
				"fnDrawCallback" : function() {
					loadClickFunction();
				}
			});
		});
		
		setTimeout(function() {
			/* oTable = $('.datatable-images table').dataTable({
				"bJQueryUI" : false,
				"bAutoWidth" : false,
				"iDisplayLength" : 5,
				"sPaginationType" : "full_numbers",
				"sDom" : '<"datatable-header"fl><"datatable-scroll"t><"datatable-footer"ip>',
				"oLanguage" : {
					"sSearch" : "<span>Filtrar:</span> _INPUT_",
					"sLengthMenu" : "",
					"oPaginate" : {
						"sFirst" : "Primeiro",
						"sLast" : "Último",
						"sNext" : ">",
						"sPrevious" : "<"
					}
				},
				"fnDrawCallback" : function() {
					loadClickFunction();
				}
			}); */
			
			// Seta funcao do clique do botao de retornar a imagem
			///loadClickFunction();
			
			/* // Ao paginar, chamar evento para dar funcao de click dos botoes, pois sao re-renderizados na paginacao.
			$(".datatable-images table").bind("page", function() {
				setTimeout(function() {
					loadClickFunction();
				}, tempo * 3);
			});
			
			// Ao filtrar, chamar evento para dar funcao de click dos botoes, pois sao re-renderizados na paginacao.
			$(".datatable-images table").bind("filter", function() {
				setTimeout(function() {
					loadClickFunction();
				}, tempo * 3);
			});
			
			// Ao ordenar, chamar evento para dar funcao de click dos botoes, pois sao re-renderizados na paginacao.
			$(".datatable-images table").bind("sort", function() {
				setTimeout(function() {
					loadClickFunction();
				}, tempo * 3);
			}); */

			$(".dataTables_wrapper tfoot input").keyup(function() {
				oTable.fnFilter(this.value, $(".dataTables_wrapper tfoot input").index(this));
			});

			$('.dataTables_filter input[type=text]').attr('placeholder','Digite o valor da pesquisa...');
			
		}, tempo);
	}
	
	function loadClickFunction() {
		debug("load click function");
		
		$(".BotaoRetornarImagem").click(function(e) {
			debug("Clique botao retornar imagem");
			
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

			// Remove-te a ti mesmo...
			$("#caixa_selecao_imagem").remove();
			
			debug("Imagem selecionada");
		});
	}
</script>

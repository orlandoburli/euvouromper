<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../../../header-title.jsp"%>

<div class="panel panel-body">
	<form class="form-horizontal" action="#" role="form">
		<div class="FormularioCadastro FormularioGeral panel panel-default form-group" data-page-consulta="materialapoioconsulta.admin" data-page-operacao="${operacao}" data-page-cadastro="materialapoiocadastro.admin">
			<div class="panel-body">
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">C&oacute;digo</label>
					<div class="col-sm-7">
						<input id="idMaterialApoio" type="text" disabled="disabled" class="form-control" value="${vo.idMaterialApoio }" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Nome</label>
					<div class="col-sm-7">
						<input id="nome" type="text" value="${vo.nome}" autofocus="autofocus" class="form-control" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Módulo</label>

					<div class="col-sm-7">
						<select id="idModulo"  data-field-value="${vo.idModulo}">
							<c:forEach var="modulo" items="${modulos}">
								<option value="${modulo.idModulo}">${modulo.nome}</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Arquivo Vídeo</label>
					<div class="col-sm-7">
						<input id="arquivo" type="text" value="${vo.arquivo}" class="form-control" disabled="disabled" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Upload</label>
					<div class="col-sm-7">
						<div class="panel">
							<div class="block">
								<div class="multiple-uploader-materialapoios with-header">Seu browser nao suporta upload nativo.</div>
							</div>
						</div>
					</div>
				</div>
				
				<%@include file="../../utils/lista_imagens.jsp"%>
				<%@include file="../../../botoes-cadastro.jsp"%>
			</div>
		</div>
	</form>
</div>

<script type="text/javascript">
	setTimeout(function() {
		$(".multiple-uploader-materialapoios").pluploadQueue({
			runtimes : 'html5, html4',
			url : 'upload/materialapoio',
			chunk_size : '100mb',
			unique_names : false,
			filters : {
				max_file_size : '100mb',
				mime_types : [ {
					title : "Materiais de Apoio files",
					extensions : "pdf"
				} ]
			},
			resize : {
				width : 320,
				height : 240,
				quality : 90
			},
			init : {
				FileUploaded: function(up, files, object) {
					var myData;
				    try {
				        myData = eval(object.response);
				    } catch(err) {
				        myData = eval('(' + object.response + ')');
				    }
				    
				    $("#arquivo").val(myData.arquivo);
				    
				    //alert(myData.arquivo);
					//var retorno = $.parseJSON(response);
	                // Called when all files are either uploaded or failed
	                //console.log('[FileUploaded] ' + up + ' - ' + files + ' - ' + response.response);
	            },
			}
		});
	});
</script>
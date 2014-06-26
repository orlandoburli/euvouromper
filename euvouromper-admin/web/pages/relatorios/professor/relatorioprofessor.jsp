<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Datatable inside panel body -->

<%@include file="../../../header-title.jsp"%>


<div class="panel panel-body">
	<form class="form-horizontal" action="#" role="form">
		<div class="FormularioCadastro FormularioGeral panel panel-default form-group" data-page-consulta="disciplinaconsulta.admin" data-page-operacao="${operacao}" data-page-cadastro="disciplinacadastro.admin">
			<div class="panel-body">
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Mês: </label>
					<select id="mes" class="col-sm-7 select">
						<c:forEach var="mes" items="${meses}">
							<option value="${mes.valor}">${mes.descricao}</option>
						</c:forEach>
					</select>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Ano: </label>
					<select id="ano" class="col-sm-7 select">
						<c:forEach var="ano" items="${anos}">
							<option value="${ano.valor}">${ano.descricao}</option>
						</c:forEach>
					</select>
				</div>
				
				<%@include file="../../../botoes-relatorio.jsp"%>
			</div>
		</div>
	</form>
</div>

<script type="text/javascript">
	$(".BotaoImprimir").click(function() {
		/* $.post(url, function (data) {
		    var win=window.open('about:blank');
		    with(win.document)
		    {
		      open();
		      write(data);
		      close();
		    }
		}); */
		
		/* var params = {
			'operacao' : 'pdf'
		}; */
		
		var params = "?operacao=view";

		// Loop nos input's do form para enviar
		debug("Parametros do metodo salvar");
		
		$("input,select,textarea").each(function(index) {
			params += "&" + $(this).attr("id") + "=" + $(this).val();
			//params[$(this).attr("id")] = $(this).val();
			//debug($(this).attr("id") + ' = ' + $(this).val());
		});
		
		window.open('relatorioprofessor.view.admin' + params);
		
/* 		$.ajax({
			url : 'relatorioprofessor.view.admin',
			type : 'POST',
			data : params,
			beforeSend : function(data) {
				// debug("loading...");
			},
			success : function(data) {
				var win=window.open('about:blank', 'pdf');
			    with(win.document)
			    {
			      open();
			      write(data);
			      close();
			    }
			},
			error : function(erro) {
				debug("Erro no load ajax! " + erro);
			}
		}); */
	});
</script>
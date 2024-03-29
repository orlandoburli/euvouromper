<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Datatable inside panel body -->

<%@include file="../../../header-title.jsp"%>

<div class="panel panel-default panel-body">
	<div class="panel form-group">
		<div class="col-md-1 text-right">
			<label class="control-label text-right">Pesquisar por: </label>
		</div>
		<div class="col-sm-2">
			<select id="ParametroPesquisa" class="select">
				<option value="Modulo">M�dulo</option>
			</select>
		</div>

		<div class="col-sm-3">
			<input id="PesquisarPor" type="text" autofocus="autofocus" autocomplete="off" class="form-control" tabindex="3" />
		</div>

		<div class="col-sm-2 ">
			<button tabindex="4" title="Clique para pesquisar [Atalho: ENTER]" class="BotaoPesquisar btn btn-default">Pesquisar</button>
		</div>
		<div class="col-sm-10"></div>
	</div>

	<c:set var="hideEditar" value="true" />

	<c:set var="customButtons">
		<button title="Voltar para a consulta de pacotes" class="BotaoVoltarPacote btn btn-lg btn-success tip">
			<i class="icon-undo2"></i> Voltar para Pacotes
		</button>
	</c:set>

	<div class="panel-body">
		<div class="DataGridConsulta" data-page="pacotemoduloconsulta.grid.admin" data-page-size="8" data-detail-page="pacotemodulocadastro.admin"></div>

		<c:if test="${usuario.perfil.permissaoPacoteAlt eq 'S'}">
			<%@include file="../../../botoes-consulta.jsp"%>
		</c:if>
	</div>

</div>
<!-- /datatable inside panel body -->
<script type="text/javascript">
	$(".BotaoVoltarPacote").click(function() {
		var paginaAcoes = "pacoteconsulta.admin";
		loadPage(paginaAcoes);
		loadJs("web/pages/js/consulta.js");
		loadJs("web/pages/js/load.js");
	});
</script>
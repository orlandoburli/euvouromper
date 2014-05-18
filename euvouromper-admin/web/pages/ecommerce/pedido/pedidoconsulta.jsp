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
				<option value="Nome">Nome</option>
				<option value="Email">Email</option>
				<option value="Codigo">Código</option>
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
	<c:set var="hideNovo" value="true" />
	<c:set var="hideExcluir" value="true" />

	<c:set var="customButtons">
		<button title="Visualizar dados do pedido" class="BotaoVisualizarPedido btn btn-lg btn-primary tip">
			<i class="icon-glasses3"></i> Visualizar pedido
		</button>
	</c:set>

	<div class="panel-body">
		<div class="DataGridConsulta" data-page="pedidoconsulta.grid.admin" data-page-size="8" data-detail-page="pedidocadastro.admin"></div>
		
		<%@include file="../../../botoes-consulta.jsp"%>
	</div>

	<script type="text/javascript">
		$(".BotaoVisualizarPedido").click(function() {
			acaoCustomizada('visualizar');
		});
	</script>

</div>
<!-- /datatable inside panel body -->
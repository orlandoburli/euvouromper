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
				<option value="Codigo">C�digo</option>
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

	<div class="panel-body">
		<div class="DataGridConsulta" data-page="professorconsulta.grid.admin" data-page-size="8" data-detail-page="professorcadastro.admin"></div>
	</div>
	
	<!-- Botoes customizados -->
	<c:set var="customButtons">
		<button type="button" class="BotaoProdutos btn btn-lg btn-warning tip" title="Produtos do professor">
			<i class="icon-cube2"></i> Produtos
		</button>
	</c:set>

	<c:if test="${usuario.perfil.permissaoProfessorAlt eq 'S'}">
		<%@include file="../../../botoes-consulta.jsp"%>
	</c:if>
</div>
<!-- /datatable inside panel body -->

<script type="text/javascript">
	$(".BotaoProdutos").click(function() {
		if (!registroSelecionado()) {
			return;
		}

		var paginaAcoes = "professorprodutoconsulta.admin?" + getSelectedDataId();
		loadPage(paginaAcoes);
		loadJs("web/pages/js/consulta.js");
		loadJs("web/pages/js/load.js");
	});
</script>
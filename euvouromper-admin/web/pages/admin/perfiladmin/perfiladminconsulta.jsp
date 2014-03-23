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

	<div class="panel-body">
		<div class="DataGridConsulta" data-page="perfiladminconsulta.grid.admin" data-page-size="10" data-detail-page="perfiladmincadastro.admin"></div>
	</div>

	<div class="FormularioBotoes form-actions text-right">
		<button type="button" class="BotaoNovo btn btn-lg btn-primary" title="Novo Registro (Ctrl + N)">
			<i class="icon-plus-circle"></i> Novo
		</button>

		<button type="button" class="BotaoEditar btn btn-lg btn-success" title="Editar Registro Selecionado (Ctrl + E)">
			<i class="icon-pencil4"></i> Editar
		</button>

		<button type="button" class="BotaoExcluir btn btn-lg btn-danger" title="Excluir Registro Selecionado (Ctrl + Del)">
			<i class="icon-minus-circle"></i> Excluir
		</button>
	</div>
</div>
<!-- /datatable inside panel body -->
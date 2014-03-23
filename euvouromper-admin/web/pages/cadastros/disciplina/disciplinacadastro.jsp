<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../../../header-title.jsp"%>

<div class="panel panel-body">
	<form class="form-horizontal" action="#" role="form">
		<div class="FormularioCadastro FormularioGeral panel panel-default form-group" data-page-consulta="disciplinaconsulta.admin" data-page-operacao="${operacao}" data-page-cadastro="disciplinacadastro.admin">

			<div class="form-group">
				<label class="col-sm-2 control-label text-right">C&oacute;digo</label>
				<div class="col-sm-7">
					<input id="idDisciplina" type="text" disabled="disabled" class="form-control" value="${vo.idDisciplina }" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label text-right">Nome</label>
				<div class="col-sm-7">
					<input id="nome" type="text" value="${vo.nome}" autofocus="autofocus" class="form-control" />
				</div>
			</div>

		</div>

		<div class="FormularioBotoes form-actions text-right">
			<button title="Salvar (Ctrl + S)" class="BotaoSalvar btn btn-lg btn-primary">
				<i class="icon-disk"></i> Salvar
			</button>

			<button title="Excluir (Ctrl + Del)" class="BotaoExcluir btn btn-lg btn-danger">
				<i class="icon-minus-circle"></i> Excluir
			</button>
			<button title="Voltar (Esc)" class="BotaoVoltar btn btn-lg btn-success">
				<i class="icon-undo2"></i> Voltar
			</button>
		</div>
		
	</form>
</div>
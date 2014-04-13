<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../../../header-title.jsp"%>

<div class="panel panel-body">
	<form class="form-horizontal" action="#" role="form">
		<div class="FormularioCadastro FormularioGeral panel panel-default form-group" data-page-consulta="moduloconsulta.admin" data-page-operacao="${operacao}" data-page-cadastro="modulocadastro.admin">
			<div class="panel-body">
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">C&oacute;digo</label>
					<div class="col-sm-7">
						<input id="idModulo" type="text" disabled="disabled" class="form-control" value="${vo.idModulo }" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Nome</label>
					<div class="col-sm-7">
						<input id="nome" type="text" value="${vo.nome}" autofocus="autofocus" class="form-control" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Descrição</label>
					<div class="col-sm-7">
						<input id="descricao" type="text" value="${vo.descricao}" class="form-control" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Horas</label>
					<div class="col-sm-2">
						<input id="horas" type="text" value="${vo.horas}" class="form-control spinner-default" />
					</div>
				</div>
				
				<%@include file="../../../botoes-cadastro.jsp"%>
			</div>
		</div>
	</form>
</div>
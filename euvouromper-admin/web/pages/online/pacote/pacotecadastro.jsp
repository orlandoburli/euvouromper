<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../../../header-title.jsp"%>

<div class="panel panel-body">
	<form class="form-horizontal" role="form">
		<div class="FormularioCadastro FormularioGeral panel panel-default form-group" data-page-consulta="pacoteconsulta.admin" data-page-operacao="${operacao}" data-page-cadastro="pacotecadastro.admin">

			<div class="form-group">
				<label class="col-sm-2 control-label text-right">C&oacute;digo</label>
				<div class="col-sm-7">
					<input id="idPacote" type="text" disabled="disabled" class="form-control" value="${vo.idPacote }" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label text-right">Nome</label>
				<div class="col-sm-7">
					<input id="nome" type="text" value="${vo.nome}" autofocus="autofocus" class="form-control" />
				</div>
			</div>

		</div>

		<%@include file="../../../botoes-cadastro.jsp"%>
		
	</form>
</div>
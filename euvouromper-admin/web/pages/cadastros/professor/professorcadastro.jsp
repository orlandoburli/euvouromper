<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../../../header-title.jsp"%>

<div class="panel panel-body">
	<form class="form-horizontal" action="#" role="form">
		<div class="FormularioCadastro FormularioGeral panel panel-default form-group" data-page-consulta="professorconsulta.admin" data-page-operacao="${operacao}" data-page-cadastro="professorcadastro.admin">

			<div class="form-group">
				<label class="col-sm-2 control-label text-right">C&oacute;digo</label>
				<div class="col-sm-7">
					<input id="idProfessor" type="text" disabled="disabled" class="form-control" value="${vo.idProfessor }" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label text-right">Nome</label>
				<div class="col-sm-7">
					<input id="nome" type="text" value="${vo.nome}" autofocus="autofocus" class="form-control" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label text-right">Email</label>
				<div class="col-sm-7">
					<input id="email" type="text" value="${vo.email}" class="form-control" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label text-right">Título</label>
				<div class="col-sm-7">
					<input id="titulo" type="text" value="${vo.titulo}" class="form-control" />
				</div>
			</div>

		</div>

		<%@include file="../../../botoes-cadastro.jsp"%>

	</form>
</div>
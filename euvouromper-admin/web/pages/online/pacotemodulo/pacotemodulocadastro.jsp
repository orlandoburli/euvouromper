<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../../../header-title.jsp"%>

<div class="panel panel-body">
	<form class="form-horizontal" action="#" role="form">
		<div class="FormularioCadastro FormularioGeral panel panel-default form-group" data-page-consulta="pacotemoduloconsulta.admin" data-page-operacao="${operacao}" data-page-cadastro="pacotemodulocadastro.admin">
			<div class="panel-body">
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">C&oacute;digo</label>
					<div class="col-sm-7">
						<input id="idPacoteModulo" type="text" disabled="disabled" class="form-control" value="${vo.idPacoteModulo }" /> <input id="idPacote" type="hidden" disabled="disabled" class="form-control" value="${pacoteSelecionado.idPacote }" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Pacote</label>
					<div class="col-sm-7">
						<input id="nomePacote" type="text" disabled="disabled" class="form-control" value="${pacoteSelecionado.nome}" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Módulo</label>

					<div class="col-sm-7">
						<select id="idModulo">
							<c:forEach var="modulo" items="${modulos}">
								<option value="${modulo.idModulo}">${modulo.nome}</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<%@include file="../../../botoes-cadastro.jsp"%>
			</div>
		</div>

	</form>
</div>
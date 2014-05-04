<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../../../header-title.jsp"%>

<div class="panel panel-body">
	<form class="form-horizontal" action="#" role="form">
		<div class="FormularioCadastro FormularioGeral panel panel-default form-group" data-page-consulta="modulovideoconsulta.admin" data-page-operacao="${operacao}" data-page-cadastro="modulovideocadastro.admin">
			<div class="panel-body">
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">C&oacute;digo</label>
					<div class="col-sm-7">
						<input id="idModuloVideo" type="text" disabled="disabled" class="form-control" value="${vo.idModuloVideo }" /> <input id="idModulo" type="hidden" disabled="disabled" class="form-control" value="${moduloSelecionado.idModulo }" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Módulo</label>
					<div class="col-sm-7">
						<input id="nomeModulo" type="text" disabled="disabled" class="form-control" value="${moduloSelecionado.nome}" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Vídeo</label>

					<div class="col-sm-7">
						<select id="idVideo">
							<c:forEach var="video" items="${videos}">
								<option value="${video.idVideo}">${video.nome} Aula ${video.aula} Bloco ${video.bloco}</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<%@include file="../../../botoes-cadastro.jsp"%>
			</div>
		</div>

	</form>
</div>
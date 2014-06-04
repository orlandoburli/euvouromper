<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../../../header-title.jsp"%>

<div class="panel panel-body">
	<form class="form-horizontal" action="#" role="form">
		<div class="FormularioCadastro FormularioGeral panel panel-default form-group" data-page-consulta="professorprodutoconsulta.admin" data-page-operacao="${operacao}" data-page-cadastro="professorprodutocadastro.admin">
			<div class="panel-body">
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">C&oacute;digo</label>
					<div class="col-sm-7">
						<input id="idProfessorProduto" type="text" disabled="disabled" class="form-control" value="${vo.idProfessorProduto }" /> <input id="idProfessor" type="hidden" disabled="disabled" class="form-control" value="${professorSelecionado.idProfessor }" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Professor</label>
					<div class="col-sm-7">
						<input id="nomeProfessor" type="text" disabled="disabled" class="form-control" value="${professorSelecionado.nome}" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Módulo</label>

					<div class="col-sm-7">
						<select id="idProduto">
							<c:forEach var="produto" items="${produtos}">
								<option value="${produto.idProduto}">${produto.nome}</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<%@include file="../../../botoes-cadastro.jsp"%>
			</div>
		</div>

	</form>
</div>
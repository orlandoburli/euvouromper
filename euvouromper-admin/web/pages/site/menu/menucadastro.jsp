<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../../../header-title.jsp"%>

<div class="panel panel-body">
	<form class="form-horizontal" action="#" role="form">
		<div class="FormularioCadastro FormularioGeral panel panel-default form-group" data-page-consulta="menuconsulta.admin" data-page-operacao="${operacao}" data-page-cadastro="menucadastro.admin">

			<div class="form-group">
				<label class="col-sm-2 control-label text-right">C&oacute;digo</label>
				<div class="col-sm-7">
					<input id="idMenu" type="text" disabled="disabled" class="form-control" value="${vo.idMenu }" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label text-right">Nome</label>
				<div class="col-sm-7">
					<input id="nome" type="text" value="${vo.nome}" autofocus="autofocus" class="form-control" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label text-right">URL</label>
				<div class="col-sm-7">
					<input id="url" type="text" value="${vo.url}" class="form-control" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label text-right">Ordem</label>
				<div class="col-sm-2">
					<input id="ordem" type="text" value="${vo.ordem}" class="form-control"  data-field-type="number" data-field-precision="0"/>
				</div>
				
				<label class="col-sm-2 control-label text-right">Grupo</label>
				<div class="col-sm-2">
					<select id="grupo" class="select" data-field-value="${vo.grupo}">
						<c:forEach items="${grupos}" var="grupo">
							<option value="${grupo.valor}">${grupo.descricao}</option>
						</c:forEach>
					</select>
				</div>
			</div>

		</div>

		<%@include file="../../../botoes-cadastro.jsp"%>
		
	</form>
</div>
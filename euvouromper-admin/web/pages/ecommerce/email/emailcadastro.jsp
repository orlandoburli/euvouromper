<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../../../header-title.jsp"%>

<div class="panel panel-body">
	<form class="form-horizontal" action="#" role="form">
		<div class="FormularioCadastro FormularioGeral panel panel-default form-group" data-page-consulta="emailconsulta.admin" data-page-operacao="${operacao}" data-page-cadastro="emailcadastro.admin">
			<div class="panel-body">
				<c:if test="${operacao ne 'inserir'}">
					<c:set var="disableui" value="disabled='disabled'">
					</c:set>
				</c:if>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Tipo de Email</label>

					<div class="col-sm-7">
						<select id="idEmail" class="" data-field-value="${vo.idEmail}" ${disableui}>
							<c:forEach items="${tipos}" var="tipo">
								<option value="${tipo.valor}">${tipo.descricao}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Assunto</label>
					<div class="col-sm-7">
						<input id="assunto" type="text" value="${vo.assunto}" autofocus="autofocus" class="form-control" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Email do Remetente</label>
					<div class="col-sm-7">
						<input id="remetenteEmail" type="text" value="${vo.remetenteEmail}" class="form-control" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Nome do Rementente</label>
					<div class="col-sm-7">
						<input id="remetenteNome" type="text" value="${vo.remetenteNome}" class="form-control" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label text-right"></label>
					<div class="col-sm-7">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h6 class="panel-title">
									<i class="icon-pencil"></i>Texto Email
								</h6>
							</div>
							<div class="panel-body">
								<div class="block-inner">
									<textarea id="corpo" rows="20" class="editor form-control" placeholder="Digite o texto aqui...">${vo.corpo}</textarea>
								</div>
							</div>
						</div>
					</div>
				</div>

				<%@include file="../../../botoes-cadastro.jsp"%>
			</div>
		</div>
	</form>
</div>
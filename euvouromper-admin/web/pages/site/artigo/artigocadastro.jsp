<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../../../header-title.jsp"%>

<div class="panel panel-body">
	<form class="form-horizontal" action="#" role="form">
		<div class="FormularioCadastro FormularioGeral panel panel-default form-group" data-page-consulta="artigoconsulta.admin" data-page-operacao="${operacao}" data-page-cadastro="artigocadastro.admin">
			<div class="panel-body">
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">C&oacute;digo</label>
					<div class="col-sm-7">
						<input id="idArtigo" type="text" disabled="disabled" class="form-control" value="${vo.idArtigo }" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">T�tulo</label>
					<div class="col-sm-7">
						<input id="titulo" type="text" value="${vo.titulo}" autofocus="autofocus" class="form-control" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Resumo</label>
					<div class="col-sm-7">
						<input id="resumo" type="text" value="${vo.resumo}" class="form-control" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Data</label>
					<div class="col-sm-2">
						<fmt:formatDate value="${vo.data.time}" pattern="dd/MM/yyyy" var="dataFormatada" />
						<input id="data" type="text" value="${dataFormatada}" class="form-control datepicker" />
					</div>

					<label class="col-sm-2 control-label text-right">Status</label>
					<div class="col-sm-3">
						<select id="status"  data-field-value="${vo.status}">
							<c:forEach var="tipo" items="${statusArtigoList}">
								<option value="${tipo.valor}">${tipo.descricao}</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Professor</label>
					<div class="col-sm-7">
						<select id="idProfessor"  data-field-value="${vo.idProfessor}">
							<option value="">[NENHUM]</option>
							<c:forEach var="professor" items="${professores}">
								<option value="${professor.idProfessor}">${professor.nome}</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right"></label>
					<div class="col-sm-7">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h6 class="panel-title">
									<i class="icon-pencil"></i>Texto Not�cia
								</h6>
							</div>
							<div class="panel-body">
								<div class="block-inner">
									<textarea id="texto" rows="20" class="editor form-control" placeholder="Digite o texto aqui...">${vo.texto}</textarea>
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
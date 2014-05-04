<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../../../header-title.jsp"%>

<div class="panel panel-body">
	<form class="form-horizontal" action="#" role="form">
		<div class="FormularioCadastro FormularioGeral panel panel-default form-group" data-page-consulta="mensagemconsulta.admin" data-page-operacao="${operacao}" data-page-cadastro="mensagemcadastro.admin">
			<div class="panel-body">

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">C&oacute;digo</label>
					<div class="col-sm-7">
						<input id="idMensagem" type="text" disabled="disabled" class="form-control" value="${vo.idMensagem }" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Assunto</label>
					<div class="col-sm-7">
						<input id="assunto" type="text" value="${vo.assunto}" autofocus="autofocus" class="form-control" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Remetente</label>
					<div class="col-sm-7">
						<input id="remetente" type="text" value="${vo.remetente}" class="form-control" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Data Inicial</label>
					<div class="col-sm-2">
						<fmt:formatDate value="${vo.dataInicial.time}" pattern="dd/MM/yyyy" var="dataFormatada" />
						<input id="dataInicial" type="text" value="${dataFormatada}" class="form-control datepicker" />
					</div>

					<label class="col-sm-3 control-label text-right">Data Final</label>
					<div class="col-sm-2">
						<fmt:formatDate value="${vo.dataFinal.time}" pattern="dd/MM/yyyy" var="dataFormatada" />
						<input id="dataFinal" type="text" value="${dataFormatada}" class="form-control datepicker" />
					</div>

				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Status</label>

					<div class="col-sm-3">
						<select id="status" class="select2" data-field-value="${vo.status}">
							<c:forEach var="tipo" items="${statusMensagens}">
								<option value="${tipo.valor}">${tipo.descricao}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Destino</label>

					<div class="col-sm-3">
						<select id="destino" class="select2" data-field-value="${vo.destino}">
							<option>[NENHUM]</option>
							<c:forEach var="tipo" items="${tipoDestinoMensagens}">
								<option value="${tipo.valor}">${tipo.descricao}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Cliente</label>

					<div class="col-sm-3">
						<select id="idCliente" class="select2" data-field-value="${vo.idCliente}" style="width: 500px;">
							<option>[NENHUM]</option>
							<c:forEach var="cliente" items="${clientes}">
								<option value="${cliente.idCliente}">${cliente.nome} (${cliente.email})</option>
							</c:forEach>
						</select>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Produto</label>

					<div class="col-sm-3">
						<select id="idProduto" class="select2" data-field-value="${vo.idProduto}">
							<option>[NENHUM]</option>
							<c:forEach var="produto" items="${produtos}">
								<option value="${produto.idProduto}">${produto.nome}</option>
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
									<i class="icon-pencil"></i>Texto Mensagem
								</h6>
							</div>
							<div class="panel-body">
								<div class="block-inner">
									<textarea id="mensagem" rows="20" class="editor form-control" placeholder="Digite o texto aqui...">${vo.mensagem}</textarea>
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
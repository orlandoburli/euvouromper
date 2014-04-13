<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../../../header-title.jsp"%>

<div class="panel panel-body">
	<form class="form-horizontal" action="#" role="form">
		<div class="FormularioCadastro FormularioGeral panel panel-default form-group" data-page-consulta="cupomdescontoconsulta.admin" data-page-operacao="${operacao}" data-page-cadastro="cupomdescontocadastro.admin">
			<div class="panel-body">
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">C&oacute;digo</label>
					<div class="col-sm-7">
						<input id="idCupom" type="text" disabled="disabled" class="form-control" value="${vo.idCupom }" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Chave</label>
					<div class="col-sm-7">
						<div class="input-group">
							<input id="chave" type="text" value="${vo.chave}" autofocus="autofocus" class="form-control" maxlength="20" /> <span class="input-group-btn">
								<button class="btn btn-default ButtonGerarChave" type="button">
									<i class="icon-share3"></i> Gerar chave aleatória&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</button>
							</span>

						</div>

					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Descrição</label>
					<div class="col-sm-7">
						<input id="descricao" type="text" value="${vo.descricao}" class="form-control" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Produto</label>
					<div class="col-sm-7">
						<select id="idProdutoDestino" class="select" data-field-value="${vo.idProdutoDestino}">
							<option value="">[NENHUM]</option>
							<c:forEach var="produto" items="${produtos}">
								<option value="${produto.idProduto}">${produto.nome}</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Tipo de Desconto</label>
					<div class="col-sm-7">
						<select id="tipoDesconto" class="select" data-field-value="${vo.tipoDesconto}">
							<c:forEach var="tipo" items="${tipoDescontoList}">
								<option value="${tipo.valor}">${tipo.descricao}</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Cliente</label>

					<div class="col-sm-7">
						<select id="idCliente" class="select" data-field-value="${vo.idCliente}">
							<option value="">[NENHUM]</option>
							<c:forEach var="cliente" items="${clientes}">
								<option value="${cliente.idCliente}">${cliente.nome}</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Data Validade</label>
					<div class="col-sm-7">
						<fmt:formatDate value="${vo.dataValidade.time}" pattern="dd/MM/yyyy" var="dataValidadeFormatada" />
						<input id="dataValidade" type="text" value="${dataValidadeFormatada}" class="form-control datepicker" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Valor / Percentual de Desconto</label>
					<div class="col-sm-7">
						<input id="valor" type="text" value="${vo.valor}" class="form-control" data-field-type="number" data-field-precision="2" />
					</div>
				</div>

				<%@include file="../../../botoes-cadastro.jsp"%>
				
			</div>
		</div>

	</form>
</div>

<script type="text/javascript">
	$(".ButtonGerarChave").click(function() {
		$.ajax({
			url : 'cupomdescontocadastro.geracadeia.admin',
			type : 'POST',
			beforeSend : function(data) {
				// debug("loading...");
			},
			success : function(data) {
				debug(data);
				$("#chave").val(data);
			},
			error : function(erro) {
				debug("Erro no load ajax! " + erro);
			}
		});
	});
</script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../../../header-title.jsp"%>

<fmt:setLocale value="pt-BR" />

<div class="panel panel-body">
	<form class="form-horizontal" action="#" role="form">
		<div class="FormularioCadastro FormularioGeral panel panel-default form-group" data-page-consulta="pedidoconsulta.admin" data-page-operacao="${operacao}" data-page-cadastro="pedidocadastro.admin">
			<div class="panel-body">

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">C&oacute;digo</label>
					<div class="col-sm-3">
						<input id="idPedido" type="text" disabled="disabled" class="form-control" value="${vo.idPedido }" />
					</div>
					<label class="col-sm-1 control-label text-right">CPF</label>
					<div class="col-sm-3">
						<input id="nome" type="text" disabled="disabled" value="${vo.cpf}" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Nome</label>
					<div class="col-sm-3">
						<input id="nome" type="text" disabled="disabled" value="${vo.nome}" class="form-control" />
					</div>

					<label class="col-sm-1 control-label text-right">Email</label>
					<div class="col-sm-3">
						<input id="email" type="text" disabled="disabled" value="${vo.email}" class="form-control" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Cupom Desconto</label>
					<div class="col-sm-7">
						<input id="idCupom" type="text" disabled="disabled" value="${vo.cupom.nome}" class="form-control" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Data / Hora do Pedido</label>
					<div class="col-sm-3">
						<fmt:formatDate value="${vo.dataHoraPedido.time}" pattern="dd/MM/yyyy HH:mm:ss" var="dataFormatada" />
						<input id="dataHoraPedido" type="text" disabled="disabled" value="${dataFormatada}" class="form-control" />
					</div>

					<label class="col-sm-1 control-label text-right">Liberação </label>
					<div class="col-sm-3">
						<fmt:formatDate value="${vo.dataHoraLiberacao.time}" pattern="dd/MM/yyyy HH:mm:ss" var="dataFormatada" />
						<input id="dataHoraPedido" type="text" disabled="disabled" value="${dataFormatada}" class="form-control" />
					</div>
				</div>


				<div class="form-group">
					<div class="col-sm-2"></div>
					<div class="col-sm-7">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h6 class="panel-title">
									<i class="icon-table2"></i> Itens
								</h6>
							</div>
							<div class="table-responsive">
								<table class="table table-condensed">
									<thead>
										<tr>
											<th class="text-left">Código</th>
											<th class="text-left">Nome Produto</th>
											<th class="text-right">Valor</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${itens}" var="item">
											<tr>
												<td class="text-left"><fmt:formatNumber minIntegerDigits="3" value="${item.idProduto}" /></td>
												<td class="text-left">${item.nome}</td>
												<fmt:formatNumber value="${item.valor}" minFractionDigits="2" type="currency" var="valor" />
												<td class="text-right">${valor}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				
				
				<div class="form-group">
					<div class="col-sm-2"></div>
					<div class="col-sm-7">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h6 class="panel-title">
									<i class="icon-table2"></i> Movimentação do pedido
								</h6>
							</div>
							<div class="table-responsive">
								<table class="table table-condensed">
									<thead>
										<tr>
											<th class="text-left">Data / Hora</th>
											<th class="text-left">Status</th>
											<th class="text-right">Usuário</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${movimentacoes}" var="mov">
											<tr>
												<fmt:formatDate value="${mov.dataHora.time}" pattern="dd/MM/yyyy HH:mm:ss" var="dataFormatada" />
												<td class="text-left">${dataFormatada}</td>
												
												<td class="text-left">${mov.statusDescritivo}</td>
												
												<c:if test="${not empty mov.usuario}">
													<td class="text-right">${mov.usuario.nome}</td>
												</c:if>
												<c:if test="${empty mov.usuario}">
													<td class="text-right">SISTEMA</td>
												</c:if>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>


				<div class="FormularioBotoes form-actions text-right">
					<button type="button" title="Marcar o pedido como pago" class="BotaoPagar btn btn-lg btn-primary tip">
						<i class="icon-tag5"></i> Pagar
					</button>

					<button type="button" title="Cancelar o pedido" class="BotaoCancelar btn btn-lg btn-danger tip">
						<i class="icon-bubble-cancel"></i> Cancelar
					</button>
					<button type="button" title="Voltar (Esc)" class="BotaoVoltar btn btn-lg btn-success tip">
						<i class="icon-undo2"></i> Voltar
					</button>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			// Funcao de salvar o registro
			function salvar(acao) {
				var paginaCadastro = $(".FormularioCadastro").attr("data-page-cadastro");
				var paginaBase = paginaCadastro.split(".")[0];
				var paginaFinal = paginaBase + "." + acao + "." + paginaCadastro.split(".")[1];

				var params = {
					'operacao' : acao
				};

				// Loop nos input's do form para enviar
				debug("Parametros do metodo salvar");

				$("input,select,textarea").each(function(index) {
					params[$(this).attr("id")] = $(this).val();
					debug($(this).attr("id") + ' = ' + $(this).val());
				});

				$.ajax({
					url : paginaFinal,
					type : 'POST',
					data : params,
					beforeSend : function(data) {
						// debug("loading...");
					},
					success : function(data) {

						var retorno = $.parseJSON(data);

						if (retorno.sucesso) {
							$.jGrowl(retorno.mensagem, {
								life : 2000,
								theme : 'growl-info',
								header : 'Aviso'
							});
							voltar();
						} else {
							$.jGrowl(retorno.mensagem, {
								life : 2000,
								theme : 'growl-error',
								header : 'Erro'
							});
							$("#" + retorno.fieldFocus).focus();
						}
					},
					error : function(erro) {
						debug("Erro no load ajax! " + erro);
					}
				});
			}

			$(".BotaoPagar").click(function() {
				salvar('pagar');
			});

			$(".BotaoCancelar").click(function() {
				salvar('cancelar');
			});
			
			// Volta para a pagina de consulta
			function voltar() {
				// Forca esconder o modal - pode ter varios aqui...
				$('#selecao_imagem').modal('hide');
				
				var pageConsulta = $(".FormularioCadastro").attr("data-page-consulta");
				loadPage(pageConsulta);
				loadJs("web/pages/js/consulta.js");
			}
			$(".BotaoVoltar").click(function() {
				voltar();
			});
		</script>
	</form>
</div>
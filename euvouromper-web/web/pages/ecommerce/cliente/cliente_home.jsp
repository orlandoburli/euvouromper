<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<%@include file="../../geral/header-includes.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<fmt:setLocale value="pt-BR" />

<body class="metro" style="">

	<%@include file="../../geral/header-geral.jsp"%>

	<div class="container" style="padding: 10px">
		<div class="metro one-column">
			<%@include file="header-aluno.jsp"%>

			<h3 class="titulo-area-aluno">Olá, ${cliente.nome}!</h3>
			
			<div class="clear" style="">
				<div class="panel span7 left margin-top">
					<div class="panel-header bg-lightBlue fg-white">Meus Pedidos</div>
					<div class="panel-content">
						<div id="saldo" class="left">
							<p>Saldo disponível:</p>
							<span><fmt:formatNumber value="${saldo}" minFractionDigits="2" type="currency" /></span>
							<button class="botao-comprar">
								<a href="" title="">Comprar mais</a>
							</button>
						</div>
						<div id="pedidos-abertos">
							<p>Pedidos Abertos</p>
							<a href="" title="" class="numeros-pedidos">${pedidosAbertos }</a>
						</div>
					</div>
				</div>

				<div class="panel span7 margin-top" style="float: right">
					<div class="panel-header bg-lightBlue fg-white">Últimas Aulas</div>
					<div class="panel-content">
						<table class="table hovered">
							<thead>
								<tr>
									<th class="text-left">Curso</th>
									<th class="text-left">Vídeo</th>
									<th class="text-left"></th>
								</tr>
							</thead>

							<tbody>
								<c:forEach var="log" items="${ultimasAulas}">
									<tr>
										<td><a href="" title="" id="" class="createWindow">${log.produto.nome}</a></td>
										<td class="right">${log.video.nome} Aula ${log.video.aula} Bloco ${log.video.bloco}</td>
										<td class="right"><a href="${root}/aluno/curso/${log.produto.url}" title="" class="revisar">Continuar</a></td>
									</tr>
								</c:forEach>
							</tbody>

							<tfoot></tfoot>
						</table>
					</div>
				</div>
			</div>

			<div class="clear margin-top" style="padding-top: 10px;">
				<div id="tabela-mensagens" class="panel margin-top">
					<div class="panel-header bg-lightBlue fg-white">Mensagens</div>
					<div class="panel-content">
						<p>
							Você tem <b>${novasMensagens}</b> novas mensagens!
						</p>
						<table class="table hovered">
							<thead>
								<tr>
									<th class="text-left">Assunto</th>
									<th class="text-left">Remetente</th>
									<th class="text-left">Data</th>
									<th class="text-left"></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="mensagem" items="${mensagens}">
									<c:if test="${not mensagem.lida}">
										<c:set var="lida" value="font-weight: bold;"/>
									</c:if>
									
									<c:if test="${mensagem.lida}">
										<c:set var="lida" value=""/>
									</c:if>
								
									<tr style="${lida}">
										<fmt:formatDate value="${mensagem.dataInicial.time}" pattern="dd/MM/yyyy" var="dataFormatada" />
										<td>
											<a href="#tabela-mensagens" data-mensagem-data="${dataFormatada}" data-mensagem-remetente="${mensagem.remetente}" data-assunto="${mensagem.assunto}" data-mensagem-id="${mensagem.idMensagem}" class="createWindow">${mensagem.assunto}</a>
										</td>
										<td class="right">${mensagem.remetente}</td>
										<td class="right">${dataFormatada}</td>
										<%-- <td class="text-right"><a href="" title=""><img src="${root}/web/assets/imgs/delete.png" alt=""></a></td> --%>
									</tr>
								</c:forEach>
							</tbody>
							<tfoot></tfoot>
						</table>
					</div>
				</div>
			</div>

		</div>
		<!-- end noticias -->
	</div>
	<!-- end container -->
	
	<%@include file="../../geral/footer.jsp"%>
	
	<script>
		$(function() {
			$(".createWindow").click(function(e) {
				var id =  $(this).attr("data-mensagem-id");
				var rementente = $(this).attr("data-mensagem-remetente");
				var dataFormatada = $(this).attr("data-mensagem-data");
				$.Dialog({
					shadow : true,
					overlay : true,
					flat: true,
					icon : '',
					title : $(this).attr("data-assunto"),
					width : 500,
					padding : 20,
					content : '',
					onShow : function(_dialog) {
						$.ajax({
							url : '${root}/aluno/mensagem?idMensagem=' + id,
							type : 'GET',
							success : function(data) {
								var conteudo = data;
								
								conteudo = '<p>De: ' + rementente
								+ '</p><p>Data: ' 
								+ dataFormatada 
								+ '</p>' 
								+ conteudo;
								
								$.Dialog.content(conteudo);
							}
						});
					}
				});
			});
		});
	</script>
</body>
</html>
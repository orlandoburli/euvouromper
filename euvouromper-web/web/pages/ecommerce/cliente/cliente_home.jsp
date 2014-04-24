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
			<%@include file="header-aluno.jsp" %>
			
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
									<th class="text-left">Aula</th>
									<th class="text-left">Assistido(%)</th>
									<th class="text-left"></th>
								</tr>
							</thead>

							<tbody>
								<tr>
									<td><a href="" title="" id="" class="createWindow">Língua Portuguesa</a></td>
									<td class="right">20%</td>
									<td class="right"><a href="" title="" class="revisar">Continuar</a></td>
								</tr>
								<tr>
									<td><a href="" title="" class="">Gestão de Pessoas</a></td>
									<td class="right">20%</td>
									<td class="right"><a href="" title="" class="iniciar">Continuar</a></td>
								</tr>
								<tr>
									<td><a href="" title="" class="">Administração Geral</a></td>
									<td class="right">20%</td>
									<td class="right"><a href="" title="" class="revisar">Continuar</a></td>
								</tr>
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
							Você tem <b>3</b> novas mensagens!
						</p>
						<table class="table hovered">
							<thead>
								<tr>
									<th class="text-left">Assunto</th>
									<th class="text-left">Remetente</th>
									<th class="text-left">Horas</th>
									<th class="text-left"></th>
								</tr>
							</thead>

							<tbody>
								<tr>
									<td><a href="" title="" id="" class="createWindow">Língua Portuguesa</a></td>
									<td class="right">HENRIQUE CASTELO BRANCO</td>
									<td class="right">15:32</td>
									<td class="text-right"><a href="" title=""><img src="${root}/web/assets/imgs/delete.png" alt=""></a></td>
								</tr>
								<tr>
									<td><a href="" title="">Gestão de Pessoas</a></td>
									<td class="right">HENRIQUE CASTELO BRANCO</td>
									<td class="right">15:32</td>
									<td class="text-right"><a href="" title=""><img src="${root}/web/assets/imgs/delete.png" alt=""></a></td>

								</tr>
								<tr>
									<td><a href="" title="">Administração Geral</a></td>
									<td class="right">HENRIQUE CASTELO BRANCO</td>
									<td class="right">15:32</td>
									<td class="text-right"><a href="" title=""><img src="${root}/web/assets/imgs/delete.png" alt=""></a></td>
								</tr>
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

</body>
</html>
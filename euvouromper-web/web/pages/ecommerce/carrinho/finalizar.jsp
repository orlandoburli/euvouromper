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
			<nav class="breadcrumbs mini">
				<ul>
					<li><a href="${root}/home"><i class="icon-home"></i></a></li>
					<li><a href="${root}/home">Home</a></li>
					<li><a href="${root}/carrinho">Carrinho de Compras</a></li>
					<li class="active"><a href="${root}/carrinho/finalizar">Finalizar Pedido</a></li>
				</ul>
			</nav>
			<h2 class="titles-big linha-h2">Finalizar Pedido</h2>
			<div class="metro one-column">
				<p>Para finalizar seu pedido, informe corretamente os dados abaixo.</p>
				<form action="" method="post" accept-charset="utf-8">
					<label>Nome:</label>
					<div class="input-control text">
						<input id="nome" name="nome" type="text" value="${carrinho.nome}" placeholder="" />
						<button class="btn-clear"></button>
					</div>
					<label>CPF:</label>
					<div class="input-control text">
						<input id="cpf" name="cpf" type="text" value="${carrinho.cpf}" placeholder="" />
						<button class="btn-clear"></button>
					</div>
					<label>CEP:</label>
					<div class="input-control text">
						<input id="cep" name="cep" type="text" value="${carrinho.cep}" placeholder="" />
						<button class="btn-clear"></button>
					</div>
					<label>Logradouro:</label>
					<div class="input-control text">
						<input id="endereco" name="endereco" type="text" value="${carrinho.endereco }" placeholder="" />
						<button class="btn-clear"></button>
					</div>
					<label>Número:</label>
					<div class="input-control text">
						<input id="numero" name="numero" type="text" value="${carrinho.numero}" placeholder="" />
						<button class="btn-clear"></button>
					</div>
					<label>Complemento:</label>
					<div class="input-control text">
						<input id="complemento" name="complemento" type="text" value="${carrinho.complemento}" placeholder="" />
						<button class="btn-clear"></button>
					</div>
					<label>Bairro:</label>
					<div class="input-control text">
						<input id="bairro" name="bairro" type="text" value="${carrinho.bairro}" placeholder="" />
						<button class="btn-clear"></button>
					</div>
					<label>Fone 1:</label>
					<div class="input-control text">
						<input id="fone1" name="fone1" type="text" value="${carrinho.fone1}" placeholder="" />
						<button class="btn-clear"></button>
					</div>
					<label>Fone 2:</label>
					<div class="input-control text">
						<input id="fone2" name="fone2" type="text" value="${carrinho.fone2}" placeholder="" />
						<button class="btn-clear"></button>
					</div>
					<label>UF:</label>
					<div class="input-control select">
						<select id="uf" name="uf">
							<option value="">[Selecione]</option>
							<option value="AC" <c:if test="${carrinho.uf eq 'AC'}"> selected</c:if>>Acre</option>
							<option value="AL" <c:if test="${carrinho.uf eq 'AL'}"> selected</c:if>>Alagoas</option>
							<option value="AP" <c:if test="${carrinho.uf eq 'AP'}"> selected</c:if>>Amapá</option>
							<option value="AM" <c:if test="${carrinho.uf eq 'AM'}"> selected</c:if>>Amazonas</option>
							<option value="BA" <c:if test="${carrinho.uf eq 'BA'}"> selected</c:if>>Bahia</option>
							<option value="CE" <c:if test="${carrinho.uf eq 'CE'}"> selected</c:if>>Ceará</option>
							<option value="DF" <c:if test="${carrinho.uf eq 'DF'}"> selected</c:if>>Distrito Federal</option>
							<option value="ES" <c:if test="${carrinho.uf eq 'ES'}"> selected</c:if>>Espírito Santo</option>
							<option value="GO" <c:if test="${carrinho.uf eq 'GO'}"> selected</c:if>>Goiás</option>
							<option value="MA" <c:if test="${carrinho.uf eq 'MA'}"> selected</c:if>>Maranhão</option>
							<option value="MT" <c:if test="${carrinho.uf eq 'MT'}"> selected</c:if>>Mato Grosso</option>
							<option value="MS" <c:if test="${carrinho.uf eq 'MS'}"> selected</c:if>>Mato Grosso do Sul</option>
							<option value="MG" <c:if test="${carrinho.uf eq 'MG'}"> selected</c:if>>Minas Gerais</option>
							<option value="PA" <c:if test="${carrinho.uf eq 'PA'}"> selected</c:if>>Pará</option>
							<option value="PB" <c:if test="${carrinho.uf eq 'PB'}"> selected</c:if>>Paraíba</option>
							<option value="PR" <c:if test="${carrinho.uf eq 'PR'}"> selected</c:if>>Paraná</option>
							<option value="PE" <c:if test="${carrinho.uf eq 'PE'}"> selected</c:if>>Pernambuco</option>
							<option value="PI" <c:if test="${carrinho.uf eq 'PI'}"> selected</c:if>>Piauí</option>
							<option value="RJ" <c:if test="${carrinho.uf eq 'RJ'}"> selected</c:if>>Rio de Janeiro</option>
							<option value="RN" <c:if test="${carrinho.uf eq 'RN'}"> selected</c:if>>Rio Grande do Norte</option>
							<option value="RS" <c:if test="${carrinho.uf eq 'RS'}"> selected</c:if>>Rio Grande do Sul</option>
							<option value="RO" <c:if test="${carrinho.uf eq 'RO'}"> selected</c:if>>Rondônia</option>
							<option value="RR" <c:if test="${carrinho.uf eq 'RR'}"> selected</c:if>>Roraima</option>
							<option value="SC" <c:if test="${carrinho.uf eq 'SC'}"> selected</c:if>>Santa Catarina</option>
							<option value="SP" <c:if test="${carrinho.uf eq 'SP'}"> selected</c:if>>São Paulo</option>
							<option value="SE" <c:if test="${carrinho.uf eq 'SE'}"> selected</c:if>>Sergipe</option>
							<option value="TO" <c:if test="${carrinho.uf eq 'TO'}"> selected</c:if>>Tocantins</option>
						</select>
					</div>
					<label>Cidade:</label>
					
					<div class="input-control text">
						<input id="cidade" name="cidade" type="text" value="${carrinho.cidade}" placeholder="" />
						<button class="btn-clear"></button>
					</div>
					
					<div class="metro one-column span4 left">
						<a href="${root}/produto/lista" title="Continuar Comprando" class="continuar-comprando left">Continuar Comprando</a>
			    	</div>
					<input type="submit" value="Finalizar compra" class="right botao-finalizar-compra">
					
					<c:if test="${not empty erro}">
						<br/><br/><br/><br/><br/>
						<div class="notice marker-on-top bg-crimson fg-white">
							${erro}
						</div>
					</c:if>
				</form>
			</div>

			<!-- <div class="metro one-column box-total">
				<a href="" title="Continuar Comprando" class="continuar-comprando left">Continuar Comprando</a>
				a href="" title="Finalizar Compra" class="finalizar-compra">Finalizar Compra</a
			</div> -->
			<div class="metro one-column margin-top">
				<img src='https://p.simg.uol.com.br/out/pagseguro/i/banners/divulgacao/728x90_10X_pagseguro.gif' alt='' />
			</div>

		</div>
		<!-- end noticias -->
	</div>
	<!-- end container -->

	<%@include file="../../geral/footer.jsp"%>

</body>
</html>
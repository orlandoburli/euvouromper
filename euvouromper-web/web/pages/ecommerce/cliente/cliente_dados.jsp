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

			<div class="clear margin-top">
				<div id="tabela-mensagens" class="panel margin-top">
					<div class="panel-header bg-lightBlue fg-white">Alterar Senha</div>
					<div class="panel-content">
						<div class="metro one-column">
							<form action="" method="post" accept-charset="utf-8">
								<label>Senha atual:</label>
								<div class="input-control text">
									<input id="senha" name="senha" type="password" placeholder="Senha atual" />
									<button class="btn-clear"></button>
								</div>

								<label>Nova Senha:</label>
								<div class="input-control text">
									<input id="novaSenha" name="novaSenha" type="password" placeholder="Digite a nova senha" />
									<button class="btn-clear"></button>
								</div>

								<label>Confirmar Nova Senha:</label>
								<div class="input-control text">
									<input id="confNovaSenha" name="confNovaSenha" type="password" placeholder="Confirme a nova senha" />
									<button class="btn-clear"></button>
								</div>
								
								<div class="one-column clear link-padrao" style="overflow: auto;">
									<input type="submit" id="btnAlterarSenha" name="btnAlterarSenha" value="Alterar senha" class="right">
								</div>
								
								<c:if test="${not empty erroSenha}">
									<div class="notice marker-on-top bg-crimson fg-white">${erroSenha}</div>
								</c:if>
								
								<c:if test="${not empty sucessoSenha}">
									<div class="notice marker-on-top bg-emerald fg-white">${sucessoSenha}</div>
								</c:if>
							</form>
						</div>
					</div>
				</div>
			</div>

			<div class="clear margin-top">
				<div id="tabela-mensagens" class="panel margin-top">
					<div class="panel-header bg-lightBlue fg-white">Alterar Meus Dados</div>
					<div class="panel-content">

						<div class="metro one-column">

							<form action="" method="post" accept-charset="utf-8">
								<label>Nome:</label>
								<div class="input-control text">
									<input id="nome" name="nome" type="text" value="${cliente.nome}" placeholder="" />
									<button class="btn-clear"></button>
								</div>
								<label>CPF:</label>
								<div class="input-control text">
									<input id="cpf" name="cpf" type="text" value="${cliente.cpf}" placeholder="" />
									<button class="btn-clear"></button>
								</div>
								<label>CEP:</label>
								<div class="input-control text">
									<input id="cep" name="cep" type="text" value="${cliente.cep}" placeholder="" />
									<button class="btn-clear"></button>
								</div>
								<label>Logradouro:</label>
								<div class="input-control text">
									<input id="endereco" name="endereco" type="text" value="${cliente.endereco }" placeholder="" />
									<button class="btn-clear"></button>
								</div>
								<label>Número:</label>
								<div class="input-control text">
									<input id="numero" name="numero" type="text" value="${cliente.numero}" placeholder="" />
									<button class="btn-clear"></button>
								</div>
								<label>Complemento:</label>
								<div class="input-control text">
									<input id="complemento" name="complemento" type="text" value="${cliente.complemento}" placeholder="" />
									<button class="btn-clear"></button>
								</div>
								<label>Bairro:</label>
								<div class="input-control text">
									<input id="bairro" name="bairro" type="text" value="${cliente.bairro}" placeholder="" />
									<button class="btn-clear"></button>
								</div>
								<label>Fone 1:</label>
								<div class="input-control text">
									<input id="fone1" name="fone1" type="text" value="${cliente.fone1}" placeholder="" />
									<button class="btn-clear"></button>
								</div>
								<label>Fone 2:</label>
								<div class="input-control text">
									<input id="fone2" name="fone2" type="text" value="${cliente.fone2}" placeholder="" />
									<button class="btn-clear"></button>
								</div>
								<label>UF:</label>
								<div class="input-control select">
									<select id="uf" name="uf">
										<option value="">[Selecione]</option>
										<option value="AC" <c:if test="${cliente.uf eq 'AC'}"> selected</c:if>>Acre</option>
										<option value="AL" <c:if test="${cliente.uf eq 'AL'}"> selected</c:if>>Alagoas</option>
										<option value="AP" <c:if test="${cliente.uf eq 'AP'}"> selected</c:if>>Amapá</option>
										<option value="AM" <c:if test="${cliente.uf eq 'AM'}"> selected</c:if>>Amazonas</option>
										<option value="BA" <c:if test="${cliente.uf eq 'BA'}"> selected</c:if>>Bahia</option>
										<option value="CE" <c:if test="${cliente.uf eq 'CE'}"> selected</c:if>>Ceará</option>
										<option value="DF" <c:if test="${cliente.uf eq 'DF'}"> selected</c:if>>Distrito Federal</option>
										<option value="ES" <c:if test="${cliente.uf eq 'ES'}"> selected</c:if>>Espírito Santo</option>
										<option value="GO" <c:if test="${cliente.uf eq 'GO'}"> selected</c:if>>Goiás</option>
										<option value="MA" <c:if test="${cliente.uf eq 'MA'}"> selected</c:if>>Maranhão</option>
										<option value="MT" <c:if test="${cliente.uf eq 'MT'}"> selected</c:if>>Mato Grosso</option>
										<option value="MS" <c:if test="${cliente.uf eq 'MS'}"> selected</c:if>>Mato Grosso do Sul</option>
										<option value="MG" <c:if test="${cliente.uf eq 'MG'}"> selected</c:if>>Minas Gerais</option>
										<option value="PA" <c:if test="${cliente.uf eq 'PA'}"> selected</c:if>>Pará</option>
										<option value="PB" <c:if test="${cliente.uf eq 'PB'}"> selected</c:if>>Paraíba</option>
										<option value="PR" <c:if test="${cliente.uf eq 'PR'}"> selected</c:if>>Paraná</option>
										<option value="PE" <c:if test="${cliente.uf eq 'PE'}"> selected</c:if>>Pernambuco</option>
										<option value="PI" <c:if test="${cliente.uf eq 'PI'}"> selected</c:if>>Piauí</option>
										<option value="RJ" <c:if test="${cliente.uf eq 'RJ'}"> selected</c:if>>Rio de Janeiro</option>
										<option value="RN" <c:if test="${cliente.uf eq 'RN'}"> selected</c:if>>Rio Grande do Norte</option>
										<option value="RS" <c:if test="${cliente.uf eq 'RS'}"> selected</c:if>>Rio Grande do Sul</option>
										<option value="RO" <c:if test="${cliente.uf eq 'RO'}"> selected</c:if>>Rondônia</option>
										<option value="RR" <c:if test="${cliente.uf eq 'RR'}"> selected</c:if>>Roraima</option>
										<option value="SC" <c:if test="${cliente.uf eq 'SC'}"> selected</c:if>>Santa Catarina</option>
										<option value="SP" <c:if test="${cliente.uf eq 'SP'}"> selected</c:if>>São Paulo</option>
										<option value="SE" <c:if test="${cliente.uf eq 'SE'}"> selected</c:if>>Sergipe</option>
										<option value="TO" <c:if test="${cliente.uf eq 'TO'}"> selected</c:if>>Tocantins</option>
									</select>
								</div>
								<label>Cidade:</label>

								<div class="input-control text">
									<input id="cidade" name="cidade" type="text" value="${cliente.cidade}" placeholder="" />
									<button class="btn-clear"></button>
								</div>

								<div class="one-column clear link-padrao" style="overflow: auto;">
									<input type="submit" id="btnSalvarDados" name="btnSalvarDados" value="Salvar dados" class="right">
								</div>

								<c:if test="${not empty erroCadastro}">
									<br />
									<br />
									<br />
									<br />
									<br />
									<div class="notice marker-on-top bg-crimson fg-white">${erroCadastro}</div>
								</c:if>
								
								<c:if test="${not empty sucessoCadastro}">
									<div class="notice marker-on-top bg-emerald fg-white">${sucessoCadastro}</div>
								</c:if>
							</form>
						</div>
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
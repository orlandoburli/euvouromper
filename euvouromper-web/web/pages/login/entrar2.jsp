<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<%@include file="../geral/header-includes.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<fmt:setLocale value="pt-BR" />

<body class="metro" style="">

	<div class="container" style="padding: 10px">
    	<div class="metro one-column">
    		<h2 class="titles-big linha-h2">Acesso Restrito</h2>
	    	
	    	<div class="metro one-column">
	    		<div class="panel span6 left">
					<div class="panel-header bg-lightBlue fg-white">
	                	Entrar
					</div>
					<div class="panel-content">
		        		<form method="post" accept-charset="utf-8">

		                   	<div class="panel-content">
		                    <p>Efetue seu login para ter acesso.</p>
		                    <label>E-mail</label>
			        		<div class="input-control text">
							    <input id="email" name="email" type="text" value="${l_email}" placeholder=""/>
							    <button class="btn-clear"></button>
							</div>
							<label>Senha</label>
							<div class="input-control password">
							    <input id="senha" name="senha" type="password" value="" placeholder=""/>
							    <button class="btn-reveal"></button>
							</div>
							<div class="links-login left">
								<a href="${root}/esqueci_a_senha" title="Esqueceu senha?" class="" style="display:block;">Esqueceu sua senha?</a>
							</div>
							<div class="floatright">
								<input id="btnEntrar" name="btnEntrar" type="submit" value="Entrar">
							</div>
							
							<c:if test="${not empty erroLogin}">
								<br/><br/><br/>
								<div class="notice marker-on-top bg-crimson fg-white">
									${erroLogin}
								</div>
							</c:if>
		        		</form>
		        	</div>
				</div><!-- end Panel -->
			</div>
			
		    <div class="span2 left" style="text-align:center;">
	        	<h3>--- OU ---</h3>
	        </div>
	        
			<div class="panel span6 floatright">
				<div class="panel-header bg-lightBlue fg-white">
	               	Cadastre-se
				</div>
				<div class="panel-content">
		       		<form method="post" accept-charset="utf-8">
		                <div class="panel-content">
		                    <p class="">Cadastre-se agora mesmo para ter acesso.</p>
		                    
		                    <label>Nome</label>
							<div class="input-control text">
							    <input id="nome" name="nome" type="text" value="${c_nome}" placeholder=""/>
							    <button class="btn-reveal"></button>
							</div>
							
		                    <label>E-mail</label>
			        		<div class="input-control text">
							    <input id="email" name="email" type="text" value="${c_email}" placeholder=""/>
							    <button class="btn-clear"></button>
							</div>
							<label>Senha</label>
							<div class="input-control password">
							    <input id="senha" name="senha" type="password" value="" placeholder=""/>
							    <button class="btn-reveal"></button>
							</div>
							<label>Confirme sua Senha</label>
							<div class="input-control password">
							    <input id="confSenha" name="confSenha" type="password" value="" placeholder=""/>
							    <button class="btn-reveal"></button>
							</div>
							
							<div class="floatright">
								<input name="btnCadastrar" id="btnCadastrar" type="submit" value="Cadastrar">
							</div>
							
							<c:if test="${not empty erroCadastro}">
								<br/><br/><br/>
								<div class="notice marker-on-top bg-crimson fg-white">
									${erroCadastro}
								</div>
							</c:if>
						</div>
	        		</form>
	        	</div>
			</div><!-- end Panel -->
		</div>
		</div>
    	</div><!-- end noticias -->
	</div><!-- end container -->

</body>
</html>
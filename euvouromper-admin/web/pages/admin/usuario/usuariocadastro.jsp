<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../../../header-title.jsp"%>

<div class="panel panel-body">
	<form class="form-horizontal" action="#" role="form">
		<div class="FormularioCadastro FormularioGeral panel panel-default form-group" data-page-consulta="usuarioconsulta.admin" data-page-operacao="${operacao}" data-page-cadastro="usuariocadastro.admin">

			<div class="form-group">
				<label class="col-sm-2 control-label text-right">C&oacute;digo</label>
				<div class="col-sm-7">
					<input id="idUsuario" type="text" disabled="disabled" class="form-control" value="${vo.idUsuario }" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label text-right">Nome</label>
				<div class="col-sm-7">
					<input id="nome" type="text" value="${vo.nome}" autofocus="autofocus" class="form-control" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label text-right">Login</label>
				<div class="col-sm-7">
					<input id="login" type="text" value="${vo.login}" class="form-control" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label text-right">Email</label>
				<div class="col-sm-7">
					<input id="email" type="text" value="${vo.email}" class="form-control" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label text-right">Senha</label>
				<div class="col-sm-7">
					<input id="senha" value="${vo.senha}" type="password" class="form-control" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label text-right">Perfil</label>

				<div class="col-sm-7">
					<select id="idPerfil" class="select" data-field-value="${vo.idPerfil}">
						<c:forEach items="${perfis}" var="perfil">
							<option value="${perfil.idPerfil}">${perfil.nome}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label text-right">Ativo</label>

				<div class="col-sm-7">
					<select id="ativo" class="select" data-field-value="${vo.ativo}">
						<option value="N">Não</option>
						<option value="S">Sim</option>
					</select>
				</div>
			</div>

		</div>

		<%@include file="../../../botoes-cadastro.jsp"%>
		
	</form>
</div>
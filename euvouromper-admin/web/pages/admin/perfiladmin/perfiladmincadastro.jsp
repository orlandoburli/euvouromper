<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../../../header-title.jsp"%>

<div class="panel panel-body">
	<form class="form-horizontal" action="#" role="form">
		<div class="FormularioCadastro FormularioGeral panel panel-default form-group" data-page-consulta="perfiladminconsulta.admin" data-page-operacao="${operacao}" data-page-cadastro="perfiladmincadastro.admin">

			<div class="form-group">
				<label class="col-sm-2 control-label text-right">C&oacute;digo</label>
				<div class="col-sm-7">
					<input id="idPerfil" type="text" disabled="disabled" class="form-control" value="${vo.idPerfil}" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label text-right">Nome</label>
				<div class="col-sm-7">
					<input id="nome" type="text" value="${vo.nome}" autofocus="autofocus" class="form-control" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label text-right">Visualizar Perfil</label>

				<div class="col-sm-2">
					<select id="permissaoPerfilVer" class="select" data-field-value="${vo.permissaoPerfilVer}">
						<option value="N">Não</option>
						<option value="S">Sim</option>
					</select>
				</div>
				
				<label class="col-sm-1 control-label text-right">Alterar Perfil</label>

				<div class="col-sm-2">
					<select id="permissaoPerfilAlt" class="select" data-field-value="${vo.permissaoPerfilAlt}">
						<option value="N">Não</option>
						<option value="S">Sim</option>
					</select>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label text-right">Visualizar Usuários</label>

				<div class="col-sm-2">
					<select id="permissaoUsuarioVer" class="select" data-field-value="${vo.permissaoUsuarioVer}">
						<option value="N">Não</option>
						<option value="S">Sim</option>
					</select>
				</div>
				
				<label class="col-sm-1 control-label text-right">Alterar Usuários</label>

				<div class="col-sm-2">
					<select id="permissaoUsuarioAlt" class="select" data-field-value="${vo.permissaoUsuarioAlt}">
						<option value="N">Não</option>
						<option value="S">Sim</option>
					</select>
				</div>
			</div>

		</div>

		<%@include file="../../../botoes-cadastro.jsp"%>
		
	</form>
</div>
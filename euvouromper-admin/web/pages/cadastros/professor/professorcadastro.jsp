<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../../../header-title.jsp"%>

<div class="panel panel-body">
	<form class="form-horizontal" action="#" role="form">
		<div class="FormularioCadastro FormularioGeral panel panel-default form-group" data-page-consulta="professorconsulta.admin" data-page-operacao="${operacao}" data-page-cadastro="professorcadastro.admin">

			<div class="form-group">
				<label class="col-sm-2 control-label text-right">C&oacute;digo</label>
				<div class="col-sm-7">
					<input id="idProfessor" type="text" disabled="disabled" class="form-control" value="${vo.idProfessor }" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label text-right">Nome</label>
				<div class="col-sm-7">
					<input id="nome" type="text" value="${vo.nome}" autofocus="autofocus" class="form-control" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label text-right">Email</label>
				<div class="col-sm-7">
					<input id="email" type="text" value="${vo.email}" class="form-control" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label text-right">Título</label>
				<div class="col-sm-7">
					<input id="titulo" type="text" value="${vo.titulo}" class="form-control" />
				</div>
			</div>

			<div class="form-group">
				<div>
					<label class="col-sm-2 control-label text-right">Foto do professor</label> <a data-toggle="modal" role="button" href="#tabs_modal">Selecionar arquivo</a>
				</div>
			</div>

			<!-- Formulario de imagens -->
			<div id="tabs_modal" class="modal fade" tabindex="-1" role="dialog">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h4 class="modal-title">
								<i class="icon-accessibility"></i> Modal with tabs
							</h4>
						</div>

						<div class="modal-body with-padding">
							<div class="tabbable">
								<ul class="nav nav-tabs">
									<li class="active">
										<a href="tabListaImagens" data-toggle="tab"><i class="icon-download"></i>Lista de imagens</a>
									</li>
									<li>
										<a href="tabEnviarImagens" data-toggle="tab"><i class="icon-windows8"></i>Enviar imagens</a>
									</li>
								</ul>
								
								<div class="tab-content">
									<div class="tab-pane fade in active" id="tabListaImagens">
										<%@include file="lista_imagens.jsp" %>
									</div>

									<div class="tab-pane body fade" id="tabEnviarImagens"></div>
								</div>
							</div>

							<div class="modal-footer">
								<button class="btn btn-warning" data-dismiss="modal">Fechar</button>
							</div>
						</div>
					</div>
				</div>
				<!-- /modal with tabs -->

			</div>

			<%@include file="../../../botoes-cadastro.jsp"%>
	</form>
</div>
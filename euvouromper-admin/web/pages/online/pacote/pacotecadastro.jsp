<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../../../header-title.jsp"%>

<div class="panel panel-body">
	<form class="form-horizontal" role="form">
		<div class="FormularioCadastro FormularioGeral panel panel-default form-group" data-page-consulta="pacoteconsulta.admin" data-page-operacao="${operacao}" data-page-cadastro="pacotecadastro.admin">
			<div class="panel-body">
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">C&oacute;digo</label>
					<div class="col-sm-7">
						<input id="idPacote" type="text" disabled="disabled" class="form-control" value="${vo.idPacote }" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Nome</label>
					<div class="col-sm-7">
						<input id="nome" type="text" value="${vo.nome}" autofocus="autofocus" class="form-control" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label text-right"></label>
					<div class="col-sm-7">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h6 class="panel-title">
									<i class="icon-pencil"></i>Objetivo
								</h6>
							</div>
							<div class="panel-body">
								<div class="block-inner">
									<textarea id="objetivo" rows="20" class="editor form-control" placeholder="Digite o texto aqui...">${vo.objetivo}</textarea>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label text-right"></label>
					<div class="col-sm-7">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h6 class="panel-title">
									<i class="icon-pencil"></i>Conteúdo
								</h6>
							</div>
							<div class="panel-body">
								<div class="block-inner">
									<textarea id="conteudo" rows="20" class="editor form-control" placeholder="Digite o texto aqui...">${vo.conteudo}</textarea>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<%@include file="../../../botoes-cadastro.jsp"%>
			</div>
		</div>

	</form>
</div>
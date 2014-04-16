<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../../../header-title.jsp"%>

<div class="panel panel-body">
	<form class="form-horizontal" action="#" role="form">
		<div class="FormularioCadastro FormularioGeral panel panel-default form-group" data-page-consulta="professorconsulta.admin" data-page-operacao="${operacao}" data-page-cadastro="professorcadastro.admin">
			<div class="panel-body">
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
					<label class="col-sm-2 control-label text-right">T�tulo</label>
					<div class="col-sm-7">
						<input id="titulo" type="text" value="${vo.titulo}" class="form-control" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">URL</label>
					<div class="col-sm-7">
						<input id="url" type="text" value="${vo.url}" class="form-control" />
					</div>
				</div>

				<div class="form-group">
					<div>
						<label class="col-sm-2 control-label text-right">Foto do professor</label> <a href="#" class="BotaoSelecionarImagem btn btn-primary" data-image-retorno="#imgFoto" data-input-retorno="#pathFoto"><i class="icon-image"></i> Selecionar imagem</a> <img id="imgFoto" name="imgFoto" src="${vo.pathFoto}" class="thumb img-thumbnail" style="max-height: 120px; max-width: 120px; width: auto; height: auto;" /> <input type="hidden" id="pathFoto" name="pathFoto" value="${vo.pathFoto}" class="form-control" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label text-right"></label>
					<div class="col-sm-7">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h6 class="panel-title">
									<i class="icon-pencil"></i>Mini Curr�culo
								</h6>
							</div>
							<div class="panel-body">
								<div class="block-inner">
									<textarea id="miniCurriculo" rows="20" class="editor form-control" placeholder="Digite o texto aqui...">${vo.miniCurriculo}</textarea>
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
									<i class="icon-pencil"></i>Curr�culo
								</h6>
							</div>
							<div class="panel-body">
								<div class="block-inner">
									<textarea id="curriculo" rows="20" class="editor form-control" placeholder="Digite o texto aqui...">${vo.curriculo}</textarea>
								</div>
							</div>
						</div>
					</div>
				</div>

				<%@include file="../../utils/lista_imagens.jsp"%>
				<%@include file="../../../botoes-cadastro.jsp"%>
			</div>
		</div>


	</form>
</div>

<script type="text/javascript">
	
</script>
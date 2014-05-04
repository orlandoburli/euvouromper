<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../../../header-title.jsp"%>

<div class="panel panel-body">
	<form class="form-horizontal" action="#" role="form">
		<div class="FormularioCadastro FormularioGeral panel panel-default form-group" data-page-consulta="bannerconsulta.admin" data-page-operacao="${operacao}" data-page-cadastro="bannercadastro.admin">
			<div class="panel-body">
			
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">C&oacute;digo</label>
					<div class="col-sm-7">
						<input id="idBanner" type="text" disabled="disabled" class="form-control" value="${vo.idBanner }" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Título</label>
					<div class="col-sm-7">
						<input id="titulo" type="text" value="${vo.titulo}" autofocus="autofocus" class="form-control" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Sub-Título</label>
					<div class="col-sm-7">
						<input id="subTitulo" type="text" value="${vo.subTitulo}" class="form-control" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">URL</label>
					<div class="col-sm-7">
						<input id="url" type="text" value="${vo.url}" class="form-control" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Ativo</label>
					<div class="col-sm-7">
						<select id="ativo"  data-field-value="${vo.ativo}">
							<option value="N">Não</option>
							<option value="S">Sim</option>
						</select>
					</div>
				</div>
				
				<div class="form-group">
					<div>
						<label class="col-sm-2 control-label text-right">Imagem do Banenr</label> 
						<a href="#" class="BotaoSelecionarImagem btn btn-primary" data-image-retorno="#imgFoto" data-input-retorno="#pathImagem">
							<i class="icon-image"></i> Selecionar imagem
						</a> 
						<img id="imgFoto" name="imgFoto" src="${vo.pathImagem}" class="thumb img-thumbnail" style="max-height: 120px; max-width: 120px; width: auto; height: auto;" /> 
						<input type="hidden" id="pathImagem" name="pathImagem" value="${vo.pathImagem}" class="form-control" />
					</div>
				</div>

				<%@include file="../../utils/lista_imagens.jsp"%>

				<%@include file="../../../botoes-cadastro.jsp"%>
			</div>
		</div>
	</form>
</div>
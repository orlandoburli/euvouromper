<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../../../header-title.jsp"%>

<div class="panel panel-body">
	<form class="form-horizontal" action="#" role="form">
		<div class="FormularioCadastro FormularioGeral panel panel-default form-group" data-page-consulta="videoyoutubeconsulta.admin" data-page-operacao="${operacao}" data-page-cadastro="videoyoutubecadastro.admin">
			<div class="panel-body">
			
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">C&oacute;digo</label>
					<div class="col-sm-7">
						<input id="idVideoYoutube" type="text" disabled="disabled" class="form-control" value="${vo.idVideoYoutube }" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Descrição</label>
					<div class="col-sm-7">
						<input id="descricao" type="text" value="${vo.descricao}" autofocus="autofocus" class="form-control" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Chave</label>
					<div class="col-sm-7">
						<input id="chave" type="text" value="${vo.chave}" class="form-control" />
					</div>
				</div>

				<%@include file="../../../botoes-cadastro.jsp"%>
			</div>
		</div>
	</form>
</div>
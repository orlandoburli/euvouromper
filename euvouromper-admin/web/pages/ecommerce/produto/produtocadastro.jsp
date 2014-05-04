<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../../../header-title.jsp"%>

<div class="panel panel-body">
	<form class="form-horizontal" action="#" role="form">
		<div class="FormularioCadastro FormularioGeral panel panel-default form-group" data-page-consulta="produtoconsulta.admin" data-page-operacao="${operacao}" data-page-cadastro="produtocadastro.admin">
			<div class="panel-body">
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">C&oacute;digo</label>
					<div class="col-sm-7">
						<input id="idProduto" type="text" disabled="disabled" class="form-control" value="${vo.idProduto }" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Nome</label>
					<div class="col-sm-7">
						<input id="nome" type="text" value="${vo.nome}" autofocus="autofocus" class="form-control" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Valor</label>
					<div class="col-sm-2">
						<input id="valor" type="text" value="${vo.valor}" class="form-control" data-field-type="number" data-field-precision="2" />
					</div>
					
					<label class="col-sm-2 control-label text-right">URL</label>
					<div class="col-sm-3">
						<input id="url" type="text" value="${vo.url}" class="form-control" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Tipo de Produto</label>

					<div class="col-sm-2">
						<select id="tipoProduto"  data-field-value="${vo.tipoProduto}">
							<c:forEach var="tipo" items="${tipoProdutoList}">
								<option value="${tipo.valor }">${tipo.descricao}</option>
							</c:forEach>
						</select>
					</div>

					<label class="col-sm-2 control-label text-right">Ativo</label>

					<div class="col-sm-2">
						<select id="ativo"  data-field-value="${vo.ativo}">
							<option value="N">Não</option>
							<option value="S">Sim</option>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Módulo</label>

					<div class="col-sm-2">
						<select id="idModulo"  data-field-value="${vo.idModulo}">
							<option value="">[NENHUM]</option>
							<c:forEach var="modulo" items="${modulos}">
								<option value="${modulo.idModulo }">${modulo.nome}</option>
							</c:forEach>
						</select>
					</div>

					<label class="col-sm-2 control-label text-right">Pacote</label>

					<div class="col-sm-2">
						<select id="idPacote"  data-field-value="${vo.idPacote}">
							<option value="">[NENHUM]</option>
							<c:forEach var="pacote" items="${pacotes}">
								<option value="${pacote.idPacote }">${pacote.nome}</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Tipo de Validade</label>

					<div class="col-sm-2">
						<select id="tipoValidade"  data-field-value="${vo.tipoValidade}">
							<c:forEach var="tipo" items="${tipoValidadeList}">
								<option value="${tipo.valor }">${tipo.descricao}</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Data Validade</label>

					<div class="col-sm-2">
						<div class="col-sm-7">
							<fmt:formatDate value="${vo.dataValidade.time}" pattern="dd/MM/yyyy" var="dataValidadeFormatada" />
							<input id="dataValidade" type="text" value="${dataValidadeFormatada}" class="form-control datepicker" />
						</div>
					</div>

					<label class="col-sm-2 control-label text-right">Dias Validade</label>

					<div class="col-sm-2">
						<input id="diasValidade" type="text" value="${vo.diasValidade}" class="form-control" data-field-type="number" data-field-precision="0" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Recorrente</label>

					<div class="col-sm-2">
						<div class="col-sm-7">
							<select id="recorrente"  data-field-value="${vo.recorrente}">
								<option value="N">Não</option>
								<option value="S">Sim</option>
							</select>
						</div>
					</div>

					<label class="col-sm-2 control-label text-right">Dias Recorrência</label>

					<div class="col-sm-2">
						<input id="diasRecorrencia" type="text" value="${vo.diasRecorrencia}" class="form-control" data-field-type="number" data-field-precision="0" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right"> </label>
					<div class="col-sm-7">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h6 class="panel-title">
									<i class="icon-pencil"></i>Descrição
								</h6>
							</div>
							<div class="panel-body">
								<div class="block-inner">
									<textarea id="descricao" rows="20" class="editor form-control" placeholder="Digite o texto aqui...">${vo.descricao}</textarea>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<div>
						<label class="col-sm-2 control-label text-right">Foto do produto</label> <a href="#" class="BotaoSelecionarImagem btn btn-primary" data-image-retorno="#imgFoto" data-input-retorno="#pathFoto"><i class="icon-image"></i> Selecionar imagem</a> <img id="imgFoto" name="imgFoto" src="${vo.pathFoto}" class="thumb img-thumbnail" style="max-height: 120px; max-width: 120px; width: auto; height: auto;" /> <input type="hidden" id="pathFoto" name="pathFoto" value="${vo.pathFoto}" class="form-control" />
					</div>
				</div>

				<%@include file="../../utils/lista_imagens.jsp"%>

				<%@include file="../../../botoes-cadastro.jsp"%>
			</div>
		</div>

	</form>
</div>
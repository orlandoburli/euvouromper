<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../../../header-title.jsp"%>

<div class="panel panel-body">
	<form class="form-horizontal" action="#" role="form">
		<div class="FormularioCadastro FormularioGeral panel panel-default form-group" data-page-consulta="perfiladminconsulta.admin" data-page-operacao="${operacao}" data-page-cadastro="perfiladmincadastro.admin">
			<div class="panel-body">
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

				<!-- ADMINISTRACAO -->
				<div class="col-md-12 form-group" id="grupoAdministracao">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h6 class="panel-title">
								<i class="icon-paragraph-justify2"></i> Administra��o
							</h6>
						</div>
						<div class="panel-body">
							<div class="form-group">
								<label class="col-sm-2 control-label text-right">Visualizar Par�metros</label>

								<div class="col-sm-2">
									<select id="permissaoParametroVer"  data-field-value="${vo.permissaoParametroVer}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>

								<label class="col-sm-2 control-label text-right">Alterar Perfil</label>

								<div class="col-sm-2">
									<select id="permissaoParametroAlt"  data-field-value="${vo.permissaoParametroAlt}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label text-right">Visualizar Perfil</label>

								<div class="col-sm-2">
									<select id="permissaoPerfilVer"  data-field-value="${vo.permissaoPerfilVer}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>

								<label class="col-sm-2 control-label text-right">Alterar Perfil</label>

								<div class="col-sm-2">
									<select id="permissaoPerfilAlt"  data-field-value="${vo.permissaoPerfilAlt}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label text-right">Visualizar Usu�rios</label>

								<div class="col-sm-2">
									<select id="permissaoUsuarioVer"  data-field-value="${vo.permissaoUsuarioVer}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>

								<label class="col-sm-2 control-label text-right">Alterar Usu�rios</label>

								<div class="col-sm-2">
									<select id="permissaoUsuarioAlt"  data-field-value="${vo.permissaoUsuarioAlt}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- grupoAdministracao -->

				<!-- CADASTROS  -->
				<div class="col-md-12 form-group" id="grupoCadastros">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h6 class="panel-title">
								<i class="icon-paragraph-justify2"></i> Cadastros
							</h6>
						</div>
						<div class="panel-body">
							<div class="form-group">
								<label class="col-sm-2 control-label text-right">Visualizar Disciplinas</label>

								<div class="col-sm-2">
									<select id="permissaoDisciplinaVer"  data-field-value="${vo.permissaoDisciplinaVer}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>

								<label class="col-sm-2 control-label text-right">Alterar Disciplinas</label>

								<div class="col-sm-2">
									<select id="permissaoDisciplinaAlt"  data-field-value="${vo.permissaoDisciplinaAlt}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label text-right">Visualizar Professores</label>

								<div class="col-sm-2">
									<select id="permissaoProfessorVer"  data-field-value="${vo.permissaoProfessorVer}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>

								<label class="col-sm-2 control-label text-right">Alterar Professores</label>

								<div class="col-sm-2">
									<select id="permissaoProfessorAlt"  data-field-value="${vo.permissaoProfessorAlt}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- grupoCadastros -->

				<!-- SITE -->
				<div class="col-md-12 form-group" id="grupoSite">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h6 class="panel-title">
								<i class="icon-paragraph-justify2"></i> Site
							</h6>
						</div>
						<div class="panel-body">
							<div class="form-group">
								<label class="col-sm-2 control-label text-right">Visualizar Departamentos</label>

								<div class="col-sm-2">
									<select id="permissaoDepartamentoVer"  data-field-value="${vo.permissaoDepartamentoVer}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>

								<label class="col-sm-2 control-label text-right">Alterar Departamentos</label>

								<div class="col-sm-2">
									<select id="permissaoDepartamentoAlt"  data-field-value="${vo.permissaoDepartamentoAlt}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>
							</div>
							
							
							<div class="form-group">
								<label class="col-sm-2 control-label text-right">Visualizar Menus</label>

								<div class="col-sm-2">
									<select id="permissaoMenuVer"  data-field-value="${vo.permissaoMenuVer}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>

								<label class="col-sm-2 control-label text-right">Alterar Menus</label>

								<div class="col-sm-2">
									<select id="permissaoMenuAlt"  data-field-value="${vo.permissaoMenuAlt}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-2 control-label text-right">Visualizar Banners</label>

								<div class="col-sm-2">
									<select id="permissaoBannerVer"  data-field-value="${vo.permissaoBannerVer}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>

								<label class="col-sm-2 control-label text-right">Alterar Banners</label>

								<div class="col-sm-2">
									<select id="permissaoBannerAlt"  data-field-value="${vo.permissaoBannerAlt}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label text-right">Visualizar Not�cias</label>

								<div class="col-sm-2">
									<select id="permissaoNoticiaVer"  data-field-value="${vo.permissaoNoticiaVer}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>

								<label class="col-sm-2 control-label text-right">Alterar Not�cias</label>

								<div class="col-sm-2">
									<select id="permissaoNoticiaAlt"  data-field-value="${vo.permissaoNoticiaAlt}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label text-right">Visualizar Artigos</label>

								<div class="col-sm-2">
									<select id="permissaoArtigoVer"  data-field-value="${vo.permissaoArtigoVer}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>

								<label class="col-sm-2 control-label text-right">Alterar Artigos</label>

								<div class="col-sm-2">
									<select id="permissaoArtigoAlt"  data-field-value="${vo.permissaoArtigoAlt}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-2 control-label text-right">Visualizar Agendas</label>

								<div class="col-sm-2">
									<select id="permissaoAgendaVer"  data-field-value="${vo.permissaoAgendaVer}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>

								<label class="col-sm-2 control-label text-right">Alterar Agendas</label>

								<div class="col-sm-2">
									<select id="permissaoAgendaAlt"  data-field-value="${vo.permissaoAgendaAlt}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label text-right">Visualizar P�ginas Institucionais</label>

								<div class="col-sm-2">
									<select id="permissaoInstitucionalVer"  data-field-value="${vo.permissaoInstitucionalVer}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>

								<label class="col-sm-2 control-label text-right">Alterar P�ginas Institucionais</label>

								<div class="col-sm-2">
									<select id="permissaoInstitucionalAlt"  data-field-value="${vo.permissaoInstitucionalAlt}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-2 control-label text-right">Visualizar Depoimentos</label>

								<div class="col-sm-2">
									<select id="permissaoDepoimentoVer"  data-field-value="${vo.permissaoDepoimentoVer}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>

								<label class="col-sm-2 control-label text-right">Alterar Depoimentos</label>

								<div class="col-sm-2">
									<select id="permissaoDepoimentoAlt"  data-field-value="${vo.permissaoDepoimentoAlt}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-2 control-label text-right">Visualizar V�deos YouTube</label>

								<div class="col-sm-2">
									<select id="permissaoVideoYoutubeVer"  data-field-value="${vo.permissaoVideoYoutubeVer}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>

								<label class="col-sm-2 control-label text-right">Alterar V�deos YouTube</label>

								<div class="col-sm-2">
									<select id="permissaoVideoYoutubeAlt"  data-field-value="${vo.permissaoVideoYoutubeAlt}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>
							</div>
							
						</div>
					</div>
				</div>
				<!-- grupoSite -->

				<!-- ONLINE -->
				<div class="col-md-12 form-group" id="grupoOnline">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h6 class="panel-title">
								<i class="icon-paragraph-justify2"></i> Online
							</h6>
						</div>
						<div class="panel-body">
							<div class="form-group">
								<label class="col-sm-2 control-label text-right">Visualizar V�deos</label>

								<div class="col-sm-2">
									<select id="permissaoVideoVer"  data-field-value="${vo.permissaoVideoVer}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>

								<label class="col-sm-2 control-label text-right">Alterar V�deos</label>

								<div class="col-sm-2">
									<select id="permissaoVideoAlt"  data-field-value="${vo.permissaoVideoAlt}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label text-right">Visualizar M�dulos</label>

								<div class="col-sm-2">
									<select id="permissaoModuloVer"  data-field-value="${vo.permissaoModuloVer}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>

								<label class="col-sm-2 control-label text-right">Alterar M�dulos</label>

								<div class="col-sm-2">
									<select id="permissaoModuloAlt"  data-field-value="${vo.permissaoModuloAlt}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label text-right">Visualizar Pacotes</label>

								<div class="col-sm-2">
									<select id="permissaoPacoteVer"  data-field-value="${vo.permissaoPacoteVer}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>

								<label class="col-sm-2 control-label text-right">Alterar Pacotes</label>

								<div class="col-sm-2">
									<select id="permissaoPacoteAlt"  data-field-value="${vo.permissaoPacoteAlt}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-2 control-label text-right">Visualizar Materiais de Apoio</label>

								<div class="col-sm-2">
									<select id="permissaoMaterialApoioVer"  data-field-value="${vo.permissaoMaterialApoioVer}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>

								<label class="col-sm-2 control-label text-right">Alterar Materiais de Apoio</label>

								<div class="col-sm-2">
									<select id="permissaoMaterialApoioAlt"  data-field-value="${vo.permissaoMaterialApoioAlt}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- grupoOnline -->

				<!-- E-COMMERCE  -->
				<div class="col-md-12 form-group" id="grupoEcommerce">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h6 class="panel-title">
								<i class="icon-paragraph-justify2"></i> e-Commerce
							</h6>
						</div>
						<div class="panel-body">
							<div class="form-group">
								<label class="col-sm-2 control-label text-right">Visualizar Produtos</label>

								<div class="col-sm-2">
									<select id="permissaoProdutoVer"  data-field-value="${vo.permissaoProdutoVer}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>

								<label class="col-sm-2 control-label text-right">Alterar Produtos</label>

								<div class="col-sm-2">
									<select id="permissaoProdutoAlt"  data-field-value="${vo.permissaoProdutoAlt}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label text-right">Visualizar Cupons de Desconto</label>

								<div class="col-sm-2">
									<select id="permissaoCupomVer"  data-field-value="${vo.permissaoCupomVer}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>

								<label class="col-sm-2 control-label text-right">Alterar Cupons de Desconto</label>

								<div class="col-sm-2">
									<select id="permissaoCupomAlt"  data-field-value="${vo.permissaoCupomAlt}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-2 control-label text-right">Visualizar Modelos de EMail</label>

								<div class="col-sm-2">
									<select id="permissaoEmailVer"  data-field-value="${vo.permissaoEmailVer}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>

								<label class="col-sm-2 control-label text-right">Alterar Modelos de Email</label>

								<div class="col-sm-2">
									<select id="permissaoEmailAlt"  data-field-value="${vo.permissaoEmailAlt}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-2 control-label text-right">Visualizar Mensagens</label>

								<div class="col-sm-2">
									<select id="permissaoMensagemVer"  data-field-value="${vo.permissaoMensagemVer}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>

								<label class="col-sm-2 control-label text-right">Alterar Visualizar Mensagens</label>

								<div class="col-sm-2">
									<select id="permissaoMensagemAlt"  data-field-value="${vo.permissaoMensagemAlt}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-2 control-label text-right">Visualizar Pedidos</label>

								<div class="col-sm-2">
									<select id="permissaoPedidoVer"  data-field-value="${vo.permissaoPedidoVer}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>

								<label class="col-sm-2 control-label text-right">Alterar Pedidos</label>

								<div class="col-sm-2">
									<select id="permissaoPedidoAlt"  data-field-value="${vo.permissaoPedidoAlt}">
										<option value="N">N�o</option>
										<option value="S">Sim</option>
									</select>
								</div>
							</div>
						</div>
					</div>


				</div>
				<!-- grupoEcommerce -->

				<%@include file="../../../botoes-cadastro.jsp"%>
			</div>
		</div>
	</form>
</div>
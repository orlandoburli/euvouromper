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
								<i class="icon-paragraph-justify2"></i> Administração
							</h6>
						</div>
						<div class="panel-body">
							<div class="form-group">
								<label class="col-sm-2 control-label text-right">Visualizar Parâmetros</label>

								<div class="col-sm-2">
									<select id="permissaoParametroVer" class="select" data-field-value="${vo.permissaoParametroVer}">
										<option value="N">Não</option>
										<option value="S">Sim</option>
									</select>
								</div>

								<label class="col-sm-2 control-label text-right">Alterar Perfil</label>

								<div class="col-sm-2">
									<select id="permissaoParametroAlt" class="select" data-field-value="${vo.permissaoParametroAlt}">
										<option value="N">Não</option>
										<option value="S">Sim</option>
									</select>
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

								<label class="col-sm-2 control-label text-right">Alterar Perfil</label>

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

								<label class="col-sm-2 control-label text-right">Alterar Usuários</label>

								<div class="col-sm-2">
									<select id="permissaoUsuarioAlt" class="select" data-field-value="${vo.permissaoUsuarioAlt}">
										<option value="N">Não</option>
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
									<select id="permissaoDisciplinaVer" class="select" data-field-value="${vo.permissaoDisciplinaVer}">
										<option value="N">Não</option>
										<option value="S">Sim</option>
									</select>
								</div>

								<label class="col-sm-2 control-label text-right">Alterar Disciplinas</label>

								<div class="col-sm-2">
									<select id="permissaoDisciplinaAlt" class="select" data-field-value="${vo.permissaoDisciplinaAlt}">
										<option value="N">Não</option>
										<option value="S">Sim</option>
									</select>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label text-right">Visualizar Professores</label>

								<div class="col-sm-2">
									<select id="permissaoProfessorVer" class="select" data-field-value="${vo.permissaoProfessorVer}">
										<option value="N">Não</option>
										<option value="S">Sim</option>
									</select>
								</div>

								<label class="col-sm-2 control-label text-right">Alterar Professores</label>

								<div class="col-sm-2">
									<select id="permissaoProfessorAlt" class="select" data-field-value="${vo.permissaoProfessorAlt}">
										<option value="N">Não</option>
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
								<label class="col-sm-2 control-label text-right">Visualizar Menus</label>

								<div class="col-sm-2">
									<select id="permissaoMenuVer" class="select" data-field-value="${vo.permissaoMenuVer}">
										<option value="N">Não</option>
										<option value="S">Sim</option>
									</select>
								</div>

								<label class="col-sm-2 control-label text-right">Alterar Menus</label>

								<div class="col-sm-2">
									<select id="permissaoMenuAlt" class="select" data-field-value="${vo.permissaoMenuAlt}">
										<option value="N">Não</option>
										<option value="S">Sim</option>
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-2 control-label text-right">Visualizar Banners</label>

								<div class="col-sm-2">
									<select id="permissaoBannerVer" class="select" data-field-value="${vo.permissaoBannerVer}">
										<option value="N">Não</option>
										<option value="S">Sim</option>
									</select>
								</div>

								<label class="col-sm-2 control-label text-right">Alterar Banners</label>

								<div class="col-sm-2">
									<select id="permissaoBannerAlt" class="select" data-field-value="${vo.permissaoBannerAlt}">
										<option value="N">Não</option>
										<option value="S">Sim</option>
									</select>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label text-right">Visualizar Notícias</label>

								<div class="col-sm-2">
									<select id="permissaoNoticiaVer" class="select" data-field-value="${vo.permissaoNoticiaVer}">
										<option value="N">Não</option>
										<option value="S">Sim</option>
									</select>
								</div>

								<label class="col-sm-2 control-label text-right">Alterar Notícias</label>

								<div class="col-sm-2">
									<select id="permissaoNoticiaAlt" class="select" data-field-value="${vo.permissaoNoticiaAlt}">
										<option value="N">Não</option>
										<option value="S">Sim</option>
									</select>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label text-right">Visualizar Artigos</label>

								<div class="col-sm-2">
									<select id="permissaoArtigoVer" class="select" data-field-value="${vo.permissaoArtigoVer}">
										<option value="N">Não</option>
										<option value="S">Sim</option>
									</select>
								</div>

								<label class="col-sm-2 control-label text-right">Alterar Artigos</label>

								<div class="col-sm-2">
									<select id="permissaoArtigoAlt" class="select" data-field-value="${vo.permissaoArtigoAlt}">
										<option value="N">Não</option>
										<option value="S">Sim</option>
									</select>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label text-right">Visualizar Páginas Institucionais</label>

								<div class="col-sm-2">
									<select id="permissaoInstitucionalVer" class="select" data-field-value="${vo.permissaoInstitucionalVer}">
										<option value="N">Não</option>
										<option value="S">Sim</option>
									</select>
								</div>

								<label class="col-sm-2 control-label text-right">Alterar Páginas Institucionais</label>

								<div class="col-sm-2">
									<select id="permissaoInstitucionalAlt" class="select" data-field-value="${vo.permissaoInstitucionalAlt}">
										<option value="N">Não</option>
										<option value="S">Sim</option>
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-2 control-label text-right">Visualizar Depoimentos</label>

								<div class="col-sm-2">
									<select id="permissaoDepoimentoVer" class="select" data-field-value="${vo.permissaoDepoimentoVer}">
										<option value="N">Não</option>
										<option value="S">Sim</option>
									</select>
								</div>

								<label class="col-sm-2 control-label text-right">Alterar Depoimentos</label>

								<div class="col-sm-2">
									<select id="permissaoDepoimentoAlt" class="select" data-field-value="${vo.permissaoDepoimentoAlt}">
										<option value="N">Não</option>
										<option value="S">Sim</option>
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-2 control-label text-right">Visualizar Vídeos YouTube</label>

								<div class="col-sm-2">
									<select id="permissaoVideoYoutubeVer" class="select" data-field-value="${vo.permissaoVideoYoutubeVer}">
										<option value="N">Não</option>
										<option value="S">Sim</option>
									</select>
								</div>

								<label class="col-sm-2 control-label text-right">Alterar Vídeos YouTube</label>

								<div class="col-sm-2">
									<select id="permissaoVideoYoutubeAlt" class="select" data-field-value="${vo.permissaoVideoYoutubeAlt}">
										<option value="N">Não</option>
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
								<label class="col-sm-2 control-label text-right">Visualizar Vídeos</label>

								<div class="col-sm-2">
									<select id="permissaoVideoVer" class="select" data-field-value="${vo.permissaoVideoVer}">
										<option value="N">Não</option>
										<option value="S">Sim</option>
									</select>
								</div>

								<label class="col-sm-2 control-label text-right">Alterar Vídeos</label>

								<div class="col-sm-2">
									<select id="permissaoVideoAlt" class="select" data-field-value="${vo.permissaoVideoAlt}">
										<option value="N">Não</option>
										<option value="S">Sim</option>
									</select>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label text-right">Visualizar Módulos</label>

								<div class="col-sm-2">
									<select id="permissaoModuloVer" class="select" data-field-value="${vo.permissaoModuloVer}">
										<option value="N">Não</option>
										<option value="S">Sim</option>
									</select>
								</div>

								<label class="col-sm-2 control-label text-right">Alterar Módulos</label>

								<div class="col-sm-2">
									<select id="permissaoModuloAlt" class="select" data-field-value="${vo.permissaoModuloAlt}">
										<option value="N">Não</option>
										<option value="S">Sim</option>
									</select>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label text-right">Visualizar Pacotes</label>

								<div class="col-sm-2">
									<select id="permissaoPacoteVer" class="select" data-field-value="${vo.permissaoPacoteVer}">
										<option value="N">Não</option>
										<option value="S">Sim</option>
									</select>
								</div>

								<label class="col-sm-2 control-label text-right">Alterar Pacotes</label>

								<div class="col-sm-2">
									<select id="permissaoPacoteAlt" class="select" data-field-value="${vo.permissaoPacoteAlt}">
										<option value="N">Não</option>
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
									<select id="permissaoProdutoVer" class="select" data-field-value="${vo.permissaoProdutoVer}">
										<option value="N">Não</option>
										<option value="S">Sim</option>
									</select>
								</div>

								<label class="col-sm-2 control-label text-right">Alterar Produtos</label>

								<div class="col-sm-2">
									<select id="permissaoProdutoAlt" class="select" data-field-value="${vo.permissaoProdutoAlt}">
										<option value="N">Não</option>
										<option value="S">Sim</option>
									</select>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label text-right">Visualizar Cupons de Desconto</label>

								<div class="col-sm-2">
									<select id="permissaoCupomVer" class="select" data-field-value="${vo.permissaoCupomVer}">
										<option value="N">Não</option>
										<option value="S">Sim</option>
									</select>
								</div>

								<label class="col-sm-2 control-label text-right">Alterar Cupons de Desconto</label>

								<div class="col-sm-2">
									<select id="permissaoCupomAlt" class="select" data-field-value="${vo.permissaoCupomAlt}">
										<option value="N">Não</option>
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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Sidebar -->
<div class="sidebar collapse">
	<div class="sidebar-content">

		<!-- User dropdown -->
		<div class="user-menu dropdown">
			<a href="#" class="dropdown-toggle" data-toggle="dropdown"> <img src="${usuario.pathFoto}" class="thumbnail-boxed"> <span class="user-info"> ${usuario.nome} <span>${usuario.perfil.nome}</span> <span>${usuario.email}</span>
			</span>
			</a>

			<div class="popup dropdown-menu dropdown-menu-right">
				<div class="thumbnail">
					<div class="thumb">
						<img src="${usuario.pathFoto}" class="thumbnail-boxed">
						<div class="thumb-options">
							<span> <a href="#" data-placement="top" class="btn btn-icon btn-success tip" data-original-title="Editar meus dados"> <i class="icon-pencil"></i>
							</a> <!-- <a href="#" class="btn btn-icon btn-success"><i class="icon-remove"></i></a> -->
							</span>
						</div>
					</div>

					<div class="caption text-center">
						<h6>
							${usuario.nome} <small>${usuario.perfil.nome }</small>
						</h6>
					</div>
				</div>

				<ul class="list-group">
					<!-- <li class="list-group-item"><i class="icon-camera7 text-muted"></i> Minhas aulas <span class="label label-success">289</span></li>
					<li class="list-group-item"><i class="icon-bubble5 text-muted"></i> Perguntas <span class="label label-danger">892</span></li>
					<li class="list-group-item"><i class="icon-stats2 text-muted"></i> Relatórios <span class="label label-primary">92</span></li>
					<li class="list-group-item"><i class="icon-stack text-muted"></i> Saldo Financeiro<h5 class="pull-right text-danger">$45.389</h5></li> -->
				</ul>
			</div>
		</div>
		<!-- /user dropdown -->

		<!-- Main navigation -->
		<ul class="navigation">
			<li class="active"><a href="#" data-link="painel.admin"><span>Home</span> <i class="icon-home3"></i></a></li>

			<li><a href="#" class="expand"><span>Administração</span> <i class="icon-paragraph-justify2"></i></a>
				<ul>
					<c:if test="${usuario.perfil.permissaoParametroVer eq 'S' }">
						<li><a data-menu-type="link" data-link="parametroconsulta.admin">Parâmetros</a></li>
					</c:if>
					<c:if test="${usuario.perfil.permissaoUsuarioVer eq 'S' }">
						<li><a data-menu-type="link" data-link="usuarioconsulta.admin">Usuário</a></li>
					</c:if>
					<c:if test="${usuario.perfil.permissaoPerfilVer eq 'S' }">
						<li><a data-menu-type="link" data-link="perfiladminconsulta.admin">Perfis</a></li>
					</c:if>
				</ul></li>

			<li><a href="#" class="expand"><span>Cadastros</span> <i class="icon-paragraph-justify2"></i></a>
				<ul>
					<c:if test="${usuario.perfil.permissaoDisciplinaVer eq 'S' }">
						<li><a data-menu-type="link" data-link="disciplinaconsulta.admin">Disciplinas</a></li>
					</c:if>
					<c:if test="${usuario.perfil.permissaoProfessorVer eq 'S' }">
						<li><a data-menu-type="link" data-link="professorconsulta.admin">Professores</a></li>
					</c:if>
				</ul></li>

			<li><a href="#" class="expand"><span>Site</span> <i class="icon-paragraph-justify2"></i></a>
				<ul>
					<c:if test="${usuario.perfil.permissaoDepartamentoVer eq 'S' }">
						<li><a data-menu-type="link" data-link="departamentoconsulta.admin">Departamentos</a></li>
					</c:if>
					<c:if test="${usuario.perfil.permissaoMenuVer eq 'S' }">
						<li><a data-menu-type="link" data-link="menuconsulta.admin">Menus</a></li>
					</c:if>
					<c:if test="${usuario.perfil.permissaoBannerVer eq 'S' }">
						<li><a data-menu-type="link" data-link="bannerconsulta.admin">Banners</a></li>
					</c:if>
					<c:if test="${usuario.perfil.permissaoNoticiaVer eq 'S' }">
						<li><a data-menu-type="link" data-link="noticiaconsulta.admin">Notícias</a></li>
					</c:if>
					<c:if test="${usuario.perfil.permissaoArtigoVer eq 'S' }">
						<li><a data-menu-type="link" data-link="artigoconsulta.admin">Artigos</a></li>
					</c:if>
					<c:if test="${usuario.perfil.permissaoAgendaVer eq 'S' }">
						<li><a data-menu-type="link" data-link="agendaconsulta.admin">Agenda</a></li>
					</c:if>
					<c:if test="${usuario.perfil.permissaoInstitucionalVer eq 'S' }">
						<li><a data-menu-type="link" data-link="institucionalconsulta.admin">Páginas Institucionais</a></li>
					</c:if>
					<c:if test="${usuario.perfil.permissaoDepoimentoVer eq 'S' }">
						<li><a data-menu-type="link" data-link="depoimentoconsulta.admin">Depoimentos</a></li>
					</c:if>
					<c:if test="${usuario.perfil.permissaoVideoYoutubeVer eq 'S' }">
						<li><a data-menu-type="link" data-link="videoyoutubeconsulta.admin">Vídeos YouTube</a></li>
					</c:if>
				</ul></li>

			<li><a href="#" class="expand"><span>Online</span> <i class="icon-paragraph-justify2"></i></a>
				<ul>
					<c:if test="${usuario.perfil.permissaoVideoVer eq 'S' }">
						<li><a data-menu-type="link" data-link="videoconsulta.admin">Vídeos</a></li>
					</c:if>
					<c:if test="${usuario.perfil.permissaoModuloVer eq 'S' }">
						<li><a data-menu-type="link" data-link="moduloconsulta.admin">Módulos</a></li>
					</c:if>
					<c:if test="${usuario.perfil.permissaoPacoteVer eq 'S' }">
						<li><a data-menu-type="link" data-link="pacoteconsulta.admin">Pacotes</a></li>
					</c:if>
					
					<c:if test="${usuario.perfil.permissaoMaterialApoioVer eq 'S' }">
						<li><a data-menu-type="link" data-link="materialapoioconsulta.admin">Materiais de Apoio</a></li>
					</c:if>
				</ul></li>

			<li><a href="#" class="expand"><span>e-Commerce</span> <i class="icon-paragraph-justify2"></i></a>
				<ul>
					<c:if test="${usuario.perfil.permissaoProdutoVer eq 'S' }">
						<li><a data-menu-type="link" data-link="produtoconsulta.admin">Produtos</a></li>
					</c:if>
					<c:if test="${usuario.perfil.permissaoCupomVer eq 'S' }">
						<li><a data-menu-type="link" data-link="cupomdescontoconsulta.admin">Cupons de Desconto</a></li>
					</c:if>
					<c:if test="${usuario.perfil.permissaoEmailVer eq 'S' }">
						<li><a data-menu-type="link" data-link="emailconsulta.admin">Modelos de Email</a></li>
					</c:if>
					<c:if test="${usuario.perfil.permissaoMensagemVer eq 'S' }">
						<li><a data-menu-type="link" data-link="mensagemconsulta.admin">Mensagens</a></li>
					</c:if>
					<c:if test="${usuario.perfil.permissaoPedidoVer eq 'S' }">
						<li><a data-menu-type="link" data-link="pedidoconsulta.admin">Pedidos</a></li>
					</c:if>
				</ul></li>
		</ul>
		<!-- /main navigation -->

	</div>
</div>
<!-- /sidebar -->
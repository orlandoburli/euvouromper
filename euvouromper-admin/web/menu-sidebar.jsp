<!-- Sidebar -->
<div class="sidebar collapse">
	<div class="sidebar-content">

		<!-- User dropdown -->
		<div class="user-menu dropdown">
			<a href="#" class="dropdown-toggle" data-toggle="dropdown"> <img src="http://placehold.it/300"> <span class="user-info"> ${usuario.nome} <span>${usuario.perfil.nome}</span>
			</span>
			</a>
			<div class="popup dropdown-menu dropdown-menu-right">
				<div class="thumbnail">
					<div class="thumb">
						<img src="http://placehold.it/300">
						<div class="thumb-options">
							<span> <a href="#" class="btn btn-icon btn-success"><i class="icon-pencil"></i></a> <a href="#" class="btn btn-icon btn-success"><i class="icon-remove"></i></a>
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
					<li class="list-group-item"><i class="icon-camera7 text-muted"></i> Minhas aulas <span class="label label-success">289</span></li>
					<li class="list-group-item"><i class="icon-bubble5 text-muted"></i> Perguntas <span class="label label-danger">892</span></li>
					<li class="list-group-item"><i class="icon-stats2 text-muted"></i> Relatórios <span class="label label-primary">92</span></li>
					<li class="list-group-item"><i class="icon-stack text-muted"></i> Saldo Financeiro<h5 class="pull-right text-danger">$45.389</h5></li>
				</ul>
			</div>
		</div>
		<!-- /user dropdown -->

		<!-- Main navigation -->
		<ul class="navigation">
			<li class="active"><a href="#" data-link="painel.admin"><span>Home</span> <i class="icon-home3"></i></a></li>

			<li>
				<a href="#" class="expand"><span>Administração</span> <i class="icon-paragraph-justify2"></i></a>
				<ul>
					<li><a data-menu-type="link" data-link="parametroconsulta.admin">Parâmetros</a></li>
					<li><a data-menu-type="link" data-link="usuarioconsulta.admin">Usuário</a></li>
					<li><a data-menu-type="link" data-link="perfiladminconsulta.admin">Perfis</a></li>
				</ul>
			</li>
			
			<li>
				<a href="#" class="expand"><span>Cadastros</span> <i class="icon-paragraph-justify2"></i></a>
				<ul>
					<li><a data-menu-type="link" data-link="disciplinaconsulta.admin">Disciplinas</a></li>
					<li><a data-menu-type="link" data-link="professorconsulta.admin">Professores</a></li>
				</ul>
			</li>
			
			<li>
				<a href="#" class="expand"><span>Online</span> <i class="icon-paragraph-justify2"></i></a>
				<ul>
					<li><a data-menu-type="link" data-link="videoconsulta.admin">Vídeos</a></li>
					<li><a data-menu-type="link" data-link="moduloconsulta.admin">Módulos</a></li>
					<li><a data-menu-type="link" data-link="pacoteconsulta.admin">Pacotes</a></li>
				</ul>
			</li>
		</ul>
		<!-- /main navigation -->

	</div>
</div>
<!-- /sidebar -->
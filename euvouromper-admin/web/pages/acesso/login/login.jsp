<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Admin - Orlando Burli Projetos de TI Personalizados</title>
	
	<%@include file="../../../header-includes.jsp"%>
	
	<script type="text/javascript" src="<%=request.getContextPath() %>/web/pages/js/login.js"></script>
	
	
</head>

<body class="full-width page-condensed">

	<!-- Navbar -->
	<div class="navbar navbar-inverse" role="navigation">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-right">
				<span class="sr-only">Toggle navbar</span> <i class="icon-grid3"></i>
			</button>
			<a class="navbar-brand" href="#">Eu Vou Romper - Admin | Orlando Burli Projetos de TI Personalizados</a>
		</div>

	</div>
	<!-- /navbar -->


	<!-- Login wrapper -->
	<div class="login-wrapper">
		<form action="#" role="form">
			<div class="popup-header">
				<span class="text-semibold">Login</span>
			</div>
			<div class="well">
				<div class="form-group has-feedback">
					<label>Login</label> <input id="login" name="login" value="${login_cookie}" type="text" class="form-control" placeholder="Login" autofocus="autofocus"> <i class="icon-user form-control-feedback"></i>
				</div>

				<div class="form-group has-feedback">
					<label>Senha</label> <input id="senha" name="senha" type="password" class="form-control" placeholder="Senha"> <i class="icon-lock form-control-feedback"></i>
				</div>

				<div class="row form-actions">
					<div class="col-xs-6">
						<div class="checkbox checkbox-success">
							<label> <input type="checkbox" class="styled" name="lembrarSenha" id="lembrarSenha" value="1"> Lembrar
							</label>
						</div>
					</div>

					<div class="col-xs-6">
						<button id="entrar" name="entrar" type="button" class="btn btn-warning pull-right">
							<i class="icon-menu2"></i> Entrar
						</button>
					</div>
				</div>
			</div>
		</form>
	</div>
	<!-- /login wrapper -->

	<%@include file="../../../footer.jsp"%>

</body>
</html>
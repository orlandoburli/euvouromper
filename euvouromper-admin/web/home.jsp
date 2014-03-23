<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>

	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Admin - Orlando Burli Projetos de TI Personalizados</title>
	
	<%@include file="header-includes.jsp"%>
	
	<script type="text/javascript" src="<%=request.getContextPath() %>/web/pages/js/geral.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/web/pages/js/home.js"></script>

</head>
<body class="sidebar-wide page-condensed">

	<%@include file="menu-navbar.jsp"%>

	<!-- Page container -->
	<div class="page-container">
		<%@include file="menu-sidebar.jsp"%>

		<!-- Page content -->
		<div class="page-content">
			
			<div id="formulario-home">
				<%-- <jsp:include page="painel.admin"></jsp:include> --%>
			</div>
		</div>
	</div>
	<!-- /page container -->

	<%@include file="footer.jsp"%>
</body>
</html>
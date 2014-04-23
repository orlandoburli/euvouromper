<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>

	<c:set var="root" value="<%= request.getServletContext().getContextPath() %>"/>	

	<title>Eu Vou Romper</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="product" content="">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="keywords" content="">

    <link href="${root}/web/assets/css/metro-bootstrap.css" rel="stylesheet">
    <link href="${root}/web/assets/css/metro-bootstrap-responsive.css" rel="stylesheet">
    <link href="${root}/web/assets/css/metro-bootstrap.css" rel="stylesheet">
    <link href="${root}/web/assets/css/iconFont.css" rel="stylesheet">
    <link href="${root}/web/assets/css/style-main.css" rel="stylesheet">
	<link href="${root}/web/assets/css/revolution.css" rel="stylesheet">
    <link href="${root}/web/assets/css/default_slider.css" rel="stylesheet">

    <!-- Load JavaScript Libraries -->
    <script src="${root}/web/assets/js/jquery/jquery.min.js"></script>
    <script src="${root}/web/assets/js/jquery/jquery.widget.min.js"></script>
    <script src="${root}/web/assets/js/jquery/jquery.mousewheel.js"></script>
	
    <!-- Metro UI CSS JavaScript plugins -->
	<script src="${root}/web/assets/js/jquery.number.min.js" type="text/javascript"></script>
	<script src="${root}/web/assets/js/jquery.themepunch.plugins.min.js" type="text/javascript"></script>
    
    <!-- <script src="${root}/web/assets/docs/js/load-metro.js"></script> -->
    <script src="${root}/web/assets/js/metro/metro.min.js"></script>
	<script src="${root}/web/assets/js/default.js" type="text/javascript"></script>
	<script src="${root}/web/assets/js/plugin_revolution.js" type="text/javascript"></script>
	<script src="${root}/web/assets/js/easypaginate.js" type="text/javascript" ></script>

</head>

<%@include file="initialize-fb.jsp" %>
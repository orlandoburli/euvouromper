<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<div id="fb-root"></div>
<!-- <script>
	(function(d, s, id) {
		var js, fjs = d.getElementsByTagName(s)[0];
		if (d.getElementById(id))
			return;
		js = d.createElement(s);
		js.id = id;
		js.src = "//connect.facebook.net/pt_BR/all.js#xfbml=1&appId=283509818470905";
		fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));
</script>
 -->

<script src="//connect.facebook.net/pt_BR/all.js"></script>

<script>
	FB.init({
		appId : '283509818470905', //ID da aplicação web definido no Facebook
		cookie : true, // permitir cookies para poder acessar a sessão
		status : true, // verificar o status do login
		xfbml : false, // usar ou não tags do Facebook
		oauth : true // autenticação via OAuth 2.0
	});
	
   function loginWithFacebook() {
          FB.login(function(response) {
             if (response.authResponse) {
              window.location = "${root}/entrar?token="+response.authResponse.accessToken;
             } else {
               console.log('User cancelled login or did not fully authorize.');
             }
           }, {scope: 'email'});
         }
</script>
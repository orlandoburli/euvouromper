var janelaAtiva = "";

$(function() {

	var tempo = 250;
	var isLoading = false;

	// Funcao principal de Login
	function entrar() {
		if ($("#login").val().length <= 0 || $("#senha").val().length <= 0) {
			$.jGrowl('Informe o usu&aacute;rio / senha!', { sticky: true, theme: 'growl-warning', header: 'Aviso' });
			$("#login").focus();
		} else {
			var params = {
				'login'        : $("#login").val(),
				'senha'        : $("#senha").val(),
				'lembrarSenha' : $("#lembrarSenha").prop('checked') ? "1" : "0"
			};
			
			$.ajax({
				url : "login.login.admin",
				type : "POST",
				data : params,

				beforeSend : function(data) {
//					debug("loading...");
				},

				success : function(data) {
					var retorno = $.parseJSON(data);

					if (retorno.sucesso) {
						if (retorno.mensagem == "LOGIN_OK") {
							finalLogin();
						}
					} else {
						$.jGrowl(retorno.mensagem, { sticky: true, theme: 'growl-error', header: 'Erro' });
						$("#login").focus();
					}
				},
				error : function(erro) {
//					debug("Erro no load ajax! " + erro);
				}
			});
		}
	}

	function finalLogin() {
		//trocar(janelaAtiva, "#form-loading");
		var isOk = false;
		
	    $('body').append('<div class="overlay"><div class="opacity"><i class="icon-spinner7 spin"></i></div>');
	    $('.overlay').fadeIn(150);
		
	    window.setTimeout(function(){
	        $('.overlay').fadeOut(150, function() {
	        	$(this).remove();
	        	if (isOk) {
	        		$(window).attr("location", "home.admin");	
	        	}
	        });
	    },1000);
		
		var params = {};

		$.ajax({
			url : "login.load.admin",
			type : "POST",
			data : params,
			beforeSend : function(data) {
//				debug("loading...");
			},
			success : function(data) {
//				debug(data);

				var retorno = $.parseJSON(data);

				if (retorno.sucesso) {
					// Redirect
					//$(window).attr("location", "home.admin");
					isOk = true;
				} else {
//					showMessage(retorno.mensagem);
//					isLoading = false;
					$.jGrowl(retorno.mensagem, { sticky: true, theme: 'growl-error', header: 'Erro' });
				}
			},
			error : function(erro) {
				debug("Erro no load ajax! " + erro);
			}
		});
	}

	// *************************************
	// EVENTOS
	// *************************************

	// Clique do login - valida se preencheu usuario e senha
	$("#entrar").click(function() {
		entrar();
	});

	// Exibe a mensagem de erro por 3 segundos
	function showMessage(messageText) {
		$("#form-mensagem").html(messageText);
		$("#form-mensagem").fadeIn(tempo);

		setTimeout(function() {
			$("#form-mensagem").fadeOut(tempo);
		}, 3000);
	}

	// Coloca o foco num componente, com um delay
	function focus(componenteId) {
		setTimeout(function() {
			$(componenteId).focus();
		}, tempo);
	}

	// 
	// Eventos de teclas dos inputs
	// 

	$("#login").keydown(function(event) {
		if (event.which == 13) {
			$("#senha").focus();
		}
	});

	$("#senha").keydown(function(event) {
		if (event.which == 13) {
			$("#entrar").click();
		}
	});

	$("#login").focus();
});
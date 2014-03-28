console.log("Carregando arquivo cadastro.js");

$(function() {

	// Carrega uma pagina
	function loadPage(pagina) {
		console.log(pagina);
		$("#formulario-home").fadeOut(tempo);
		setTimeout(function() {
			$("#formulario-home").load(pagina);
			setTimeout(function() {
				$("#formulario-home").fadeIn(tempo);
			}, tempo);
		}, tempo);
		
		// Forca o load dos componentes
		loadJs("web/pages/js/load.js");
	}

	// Carrega um arquivo .css
	function loadCSS(href) {
		setTimeout(function() {
			var cssLink = $("<link>");
			$("head").append(cssLink); // IE hack: append before setting href

			cssLink.attr({
				rel : "stylesheet",
				type : "text/css",
				href : href
			}, tempo * 4);
		});
	}

	// Carrega um arquivo .js
	function loadJs(jsFile) {
		setTimeout(function() {
			console.log("Carregando arquivo " + jsFile);
			$.getScript(jsFile).done(function(script, textStatus) {
				console.log("Arquivo " + jsFile + " carregado com sucesso.");
			}).fail(function(jqxhr, settings, exception) {
				console.log("Erro ao carregar js file - " + exception);
			});
		}, tempo * 2);
	}

	$(".BotaoSalvar").click(function() {
		salvar();
	});

	$(".BotaoExcluir").click(function() {
		excluir();
	});

	$(".BotaoVoltar").click(function() {
		voltar();
	})

	// Funcao de salvar o registro
	function salvar() {
		var paginaCadastro = $(".FormularioCadastro").attr("data-page-cadastro");
		var paginaBase = paginaCadastro.split(".")[0];
		var operacao = $(".FormularioCadastro").attr("data-page-operacao");
		var paginaFinal = paginaBase + "." + operacao + "." + paginaCadastro.split(".")[1];

		var params = {
			'operacao' : operacao
		};

		// Loop nos input's do form para enviar
		$("input,select,textarea").each(function(index) {
			params[$(this).attr("id")] = $(this).val();
		});

		$.ajax({
			url : paginaFinal,
			type : 'POST',
			data : params,
			beforeSend : function(data) {
				// console.log("loading...");
			},
			success : function(data) {

				var retorno = $.parseJSON(data);

				if (retorno.sucesso) {
					$.jGrowl(retorno.mensagem, { life : 2000, theme: 'growl-info', header: 'Aviso' });
					voltar();
				} else {
					$.jGrowl(retorno.mensagem, { life : 2000, theme: 'growl-error', header: 'Erro' });
					$("#" + retorno.fieldFocus).focus();
					
//					mensagemModal(retorno.mensagem, "Erro", function() {
						
//					});
				}
			},
			error : function(erro) {
				console.log("Erro no load ajax! " + erro);
			}
		});
	}

	// Funcao de excluir o registro
	function excluirOld() {
		confirmacaoModal("Confirma a exclusão deste registro?", "Confirmação", excluirConfirmado);
	}

	function excluir() {
		var paginaCadastro = $(".FormularioCadastro").attr("data-page-cadastro");
		var paginaBase = paginaCadastro.split(".")[0];
		var operacao = "excluir";
		var paginaFinal = paginaBase + "." + operacao + "." + paginaCadastro.split(".")[1];

		var params = {
			'operacao' : operacao
		};

		// Loop nos input's do form para enviar
		$("input,select").each(function(index) {
			params[$(this).attr("id")] = $(this).val();
		});

		$.ajax({
			url : paginaFinal,
			type : 'POST',
			data : params,
			beforeSend : function(data) {
				// console.log("loading...");
			},
			success : function(data) {

				var retorno = $.parseJSON(data);

				if (retorno.sucesso) {
					$.jGrowl(retorno.mensagem, { life : 2000, theme: 'growl-info', header: 'Aviso' });
//					mensagemModal(retorno.mensagem, "Confirmação", function() {
						voltar();
//					});
				} else {
					$.jGrowl(retorno.mensagem, { life : 2000, theme: 'growl-error', header: 'Erro' });
					$("#" + retorno.fieldFocus).focus();
//					mensagemModal(retorno.mensagem, "Erro", function() {
//						$("#" + retorno.fieldFocus).focus();
//					});
				}
			},
			error : function(erro) {
				console.log("Erro no load ajax! " + erro);
			}
		});
	}

	// Volta para a pagina de consulta
	function voltar() {
		// Forca esconder o modal - pode ter varios aqui...
		$('#selecao_imagem').modal('hide');
		
		var pageConsulta = $(".FormularioCadastro").attr("data-page-consulta");
		loadPage(pageConsulta);
		loadJs("web/pages/js/consulta.js");
	}

	// Funcao das teclas de cadastro
	var eventoTeclasCadastro = function(event) {
		
		switch (event.which) {
		
		case (KEY_ESC):
			event.preventDefault();
			voltar();
			break;

		case (KEY_S):
			if (event.ctrlKey) {
				event.preventDefault();
				salvar();
			}
			break;
		
		case (KEY_DEL):
			if (event.ctrlKey) {
				event.preventDefault();
				excluir();
			}
			break;
		}
	};

	// Seleciona os input's SELECT de acordo com a custom tag data-field-value
	$("select").each(function() {

		var val = $(this).attr("data-field-value");
		
		console.log($(this).attr("id") + " = " + val);
		
		if (val != null && val != "") {
			$(this).val(val);
		}
	});

	// Adiciona um option vazio ao select do tipo autocomplete
	$( "select[data-field-type='autocomplete']" ).prepend("<option value=\"\">NENHUM</option>");

	// Transforma os input's select em combobox autocomplete
	$( "select[data-field-type='autocomplete']" ).combobox();

	// Funcao keydown para tratar as teclas de cadastro
	$(document).ready(function() {
		$(document).off("keydown");
		
		// Verifica se e uma tela de cadastro
		if ($(".FormularioCadastro")) {
			$(document).on("keydown", eventoTeclasCadastro);
		}
	});

	// Funcao para input's numericos - Formata e coloca a mascara
	$("input[data-field-type='number']").each(function() {
		var decimais = $(this).attr("data-field-precision");

		var valueNumber = parseFloat($(this).val());
		valueNumber = valueNumber * (Math.pow(10, decimais));

		$(this).val(valueNumber);

		$(this).priceFormat({
			clearPrefix: true,
		    prefix: '',
		    centsSeparator: ',',
		    thousandsSeparator: '',
		    centsLimit : parseInt(decimais)
		});
	});
	
	// Funcao para caixa de selecao de imagens
	// ATENCAO - Obrigatorio o include do arquivo lista_imagens.jsp.
	$(".BotaoSelecionarImagem").click(function(e) {
		// Seta os atributos que serao de retorno
		$("#selecao_imagem").attr("data-image-retorno", $(e.currentTarget).attr("data-image-retorno"));
		$("#selecao_imagem").attr("data-input-retorno", $(e.currentTarget).attr("data-input-retorno"));
		
		$("#selecao_imagem").modal({
			keyboard : false
		});
	});

	// Funcao ENTER funcionar como TAB em input's
	textboxes = $("input:visible, select:visible, textarea:visible");

	if (browser.mozilla) {
		$(textboxes).keypress(checkForEnter);
	} else {
		$(textboxes).keydown(checkForEnter);
	}

	function checkForEnter(event) {
		if (event.keyCode == 13) {
			currentBoxNumber = textboxes.index(this);

			if (textboxes[currentBoxNumber + 1] != null) {
				nextBox = textboxes[currentBoxNumber + 1]
				nextBox.focus();
				nextBox.select();
				event.preventDefault();
				return false;
			}
		}
	}
});
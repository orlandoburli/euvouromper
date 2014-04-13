$(function(){

	var liWidth = $("#sliders ul li").outerWidth(),
		speed   = 3000,
		rotate	= setInterval(autoplay, speed);


	//mostra os botoes
	$("section#sliders").hover(function(){
		$("section#controls-navs").fadeIn();
		clearInterval(rotate);

	}, function(){
		$("section#controls-navs").fadeOut();
		rotate = setInterval(autoplay, speed);
	});

	
	//Proximo
	$(".nexts").click(function(e){
		e.prevsentDefault();

		$("section#sliders ul").css({'width':'99999%'}).animate({left: -liWidth}, function(){
			$("#sliders ul li").last().after($("#sliders ul li").first());
			$(this).css({'left': '0', 'width':'auto'});
		});
	});

	//Voltar
	$(".prevs").click(function(e){
		e.prevsentDefault();

		
		$("section#sliders ul li").first().before($("#sliders ul li").last().css({'margin-left':-liWidth}))
		$("section#sliders ul").css({'width': '99999%'}).animate({left:liWidth}, function(){
			$("#sliders ul li").first().css({'margin-left':'0'});
			$(this).css({'left': '0', 'width':'auto'});
		});
	});

	function autoplay(){
		$(".nexts").click();
	}

});
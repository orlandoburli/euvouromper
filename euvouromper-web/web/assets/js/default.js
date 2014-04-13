
$(function() {


	if ($('.sliders')[0]) {
		$('#slider').show().revolution({
			delay:9000,
			startheight:350,
			startwidth:$('.span12').width(),
			hideThumbs:200,
			thumbWidth:100,
			thumbHeight:50,
			thumbAmount:5,
			navigationType:"none",
			navigationArrows:"nextto",
			navigationStyle:"round",
			navigationHAlign:"center",
			navigationVAlign:"bottom",
			navigationHOffset:0,
			navigationVOffset:20,
			soloArrowLeftHalign:"left",
			soloArrowLeftValign:"center",
			soloArrowLeftHOffset:20,
			soloArrowLeftVOffset:0,
			soloArrowRightHalign:"right",
			soloArrowRightValign:"center",
			soloArrowRightHOffset:20,
			soloArrowRightVOffset:0,
			touchenabled:"on",
			onHoverStop:"on",
			stopAtSlide:-1,
			stopAfterLoops:-1,
			hideCaptionAtLimit:0,
			hideAllCaptionAtLilmit:0,
			hideSliderAtLimit:0,
			shadow:0,
			fullWidth:"on"
		});
	}

	

	


});
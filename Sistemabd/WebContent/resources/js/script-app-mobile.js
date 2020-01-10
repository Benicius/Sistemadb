jQuery(document).ready(function( $ )
{
	$(".menu-hamburger").on("click", function(){
		$(".menu-lateral").toggleClass("show-menu");
		$(".block").toggleClass("show-block");
	});
	
	$(".block").on("click", function(){
		$(".menu-lateral").removeClass("show-menu");
		$(".block").removeClass("show-block");
	});
});
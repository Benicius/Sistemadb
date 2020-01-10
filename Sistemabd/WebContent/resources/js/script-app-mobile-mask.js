jQuery(document).ready(function( $ )
{
	$(".campo-data").mask('00/00/0000', {reverse: false});
	$(".campo-cpf").mask('000.000.000-00', {reverse: false});
	$(".campo-telefone").mask('(00) 0 0000-0009', {reverse: false});
});
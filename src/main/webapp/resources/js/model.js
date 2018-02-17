document.getElementsByClassName('relatorio')[0].style.display="none";

$(function() {
	var panel1 = $('.panelInfoP');
	$('#btnToggle').click(function() {
		if (panel1.is(':visible')) {
			panel1.hide(200);
			$('#btnToggle').text('Mostrar');
		} else {
			panel1.show(200);
			$('#btnToggle').text('Menos');
		}
	});

	var panel2 = $('.panelProntuP');
	$('#btnToggle2').click(function() {
		if (panel2.is(':visible')) {
			panel2.hide(200);
			$('#btnToggle2').text('Mostrar');
		} else {
			panel2.show(200);
			$('#btnToggle2').text('Menos');
		}
	});
	
	
	var relatorio = $('.relatorio');
	$('#frmConsulta\\:btnPrint').click(function() {
		if (relatorio.is(':visible')) {
			relatorio.hide(200);
		} else {
			relatorio.show(200);
		}
	});
	
});
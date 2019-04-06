function submit(form) {

	var emails = document.getElementById("emails").value;
	var pwds = document.getElementById("pwds").value;

	if (emails == "") {
		alert("Please enter your email")
	}
	if (pwds == "") {
		alert("Please enter your password")
	}
	form.action=document.getElementById("applicationContext").value + '/login';
	form.target="_self";
	form.method="post";
	form.submit(form);
}
$(document).ready(function() {
	  $('#cars').on('change', function() {
	    var $form = $(this).closest('form');
	    $form.find('input[type=submit]').click();
	  });
	});
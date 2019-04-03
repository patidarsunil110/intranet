<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3"
	xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">

<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
 <!-- <script src="/js/validation.js">
	
</script>
 -->
<script type="text/javascript"
src="/js/validation.js">
</script>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
	font-family: sans-serif;
	background: black;
}

.container {
	width: 300px;
	padding: 40;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	background: #191919;
	text-align: center;
}

.container h2 {
	color: grey;
	text-transform: uppercase;
	font-weight: 500;
}

.container input[type="text"], .container input[type="password"],
	.container input[type="email"] {
	border: 0;
	background: none;
	display: block;
	margin: 20px auto;
	text-align: center;
	border: 2px solid #3498db;
	padding: 14px 10px;
	width: 200px;
	outline: none;
	color: white;
	border-radius: 24px;
	transition: 0.25s;
}

.container input[type="text"]:focus, .container input[type="password"]:focus,
	.container input[type="email"]:focus {
	width: 280px;
	border-color: #2ecc71;
}
</style>
<title>Login</title>
</head>
<body>



	<div class="container">
		<h2>Registration Form</h2>
		<form class="form-inline" name="welcome" method="post" action="/login">
			<div class="form-group">
				<input type="text" class="form-control" id="empName"
					placeholder="Enter Name" name="empName">
			</div>

			<div class="form-group">
				<input type="text" class="form-control" id="emails"
					placeholder="Enter Lastname" name="empLastName">
			</div>


			<div class="form-group">
				<input type="text" class="form-control" id="emails"
					placeholder="Enter Your Contact No" name="contact">
			</div>

			<div class="form-group">
				<input type="email" class="form-control" id="emails"
					placeholder="Enter Your Email" name="emailId">
			</div>

			<div class="form-group">
				<input type="password" class="form-control" id="pwds"
					placeholder="Enter  Your password" name="password">
			</div>
			<button type="submit" class="btn btn-default"
				onclick="submit(this.form);">Submit</button>
		</form>
	</div>
	<script type="text/javascript">
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
	</script>
</body>
</html>
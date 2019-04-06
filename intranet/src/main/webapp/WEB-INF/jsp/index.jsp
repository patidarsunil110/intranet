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

<!-- <script type="text/javascript" src="js/validation.js">
</script>
 -->
<style type="text/css">
body {
	margin: 0;
	padding: 0;
	font-family: sans-serif;
	background: black;
}

/* .container {
	width: 300px;
	padding: 40;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	background: #191919;
	text-align: center;
}
 */
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
		<form id="form" class="form-inline" name="welcome" method="post"
			action="/signup">
			<div class="form-group">
				<input type="text" class="form-control" id="empName"
					placeholder="Enter Name" name="empName">
			</div>

			<div class="form-group">
				<input type="text" class="form-control" id="empLastName"
					placeholder="Enter Lastname" name="empLastName">
			</div>


			<div class="form-group">
				<input type="text" class="form-control" id="mobile"
					placeholder="Enter Your Contact No" name="mobile">
			</div>

			<div class="form-group">
				<input type="email" class="form-control" id="manager"
					placeholder="Enter manager name" name="manager">
			</div>

			<div class="form-group">
				<input type="email" class="form-control" id="email"
					placeholder="Enter  Your email" name="email">
			</div>
			'

			<div class="form-group">
				<input type="password" class="form-control" id="password"
					placeholder="Enter  Your password" name="password">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" id="department"
					placeholder="Enter  department" name="department">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" id="dateOfJoining"
					placeholder="Enter  Your dob" name="dateOfJoining">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" id="designation"
					placeholder="Enter  Your email" name="designation">
			</div>
			<button type="submit" class="btn btn-default" onclick="myFunction()">Submit</button>
		</form>
	</div>

	<!-- <script>
	 
		function myFunction() {
		
		var emails = document.getElementById("emailId").value;
		var pwds = document.getElementById("password").value;
	
		var form = document.getElementById("form").value;

		if (emails == "") {
			alert("Please enter your email");
			return false;
			
		}
		
		else if (pwds == "") {
			alert("Please enter your password");
			return false;
		}
		alert("Inside function");
		form.action=document.getElementById("applicationContext").value + '/xyz';
		form.target="_self";
		form.method="post";
		form.submit(form);
  
		}
	</script> -->
</body>
</html>
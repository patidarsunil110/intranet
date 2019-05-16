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
	<%-- <c:if test="${not empty msg }">
		<div class="text-center well well-large" padding="right 50%">
			<h1>
				<font color="green">${msg}</font>
			</h1>
		</div>
	</c:if> --%>

	<c:if test="${not empty errorMsg }">
		<div class="text-center well well-large" padding="right 50%">
			<h1>
				<font color="red">${msg}</font>
			</h1>
		</div>
	</c:if>



	<div class="container">
		<h2>Registration Form</h2>
		<form id="form" class="form-inline" name="welcome" method="post"
			action="/addEmployee">
			<div class="form-group">
				<input type="text" class="form-control" id="empFirstName"
					placeholder="Enter Name" name="empFirstName">
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
				<input type="email" class="form-control" id="email"
					placeholder="Enter  Your email" name="email">
			</div>
			'

			<div class="form-group">
				<input type="password" class="form-control" id="password"
					placeholder="Enter  Your password" name="password">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" id="dateOfJoining"
					placeholder="Enter  Your dob" name="dateOfJoining">
			</div>
			<div class="row" style="padding-left: 10px">
			<div class="form-group">
				<select class="form-control" style="width: 300px;" id="departmentId"
					name="departmentId">
					<option value="0">--Select Department --</option>
					<option value="1">Devlopment</option>
					<option value="2">Support</option>
					<option value="3">Tester</option>

				</select>
			</div>
			<br>
			<br>
			<div class="form-group">
				<select class="form-control" style="width: 300px;" id="managerId"
					name="managerId">
					<option value="0">--Select Manager --</option>
					<option value="1">Manager 1</option>
					<option value="2">Manager 2</option>
					<option value="3">Manager 3</option>

				</select>
			</div>
			<div class="form-group">
				<select class="form-control" style="width: 300px;" id="roleId"
					name="roleId">
					<option value="0">--Select Role --</option>
					<option value="1">Employee</option>
					<option value="2">Manager</option>
					<option value="3">Admin </option>

				</select>
			</div>
						
			<div class="form-group">
				<select class="form-control" style="width: 300px;" id="desgnId"
					name="desgnId">
					<option value="0">--Select Designation --</option>
					<option value="1">Management Trainee</option>
					<option value="2">Executive</option>
					<option value="3">Sr. Executive</option>
					<option value="4">Team Leader</option>
					<option value="5">Sr. Team Leader</option>
					<option value="6">Sr. Project Leader</option>
					<option value="7">Program Manager</option>
					<option value="8">Administration</option>
					<option value="9">A. Vice President</option>
					<option value="10">Vice President</option>
					<option value="11">CEO</option>

				</select>
			</div>
			</div>
			<br> <br>
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
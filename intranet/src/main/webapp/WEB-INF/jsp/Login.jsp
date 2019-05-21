<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

 <script type="text/javascript" src="js/validation.js">
</script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
	font-family: sans-serif;
	background: skyblue;
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

.btn-default {
	font-size: 25px;
	font-family: inherit;
	border-color: white;
}

h1 {
	color: green;
	text-transform: inherit;
	font-weight: 500;
}
</style>

</head>

<body>
	<c:if test="${not empty errorMsg }">
<div class="text-center well well-lg">
<h1><font color="red">${errorMsg}</font></h1>
</div>
</c:if>

	<div class="container">
		<marquee font color="blue">
			<h1>Welcome To Intranet Project</h1>
		</marquee>

		<h2>Login Form</h2>
		<form class="form-inline" name="auth" method="post" action="/login">
			<div class="form-group">
				<input type="text" class="form-control" id="email"
					placeholder="Enter Email" name="email">
			</div>

			<div class="form-group">
				<input type="text" class="form-control" id="password"
					placeholder="Enter Password" name="password">
			</div>
			<div>
				<button type="button" class="btn btn-default"
					onclick="submit(this.form);">Login</button>
			</div>
		</form>
	</div>
	
	
<!-- 	<script type="text/javascript">
	
	
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
	
	</script> -->
</body>
</html>
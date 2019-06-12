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
	width: 320px;
	height: 280px;
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
body, html {
  height: 100%;
}

.bg { 
  /* The image used */
  background-image: url("images/login-bg.jpg");

  /* Full height */
  height: 100%; 

  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
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

.button {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 14 px;
  margin: 4px 2px;
  cursor: pointer;
}
.button4 {border-radius: 12px;}
</style>

</head>

<body>
<div class="bg"></div>

	<c:if test="${not empty errorMsg }">
<div class="text-center well well-lg">
<h1><font color="red">${errorMsg}</font></h1>
</div>
</c:if>

	<div class="container">
		<div class="m" style="color:blue">
			<h1>Intech People</h1>
		</div>

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
				<button type="button" class="button button4"
					onclick="submit(this.form);">Login</button>
					<button type="reset" class="button button4">
					Reset</button>
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
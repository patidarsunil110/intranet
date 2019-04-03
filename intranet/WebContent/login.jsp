<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
 
body{
margin: 0;
padding: 0;
font-family: sans-serif;
background: black;

}
.container{
width: 300px;
padding: 40;
position: absolute;
top: 50%;
left: 50%;
transform: translate(-50% , -50%);
background: #191919;
text-align: center;
}
.container h1{

color: white;
text-transform: uppercase;
font-weight: 500;
}
.container input[type= "text"], .container input[type="password"] {
	border: 0;
	background: none;
	display: block;
	margin: 20px auto;
	text-align: center;
	border: 2px solid #3498db;
	padding: 14px 10px ;
	width: 200px;
	outline: none;
	color: white;
	border-radius: 24px;
	transition:0.25s;
	
}
	
	
}
 
 
 
 
 </style>

</head>
<body>

<div class="container">
		<h1>Login Form</h1>
		<form class="form-inline" name="welcome" method="post" action="/login">
			<div class="form-group">
				<input type="text"
					class="form-control" id="empName" placeholder="Enter email"
					name="empName">
			</div>

			<div class="form-group">
		         <input type="password"
					class="form-control" id="password" placeholder="Enter Your Password"
					name="password">
					
					<input type="submit" name="" value="Login">
			</div>
			</form>
			</div>
		
</body>
</html>
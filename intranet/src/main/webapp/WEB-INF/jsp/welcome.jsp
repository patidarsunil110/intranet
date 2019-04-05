<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
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
 h1 {
	color: grey;
	text-transform: inherit;
	font-weight: 500;
}
.class{
font-size: 40px;
font-family: inherit;
}
</style>
</head>
<body>

<marquee font color="blue"><h1>Welcome To Intranet Project</h1></marquee>

<div class="container">
<a class="class" href="/signup" type="button">Signup here</a>
<a class="class" href="/login" type="button">Login here</a>

</div>
</body>
</html>
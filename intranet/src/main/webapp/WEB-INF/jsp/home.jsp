<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Welcome ${emails} And ${pwds}


	<div class="container">
		<h2>Login Form</h2>
		<form class="form-inline" name="auth" method="post" action="/login">
			<div class="form-group">
				<input type="text" class="form-control" id="emailId"
					placeholder="Enter Email" name="emailId">
			</div>

			<div class="form-group">
				<input type="text" class="form-control" id="password"
					placeholder="Enter Password" name="password">
			</div>
			<button type="submit" class="btn btn-default"
				onclick="submit(this.form);">Login</button>
		</form>
	</div>
</body>
</html>
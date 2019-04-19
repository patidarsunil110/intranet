<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update details</title>
</head>
<body>

	<div class="container">
		<h2>Registration Form</h2>
		<form id="form" class="form-inline" modelAttribute="update" method="post"
			action="/updateUser">
			
			<div class="form-group">
				<input type="hidden" class="form-control" id="empId"
					placeholder="Enter Name" name="empId" value="${user.empId}">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" id="empFirstName"
					placeholder="Enter Name" name="empFirstName"
					value="${user.empFirstName}">
			</div>

			<div class="form-group">
				<input type="text" class="form-control" id="empLastName"
					placeholder="Enter Lastname" name="empLastName"
					value="${user.empLastName}">
			</div>


			<div class="form-group">
				<input type="text" class="form-control" id="mobile"
					placeholder="Enter Your Contact No" name="mobile"
					value="${user.mobile}">
			</div>

			<div class="form-group">
				<input type="email" class="form-control" id="email"
					placeholder="Enter  Your email" name="email" value="${user.email}">
			</div>

			<div class="form-group">
				<input type="password" class="form-control" id="password"
					placeholder="Enter  Your password" name="password"
					value="${user.password}">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" id="department"
					placeholder="Enter  department" name="departmentId"
					value="${user.departmentId}">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" id="manager"
					placeholder="Enter manager name" name="managerId"
					value="${user.managerId}">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" id="dateOfJoining"
					placeholder="Enter  Your dob" name="dateOfJoining"
					value="${user.dateOfJoining}">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" id="roleId"
					placeholder="Enter  Your Role" name="roleId" value="${user.roleId}">
			</div>
			<button type="submit" class="btn btn-default" onclick="myFunction()">Submit</button>
		</form>
	</div>

</body>
</html>
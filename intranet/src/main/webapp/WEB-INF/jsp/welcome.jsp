<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

.msg {
	color: red;
	text-align: center;
}

.class {
	font-size: 40px;
	font-family: inherit;
}
</style>
</head>
<body>

	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="Home">Adventure</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li><a href="index"><span class="glyphicon glyphicon-home"></span>
						Home</a></li>
				<li class="active"><a href="userList"><span
						class="glyphicon glyphicon-th-list"></span> Users</a></li>
				<li><a href="Queries"><span
						class="glyphicon glyphicon-envelope"></span> Queries</a></li>
				<li><a href="AdminNotification"><span
						class="glyphicon glyphicon-bell"></span> Notification</a></li>
				<!-- <li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Destination <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Shimla</a></li>
						<li><a href="#">Kullu</a></li>
						<li><a href="#">Manali</a></li>
						<li><a href="#">Dharmshala</a></li>
						<li><a href="#">Chamba</a></li>
						<li><a href="#">Dalhousie</a></li>
						<li><a href="#">Kangra</a></li>
						<li><a href="#">Kasauli</a></li>
						<li><a href="#">Hamirpur</a></li>
						<li><a href="#">Parwanoo</a></li>
					</ul></li> -->

			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-log-in "></span>
						<%=session.getAttribute("username")%></a></li>
				<li><a href="logout"><span
						class="glyphicon glyphicon-log-out"></span> Logout</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<c:if test="${not empty msg }">
		<div class="text-center well well-large" padding="right 50%">
			<h1>
				<font color="green">${msg}</font>
			</h1>
		</div>
	</c:if>


	<h2 align="right">
		Welcome
		<%=session.getAttribute("username")%>
	</h2>

	<marquee font color="blue">
		<h1>Welcome To Intranet Project</h1>
	</marquee>


	<h1 class="msg">Employee List..!</h1>

	<div class="table-responsive">
		<table class="table">
			<thead>
				<tr>
					<th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Mobile</th>
					<th>Email</th>
					<th>Password</th>
					<th>Department Name</th>
					<th>Manager Name</th>
					<th>Date of Joining</th>
					<th>Role</th>
					<th colspan="2">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${employees}">
					<tr>
						<td>${user.empId}</td>
						<td>${user.empFirstName}</td>
						<td>${user.empLastName}</td>
						<td>${user.mobile}</td>
						<td>${user.email}</td>
						<td>${user.password}</td>
						<td>${user.departmentId}</td>
						<td>${user.managerId}</td>
						<td>${user.dateOfJoining}</td>
						<td>${user.roleId}</td>
						<td><a href="updateUser?id=${user.id}">Update</a></td>
						<td><a href="deleteUser?id=${user.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
	</div>

	<button href="/signup" type="button">Add Users</button>
	<a href="/signup">Add Users</a>

</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/index.css">
<nav class="navbar navbar-default">
<div class="container-fluid">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target="#myNavbar">
			<span class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="Home">i-HRMS</a>
	</div>
	<div class="collapse navbar-collapse" id="myNavbar">
		<ul class="nav navbar-nav">
			<li><a href="Home"><span class="glyphicon glyphicon-home"></span>
					Home</a></li>
			<li class="active"><a href="userList"><span
					class="glyphicon glyphicon-th-list"></span> Users</a></li>
			<li><a href="Queries"><span
					class="glyphicon glyphicon-envelope"></span> Queries</a></li>
			<li><a href="AdminNotification"><span
					class="glyphicon glyphicon-bell"></span> Notification</a></li>

		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="#"><span class="glyphicon glyphicon-log-in "></span>
					<%=session.getAttribute("username")%></a></li>
			<li><a href="logout"><span
					class="glyphicon glyphicon-log-out"></span> Logout</a></li>
		</ul>
	</div>
</div>
</nav>


<title>About</title>
</head>
<body style="color: black;">
	<div class="container">
		<div class="form">
			<form action="search" method="GET">
				<h5>
					<input type="text" name="searchParam">
				</h5>
				<h4>
					<input type="submit" value="Search">
				</h4>

			</form>
		</div>
		<div class="table-responsive">
			<table class="table">
				<thead>
					<tr>
						<th>EmpId</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Mobile</th>
						<th>Email</th>
						<th>Password</th>
						<th>Department Name</th>
						<th>Manager Name</th>
						<th>Date of Joining</th>
						<th>Role</th>
						<th colspan="2">Action</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="user" items="${employees}">
						<tr>
							<td>${user.empId}</td>
							<td>${user.empFirstName}</td>
							<td>${user.empLastName}</td>
							<td>${user.mobile}</td>
							<td>${user.email}</td>
							<td>${user.password}</td>
							<td>${user.departmentName}</td>
							<td>${user.managerName}</td>
							<td>${user.dateOfJoining}</td>
							<td>${user.roleName}</td>
							<td><form action="get" modelAttribute="updateEmployee ">
									<a href="updateUser?empId=${user.empId}">Update</a>
								</form></td>
							<td><form action="get" modelAttribute="deleteUser ">
									<a href="deleteUser?empId=${user.empId}">Delete</a>
								</form></td>
						</tr>
					</c:forEach>

				</tbody>

			</table>
		</div>
	</div>
	<!-- jQuery library -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

	<!-- Latest compiled JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
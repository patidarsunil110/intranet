<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 <!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	<style>
body {
	font-family: "Lato", sans-serif;
}

.sidenav {
	height: 100%;
	width: 230px;
	position: absolute;
	z-index: 1;
	top: 52px;
	left: 0;
	background-color: #111;
	overflow-x: hidden;
	padding-top: 5px;
}

.sidenav a {
	padding: 6px 8px 6px 16px;
	text-decoration: none;
	font-size: 20px;
	color: white;
	display: block;
}

.sidenav a:hover {
	color: #f1f1f1;
}

.main {
	margin-left: 240px; /* Same as the width of the sidenav */
	font-size: 25px; /* Increased text to enable scrolling */
	padding: 0px 10px;
}

@media screen and (max-height: 450px) {
	.sidenav {
		padding-top: 15px;
	}
	.sidenav a {
		font-size: 18px;
	}
}
</style>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">i-HRMS</a>
    </div>
    <ul class="nav navbar-nav navbar-right">
    			<li><a href="#"><span class="glyphicon glyphicon-user"></span><%=session.getAttribute("username")%></a></li>
				<li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </ul>
  </div>
</nav>
  
<div class="container">
	<div class="sidenav">
			<a href="/home">Home</a>
			<a href="/allUsers">Intech Pax List</a>
			<a href="/teamList">Team List</a>
			<a href="/leavebal">My Leave Balance</a> 
			<a href="/leaveapply">Apply Leave</a> 
			<a href="/attendance" name="attendance">Attendance</a>
			<a href="/payslips">Individual Payslip</a> 
			<a href="/tax">Tax Estimate</a> 
			<a href="/vehicle">Vehicle Reimbursement</a> 
			<a	href="/mobile">Mobile Reimbursement</a> 
	 		<a href="/addEmployee">Add Employees</a> 
			<a href="/deleteEmployee">Delete Employees</a>
			<a href="/updateEmployee">Update Employees</a>
			<a href="/addPayslips">Add Payslips</a>
			<a href="/attendanceReview">Attendance Application</a>
			<a href="/mobileReview">Mobile Application</a>
			<a href="/vehicleReview">Vehicle Application</a>
			<a href="/documentsView">View Documents Detail</a>
			<a href="/documentsAdd">Add Documents Detail</a>
	</div>
	
</div>
<div class="main">
HelloHome Page
</div>
</body>
</html>
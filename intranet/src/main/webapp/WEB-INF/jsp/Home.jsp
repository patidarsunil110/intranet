<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  
 <!-- <script type="text/javascript" src="js/validation.js">
</script> -->
	<style>
body {
	font-family: "Lato", sans-serif;
}

.sidenav {
	height: 100%;
	width: 230px;
	position: fixed;
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
	margin-left: 235px; /* Same as the width of the sidenav */
	font-size: 25px; /* Increased text to enable scrolling */
	padding: 0px 10px;
	margin-right:5px; 
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
  <form modelAttribute="attendence" class="form-horizontal"
role="form">

<div class="container">
	<div class="sidenav">
			<a href="/home">Home</a> 
			<a href="/leavebal">My Leave Balance</a> 
			<a href="/leaveapply">Apply Leave</a> 
			<!-- <a onclick='myFunction(this.form)' name="attendance">Attendance</a> -->
			<button onclick="myFunction(this.form);"> Click Me</button>
			<a href="/payslips">Individual Payslip</a> 
			<a href="/tax">Tax Estimate</a> 
			<a href="/vehicle">Vehicle Reimbursement</a> 
			<a	href="/mobile">Mobile Reimbursement</a> 
	<!-- 		<a href="/addEmployee">Add Employees</a> 
			<a href="/allUsers">Intech Pax List</a>
			 <a href="/teamList">Team List</a> -->

	</div>
	
</div>
<div class="main">
	<div class="row">
	
	<%-- <p>Total Hours(Previous Day)<%=session.getAttribute("totalHours")%></p>
	<p>Check In (Today)<%=session.getAttribute("checkIn")%></p>
	 --%>
	 <div class="col-sm-3" style="background-color:lavender;">Total Hours(Previous Day)<%=session.getAttribute("totalHours")%></div>
    <div class="col-sm-3" style="background-color:lavender;">Check In (Today)<%=session.getAttribute("checkIn")%></div>
	<%-- <div class="table-responsive">
		<table class="table">
			<thead>
				<tr>
					<th> Total Hours(Previous Day)</th>
    				<!-- <th>  Present Days(Current Month)</th> 
    				<th>  Total Leave(Casual Leave)</th>-->
    				<th>  Check-in (Today) </th> 
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${homePages}" var="homes">
					<tr>
						<td>${homes.totalHours}</td>
						<td>${homes.checkIn}</td>
					</tr>
				</c:forEach>

			</tbody>

		</table>
		
	</div>
	 --%>

  </div>
  
  </div>
	<%-- <input type="hidden" id="empId" name="empId" value=${empId} >
	
		<input type="hidden" id="applicationContext" value="${pageContext.servletContext.contextPath}" > --%>
	</form>
</body>
</html>

<script>

function myFunction(form) {
	var empId = document.getElementById("empId").value;
	alert("Inside function");
	form.action=document.getElementById("applicationContext").value + 'attendance?empId'+empId;
	form.target="_self";
	form.method="post";
	form.submit(form);

	}
</script>
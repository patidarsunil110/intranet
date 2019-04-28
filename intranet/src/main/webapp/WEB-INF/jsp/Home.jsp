<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<ul>
<li><a href="/home">Home</a></li>
<li><a href="/leavebal">My Leave Balance</a></li>
<li><a href="/leaveapply">Apply Leave</a></li>
<li><a href="/attendance" name="attendance">Attendance</a></li>
<li><a href="/payslips">Individual Payslip</a></li>
<li><a href="/tax">Tax Estimate</a></li>
<li><a href="/vehicle">Vehicle Reimbursement</a></li>
<li><a href="/mobile">Mobile Reimbursement</a></li>
<li><a href="/addEmployee">Add Employees</a></li>
<li><a href="/allUsers">Intech Pax List</a></li>
</ul>
<ul class="nav navbar-nav navbar-right">
			<li><span class="glyphicon glyphicon-log-in "></span>
					<%=session.getAttribute("username")%></li>
					</ul>
</head>
<body>
	<P color="purple">Welcome to the Home</P>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Daily Attendance</title>
</head>
<body>

	<div class="table-responsive">
		<table class="table">
			<thead>
				<tr>
					<th>Day</th>
					<th>Date</th>
					<th>Check In</th>
					<th>Check Out</th>
					<th>Status</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${attendance}" var="atten">
					<tr>
						<td>${atten.dayName}</td>
						<td>${atten.dayDate}</td>
						<td>${atten.checkIn}</td>
						<td>${atten.checkOut}</td>
						<td>${atten.status}</td>
						<%-- <td>${user.managerName}</td>
							<td>${user.dateOfJoining}</td>
							<td>${user.roleName}</td>
							<td><form action="get" modelAttribute="updateEmployee ">
									<a href="updateUser?empId=${user.empId}">Update</a>
								</form></td>
							<td><form action="get" modelAttribute="deleteUser ">
									<a href="deleteUser?empId=${user.empId}">Delete</a>
								</form></td> --%>
					</tr>
				</c:forEach>

			</tbody>

		</table>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Daily Attendance</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
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
					<th>Total hours</th>
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
						<td>${atten.totalHours}</td>
					</tr>
				</c:forEach>

			</tbody>

		</table>
		
	</div>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core " prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>View Contacts Here</h3>
	<table>
		<thead>
			<tr>
				<th>SL.NO</th>
				<th>NAME</th>
				<th>EMAIL</th>
				<th>PHONE NUMBER</th>
				<th>ACTION</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${contacts}" var="c" varStatus="index">
				<tr>
					<td>${index.count}</td>
					<td>${c.contactName}</td>
					<td>${c.contactEmail}</td>
					<td>${c.contactNumber}</td>
					<td><a href="editContact?cid=${c.contactId}">EDIT</a> <a
						href="deleteContact?cid=${c.contactId}">DELETE</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
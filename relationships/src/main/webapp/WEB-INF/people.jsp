<html>
	<head>
		<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
		<style>
			.black{
				background-color:black;
				color:white;
			}
		</style>
	</head>
	<body>
		<h1>All People</h1>
		<table>
			<tr class="black">
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>License #</th>
			</tr>
			<c:forEach items="${people}" var="person">
			<tr>
			<td><c:out value="${person.id}"/></td>
			<td><c:out value="${person.firstName}"/></td>
			<td><c:out value="${person.lastName}"/></td>
			<td>${person.license.number}</td>
			</tr>
			</c:forEach>
		</table>
	</body>
</html>
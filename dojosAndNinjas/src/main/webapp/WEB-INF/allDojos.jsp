<html>
	<head>
		<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	</head>
	<body>
		<h1>All Dojos</h1>
		<a href="/dojos/new">Add a New Dojo</a>
		<c:forEach items="${dojos}" var="dojo">
		<h3>${dojo.name}</h3>
		</c:forEach>
	</body>
</html>
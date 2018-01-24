<html>
	<head>
		<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	</head>
	<body>
		<h1>All Ninjas</h1>
		<a href="/ninjas/new">Add a New Ninja</a>
		<c:forEach items="${ninjas}" var="ninja">
		<h3>${ninja.firstName} ${ninja.lastName}, ${ninja.age}</h3>
		<p>${ninja.dojo.name}, id# ${ninja.dojo.id}</p>
		</c:forEach>
	</body>
</html>
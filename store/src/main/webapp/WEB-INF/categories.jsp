<html>
	<head>
		<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	</head>
	<body>
		<a href="/categories/new">Add A New Category</a>
		<h1>All Categories</h1>
		<c:forEach items="${categories}" var="category">
			<a href="/categories/${category.id}"><h2>${category.name}</h2></a>
		</c:forEach>
	</body>
</html>
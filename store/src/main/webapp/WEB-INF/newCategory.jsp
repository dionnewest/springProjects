<html>
	<head>
		<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	</head>
	<body>
		<a href="/categories">View All Categories</a>
		<h1>Add a New Category</h1>
		<form:form method="POST" action="/categories/new" modelAttribute="category">
			<form:label path="name">Name:
				<form:errors path="name"/>
				<form:input path="name"/>
			</form:label>
			<input type="submit" value="Add New Category"/>
		</form:form>
	</body>
</html>
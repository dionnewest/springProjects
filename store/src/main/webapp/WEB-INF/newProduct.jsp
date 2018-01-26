<html>
	<head>
		<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	</head>
	<body>
		<a href="/products">View All Products</a>
		<h1>Add a new Product</h1>
		<form:form method="POST" action="/products/new" modelAttribute="product">
			<form:label path="name">Name:
				<form:errors path="name"/>
				<form:input path="name"/>
			</form:label>
			<form:label path="description">Description:
				<form:errors path="description"/>
				<form:input path="description"/>
			</form:label>
			<form:label path="price">Price:
				<form:errors path="price"/>
				<form:input path="price"/>
			</form:label>
			<input type="submit" value="Add New Product"/>
		</form:form>
	</body>
</html>
<html>
	<head>
		<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	</head>
	<body>
		<a href="/products/new">Add A New Product</a>
		<h1>All Products</h1>
		<c:forEach items="${products}" var="product">
			<h2><a href="products/${product.id}">${product.name}</a> - $${product.price}</h2>
			<p>${product.description}</p>
		</c:forEach>
	</body>
</html>
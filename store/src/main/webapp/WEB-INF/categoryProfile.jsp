<html>
	<head>
		<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
		<style>
			*{
				border: 1px solid black;
			}
			.left, .right{
				width:45%;
				display: inline-block;
				vertical-align: top;
			}
			h2 {
				margin-top:0px;
			}
			.title, .link{
				margin-top:0px;
				display: inline-block;
				vertical-align: top;
			}
			.link{
				float: right;
			}
		</style>
	</head>
	<body>
	<div>
		<h1 class="title">${category.name}</h1>
		<a class="link" href="/categories">All Categories</a>
	</div>
	<div class="left">
		<h2>Products:</h2>
			<c:forEach items="${catProducts}" var="product">
				<p>${product.name}</p>
			</c:forEach>
	</div>
	<div class="right">
		<form method="POST" action="/categories/${id}">
			<label>Add Product
				<select name="productId">
					<c:forEach items="${products}" var="product">
					<option value="${product.id}">${product.name}</option>
					</c:forEach>
				</select>
			</label>
			<input type="submit" value="Add">
		</form>
	</div>
	</body>
</html>
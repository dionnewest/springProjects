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
		<h1 class="title">${product.name}</h1>
		<a class="link" href="/products">All Products</a>
	</div>
		<div class="left">
			<h2>Categories:</h2>
				<c:forEach items="${productCats}" var="category">
					<p>${category.name}</p>
				</c:forEach>
		</div>
		<div class="right">
			<form method="POST" action="/products/${id}">
				<label>Add Category
					<select name="categoryId">
						<c:forEach items="${categories}" var="category">
						<option value="${category.id}">${category.name}</option>
						</c:forEach>
					</select>
				</label>
				<input type="submit" value="Add">
			</form>
		</div>
	</body>
</html>
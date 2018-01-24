<html>
	<head>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	</head>
	<body>
	<h1>New Dojo</h1>
	<form:form method="POST" action="/dojos/new" modelAttribute="dojo">
		<form:label path="name">Dojo Location:
			<form:input path="name"/>
		</form:label>
		<input type="submit" value="Create">
	</form:form>
	</body>
</html>
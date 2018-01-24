<html>
	<head>
		<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
		<style>
		</style>
	</head>
	<body>
		<h1>New Person</h1>
		<form:form method="POST" action="/persons/new" modelAttribute="person">
			<form:label path="firstName">First Name:
				<form:errors path="firstName"/>
				<form:input path="firstName"/>
			</form:label>
			<form:label path="lastName">Last Name:
				<form:errors path="lastName" />
				<form:input path="lastName" />
			</form:label>
			<input type="submit" value="Create">
		</form:form>
	</body>
</html>


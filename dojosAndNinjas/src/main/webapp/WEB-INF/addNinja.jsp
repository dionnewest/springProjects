<html>
	<head>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
		<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	</head>
	<body>
	<h1>New Dojo</h1>
	<form:form method="POST" action="/ninjas/new" modelAttribute="ninja">
		<form:label path="dojo">Select Dojo
			<form:select path="dojo">
				<c:forEach items="${dojos}" var="dojo">
				<form:option value="${dojo.id}">${dojo.name}</form:option>
				</c:forEach>
			</form:select>
		</form:label>
		<form:label path="firstName">First Name:
			<form:input path="firstName"/>
		</form:label>
		<form:label path="lastName">Last Name:
			<form:input path="lastName"/>
		</form:label>
		<form:label path="age">Age:
			<form:input path="age"/>
		</form:label>
		<input type="submit" value="Create Ninja">
	</form:form>
	</body>
</html>
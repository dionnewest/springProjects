<html>
	<head>
		<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	</head>
	<body>
		<h1>New License</h1>
		<form:form method="POST" action="/licenses/new" modelAttribute="license">
			<form:label path="person">Person:
				<form:errors path="person"/>
				<form:select path="person">
					<c:forEach items="${people}" var="person">
					<form:option value="${person.id}">${person.firstName} ${person.lastName}</form:option>
					</c:forEach>
				</form:select>
			</form:label>
			<form:label path="state">State:
				<form:errors path="state" />
				<form:input path="state" />
			</form:label>
			<form:label path="expiration_date">Expiration Date:
				<form:errors path="expiration_date" />
				<form:input path="expiration_date" />
			</form:label>
			<input type="submit" value="Create">
		</form:form>
		<p><i>${message}</i></p>
	</body>
</html>

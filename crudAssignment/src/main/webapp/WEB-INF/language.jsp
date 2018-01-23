<html>
	<head>
		<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
		<title>Languages</title>
		<style type="text/css">
			label,input {
				display: flex;
				margin-bottom: 5px;
			}
			input {
				margin-left: 10px;
			}
			.button {
				margin-left: 0px;
			}
			tr, th, td{
				border: 1px solid black;
			}
		</style>
	</head>
	<body>
		<table class="table">
			<tr>
				<th>Name</th>
				<th>Creator</th>
				<th>Version</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${allLanguages}" var = "language" varStatus="loop">
				<tr>
					<td><a href="/languages/${loop.index}"><c:out value="${language.name}"/></a></td>
					<td><c:out value="${language.creator}" /></td>
					<td><c:out value="${language.version}" /></td>
					<td><a href="/languages/delete/${loop.index}">delete</a> <a href="/languages/edit/${loop.index}">edit</a></td>
				</tr>
			</c:forEach>
		</table>
		<h2>Add a New language</h2>
		<form:form method="POST" action="/languages/new" modelAttribute="language">
			<form:label path="name">Name:
				<form:input path="name" />
				<form:errors path="name" />
			</form:label>
			<form:label path="creator">Creator:
				<form:input path="creator" />
				<form:errors path="creator" />
			</form:label>
			<form:label path="version">Version:
				<form:input path="version" />
				<form:errors path="version" />
			</form:label>
			<input class="button" type="submit" value="Submit" />
		</form:form>
	</body>
</html>

    
<html>
    <head>
        	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
        <title>New Language</title>
    </head>
    <body>
		<a href="/languages">Dashboard</a>
		<h2>Edit a language</h2>
		<form:form method="POST" action="/languages/edit/${id}" modelAttribute="language">
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

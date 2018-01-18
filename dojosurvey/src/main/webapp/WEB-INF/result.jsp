<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<h1>Result Page</h1>
<p>Name: <c:out value="${username}"/></p>
<p>Location: <c:out value="${location}"/></p>
<p>Language: <c:out value="${language}"/></p>
<p>Comment: <c:out value="${comment}"/></p>

<a href="/"><button>Go Back</button></a>
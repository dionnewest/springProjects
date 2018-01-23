<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <a href="/languages">Dashboard</a>
    <div>
        <h2>Name:
            <c:out value="${language.name}" />
        </h2>
        <p>Creator:
            <c:out value="${language.creator}" />
        </p>
        <p>Version:
            <c:out value="${language.version}" />
        </p>
        <a href="/languages/delete/${id}">Delete</a>
        <a href="/languages/edit/${id}">Edit</a>
    </div>
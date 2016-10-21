
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>FL Main</title>
</head>
<body>

<h3>Hello <sec:authentication property="principal.username" />!</h3>

<br />
<c:url value="/logout" var="logout" />
<a href="${logout}">Logout</a>

</body>
</html>

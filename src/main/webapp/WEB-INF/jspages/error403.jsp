<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Access denied</title>
</head>
<body>
Access denied.
<br />
<c:url value="/main" var="toMain" />
<a href="${toMain}">To main page</a>
<p>
    <h3>Hello <sec:authentication property="principal.username" />!</h3>
<sec:authentication property="authorities" var="roles" scope="page" />
Your roles can not give you access to this page.
<br />
Your roles are:
<ul>
    <c:forEach var="role" items="${roles}">
        <li>${role}</li>
    </c:forEach>
</ul>
</p>

</body>
</html>

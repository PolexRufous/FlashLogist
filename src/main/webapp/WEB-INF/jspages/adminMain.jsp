
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>FL Main</title>
</head>
<body>

<h3>Hello <sec:authentication property="principal.username" />!</h3>

<br />
<c:url value="/logout" var="logout" />
<form:form action="${logout}">
    Click for <label for="submit-logout" style="text-decoration: underline; color: #a3602a; cursor: pointer;">Log Out</label>
    <input id="submit-logout" type="submit" style="display: none;" />
</form:form>

</body>
</html>

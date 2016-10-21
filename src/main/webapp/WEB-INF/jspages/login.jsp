<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>FL Login</title>
    <c:url value="/resources/css/default.css" var="defaultcss" />
    <link rel="stylesheet" type="text/css" href="${defaultcss}" />
</head>
<body>

<h1>Page is in active development!</h1>

<c:url value="/login" var="login" />
<form action="${login}" method="post">
    <label for="login">Login</label>
    <input id="login" type="text" name="username" />
    <br />
    <label for="password">Password</label>
    <input id="password" type="password" name="password" />
    <br />
    <input type="submit" value="Log in"/>
    <label class="info-message">${message }</label>

</form>

</body>
</html>

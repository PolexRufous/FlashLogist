<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>FL Login</title>
    <c:url value="/resources/css/loginPage.css" var="loginPagecss"/>
    <link rel="stylesheet" type="text/css" href="${loginPagecss}"/>
</head>
<body>
<c:url value="/login" var="login"/>
<main>
    <div class="delimiter"></div>
    <form:form method="post" action="${login}">
        <label class="form-label" for="username">Login:</label>
        <input id="username" name="username" type="text" placeholder="Login" />
        <br />
        <br />
        <label class="form-label" for="password">Password:</label>
        <input id="password" type="password" name="password" placeholder="Password" />
        <br />
        <br />
        <input type="submit" value="Log In" />
    </form:form>
    <label class="info-message">${message}</label>
</main>
</body>
</html>

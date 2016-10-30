<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>FL Login</title>
    <c:url value="/resources/css/loginPage.css" var="loginPagecss"/>
    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css"/>
    <link rel="stylesheet" type="text/css" href="${loginPagecss}"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
</head>
<body>
<c:url value="/login" var="login"/>
<main>
    <div class="delimiter"></div>
    <div class="pure-g">
        <div class="pure-u-1-3"></div>
        <div class="pure-u-1-3">
            <form:form class="pure-form pure-form-aligned" method="post" action="${login}">
                <fieldset>
                    <div class="pure-control-group">
                        <label for="username">Login:</label>
                        <input id="username" name="username" type="text" placeholder="Login"/>
                    </div>
                    <div class="pure-control-group">
                        <label for="password">Password:</label>
                        <input id="password" name="password" type="password" placeholder="Password"/>
                    </div>
                    <div class="pure-controls">
                        <input type="submit" class="pure-button button-submit" value="Log In"/>
                    </div>
                    <label class="info-message">${message}</label>
                </fieldset>
            </form:form>
        </div>
        <div class="pure-u-1-3"></div>
    </div>
</main>
</body>
</html>

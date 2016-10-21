<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Access denied</title>
</head>
<body>
Access denied.
<br />
<c:url value="/main" var="toMain" />
<a href="${toMain}">To main page</a>

</body>
</html>

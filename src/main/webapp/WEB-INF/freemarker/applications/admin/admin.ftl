<#import "/spring.ftl" as spring/>
<html>
<head>
    <title>FL Main</title>
    <link rel="icon" href="<@spring.url "/resources/applications/admin/images/favicon.ico" />" />
    <#include "../../baseparts/base.css.ftl" >
    <script data-main="<@spring.url "/resources/applications/admin/js/adminMain.js" />"
            src="<@spring.url "/resources/vendors/requirejs/require.js" />" ></script>
</head>
<body>
    <#include "../../baseparts/header.ftl" >
</body>
</html>
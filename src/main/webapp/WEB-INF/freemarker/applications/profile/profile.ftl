<#import "/spring.ftl" as spring/>
<html>
<head>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <meta name="_csrf" content="${_csrf.token}"/>
    <title>Personal Profile</title>
    <link rel="icon" href="<@spring.url "/resources/applications/profile/images/favicon.ico" />" />
    <#include "../../baseparts/base.css.ftl" >
    <#include "../../baseparts/base.js.ftl" >
</head>
<body>
    <#include "../../baseparts/header.ftl" >
    <main id="profile-main">
        <i class="fa fa-spinner" aria-hidden="true"></i> Loading ...
    </main>
    <#include "../../baseparts/footer.ftl">
</body>
</html>
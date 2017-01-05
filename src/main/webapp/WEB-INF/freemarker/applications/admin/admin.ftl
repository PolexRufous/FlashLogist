<#import "/spring.ftl" as spring/>
<html>
<head>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <meta name="_csrf" content="${_csrf.token}"/>
    <title>FL Main</title>
    <link rel="icon" href="<@spring.url "/resources/applications/admin/images/favicon.ico" />" />
    <#include "../../baseparts/base.css.ftl" >
    <#include "../../baseparts/base.js.ftl" >
    <script data-main="<@spring.url "/resources/applications/admin/js/adminMain.js" />"
            src="<@spring.url "/resources/global/vendors/requirejs/require.js" />" ></script>
</head>
<body>
    <#include "../../baseparts/header.ftl" >
    <main id="admin-main">
        <i class="fa fa-spinner" aria-hidden="true"></i> Loading ...
    </main>
    <#include "../../baseparts/footer.ftl">
</body>
</html>
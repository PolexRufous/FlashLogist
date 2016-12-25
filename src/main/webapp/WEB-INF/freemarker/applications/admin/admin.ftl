<#import "/spring.ftl" as spring/>
<html>
<head>
    <meta name='csrf-token' content={{ csrf_token }}>
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
        Loading ...
    </main>
    <#include "../../baseparts/footer.ftl">
</body>
</html>
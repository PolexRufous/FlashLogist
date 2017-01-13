<#import "/spring.ftl" as spring/>
<html>
<head>
    <title>Rout managment</title>
    <link rel="icon" href="<@spring.url '/resources/applications/rout/dist/images/favicon.ico' />" />
    <#include "../../baseparts/base.css.ftl" >
    <#include "../../baseparts/base.js.ftl" >
    <link rel="stylesheet" href="<@spring.url '/resources/applications/rout/dist/css/main.css' />">
</head>
<body>
<#include "../../baseparts/header.ftl" >
<main class="main-content wrapper">
    <h1>Welcome back, ${userName}</h1>
    <div>
        <h2>Routs</h2>
        <div id="map"></div>
    </div>
</main>
<#include "../../baseparts/footer.ftl" >
<script data-main="<@spring.ur '/resources/applications/rout/js/require-cong.js' />"
 src="<@spring.url '/resources/global/vendors/requirejs/require.js' />" async></script>
</body>
</html>
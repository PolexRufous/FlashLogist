<#import "/spring.ftl" as spring/>
<html>
<head>
    <title>Rout managment</title>
    <link rel="icon" href="<@spring.url "/resources/applications/rout/images/favicon.ico" />" />
    <link rel="stylesheet" href="/resources/applications/rout/css/main.css">
    <#include "../../baseparts/base.css.ftl" >
    <#include "../../baseparts/base.js.ftl" >
</head>
<body>
<#include "../../baseparts/header.ftl" >
<main class="main-content wrapper">
    <h1>Welcome back, ${userName}</h1>
    <div>
        <h2>Routs</h2>
    </div>
</main>
<#include "../../baseparts/footer.ftl" >
<script src="/resources/applications/rout/js/main.js" ></script>
</body>
</html>
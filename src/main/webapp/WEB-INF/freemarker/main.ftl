<#import "/spring.ftl" as spring/>
<html>
<head>
    <title>FL Main</title>
    <link rel="icon" href="<@spring.url '/resources/global/images/logo.png'/>" />
    <#include "baseparts/base.css.ftl" >
    <#include "baseparts/base.js.ftl" >
    <link rel="stylesheet" href="<@spring.url '/resources/global/css/main.page.css'/>"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
</head>
<body>
    <#include "baseparts/header.ftl" >
    <#include "baseparts/content.ftl" >
    <#include "baseparts/footer.ftl" >
</body>
</html>

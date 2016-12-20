<#import "/spring.ftl" as spring/>
<html>
<head>
    <title>FL Login</title>
    <link rel="icon" href="<@spring.url '/resources/global/images/logo.png'/>" />
    <#include "baseparts/base.css.ftl" >
    <#include "baseparts/base.js.ftl" >
    <link rel="stylesheet" href="<@spring.url '/resources/global/css/indexPage.css'/>">
    <link rel="stylesheet" href="<@spring.url '/resources/global/vendors/font-awesome/css/font-awesome.css'/>">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

</head>
<body>
<#include "baseparts/header.ftl" >
<main>
<div class="main-image-container" >
    <img src="<@spring.url '/resources/global/images/flashMain.png'/>" alt="Base logo" />
</div>
</main>
<#include "baseparts/footer.ftl" >
</body>
</html>

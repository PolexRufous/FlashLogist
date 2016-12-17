<#import "/spring.ftl" as spring/>
<html>
<head>
    <title>FL Login</title>
    <link rel="icon" href="<@spring.url '/resources/global/images/logo.png'/>" />
    <#include "baseparts/base.css.ftl" >
    <link rel="stylesheet" href="<@spring.url '/resources/global/css/indexPage.css'/>">
    <link rel="stylesheet" href="<@spring.url '/resources/global/vendors/font-awesome/css/font-awesome.css'/>">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <script src="<@spring.url '/resources/global/vendors/jQuery/dist/jquery.min.js'/>" ></script>
    <script src="<@spring.url '/resources/global/js/header.base.js'/>" ></script>

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

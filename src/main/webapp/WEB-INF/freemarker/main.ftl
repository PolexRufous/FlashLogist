<#import "/spring.ftl" as spring/>
<html>
<head>

</head>
<body>
<#if applications??>
<#list applications as application>
<h2 class="info-message">${application.showName}</h2>
</#list>

</#if>
</body>
</html>

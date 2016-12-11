<#import "/spring.ftl" as spring/>
<html>
<head>
    <title>FL Login</title>
    <#include "baseparts/base.css.ftl" >
    <link rel="stylesheet" href="<@spring.url '/resources/global/css/loginPage.css'/>">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

</head>
<body>
<#include "baseparts/header.ftl" >
<main>
    <div class="delimiter"></div>
    <div class="pure-g">
        <div class="pure-u-1-3"></div>
        <div class="pure-u-1-3">
            <form class="pure-form pure-form-aligned" method="post" action="<@spring.url '/login' />">
                <fieldset>
                    <div class="pure-control-group">
                        <label for="username">Login:</label>
                        <input id="username" name="username" type="text" placeholder="Login"/>
                    </div>
                    <div class="pure-control-group">
                        <label for="password">Password:</label>
                        <input id="password" name="password" type="password" placeholder="Password"/>
                    </div>
                    <div class="pure-controls">
                        <input type="submit" class="pure-button button-submit" value="Log In"/>
                    </div>
                    <input type="hidden"
                           name="${_csrf.parameterName}"
                           value="${_csrf.token}"/>
                <#if message??>
                    <label class="info-message">${message}</label>
                </#if>
                </fieldset>
            </form>
        </div>
        <div class="pure-u-1-3"></div>
    </div>
</main>
</body>
</html>

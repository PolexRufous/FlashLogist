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
    <div class="login-wrapper">
        <div class="login-form-container">
            <form method="post" action="<@spring.url '/login' />">
                <fieldset>
                    <div class="login-form-part">
                        <label for="username">Login:</label>
                        <input id="username" name="username" type="text" placeholder="Login"/>
                    </div>
                    <div class="login-form-part">
                        <label for="password">Password:</label>
                        <input id="password" name="password" type="password" placeholder="Password"/>
                    </div>
                    <div class="login-form-part login-form-buttons">
                        <input type="submit" class="pure-button button-submit" value="Log In"/>
                    </div>
                    <input type="hidden"
                           name="${_csrf.parameterName}"
                           value="${_csrf.token}"/>
                <#if message??>
                    <div class="login-form-part login-form-messages">
                        <label>${message}</label>
                    </div>
                </#if>
                </fieldset>
            </form>
        </div>
    </div>
</main>
</body>
</html>

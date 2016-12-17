<#import "/spring.ftl" as spring/>
<header class="main-header">
    <section class="header-section">
    </section>
    <nav>
        <ul class="menu-container">
            <#if applications??>
                <li class="parent">
                    <span class="menu-span parent-span">Applications</span>
                    <div class="container">
                    <ul>
                        <#list applications as application>

                            <li><span class="menu-span">
                                <a href="<@spring.url '${application.url}' />"
                            class="menu-link">${application.showName}</a></span></li>
                        </#list>
                    </ul>
                    </div>
                </li>
            </#if>
            <#if principal??>
                <li class="parent">
                    <span class=" menu-span parent-span span-user">${principal}</span>
                    <div class="container">
                    <ul>
                        <li>
                            <form action="<@spring.url '/logout' />" method="post">
                                <label class="input-label" for="logout">Log Out</label>
                                <input type="hidden"
                                       name="${_csrf.parameterName}"
                                       value="${_csrf.token}"/>
                                <input id="logout" type="submit" value="Log Out" class="logout-button" />
                            </form>
                        </li>
                    </ul>
                    </div>
                </li>
            <#else>
            <li class="parent">
                <span class="menu-span parent-span">Log In</span>
                <div class="login-form-container container">
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
            </li>
            </#if>
        </ul>
    </nav>
    <hr />
</header>
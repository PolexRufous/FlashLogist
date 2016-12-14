<#import "/spring.ftl" as spring/>
<header class="main-header">
    <section class="wrapper">
    </section>
    <nav>
        <ul class="menu-container">
            <li>
                <span class="menu-span"><a href="#" class="menu-link">Home</a></span>
            </li>
            <#if applications??>
                <li class="parent">
                    <span class="menu-span parent-span">Applications</span>
                    <ul>
                        <#list applications as application>

                            <li><span class="menu-span">
                                <a href="<@spring.url '${application.url}' />"
                            class="menu-link">${application.showName}</a></span></li>
                        </#list>
                    </ul>
                </li>
            </#if>
            <#if principal??>
                <li class="parent">
                    <span class=" menu-span parent-span span-user">${principal}</span>
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
                </li>
            </#if>
        </ul>
    </nav>
</header>
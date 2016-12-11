<#import "/spring.ftl" as spring/>
<header class="main-header">
    <nav>
        <ul class="menu-container">
            <li><a href="#" class="menu-link">Home</a></li>
            <#if applications??>
                <li class="parent"><a href="#" class="menu-link">Applications</a>
                    <ul>
                        <#list applications as application>
                            <li><a href="<@spring.url '${application.url}' />"
                            class="menu-link">${application.showName}</a></li>
                        </#list>
                    </ul>
                </li>
            </#if>
            <#if principal??>
                <li>
                    <form action="<@spring.url '/logout' />" method="post"
                        class="menu-link">
                        <input type="hidden"
                               name="${_csrf.parameterName}"
                               value="${_csrf.token}"/>
                        <input type="submit" value="${principal} Log Out" class="pure-button" />
                    </form>
                </li>
            </#if>
        </ul>
    </nav>
</header>
<#import "/spring.ftl" as spring/>
<html>
<head>
    <title>Rout managment</title>
    <link rel="icon" href="<@spring.url '/resources/applications/rout/dist/images/favicon.ico' />"/>
<#include "../../baseparts/base.css.ftl" >
<#include "../../baseparts/base.js.ftl" >
    <link rel="stylesheet" href="<@spring.url '/resources/applications/rout/dist/css/main.css' />">
</head>
<body>
<#include "../../baseparts/header.ftl" >
<main class="main-content wrapper">
    <div>
        <div class="options-box">
            <div>
                <form id="zoom-to-area" action="javascript:void(0);">
                    <input id="zoom-to-area-text" type="text" placeholder="Enter your favorite area!">
                    <input type="submit" value="Zoom">
                </form>
                <p id="zoom-to-area-results"></p>
            </div>

            <div>
                <form id="search-within-time" action="javascript:void(0);">
                    <input id="search-within-time-text" type="text" placeholder="Ex: Google Office NYC or 75 9th Ave, New York, NY">
                    <select id="mode">
                        <option value="DRIVING">drive</option>
                        <option value="WALKING">walk</option>
                        <option value="BICYCLING">bike</option>
                        <option value="TRANSIT">transit ride</option>
                    </select>
                    <input type="submit" value="Calculate distance">
                </form>
            </div>
        </div>
        <div id="map"></div>
    </div>
</main>
<#include "../../baseparts/footer.ftl" >
<script data-main="<@spring.url '/resources/applications/rout/js/require-conf.js' />"
        src="<@spring.url '/resources/global/vendors/requirejs/require.js' />" async></script>
</body>
</html>
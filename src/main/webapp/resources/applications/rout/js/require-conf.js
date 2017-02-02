'use strict';


requirejs.config({
    baseUrl: '/resources/applications/rout/dist/js',

    paths: {
        all: 'all',
        jquery: '../../../global/vendors/jQuery/dist/jquery.slim',
        maps: '//maps.googleapis.com/maps/api/js?key=AIzaSyAk9Xy_JEOMGwoHuO-WebODfHRKyBhXCYg&callback=initMap'
    }
});

requirejs(['jquery', 'all', 'maps'], function () {

});




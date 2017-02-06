'use strict';
let configs  = {
    mapApiKey :  'AIzaSyAk9Xy_JEOMGwoHuO-WebODfHRKyBhXCYg',
    mapLibraries: ''
};

requirejs.config({
    baseUrl: '/resources/applications/rout/dist/js',

    paths: {
        maps: 'maps/maps',
        mapStyles: 'maps/mapStyles',
        jquery: '../../../../global/vendors/jQuery/dist/jquery',
        mapsAPI: '//maps.googleapis.com/maps/api/js?key=' + configs.mapApiKey + '&callback=initMap'
    }
});

/*
requirejs(['jquery', 'maps', 'mapStyles', 'maps'], function () {

});*/

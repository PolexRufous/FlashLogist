'use strict';

let configs  = {
    mapApiKey :  'AIzaSyAk9Xy_JEOMGwoHuO-WebODfHRKyBhXCYg',
    mapLibraries: ''
};

requirejs.config({
    baseUrl: '/resources/applications/rout/dist/js',

    paths: {
        events: 'Events',

        //Utils
        jquery: '../../../../global/vendors/jQuery/dist/jquery',

        //Maps
        maps: 'maps/Maps',
        zoomer: 'maps/Zoomer',
        mapStyles: 'maps/MapStyles',
        markers: 'maps/Markers',
        distanceCalculator: 'maps/DistanceCalculator',
        directoryCalculator: 'maps/DirectionCalculator',
        infoWindow : 'maps/InfoWindow',
        mapsAPI: '//maps.googleapis.com/maps/api/js?key=' + configs.mapApiKey
    }
});


requirejs(['mapsAPI', 'events', 'zoomer', 'distanceCalculator'], function (maps) {
    require(['maps', 'markers'], function (Maps, Markers) {

        let locations = [
            {title: 'Zhytomir', location: {lat: 50.263125 , lng: 28.657825}},
            {title: 'Uman', location: {lat: 48.766320, lng: 30.202530}},
            {title: 'Kolomyya', location: {lat: 48.531489, lng: 25.036326}},
            {title: 'Poltava', location: {lat: 49.605469, lng: 34.545094}},
            {title: 'Antratsyt', location: {lat: 48.132824, lng:  39.083097}},
            {title: 'Armiansk', location: {lat: 46.108801, lng: 33.685627}}
        ];

        locations.forEach(function (location) {
            let position = location.location;
            let title = location.title;
            Markers.addMarker(position, title);
        });

        Markers.fitBounds();
    })
});

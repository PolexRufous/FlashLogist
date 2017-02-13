'use strict';

define(['mapsAPI', 'mapStyles'], function (MapsApi, MapStyles) {
    var map = createMap();
    initMap();

    function initMap() {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function (position) {
                var center = {
                    lat: position.coords.latitude,
                    lng: position.coords.longitude
                };
                map.setCenter(center);
            }, function (error) {
                reject("Geolocation error: " + error.code);
            });
        } else {
            reject("Geolocation not supported: ");
        }
    }

    function createMap() {
        return new google.maps.Map(document.querySelector('#map'), {
            zoom: 15,
            styles: MapStyles,
            disableDefaultUI: true
        });
    }

    function _createInfoWindow(map, position, content) {
        var infoWindow = new google.maps.InfoWindow({ map: map });
        infoWindow.setPosition(position);
        infoWindow.setContent(content);
    }

    return {
        createInfoWindow: function createInfoWindow(map, position, content) {
            _createInfoWindow(map, position, content);
        },

        map: map
    };
});
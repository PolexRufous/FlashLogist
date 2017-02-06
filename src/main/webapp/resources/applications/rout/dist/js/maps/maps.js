'use strict';

define(['mapStyles'], function (require) {

    function initMap(mapStyles) {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(callback, function () {
                handleLocationError(true);
            });
        } else {
            handleLocationError(false);
        }

        function callback(position) {
            var center = {
                lat: position.coords.latitude,
                lng: position.coords.longitude
            };
            var map = createMap(center);

            createInfoWindow(map, center, 'You are here');
        }

        function createMap(center) {
            return new google.maps.Map(document.querySelector('#map'), {
                zoom: 6,
                center: center,
                styles: mapStyles,
                disableDefaultUI: true
            });
        }

        function createInfoWindow(map, position, content) {
            var infoWindow = new google.maps.InfoWindow({ map: map });
            infoWindow.setPosition(position);
            infoWindow.setContent(content);
        }

        function handleLocationError(browserHasGeolocation) {
            console.log(browserHasGeolocation ? 'Error: The Geox`location service failed.' : 'Error: Your browser doesn\'t support geolocation.');
        }
    }
});
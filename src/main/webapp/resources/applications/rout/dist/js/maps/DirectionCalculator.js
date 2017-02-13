'use strict';

define(['maps', 'markers'], function (Maps, Markers) {

    function _displayDirections(event) {
        var button = event.target;
        if (!button) return;

        Markers.hideListings();

        var directionService = new google.maps.DirectionsService();
        var destinationAddress = button.getAttribute('destination');
        var originAddress = button.getAttribute('origin');

        directionService.route({
            origin: originAddress,
            destination: destinationAddress,
            travelMode: google.maps.TravelMode[mode]
        }, function (response, status) {
            if (status == google.maps.DirectionsStatus.OK) {
                var directionsDispay = new google.map.DirectionRenderer({
                    map: Maps.map,
                    directions: response,
                    draggable: true,
                    plylineOptions: {
                        strokeColor: 'green'
                    }
                });
            } else {
                console.log('Directions request failed due to ' + status);
            }
        });
    }

    return {
        displayDirections: function displayDirections(event) {
            _displayDirections(event);
        }
    };
});
'use strict';

define(['maps', 'markers'], function (Maps, Markers) {

    function _displayDirections(event) {
        var button = event.target;
        if (!button) return;

        Markers.hideListings();

        var directionService = new google.maps.DirectionsService();
        var destinationAddress = button.getAttribute('destination');
        var originAddress = button.getAttribute('origin');
        var mode = button.getAttribute('routMode');

        var request = {
            origin: originAddress,
            destination: destinationAddress,
            travelMode: google.maps.TravelMode[mode]
        };

        directionService.route(request, function (response, status) {
            if (status == google.maps.DirectionsStatus.OK) {
                var directionsDispay = new google.maps.DirectionsRenderer({
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
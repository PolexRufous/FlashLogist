'use strict';

define(['maps', 'markers'], function (Maps, Markers) {


    function displayDirections(event) {
        let button = event.target
        if (!button)
            return;

        Markers.hideListings();

        let directionService = new google.maps.DirectionsService;
        let destinationAddress = button.getAttribute('destination');
        let originAddress = button.getAttribute('origin');

        directionService.route({
            origin: originAddress,
            destination: destinationAddress,
            travelMode: google.maps.TravelMode[mode]
        }, function (response, status) {
            if (status == google.maps.DirectionsStatus.OK) {
                let directionsDispay = new google.map.DirectionRenderer({
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
        displayDirections : function (event) {
            displayDirections(event);
        }
    }
});
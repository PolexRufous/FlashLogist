'use strict';

define(['maps', 'markers', 'infoWindow', 'events', 'directoryCalculator'], function (Maps, Markers, InfoWindow, Events, DirectoryCalculator) {
    var selector = '#search-within-time';
    var form = document.querySelector(selector);
    var destination = void 0;
    var mode = void 0;

    function calculateDistance() {
        Markers.hideListings();
        mode = document.querySelector('#mode').value;
        destination = document.querySelector('#search-within-time-text').value;
        var distanceMatrix = createDistanceMatrix();
        var distanceMatrixService = new google.maps.DistanceMatrixService();
        distanceMatrixService.getDistanceMatrix(distanceMatrix, callback);
    }

    function createDistanceMatrix() {
        var origins = [];
        for (var i = 0; i < Markers.markers.length; i++) {
            origins[i] = Markers.markers[i].position;
        }
        return {
            origins: origins,
            destinations: [destination],
            travelMode: google.maps.TravelMode[mode]
        };
    }

    function callback(response, status) {
        if (status !== google.maps.DistanceMatrixStatus.OK) {
            console.log('Error was: ' + status);
        } else {
            displayMarkersWithin(response);
        }
    }

    function displayMarkersWithin(response) {
        var atLeastOne = false;
        for (var i = 0; i < response.rows.length; i++) {
            var resultsForOrigin = response.rows[i].elements;
            if (processResultsForOrigin(resultsForOrigin, i, response.originAddresses[i])) {
                atLeastOne = true;
            }
        }
        if (!atLeastOne) {
            console.log('We could not find any locations within that distance!');
        }
    }

    function processResultsForOrigin(resultsForOrigin, markerIndex, address) {
        var atLeastOne = false;
        for (var j = 0; j < resultsForOrigin.length; j++) {
            var element = resultsForOrigin[j];
            if (element.status === "OK") {
                atLeastOne = true;
                var button = getDisplayDirectionButton(address, markerIndex);
                var div = createInfoWindowDiv(button, element);
                var infowindow = InfoWindow.createInfoWindow(div);
                var marker = Markers.markers[markerIndex];
                marker.setMap(Maps.map);
                InfoWindow.populateInfoWindow(marker, infowindow);
                marker.infowindow = infowindow;

                google.maps.event.addListener(marker, 'click', function () {
                    this.infowindow.close();
                });

                setButtonListener(button, markerIndex);
            }
        }
        return atLeastOne;
    }

    function setButtonListener(button, markerIndex) {
        var selector = '#marker' + markerIndex;
        Events.subscribe(button, selector, 'click', DirectoryCalculator.displayDirections);
    }

    function getDisplayDirectionButton(address, markerIndex, routElement) {

        var escapedAddress = address.replace('\'', '');

        var input = document.createElement('input');
        input.setAttribute('id', 'marker' + markerIndex);
        input.setAttribute('index', markerIndex);
        input.setAttribute('type', 'button');
        input.setAttribute('value', 'View Rout');
        input.setAttribute('origin', escapedAddress);
        input.setAttribute('destination', destination);
        input.setAttribute('routMode', mode);

        return input;
    }

    function createInfoWindowDiv(button, routElement) {
        var distanceText = routElement.distance.text;
        var durationText = routElement.duration.text;

        var div = document.createElement('div');
        var span = document.createTextNode(durationText + ' away, ' + distanceText);
        div.appendChild(span);
        div.appendChild(button);

        return div;
    }

    Events.subscribe(form, selector, 'submit', calculateDistance);
});
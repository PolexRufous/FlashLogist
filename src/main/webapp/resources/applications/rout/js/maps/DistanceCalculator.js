'use strict';

define(['maps', 'markers', 'infoWindow', 'events', 'directoryCalculator'], function (Maps, Markers, InfoWindow, Events, DirectoryCalculator) {
    const selector = '#search-within-time';
    const form = document.querySelector(selector);
    let destination;
    let mode;

    function calculateDistance() {
        Markers.hideListings();
        mode = document.querySelector('#mode').value;
        destination = document.querySelector('#search-within-time-text').value;
        let distanceMatrix = createDistanceMatrix();
        let distanceMatrixService = new google.maps.DistanceMatrixService;
        distanceMatrixService.getDistanceMatrix(distanceMatrix, callback);
    }

    function createDistanceMatrix() {
        let origins = [];
        for (let i = 0; i < Markers.markers.length; i++) {
            origins[i] = Markers.markers[i].position;
        }
        return {
            origins: origins,
            destinations: [destination],
            travelMode: google.maps.TravelMode[mode],
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
        let atLeastOne = false;
        for (let i = 0; i < response.rows.length; i++) {
            let resultsForOrigin = response.rows[i].elements;
            if (processResultsForOrigin(resultsForOrigin, i, response.originAddresses[i])) {
                atLeastOne = true;
            }
        }
        if (!atLeastOne) {
            console.log('We could not find any locations within that distance!');
        }
    }

    function processResultsForOrigin(resultsForOrigin, markerIndex, address) {
        let atLeastOne = false;
        for (let j = 0; j < resultsForOrigin.length; j++) {
            let element = resultsForOrigin[j];
            if (element.status === "OK") {
                atLeastOne = true;
                let button = getDisplayDirectionButton(address, markerIndex);
                let div = createInfoWindowDiv(button, element);
                let infowindow = InfoWindow.createInfoWindow(div);
                let marker = Markers.markers[markerIndex];
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
            let selector = '#marker' + markerIndex;
            Events.subscribe(button, selector, 'click', DirectoryCalculator.displayDirections);
    }

    function getDisplayDirectionButton(address, markerIndex, routElement) {

        let escapedAddress = address.replace('\'', '');

        let input = document.createElement('input');
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
        let distanceText = routElement.distance.text;
        let durationText = routElement.duration.text;

        let div = document.createElement('div');
        let span = document.createTextNode(durationText + ' away, ' + distanceText);
        div.appendChild(span);
        div.appendChild(button);

        return div;
    }

    Events.subscribe(form, selector, 'submit', calculateDistance);
})
;
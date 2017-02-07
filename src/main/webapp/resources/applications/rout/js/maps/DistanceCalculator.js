'use strict';

define(['maps', 'markers', 'infoWindow', 'events'], function (Maps, Markers, InfoWindow, Events) {
    let addressInput = document.querySelector('#search-within-time-text');
    let modeInput = document.querySelector('#mode');
    let selector = '#search-within-time';
    let form = document.querySelector(selector);

    function searchWithinTime() {
        Markers.hideListings();
        let distanceMatrix = createDistanceMatrix();
        let distanceMatrixService = new google.maps.DistanceMatrixService;
        distanceMatrixService.getDistanceMatrix(distanceMatrix, callback);
    }

    function createDistanceMatrix() {
        let origins = [];
        for (let i = 0; i < Markers.markers.length; i++) {
            origins[i] = Markers.markers[i].position;
        }

        let destination = addressInput.value;
        let mode = modeInput.value;

        return {
            origins: origins,
            destinations: [destination],
            travelMode: google.maps.TravelMode[mode],
            unitSystem: google.maps.UnitSystem.IMPERIAL,
        };
    }

    function callback(response, status) {
        if (status !== google.maps.DistanceMatrixStatus.OK) {
            window.alert('Error was: ' + status);
        } else {
            displayMarkersWithinTime(response);
        }
    }

    function displayMarkersWithinTime(response) {
        let origins = response.originAddresses;
        let atLeastOne = false;
        for (let i = 0; i < origins.length; i++) {
            let results = response.rows[i].elements;
            for (let j = 0; j < results.length; j++) {
                let element = results[j];
                if (element.status === "OK") {
                    let distanceText = element.distance.text;
                    let durationText = element.duration.text;
                    let infowindow = InfoWindow.createInfoWindow(durationText + ' away, ' + distanceText);
                    let marker = Markers.markers[i];
                    marker.setMap(Maps.map);
                    InfoWindow.populateInfoWindow(marker, infowindow);
                    marker.infowindow = infowindow;
                    atLeastOne = true;

                    google.maps.event.addListener(marker, 'click', function () {
                        this.infowindow.close();
                    });
                }
            }
        }
        if (!atLeastOne) {
            window.alert('We could not find any locations within that distance!');
        }
    }

    Events.subscribe(form, selector, 'submit', searchWithinTime);
})
;
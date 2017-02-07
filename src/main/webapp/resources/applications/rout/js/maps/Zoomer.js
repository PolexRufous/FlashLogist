'use strict';

define(['events', 'maps'], function (Events, Maps) {
    let geocoder = new google.maps.Geocoder();
    let address = document.querySelector('#zoom-to-area-text');
    let resultsSpan = document.querySelector('#zoom-to-area-results');
    let selector = '#zoom-to-area';
    let form = document.querySelector(selector);

    function zoomToArea() {
        let params = {address: address.value};
        geocoder.geocode(params, callback);
    }

    function callback(results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
            let firstResult = results[0];
            Maps.map.setCenter(firstResult.geometry.location);
            Maps.map.setZoom(15);
            resultsSpan.textContent = firstResult.formatted_address;
        } else {
            resultsSpan.textContent = 'We could not find that location - try entering a more' +
                ' specific place.';
        }
    }

    Events.subscribe(form, selector, 'submit', zoomToArea);
    return {
        zoomToArea: function () {
            zoomToArea();
        }
    }
});

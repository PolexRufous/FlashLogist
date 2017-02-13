'use strict';

define(['events', 'maps'], function (Events, Maps) {
    var geocoder = new google.maps.Geocoder();
    var address = document.querySelector('#zoom-to-area-text');
    var resultsSpan = document.querySelector('#zoom-to-area-results');
    var selector = '#zoom-to-area';
    var form = document.querySelector(selector);

    function _zoomToArea() {
        var params = { address: address.value };
        geocoder.geocode(params, callback);
    }

    function callback(results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
            var firstResult = results[0];
            Maps.map.setCenter(firstResult.geometry.location);
            Maps.map.setZoom(15);
            resultsSpan.textContent = firstResult.formatted_address;
        } else {
            resultsSpan.textContent = 'We could not find that location - try entering a more' + ' specific place.';
        }
    }

    Events.subscribe(form, selector, 'submit', _zoomToArea);
    return {
        zoomToArea: function zoomToArea() {
            _zoomToArea();
        }
    };
});
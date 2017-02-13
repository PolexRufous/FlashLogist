'use strict';

define(['maps'], function (Maps) {
    var map = Maps.map;

    function _createInfoWindow(content) {
        var infoWindow = new google.maps.InfoWindow({
            content: content
        });
        return infoWindow;
    }

    function _populateInfoWindow(marker, infoWindow) {
        if (infoWindow.marker != marker) {
            infoWindow.marker = marker;
            infoWindow.addListener('closeclick', function () {
                infoWindow.marker = null;
            });
            infoWindow.open(map, marker);
        }
    }

    return {
        createInfoWindow: function createInfoWindow() {
            var content = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : null;

            return _createInfoWindow(content);
        },

        populateInfoWindow: function populateInfoWindow(marker, infoWindow) {
            _populateInfoWindow(marker, infoWindow);
        }
    };
});
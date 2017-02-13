'use strict';

define(['maps'], function (Maps) {
    let map = Maps.map;

    function createInfoWindow(content) {
        let infoWindow = new google.maps.InfoWindow({
            content: content
        });
        return infoWindow;
    }

    function populateInfoWindow(marker, infoWindow) {
        if (infoWindow.marker != marker) {
            infoWindow.marker = marker;
            infoWindow.addListener('closeclick', function() {
                infoWindow.marker = null;
            });
            infoWindow.open(map, marker);
        }
    }

    return {
        createInfoWindow : function (content = null) {
            return createInfoWindow(content);
        },

        populateInfoWindow : function (marker, infoWindow) {
            populateInfoWindow(marker, infoWindow);
        }
    }
});
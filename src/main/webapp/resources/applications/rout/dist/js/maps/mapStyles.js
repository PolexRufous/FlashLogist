'use strict';

define(function (require) {

    return [
    /*{
        featureType: 'all',
        stylers: [
            {saturation: -80}
        ]
    },*/
    {
        featureType: 'road.arterial',
        elementType: 'geometry',
        stylers: [{ hue: '#00ffee' }, { saturation: 50 }]
    }, {
        featureType: 'poi.business',
        elementType: 'labels',
        stylers: [{ visibility: 'off' }]
    }, {
        featureType: "administrative",
        elementType: "all",
        stylers: [{
            "visibility": "off"
        }]
    }, {
        featureType: "administrative.country",
        elementType: "all",
        stylers: [{
            "visibility": "on"
        }]
    }, {
        featureType: "administrative.locality",
        elementType: "all",
        stylers: [{
            "visibility": "on"
        }]
    }, {
        featureType: "landscape",
        elementType: "all",
        stylers: [{
            "visibility": "off"
        }]
    }, {
        featureType: "road",
        elementType: "geometry",
        stylers: [{ lightness: 100 }, { visibility: "on" }, { color: "#c15d5d" }]
    }];
});
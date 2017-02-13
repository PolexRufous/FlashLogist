'use strict';

define(['maps', 'infoWindow'], function (Maps, InfoWindow) {
    var defaultIcon = makeMarkerIcon('c25b5b');
    var highlightedIcon = makeMarkerIcon('6590b3');
    var markers = [];

    function makeMarkerIcon(markerColor) {
        return new google.maps.MarkerImage('http://chart.googleapis.com/chart?chst=d_map_spin&chld=1.15|0|' + markerColor + '|40|_|%E2%80%A2', new google.maps.Size(21, 34), new google.maps.Point(0, 0), new google.maps.Point(10, 34), new google.maps.Size(21, 34));
    }

    function _hideListings() {
        markers.forEach(function (marker) {
            if (marker.infowindow) {
                marker.infowindow.close();
            }
            marker.setMap(null);
        });
    }

    function _addMarker(position, title, animation, icon, infoWindow) {
        var marker = makeMarker(position, title, animation, icon);

        if (infoWindow != null) {
            marker.addListener('click', function () {
                InfoWindow.populateInfoWindow(this, infoWindow);
            });
        }

        marker.addListener('mouseover', function () {
            this.setIcon(highlightedIcon);
        });

        marker.addListener('mouseout', function () {
            this.setIcon(defaultIcon);
        });

        marker.setMap(Maps.map);
    }

    function _fitBounds() {
        var bounds = new google.maps.LatLngBounds();
        markers.forEach(function (marker) {
            bounds.extend(marker.getPosition());
        });
        Maps.map.fitBounds(bounds);
    }

    function makeMarker(position, title, animation, icon) {
        var marker = new google.maps.Marker({
            position: position,
            title: title,
            animation: animation,
            icon: icon
        });

        markers.push(marker);
        return marker;
    }

    return {
        markers: markers,
        hideListings: function hideListings() {
            _hideListings();
        },
        addMarker: function addMarker(position, title) {
            var animation = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : google.maps.Animation.DROP;
            var icon = arguments.length > 3 && arguments[3] !== undefined ? arguments[3] : defaultIcon;
            var infoWindow = arguments.length > 4 && arguments[4] !== undefined ? arguments[4] : null;

            _addMarker(position, title, animation, icon);
        },
        fitBounds: function fitBounds() {
            _fitBounds();
        }
    };
});
'use strict';

define(['maps', 'infoWindow'], function (Maps, InfoWindow) {
    let defaultIcon = makeMarkerIcon('0091ff');
    let highlightedIcon = makeMarkerIcon('FFFF24');
    let markers = [];

    function makeMarkerIcon(markerColor) {
        return new google.maps.MarkerImage(
            'http://chart.googleapis.com/chart?chst=d_map_spin&chld=1.15|0|' + markerColor +
            '|40|_|%E2%80%A2',
            new google.maps.Size(21, 34),
            new google.maps.Point(0, 0),
            new google.maps.Point(10, 34),
            new google.maps.Size(21, 34));
    }


    function hideListings() {
        markers.forEach(function (marker) {
            marker.setMap(null);
            if (marker.infowindow) {
                marker.infowindow.close();
            }
        });
    }

    function addMarker(position, title, animation, icon, infoWindow) {
        let marker = makeMarker(position, title, animation, icon);

        if (infoWindow != null) {
            marker.addListener('click', function() {
                InfoWindow.populateInfoWindow(this, infoWindow);
            });
        }

        marker.addListener('mouseover', function() {
            this.setIcon(highlightedIcon);
        });

        marker.addListener('mouseout', function() {
            this.setIcon(defaultIcon);
        });

        marker.setMap(Maps.map);
    }

    function fitBounds() {
        let bounds = new google.maps.LatLngBounds();
        markers.forEach(function (marker) {
            bounds.extend(marker.getPosition());
        });
        Maps.map.fitBounds(bounds);
    }


    function makeMarker(position, title, animation, icon) {
        let marker = new google.maps.Marker({
            position: position,
            title: title,
            animation: animation,
            icon: icon
        });

        markers.push(marker);
        return marker;
    }

    return {
        markers : markers,
        hideListings : function () {
            hideListings();
        },
        addMarker : function (position, title, animation = google.maps.Animation.DROP, icon = defaultIcon, infoWindow = null) {
            addMarker(position, title, animation, icon);
        },
        fitBounds : function () {
            fitBounds();
        }
    }
});
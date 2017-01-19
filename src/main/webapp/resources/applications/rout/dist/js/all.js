function initMap(){var o=new google.maps.Map(document.getElementById("map"),{center:{lat:-34.397,lng:150.644},zoom:6}),t=new google.maps.InfoWindow({map:o});navigator.geolocation?navigator.geolocation.getCurrentPosition(function(e){var n={lat:e.coords.latitude,lng:e.coords.longitude};void 0!=n.lat&&void 0!=n.lng||(n.lat=50.44985,n.lng=30.523151),t.setPosition(n),t.setContent("You are here"),o.setCenter(n)},function(){handleLocationError(!0,t,o.getCenter())}):handleLocationError(!1,t,o.getCenter())}function handleLocationError(o,t,e){t.setPosition(e),t.setContent(o?"Error: The Geolocation service failed.":"Error: Your browser doesn't support geolocation.")}const MapOptions={apiKey:"AIzaSyAk9Xy_JEOMGwoHuO-WebODfHRKyBhXCYg"};
//# sourceMappingURL=data:application/json;charset=utf8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIm1hcHMuanMiLCJjb25maWcuanMiXSwibmFtZXMiOlsiaW5pdE1hcCIsIm1hcCIsImdvb2dsZSIsIm1hcHMiLCJNYXAiLCJkb2N1bWVudCIsImdldEVsZW1lbnRCeUlkIiwiY2VudGVyIiwibGF0IiwibG5nIiwiem9vbSIsImluZm9XaW5kb3ciLCJJbmZvV2luZG93IiwibmF2aWdhdG9yIiwiZ2VvbG9jYXRpb24iLCJnZXRDdXJyZW50UG9zaXRpb24iLCJwb3NpdGlvbiIsInBvcyIsImNvb3JkcyIsImxhdGl0dWRlIiwibG9uZ2l0dWRlIiwidW5kZWZpbmVkIiwic2V0UG9zaXRpb24iLCJzZXRDb250ZW50Iiwic2V0Q2VudGVyIiwiaGFuZGxlTG9jYXRpb25FcnJvciIsImdldENlbnRlciIsImJyb3dzZXJIYXNHZW9sb2NhdGlvbiIsIk1hcE9wdGlvbnMiLCJhcGlLZXkiXSwibWFwcGluZ3MiOiJBQUFBLFFBQUFBLFdBQ0EsR0FBQUMsR0FBQSxHQUFBQyxRQUFBQyxLQUFBQyxJQUFBQyxTQUFBQyxlQUFBLFFBQ0FDLFFBQUFDLEtBQUEsT0FBQUMsSUFBQSxTQUNBQyxLQUFBLElBR0FDLEVBQUEsR0FBQVQsUUFBQUMsS0FBQVMsWUFBQVgsSUFBQUEsR0FHQVksV0FBQUMsWUFDQUQsVUFBQUMsWUFBQUMsbUJBQUEsU0FBQUMsR0FDQSxHQUFBQyxJQUNBVCxJQUFBUSxFQUFBRSxPQUFBQyxTQUNBVixJQUFBTyxFQUFBRSxPQUFBRSxVQUdBQyxTQUFBSixFQUFBVCxLQUFBYSxRQUFBSixFQUFBUixNQUNBUSxFQUFBVCxJQUFBLFNBQ0FTLEVBQUFSLElBQUEsV0FHQUUsRUFBQVcsWUFBQUwsR0FDQU4sRUFBQVksV0FBQSxnQkFDQXRCLEVBQUF1QixVQUFBUCxJQUNBLFdBQ0FRLHFCQUFBLEVBQUFkLEVBQUFWLEVBQUF5QixlQUlBRCxxQkFBQSxFQUFBZCxFQUFBVixFQUFBeUIsYUFJQSxRQUFBRCxxQkFBQUUsRUFBQWhCLEVBQUFNLEdBQ0FOLEVBQUFXLFlBQUFMLEdBQ0FOLEVBQUFZLFdBQUFJLEVBQ0EseUNBQ0Esb0RDckNBLEtBQUFDLGFBQ0FDLE9BQUEiLCJmaWxlIjoiYWxsLmpzIiwic291cmNlc0NvbnRlbnQiOlsiZnVuY3Rpb24gaW5pdE1hcCgpIHtcclxuICAgIHZhciBtYXAgPSBuZXcgZ29vZ2xlLm1hcHMuTWFwKGRvY3VtZW50LmdldEVsZW1lbnRCeUlkKCdtYXAnKSwge1xyXG4gICAgICAgIGNlbnRlcjoge2xhdDogLTM0LjM5NywgbG5nOiAxNTAuNjQ0fSxcclxuICAgICAgICB6b29tOiA2XHJcbiAgICB9KTtcclxuXHJcbiAgICB2YXIgaW5mb1dpbmRvdyA9IG5ldyBnb29nbGUubWFwcy5JbmZvV2luZG93KHttYXA6IG1hcH0pO1xyXG5cclxuICAgIC8vIFRyeSBIVE1MNSBnZW9sb2NhdGlvbi5cclxuICAgIGlmIChuYXZpZ2F0b3IuZ2VvbG9jYXRpb24pIHtcclxuICAgICAgICBuYXZpZ2F0b3IuZ2VvbG9jYXRpb24uZ2V0Q3VycmVudFBvc2l0aW9uKGZ1bmN0aW9uKHBvc2l0aW9uKSB7XHJcbiAgICAgICAgICAgIHZhciBwb3MgPSB7XHJcbiAgICAgICAgICAgICAgICBsYXQ6IHBvc2l0aW9uLmNvb3Jkcy5sYXRpdHVkZSxcclxuICAgICAgICAgICAgICAgIGxuZzogcG9zaXRpb24uY29vcmRzLmxvbmdpdHVkZVxyXG4gICAgICAgICAgICB9O1xyXG5cclxuICAgICAgICAgICAgaWYgKHBvcy5sYXQgPT0gdW5kZWZpbmVkIHx8IHBvcy5sbmcgPT0gdW5kZWZpbmVkKSB7XHJcbiAgICAgICAgICAgICAgICBwb3MubGF0ID0gNTAuNDQ5ODU7XHJcbiAgICAgICAgICAgICAgICBwb3MubG5nID0gMzAuNTIzMTUxO1xyXG4gICAgICAgICAgICB9XHJcblxyXG4gICAgICAgICAgICBpbmZvV2luZG93LnNldFBvc2l0aW9uKHBvcyk7XHJcbiAgICAgICAgICAgIGluZm9XaW5kb3cuc2V0Q29udGVudCgnWW91IGFyZSBoZXJlJyk7XHJcbiAgICAgICAgICAgIG1hcC5zZXRDZW50ZXIocG9zKTtcclxuICAgICAgICB9LCBmdW5jdGlvbigpIHtcclxuICAgICAgICAgICAgaGFuZGxlTG9jYXRpb25FcnJvcih0cnVlLCBpbmZvV2luZG93LCBtYXAuZ2V0Q2VudGVyKCkpO1xyXG4gICAgICAgIH0pO1xyXG4gICAgfSBlbHNlIHtcclxuICAgICAgICAvLyBCcm93c2VyIGRvZXNuJ3Qgc3VwcG9ydCBHZW9sb2NhdGlvblxyXG4gICAgICAgIGhhbmRsZUxvY2F0aW9uRXJyb3IoZmFsc2UsIGluZm9XaW5kb3csIG1hcC5nZXRDZW50ZXIoKSk7XHJcbiAgICB9XHJcbn1cclxuXHJcbmZ1bmN0aW9uIGhhbmRsZUxvY2F0aW9uRXJyb3IoYnJvd3Nlckhhc0dlb2xvY2F0aW9uLCBpbmZvV2luZG93LCBwb3MpIHtcclxuICAgIGluZm9XaW5kb3cuc2V0UG9zaXRpb24ocG9zKTtcclxuICAgIGluZm9XaW5kb3cuc2V0Q29udGVudChicm93c2VySGFzR2VvbG9jYXRpb24gP1xyXG4gICAgICAgICdFcnJvcjogVGhlIEdlb2xvY2F0aW9uIHNlcnZpY2UgZmFpbGVkLicgOlxyXG4gICAgICAgICdFcnJvcjogWW91ciBicm93c2VyIGRvZXNuXFwndCBzdXBwb3J0IGdlb2xvY2F0aW9uLicpO1xyXG59IiwiY29uc3QgTWFwT3B0aW9ucyA9IHtcclxuICAgIGFwaUtleTogJ0FJemFTeUFrOVh5X0pFT01Hd29IdU8tV2ViT0RmSFJLeUJoWENZZydcclxufTsiXX0=

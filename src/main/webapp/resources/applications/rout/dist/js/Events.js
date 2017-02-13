'use strict';

define(function () {
    var listeners = {};
    var hOP = listeners.hasOwnProperty;

    function _subscribe(element, name, event, listener) {
        listeners[name] = {
            element: element,
            name: name,
            event: event,
            listener: listener
        };

        element.addEventListener(event, listener);

        return {
            remove: function remove(name) {
                var listener = listeners[name];
                listener.element.removeEventListener(listener.event, listener.listener);
                delete listeners[name];
            }
        };
    }

    return {
        subscribe: function subscribe(element, name, event, listener) {
            _subscribe(element, name, event, listener);
        }
    };
});
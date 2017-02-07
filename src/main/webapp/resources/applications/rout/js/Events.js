'use strict';

define(function () {
    let listeners = {};
    let hOP = listeners.hasOwnProperty;

    function subscribe(element, name, event, listener) {
            listeners[name] = {
                element: element,
                name: name,
                event: event,
                listener: listener
            };

            element.addEventListener(event, listener);

            return {
                remove: function (name) {
                    let listener = listeners[name];
                    listener.element.removeEventListener(listener.event, listener.listener);
                    delete listeners[name];
                }
            };
    }

    return {
        subscribe: function (element, name, event, listener) {
            subscribe(element, name, event, listener);
        },
    };

});


define(['backbone', 'config', 'validation'], function (Backbone, config) {
    return Backbone.Model.extend({
        urlRoot: config.urls.users
    });
});

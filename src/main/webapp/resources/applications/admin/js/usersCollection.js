define(['backbone', 'user', 'config'], function (Backbone, user, config) {
    return Backbone.Collection.extend({
        model: user,
        url: config.urls.users
    });
});

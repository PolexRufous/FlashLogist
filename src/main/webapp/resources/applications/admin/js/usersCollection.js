define(['backbone', 'user', 'config'], function (Backbone, user, config) {
    var UsersCollection = Backbone.Collection.extend({
        model: user,
        url: config.urls.users
    });

    return new UsersCollection();
});

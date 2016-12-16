define(['backbone', 'users', 'dust', 'config'], function (Backbone, users, dust, config) {
    var AllUsersView = Backbone.View.extend({
        model: users,
        el: '#admin-main',
        render: function () {
            setTimeout(2000, function () {
                this.$el.append(
                    dust.render(config.templates.users, this.model.toJSON())
                );
            });
        }
    });

    return new AllUsersView();

});

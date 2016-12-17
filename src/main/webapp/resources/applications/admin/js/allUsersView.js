define(['backbone', 'users', 'dust', 'config'], function (Backbone, users, dust, config) {
    return Backbone.View.extend({
        model: users,
        el: '#admin-main',
        render: function () {
                    var self = this;
                    dust.render(config.templates.users, {}, function (err, out) {
                        if (err) {
                            cosole.error(err);
                        } else {
                            self.$el.html(out);
                        }
                    });
        }
    });
});

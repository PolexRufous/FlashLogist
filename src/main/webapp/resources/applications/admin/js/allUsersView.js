define(['backbone', 'users', 'dust', 'config', 'userrow'], function (Backbone, users, dust, config, UserRowView) {
    return Backbone.View.extend({
        model: users,
        el: '#admin-main',
        initialize: function() {
            var self = this;
            self.model.fetch({
              success: function () {
                  self.render();
              },
              error: function () {
                  console.error('Collection fetch exception');
              }
            });
        },
        render: function () {
                    var self = this;
                    dust.render(config.templates.users, {}, function (err, out) {
                        if (err) {
                            cosole.error(err);
                        } else {
                            self.$el.html(out);
                            self.model.each(function (user) {
                                self.$el.append(
                                    new UserRowView({model: user}).render()
                                );
                            });
                        }
                    });
        }
    });
});

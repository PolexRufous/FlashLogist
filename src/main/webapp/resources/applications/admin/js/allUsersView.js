define(['backbone', 'users', 'dust', 'config', 'userrow', 'user'], function (Backbone, users, dust, config,
                                                                             UserRowView, UserModel) {
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

        events: {
            'click .table-button.add-user-button': 'addEditUserRaw'
        },

        render: function () {
                    var self = this;
                    dust.render(config.templates.users, {}, function (err, out) {
                        if (err) {
                            cosole.error(err);
                        } else {
                            self.$el.html(out);
                            self.model.each(function (user) {
                                self.$el.find('#users-container').append(
                                    new UserRowView({model: user}).render()
                                );
                            });
                        }
                    });
        },

        addEditUserRaw: function () {
            this.$el.find('#users-container').append(
                new UserRowView({model: new UserModel()}).renderEdit()
            );
        }
    });
});

define(['backbone', 'user', 'config', 'dust'], function (Backbone, UserModel, config, dust) {
    return Backbone.View.extend({
        model: UserModel,
        tagName: 'tr',
        className: 'userRow',

        events: {
            'click .userButton.editButton': 'renderEdit',
            'click .userButton.removeButton': 'confirmRemove',
            'click .userButton.lockButton': 'confirmLock',
            'click .userButton.unlockButton': 'confirmUnlock',
            'click .userButton.cancelButton': 'cancelEdit',
            'click .userButton.confirmButton': 'confirmEdit'
        },

        initialize: function () {

        },
        render: function () {
            var self = this;
            dust.render(config.templates.userrow, this.model.toJSON(), function (err, out) {
                if (err) {
                    console.error(err);
                } else {
                    self.$el.html(out);
                }
            });
            return this.$el;
        },

        confirmRemove: function () {
            confirm('Are you realy want to remove user?');
        },

        renderEdit: function () {
            var self = this;
            dust.render(config.templates.useredit, this.model.toJSON(), function (err, out) {
                if (err) {
                    console.error(err);
                } else {
                    self.$el.html(out);
                }
            });
            return self.$el;
        },

        cancelEdit: function () {
            this.render();
        }


    });
});

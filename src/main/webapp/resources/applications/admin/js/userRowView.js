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
            if (this.model.isNew()) {
                this.model.destroy();
                this.remove();
            } else {
                this.render();
            }
        },

        confirmEdit: function () {
            var attributes = this._collectModelAttributes();
            var self = this;
            self.model.save(attributes, {
               success: function () {
                   self.render();
               },
                error: function () {
                    console.error('Save error!');
                }
            });
        },

        _collectModelAttributes: function () {
            var result = {};
            var inputs = this.$el.find('input');
            inputs.each(function (i) {
                var name = this.name;
                result[name] = this.value;
            });
            var selects = this.$el.find('select');
            selects.each(function () {
                var name = this.name;
                result[name] = this.value;
            });
            return result;
        }


    });
});

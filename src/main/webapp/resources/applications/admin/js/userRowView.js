define(['backbone', 'user', 'config', 'dust'], function (Backbone, userModel, config, dust) {
    return Backbone.View.extend({
        model: userModel,
        tagName: 'tr',
        className: 'userRow',

        events: {
            'click .userButton.editButton': 'renderEdit',
            'click .userButton.removeButton': 'confirmRemove'
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
        }


    });
});

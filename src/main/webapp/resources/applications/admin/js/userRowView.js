define(['backbone', 'user', 'config', 'dust'], function (Backbone, UserModel, config, dust) {
    return Backbone.View.extend({
        model: UserModel,
        tagName: 'tr',
        className: 'userRow',

        events: {
            'click .userButton.editButton': 'renderEdit',
            'click .userButton.removeButton': 'confirmRemove',
            'click .userButton.lockButton': 'lockUser',
            'click .userButton.unlockButton': 'unlockUser',
            'click .userButton.cancelButton': 'cancelEdit',
            'click .userButton.confirmButton': 'confirmEdit',

            'click .ok-button': 'removeUser',
            'click .cancel-button': '_clearPopups'
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

            this._clearPopups();

            var confirmPopup = $('<div></div>');
            confirmPopup.text(config.messages.confirmDeleteUser);
            confirmPopup.append('<hr />');

            var confirmButton = $('<button>Yes</button>');
            confirmButton.addClass('confirm-popup-button');
            confirmButton.addClass('ok-button');
            var cancelButton = $('<button>No</button>');
            cancelButton.addClass('confirm-popup-button');
            cancelButton.addClass('cancel-button');

            confirmPopup.append(confirmButton).append(cancelButton);

            confirmPopup.addClass('confirm-popup');
            confirmPopup.attr('id', 'popup-dialog');

            this.$el.find('.userButton.removeButton').after(confirmPopup);

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
        },

        lockUser: function () {
            if (this.model.get('available')) {
                this._modelSaveRender({available: false});
            }
        },

        unlockUser: function () {
            if (!this.model.get('available')) {
                this._modelSaveRender({available: true});
            }
        },

        removeUser: function () {
            var self = this;
            this.model.destroy({
                success: function () {
                    self.remove();
                },
                error: function (model, response) {
                    if(self._isResponseStatusOk(response.status)) {
                        self.remove();
                    } else {
                        console.error('Error remove user!')
                    }
                }
            });
        },

        _modelSaveRender: function (attrs) {
            var self = this;
            this.model.save(attrs, {
                success: function () {
                    self.render();
                },
                error: function () {
                    console.error('Model save error!');
                }
            });
        },

        _clearPopups: function () {
            $('body').find('#popup-dialog').remove();
        },

        _isResponseStatusOk: function (status) {
            return status >= 200 && status <= 300;
        }


    });
});

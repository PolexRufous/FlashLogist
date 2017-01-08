define(['backbone', 'config', 'validation'], function (Backbone, config) {
    return Backbone.Model.extend({
        urlRoot: config.urls.users,
        defaults: {
            login: '',
            available: true,
            firstName: '',
            lastName: '',
            email: '',
            role: 'USER'
        },

        validation: {
            login: [{
                required: true
            }, {
                minLength: 4,
                maxLength: 24,
                msg: 'Login cannot be less than 4 letters and longer than 24 letters'
            }, {
                pattern: /[A-Za-z0-9_]+/,
                msg: 'Login is invalid. Use only ASCII letters, digits and _ simbol'
            }],
            firstName: [{
                required: true
            }, {
                pattern: /[A-Za-z]+/,
                msg: 'First name is invalid. Use only ASCII letters'
            }, {
                minLength: 1,
                maxLength: 24,
                msg: 'First name cannot be longer than 24 letters'
            }],
            lastName: [{
                required: true
            }, {
                pattern: /[A-Za-z]+/,
                msg: 'Last name is invalid. Use only ASCII letters'
            }, {
                minLength: 1,
                maxLength: 24,
                msg: 'Last name cannot be longer than 24 letters'
            }],
            email: [
                {
                    required: true
                },
                {
                    pattern: 'email',
                    msg: 'Please enter a valid email'
                }
            ]

        }
    });
});

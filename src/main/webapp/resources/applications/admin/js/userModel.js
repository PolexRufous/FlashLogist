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
            login: {
                required: true,
                msg: 'Login is required'
            },
            email: [
                {
                    required: true,
                    msg: 'Email is required'
                },
                {
                    pattern: 'email',
                    msg: 'Please enter a valid email'
                }
            ]

        }
    });
});


require.config({
    paths: {
        //libraries
        backbone: '../bower_components/backbone/backbone-min',
        underscore: '../bower_components/underscore/underscore-min',
        jquery: '../../../global/vendors/jQuery/dist/jquery.min',
        validation: '../bower_components/backbone.validation/dist/backbone-validation-amd-min',
        dust: '../bower_components/dustjs-linkedin/dist/dust-full.min',
        dust_helpers: '../bower_components/dustjs-helpers/dist/dust-helpers',

        //styling
        fontawesome: '../../../global/vendors/font-awesome/css/font-awesome.min',

        //application js
        userapp: 'usersManagementApplication',
        user: 'userModel',
        userrow: 'userRowView',
        users: 'usersCollection',
        allusers: 'allUsersView',

        //config js
        config: 'admin.configs',

        //application css
        overrides: '../css/admin.overrides',
        base: '../css/base.admin',

        //templates
        templ_register: 'user.templates.registerer',
        user_templ: '../templates/userrow.dust',
        user_edit_templ: '../templates/useredit.dust',
        users_templ: '../templates/users.dust'

    },

    map: {
        '*': {
            css: '../../../global/vendors/require-css/css.min',
            text: '../../../global/vendors/text/text'
        }
    }

});

requirejs(['backbone','css!overrides', 'css!base', 'css!fontawesome'], function (Backbone) {
    define.amd.dust = true;

    var sync = Backbone.sync;
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    Backbone.sync = function(method, model, options) {
        options.beforeSend = function (xhr) {
            xhr.setRequestHeader(header, token);
        };

        sync(method, model, options);
    };

    require(['templ_register'], function () {
            require(['userapp'], function (UserApp) {
                UserApp.start();
            });
        }
    );
});

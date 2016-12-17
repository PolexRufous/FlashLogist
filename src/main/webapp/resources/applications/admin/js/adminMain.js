
require.config({
    paths: {
        //libraries
        backbone: '../bower_components/backbone/backbone-min',
        underscore: '../bower_components/underscore/underscore-min',
        jquery: '../../../global/vendors/jQuery/dist/jquery.min',
        validation: '../bower_components/backbone.validation/dist/backbone-validation-amd-min',
        dust: '../bower_components/dustjs-linkedin/dist/dust-full.min',
        dust_helpers: '../bower_components/dustjs-helpers/dist/dust-helpers',

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

requirejs(['css!base', 'css!overrides'], function () {
    define.amd.dust = true;
    require(['templ_register'], function () {
            require(['userapp'], function (UserApp) {
                UserApp.start();
            });
        }
    );
});

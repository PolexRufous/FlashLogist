
require.config({
    paths: {
        //libraries
        backbone: '../bower_components/backbone/backbone-min',
        underscore: '../bower_components/underscore/underscore-min',
        jQuery: '../../../vendors/jQuery/dist/jquery.min',
        validation: '../bower_components/backbone.validation/dist/backbone-validation-amd-min',

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
        base: '../css/base.admin'

        //templates


    },

    map: {
        '*': {
            css: '../../../vendors/require-css/css.min'
        }
    }

});

requirejs(["userapp", "css!base"], function (UserApp) {
    define.amd.dust = true;
    UserApp.start();
});

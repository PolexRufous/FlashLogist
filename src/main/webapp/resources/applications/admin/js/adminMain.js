
require.config({
    paths: {
        //libraries
        backbone: '../bower-components/backbone/backbone-min',
        underscore: '../bower-components/underscore/underscore-min',
        jQuery: '../../../vendors/jQuery/dist/jquery.min'

        //application

    }
});

requirejs(["jQuery", "underscore", "backbone"], function ($, _, Backbone) {

    alert("ok");


});

var gulp = require('gulp');
var bower = require('gulp-bower');
var requireDir = require('require-dir');

const paths = {
  global: 'src/main/webapp/resources/global',
  admin: 'src/main/webapp/resources/applications/admin'
};

const configs = {
  bower_verbosity: 2
};

//default task
gulp.task('default', ['bower']);


//GLOBAL TASKS
//****************************

//bower
gulp.task('bower', ['bower:admin', 'bower:global']);
gulp.task('bower:global', function () {
    return bower({
        cwd: paths.global,
        verbosity: configs.bower_verbosity
    });
});



//****************************
// END OF GLOBAL TASKS


//ADMIN APPLICATION TASKS
//****************
gulp.task('bower:admin', function () {
   return bower({
       cwd: paths.admin,
       verbosity: configs.bower_verbosity
   });
});

//***************
//END OF ADMIN APPLICATIONS TASKS


//ROUT APPLICATION TASKS
//****************
requireDir('src/main/webapp/resources/applications/rout');
//***************
//END OF ROUT APPLICATIONS TASKS
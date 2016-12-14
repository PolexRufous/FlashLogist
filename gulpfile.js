var gulp = require('gulp');
var bower = require('gulp-bower');

const paths = {
  admin: 'src/main/webapp/resources/applications/admin'
};

const configs = {
  bower_verbosity: 2
};


gulp.task('default', ['bower']);


gulp.task('bower:admin', function () {
   return bower({
       cwd: paths.admin,
       verbosity: configs.bower_verbosity
   });
});

gulp.task('bower:global', function () {
    return bower({
        verbosity: configs.bower_verbosity
    });
});

gulp.task('bower', ['bower:admin', 'bower:global']);

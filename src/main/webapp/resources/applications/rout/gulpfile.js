'use strict';

var gulp = require('gulp');
var sass = require('gulp-sass');
var autoprefixer = require('gulp-autoprefixer');
var jasmine = require('gulp-jasmine-phantom');
var browserSync = require('browser-sync');
var sourcemaps = require('gulp-sourcemaps');
var concat = require('gulp-concat');
var uglify = require('gulp-uglify');
var imagemin = require('gulp-imagemin');
var pngquant = require('imagemin-pngquant');
const reporters = require('jasmine-reporters');
var appPath = 'src/main/webapp/resources/applications/rout/';

gulp.task('rout', [
    'rout:test',
    'rout:styles',
    'rout:copy-images',
    'rout:copy-js'],
    function () {});

gulp.task('rout:styles', function() {
    gulp.src(appPath + 'sass/**/*.scss')
        .pipe(sourcemaps.init())
        .pipe(sass().on('error', sass.logError))
        .pipe(autoprefixer({
            browsers: ['last 2 versions']
        }))
        .pipe(sourcemaps.write())
        .pipe(gulp.dest(appPath + 'dist/css'))
        .pipe(browserSync.stream());
});

gulp.task('rout:copy-images', function () {
   gulp.src(appPath + 'images/*')
       .pipe(imagemin({
           progressive: true,
           use: [pngquant()]
       }))
       .pipe(gulp.dest(appPath +'dist/images'));
});

gulp.task('rout:copy-js', function () {
    gulp.src([appPath + 'js/*', '!' + appPath + 'js/require-conf.js'])
        .pipe(sourcemaps.init())
        .pipe(concat('all.js'))
        .pipe(uglify().on('error', function(e){
            console.log(e);
        }))
        .pipe(sourcemaps.write())
        .pipe(gulp.dest(appPath +'dist/js'));
});

gulp.task('rout:test', function () {
    gulp.src(appPath + 'tests/spec/extra-spec.js')
        .pipe(jasmine({
            //integration:true,
            vendor:'js/**/*.js',
            reporter: new reporters.JUnitXmlReporter()
        }));
});
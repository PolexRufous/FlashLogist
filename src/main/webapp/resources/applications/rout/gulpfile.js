'use strict';

const gulp = require('gulp');
const sass = require('gulp-sass');
const autoprefixer = require('gulp-autoprefixer');
const jasmine = require('gulp-jasmine-phantom');
const browserSync = require('browser-sync');
const sourcemaps = require('gulp-sourcemaps');
const concat = require('gulp-concat');
const uglify = require('gulp-uglify');
const imagemin = require('gulp-imagemin');
const pngquant = require('imagemin-pngquant');
const reporters = require('jasmine-reporters');
const babel = require('gulp-babel');
const appPath = 'src/main/webapp/resources/applications/rout/';
const clean = require('gulp-clean');

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

gulp.task('rout:copy-js', ['rout:js-clean-dest'], function () {
    gulp.src([appPath + 'js/**/*.js', '!' + appPath + 'js/require-conf.js'])
        //.pipe(sourcemaps.init())
        .pipe(babel({
            presets: ['es2015']
        }))
        //.pipe(concat('all.js'))
        // .pipe(uglify().on('error', function(e){
        //     console.log(e);
        // }))
       // .pipe(sourcemaps.write())
        .pipe(gulp.dest(appPath +'dist/js'));
});

gulp.task('rout:js-clean-dest', function () {
   return gulp.src([appPath + 'dist/js'])
       .pipe(clean())
});

gulp.task('rout:test', function () {
    gulp.src(appPath + 'tests/spec/extra-spec.js')
        .pipe(jasmine({
            //integration:true,
            vendor:'js/**/*.js',
            reporter: new reporters.JUnitXmlReporter()
        }));
});
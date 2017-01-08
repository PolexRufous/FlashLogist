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

gulp.task('rout', ['rout:test', 'rout:styles', 'rout:copy-images', 'rout:copy-js'], function () {
    gulp.watch('sass/**/*.scss', ['rout:styles']);
    gulp.watch('js/**/*.js', ['rout:copy-js']);

});

gulp.task('rout:styles', function() {
    gulp.src('sass/**/*.scss')
        .pipe(sass().on('error', sass.logError))
        .pipe(autoprefixer({
            browsers: ['last 2 versions']
        }))
        .pipe(gulp.dest('dist/css'))
        .pipe(browserSync.stream());
});

gulp.task('rout:copy-images', function () {
   gulp.src('images/*')
       .pipe(imagemin({
           progressive: true,
           use: [pngquant()]
       }))
       .pipe(gulp.dest('dist/images'));
});

gulp.task('rout:copy-js', function () {
    gulp.src('js/*')
        .pipe(sourcemaps.init())
        .pipe(concat('all.js'))
        .pipe(uglify())
        .pipe(sourcemaps.write())
        .pipe(gulp.dest('dist/js'));
});

gulp.task('rout:test', function () {
    gulp.src('tests/spec/extra-spec.js')
        .pipe(jasmine({
            //integration:true,
            vendor:'js/**/*.js'
        }));
});
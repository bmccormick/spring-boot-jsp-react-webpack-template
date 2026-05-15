const gulp = require('gulp');
const concat = require('gulp-concat');
const rimraf = require('rimraf');
const eslint = require('gulp-eslint-new');
const cleanCSS = require('gulp-clean-css');
const sourcemaps = require('gulp-sourcemaps');
const webpack = require('webpack');
const WebpackDevServer = require('webpack-dev-server');

const webpackConfig = require('./webpack.config.js');

gulp.task('cleanGen', () => {
  return rimraf.rimraf('css/*.css');
});

gulp.task('cleanDist', () => {
  return rimraf.rimraf('../resources/static/dist');
});

gulp.task('clean', gulp.series('cleanDist', 'cleanGen'));

gulp.task('lint', () => {
  return gulp.src('app/**/*.js')
    .pipe(eslint())
    .pipe(eslint.format())
    .pipe(eslint.failOnError());
});

gulp.task('user-css', function () {
  return gulp.src(['css/common/bootstrap.css',
      'css/common/bootstrap-theme.css',
      'css/common/dataTables.bootstrap.css',
      'css/common/buttons.bootstrap.css',
      'css/user/user.css'])
    .pipe(concat('user.css'))
    .pipe(sourcemaps.init())
    .pipe(cleanCSS({ level: 2 }))
    .pipe(sourcemaps.write())
    .pipe(gulp.dest('css'))
    .pipe(gulp.dest('../resources/static/dist/css'));
});

gulp.task('home-css', function () {
  return gulp.src(['css/common/bootstrap.css',
      'css/common/bootstrap-theme.css',
      'css/common/dataTables.bootstrap.css',
      'css/common/buttons.bootstrap.css',
      'css/home/home.css'])
    .pipe(concat('home.css'))
    .pipe(sourcemaps.init())
    .pipe(cleanCSS({ level: 2 }))
    .pipe(sourcemaps.write())
    .pipe(gulp.dest('css'))
    .pipe(gulp.dest('../resources/static/dist/css'));
});

gulp.task('css', gulp.series('clean', 'user-css', 'home-css'));

gulp.task('pre', gulp.series('css', 'lint'));

gulp.task('webpack:build', gulp.series('pre', function (callback) {
  webpackConfig.mode = 'production';
  webpackConfig.performance = { hints: false };
  webpack(webpackConfig, function (err, stats) {
    if (err) {
      callback(err);
      return;
    }
    if (stats.hasErrors()) {
      callback(new Error(stats.toString({ colors: true })));
      return;
    }
    console.log('[webpack:build]', stats.toString({ colors: true }));
    callback();
  });
}));

// Production build
gulp.task('build', gulp.series('webpack:build'));

gulp.task('webpack-dev-server', gulp.series('pre', function (callback) {
  webpackConfig.mode = 'development';
  const compiler = webpack(webpackConfig);
  const server = new WebpackDevServer({
    port: 9090,
    host: 'localhost',
    static: { publicPath: '/dist/' },
  }, compiler);
  server.start().then(function () {
    console.log('[webpack-dev-server] http://localhost:9090/webpack-dev-server/index.html');
    callback();
  }).catch(callback);
}));

gulp.task('default', gulp.series('webpack-dev-server'));
const path = require("path");
const webpack = require("webpack");

module.exports = {
  resolve: {
    modules: [
      path.resolve(__dirname),
      "node_modules"
    ]
  },
  cache: true,
  entry: {
    app: "./app/index.js",
    user_app: "./app/user_index.js"
  },
  output: {
    path: path.resolve(__dirname + "/../resources/static/dist/"),
    filename: "[name].js"
  },
  module: {
    rules: [
      
      // required to write "require('./style.css')"
      { test: /\.css$/, use: ["css-loader"] },

      // required for bootstrap icons
      { test: /\.(woff|woff2|ttf|eot|svg)$/, type: 'asset/resource' },
      
      {
        test: [/\.js$/],
        exclude: path.resolve(__dirname + "/node_modules/"),
        use: {
          loader: 'swc-loader',
          options: {
            jsc: {
              parser: { syntax: 'ecmascript', jsx: true },
              transform: { react: { runtime: 'automatic' } },
            },
            env: { targets: 'defaults' },
          }
        }
      }
    ]
  },
  plugins: [
    new webpack.ProvidePlugin({
      jQuery: 'jquery',
      $: 'jquery',
      boostrap: 'bootstrap'
    })
  ]
};

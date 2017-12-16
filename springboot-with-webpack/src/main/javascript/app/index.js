const $ = require('jquery');
const React = require('react');
const ReactDOM = require('react-dom');
const CurrentTime = require('./components/test/CurrentTime');

$(document).ready(() => {
  ReactDOM.render(
    <CurrentTime date={new Date()}/>,
    document.getElementById('currentTime')
  );
});

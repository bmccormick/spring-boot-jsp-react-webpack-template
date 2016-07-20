var $ = require("jquery");
require("react");
var ReactDOM = require('react-dom');
var CurrentTime = require('./components/test/CurrentTime');

console.log('Loaded Homepage');

$(document).ready(function () {
  ReactDOM.render(
    <CurrentTime date={new Date()}/>,
    document.getElementById('currentTime')
  );
});

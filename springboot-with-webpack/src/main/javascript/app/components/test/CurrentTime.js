var React = require("react");

module.exports = React.createClass({
  render: function () {
    return (
      <p>
        It is {this.props.date.toTimeString()}
      </p>
    );
  }
});


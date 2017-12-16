const React = require('react');

module.exports = class CurrentTime extends React.Component {
  render() {
    return (
      <p>
        It is {this.props.date.toTimeString()}
      </p>
    );
  }
};


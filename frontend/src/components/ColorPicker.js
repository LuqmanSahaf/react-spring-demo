import React from "react";
import { SketchPicker } from "react-color";

class ColorPicker extends React.Component {
  state = {
    displayColorPicker: false,
    color: {
      rgb: {
        r: "241",
        g: "112",
        b: "19",
        a: "1"
      }
    }
  };

  handleClick = () => {
    this.setState({ displayColorPicker: !this.state.displayColorPicker });
  };

  handleChange = color => {
    this.setState({ color });
  };

  handleClose = () => {
    this.setState({ displayColorPicker: false });
  };

  render() {
    const popover = {
      position: "absolute",
      zIndex: "2"
    };
    const cover = {
      position: "fixed",
      top: "0px",
      right: "0px",
      bottom: "0px",
      left: "0px"
    };
    return (
      <span>
        <button onClick={this.handleClick}>Pick Color</button>
        {this.state.displayColorPicker ? (
          <div style={popover}>
            <div style={cover} onClick={this.handleClose} />
            <SketchPicker disableAlpha color={this.state.color} onChange={this.handleChange} onChangeComplete={this.props.updateColor} />
          </div>
        ) : null}
      </span>
    );
  }
}

export default ColorPicker;

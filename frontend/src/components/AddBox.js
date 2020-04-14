import React from "react";
import { connect } from "react-redux";
import { addBox } from "../redux/actions";
import ColorPicker from "./ColorPicker";


const mapStateToProps = state => {
  const countries = Object.keys(state.countries).map(function(name, index){return name});
  return { countries };
};

class AddBox extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      name: "",
      weight: 0.0,
      displayColorPicker: false,
      color: {
        rgb: {
          r: "241",
          g: "112",
          b: "19",
          a: "1"
        }
      },
      country: "Sweden"
    };
  }

  updateName = name => {
    this.setState({ name });
  };

  updateWeight = weight => {
    const new_weight = weight < 0 ? 0 : weight;
    this.setState({ weight: new_weight });
  };

  handleAddBox = () => {
    const c = this.state.color.rgb;
    const box = {
      name: this.state.name,
      weight: this.state.weight,
      color: c.r + "," + c.g + "," + c.b,
      country: this.state.country
    };
    this.props.addBox(box);
    this.setState({
      name: "",
      weight: 0.0,
      displayColorPicker: false,
      color: {
        rgb: {
          r: "241",
          g: "112",
          b: "19",
          a: "1"
        }
      },
      country: "Sweden"
    });
  };

  updateCountry = country => {
    this.setState({ country });
  };

  updateColor = color => {
    this.setState({ color });
  };

  render() {
    return (
      <div>
        Name:{" "}
        <input
          onChange={e => this.updateName(e.target.value)}
          value={this.state.name}
        />
        <br />
        <br />
        Weight:{" "}
        <input
          type="number"
          step="0.1"
          min="0"
          onChange={e => this.updateWeight(e.target.value)}
          value={this.state.weight}
        />
        <br />
        <br />
        Color: <ColorPicker updateColor={this.updateColor} />
        <br />
        <br />
        <label>
          Country:{" "}
          <select
            value={this.state.country}
            onChange={e => this.updateCountry(e.target.value)}
          >
            {this.props.countries.map(country => (
              <option key={country} value={country}>{country}</option>
            ))};
          </select>
        </label>
        <br />
        <br />
        <button className="add-box" onClick={this.handleAddBox}>
          Add Box
        </button>
      </div>
    );
  }
}

export default connect(
  mapStateToProps,
  { addBox }
)(AddBox);
// export default AddBox;

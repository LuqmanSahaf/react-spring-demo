import React, { Component } from "react";
import BoxList from "./BoxList";
import "../styles.css";
import { fetchBoxes } from "../redux/actions";
import { connect } from "react-redux";

class ListBoxes extends Component {
  componentDidMount() {
    this.props.fetchBoxes()
  }

  render() {
    return (
      <div className="box-app">
        <h2>Box List</h2>
        <BoxList />
      </div>
    );
  }
}

export default connect(
  null,
  {
    fetchBoxes: fetchBoxes
  }
)(ListBoxes);

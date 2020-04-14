import React from "react";
import { connect } from "react-redux";
// import { getBoxes } from "../redux/selectors";
import { getBoxes } from "../redux/selectors";
import SimpleTable from "./Table";

const BoxList = ({ boxes, countries }) => (
  <div>
    <ul>{boxes && boxes.length ? "" : "No boxes, yay!"}</ul>
    <SimpleTable rows={boxes} countries={countries} />
  </div>
);

const mapStateToProps = state => {
  const boxes = getBoxes(state);
  const countries = state.countries;
  return { boxes, countries };
};
// export default BoxList;
export default connect(mapStateToProps)(BoxList);

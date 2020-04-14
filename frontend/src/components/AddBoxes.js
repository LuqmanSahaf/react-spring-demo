import React from "react";
import AddBox from "./AddBox";
import "../styles.css";

export default function AddBoxes() {
  return (
    <div className="box-app">
      <h2>Add a Box!</h2>
      <AddBox />
    </div>
  );
}

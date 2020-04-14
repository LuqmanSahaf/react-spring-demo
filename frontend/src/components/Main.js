import React, { Component } from "react";
import "../styles.css";
import Home from "./Home";
import ListBoxes from "./ListBoxes";
import AddBoxes from "./AddBoxes";
import { Switch, Route, Link, HashRouter as Router } from "react-router-dom";
import { fetchCountries } from "../redux/actions";
import { connect } from "react-redux";

class Main extends Component {

  componentDidMount() {
      this.props.fetchCountries()
  }

  render() {
    return (
      <Router>
        <div>
          <h1>Box App</h1>
          <ul className="header">
            <li>
              <Link to="/">Home</Link>
            </li>
            <li>
              <Link to="/addBox">Add Box</Link>
            </li>
            <li>
              <Link to="/listBoxes">List of Boxes</Link>
            </li>
          </ul>
          <div className="content">
            <Switch>
              <Route exact path="/" component={Home} />
              <Route path="/addBox" component={AddBoxes} />
              <Route path="/listBoxes" component={ListBoxes} />
            </Switch>
          </div>
        </div>
      </Router>
    );
  }
};

export default connect(
  null,
  {
    fetchCountries: fetchCountries
  }
)(Main);

import { combineReducers } from "redux";
import boxes from "./boxes";
import countries from "./countries";

const rootReducer = combineReducers({
  boxes: boxes,
  countries: countries
});
export default rootReducer;

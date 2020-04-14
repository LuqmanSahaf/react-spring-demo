import { FETCH_COUNTRIES_SUCCESS } from "../actionTypes";

const initialState = {};

export default function(state = initialState, action) {
  switch (action.type) {
    case FETCH_COUNTRIES_SUCCESS: {
      const countries = action.payload.reduce(function(map, obj) {
        map[obj.name] = obj;
        return map;
      }, {});
      return {
        ...state,
        ...countries
      };
    }
    default:
      return state;
  }
}

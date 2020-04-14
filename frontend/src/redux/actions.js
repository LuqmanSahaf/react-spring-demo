import {
  FETCH_BOXES_SUCCESS,
  ADD_BOX_SUCCESS,
  FETCH_COUNTRIES_SUCCESS
} from "./actionTypes";
import { get, post } from "axios";

export const addBox = box => {
  return dispatch => {
    return post('http://127.0.0.1:8080/api/dispatch', box)
      .then(res => {
        dispatch(addBoxSuccess(res.data));
      })
      .catch(err => {
        console.log(err);
      });
  };
};

export const fetchBoxes = () => {
  return dispatch => {
    return get('http://127.0.0.1:8080/api/dispatch')
        .then(res => {
          dispatch(fetchBoxesSuccess(res.data));
        })
        .catch(err => {
          console.log(err.message);
        });
  };
};

export const fetchCountries = () => {
  return dispatch => {
    return get('http://127.0.0.1:8080/api/country')
      .then(res => {
        dispatch(fetchCountriesSuccess(res.data))
      })
      .catch(err => {
        console.log(err.message)
      })
  }
};

const fetchBoxesSuccess = boxes => ({
  type: FETCH_BOXES_SUCCESS,
  payload: boxes
});

const fetchCountriesSuccess = countries => ({
  type: FETCH_COUNTRIES_SUCCESS,
  payload: countries
});

const addBoxSuccess = box => ({
  type: ADD_BOX_SUCCESS,
  payload: box
});

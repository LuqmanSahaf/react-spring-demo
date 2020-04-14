export const getBoxesState = store => store.boxes;

export const getBoxList = store =>
  getBoxesState(store) ? getBoxesState(store).allIds : [];

export const getBoxById = (store, id) =>
  getBoxesState(store) ? { ...getBoxesState(store).byIds[id], id } : {};

/**
 * example of a slightly more complex selector
 * select from store combining information from multiple reducers
 */
export const getBoxes = store =>
  getBoxList(store).map(id => getBoxById(store, id));

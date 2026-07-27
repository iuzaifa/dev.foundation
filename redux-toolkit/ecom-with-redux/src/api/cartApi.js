import api from "./axios";


export const addCart = async (cart) => {
  const { data } = await api.post("/carts", cart);
  return data;
};

export const removeCart = async (id) => {
  const { data } = await api.delete(`/carts/${id}`);
  return data;
};


export const getAllCarts = async () => {
  const { data } = await api.get(`/carts`);
  return data;
};
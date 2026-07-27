import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import api from "../api/axios"

export const fetchProducts = createAsyncThunk(
  "products/fetchProducts",
  async () => {
    // https://fakestoreapi.com/products
    const res = await api.get("/products");
    return res.data;
  },
);

const initialState = {
  items: [],
  loading: false,
  error: null,
};

const productSlice = createSlice({
  name: "product",
  initialState,
  reducers: {},
  extraReducers: (builder) => {
    builder

      .addCase(fetchProducts.pending, (state) => {
        state.loading = true;
      })

      .addCase(fetchProducts.fulfilled, (state, action) => {
        ((state.loading = false), (state.items = action.payload));
      })

      .addCase(fetchProducts.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message;
      });
  },
});

export default productSlice.reducer;

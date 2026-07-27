import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import { addCart , removeCart} from "../api/cartApi";

export const addToCart = createAsyncThunk(
  "cart/addToCart",
  async (cartData, thunkApi) => {
    try {
      return await addCart(cartData);
    } catch (error) {
      return thunkApi.rejectWithValue(error.response?.data);
    }
  },
);

export const removeFromCart = createAsyncThunk ("cart/remove", 
    async (id, thunkApi) => {
        try {
            await removeCart(id);
            return id;

        } catch (error) {
            return thunkApi.rejectWithValue(error.response?.data || "Faild To remove from cart")
        }
    }
)

const initialState = {
  items: [],
  loading: false,
  error: null,
};

const cartSlice = createSlice({
  name: "cart",
  initialState,

  reducers: {},
  // reducers : {
  //     add (state, action) {
  //         state.push(action.payload)
  //     },
  //     remove (state, action) {
  //         // state = state.filter((item) => item.id !== action.payload)
  //         return state.filter((item) => item.id !== action.payload);

  //     },
  // }

  extraReducers: (builder) => {
    builder
      .addCase(addToCart.pending, (state) => {
        state.loading = true;
      })
      .addCase(addToCart.fulfilled, (state, action) => {
        state.loading = false;
        state.items.push(action.payload);
      })
      .addCase(addToCart.rejected, (state, action) => {
        state.loading = false;
        state.error = action.payload;
      })

      .addCase(removeFromCart.fulfilled, (state, action) => {
        state.items = state.items.filter(
          (item) => item.id !== action.payload
        );
      })


  },
});

export const { add, remove } = cartSlice.actions;
export default cartSlice.reducer;

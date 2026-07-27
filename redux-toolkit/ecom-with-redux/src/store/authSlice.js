import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import { getMe, loginUser } from "../api/authApi";

export const login = createAsyncThunk(
  "auth/login",
  async (credentials, thunkApi) => {
    try {
      return await loginUser(credentials);
    } catch (error) {
      return thunkApi.rejectWithValue(error.response.data || "Login faild");
    }
  },
);

export const getLoggedInUser = createAsyncThunk(
  "users/me",
  async (id, thunkApi) => {
    try {
      return await getMe(id);
    } catch (error) {
      return thunkApi.rejectWithValue(
        error?.response?.data || "Failed to get profile",
      );
    }
  },
);

const token = localStorage.getItem("token");

const initialState = {
  token: null,
  isLoggedIn: !!token,
  loading: false,
  error: null,
  user: null,
};

const authSlice = createSlice({
  name: "auth",

  initialState,

  reducers: {
    logout(state) {
      state.token = null;
      state.user = null;
      state.isLoggedIn = false;
      localStorage.removeItem("token");
    },
  },
  extraReducers: (builder) => {
    builder
      .addCase(login.pending, (state) => {
        state.loading = true;
        state.error = null;
      })

      .addCase(login.fulfilled, (state, action) => {
        state.loading = false;
        state.token = action.payload.token;
        state.isLoggedIn = true;

        localStorage.setItem("token", action.payload.token);
      })

      .addCase(login.rejected, (state, action) => {
        state.loading = false;
        state.error = action.payload;
      })

      .addCase(getLoggedInUser.pending, (state) => {
        state.loading = true;
        state.error = null;
      })
      .addCase(getLoggedInUser.fulfilled, (state, action) => {
        state.loading = false;
        state.user = action.payload;
        state.isLoggedIn = true;
      })
      .addCase(getLoggedInUser.rejected, (state, action) => {
        state.loading = false;
        state.error = action.payload;
      });
  },
});

export default authSlice.reducer;

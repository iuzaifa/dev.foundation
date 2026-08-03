import {configureStore} from "@reduxjs/toolkit";
import postReducer from "../feature/post/postSlice.js"
import userReducer from "../feature/users/usersSlice.js"



export const store = configureStore({
    reducer: {
        posts : postReducer,
        users : userReducer,
    }
})





// // first example
// import counterReducer from "../feature/counter/counterSlice.js";
// export const store = configureStore({
//     reducer: {
//         counter : counterReducer,
//     }
// })

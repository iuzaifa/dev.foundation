import {configureStore} from "@reduxjs/toolkit";
import postReducer from "../feature/post/postSlice.js"



export const store = configureStore({
    reducer: {
        posts : postReducer,
    }
})





// // first example
// import counterReducer from "../feature/counter/counterSlice.js";
// export const store = configureStore({
//     reducer: {
//         counter : counterReducer,
//     }
// })

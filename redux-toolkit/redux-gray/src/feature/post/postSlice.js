import {createSlice, nanoid} from '@reduxjs/toolkit';

const initialState = {
    posts: [
        {id : `1`, title : `Learning Redux Toolkit`, content : `Redux Toolkit simplifies state management with less boilerplate using createSlice, configureStore, and built-in Immer support.`},
        {id : `2`, title : `Learning React with Redux Toolkit`, content : `Combining React with Redux Toolkit helps manage global state efficiently while keeping components clean and predictable.`},
    ],
}

export const postSlice = createSlice ({
    name : `posts`,
    initialState,
    reducers: {
        postAdded : {
            reducer (state, action) {
                state.posts.push(action.payload)
            },
            prepare (title, content) {
                return {
                    payload : {
                        id : nanoid,
                        title,
                        content
                    }
                }
            }
        }
    },
})

export const {postAdded} = postSlice.actions;
export const selectAllPosts = (state) => state.posts.posts;
export default postSlice.reducer;
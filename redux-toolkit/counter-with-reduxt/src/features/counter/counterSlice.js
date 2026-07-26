import { createSlice } from "@reduxjs/toolkit";
import { toast } from "react-toastify";


const initialState = {
    value : 0,
}

const counterSlice = createSlice ({
    name : 'counter',
    initialState,
    reducers : {
        increment : (state) => {
            state.value += 1 
        },
        decrement : (state) => {
            if (state.value === 0 ) {
                toast.error("Value is already 0 it can't go with negative")
                return
            }
            state.value -= 1 
        },
        reset : (state) => {
            
            state.value = 0
        },
        incrementByAmount : (state, action ) => {
            state.value += action.payload
        },
        decrementByAmount : (state, action) => {
            if (state.value === 0 || action.payload > state.value) {
                toast.error("Value is already 0 it can't go with negative")
                return
            }

            state.value -= action.payload
        }
    }
})

export const {increment, decrement, reset, incrementByAmount, decrementByAmount} = counterSlice.actions;
export default counterSlice.reducer;
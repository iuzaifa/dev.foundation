import { useState } from "react";
import { ConterContext } from "./ContextProvider";


export const CounterProvider = (props) => {
    const [count , setCount ] = useState(0)
    return (
        <ConterContext.Provider value={{count, setCount, name : "huzaifa"}}>
            {props.children}
        </ConterContext.Provider>
        
    )
}

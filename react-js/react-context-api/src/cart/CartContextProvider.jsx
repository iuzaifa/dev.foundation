import { useState } from "react";
import { CartContext } from "./CartContext";

export const CartContextProvider = (props) => {

    const [item , setItem] = useState([]);
    


    return (
        <CartContext.Provider value={{item, setItem}}>
            {props.children}
        </CartContext.Provider>
    )
}
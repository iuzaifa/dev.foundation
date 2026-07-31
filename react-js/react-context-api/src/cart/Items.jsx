import { useContext } from "react";
import { CartContext } from "./CartContext";


const Items = (props) => {
  const cart = useContext(CartContext);
  return (
    <>
      <div className="bg-gray-200 p-5 rounded-sm border border-gray-300">
        <h1>{props.name}</h1>
        <p>Price : $ {props.price}</p>
        
        
        <button onClick={() => cart.setItem([...cart.item, {name:props.name, price:props.price}])}
        
        className="mt-3 mr-4 bg-[#202002] text-white p-2 text-xs rounded-xs border border-[#404040] cursor-pointer">
          Add To Cart
        </button>

        <button
          onClick={() =>
            cart.setItem(cart.item.filter((item) => item.id !== props.id))
          }
          className="mt-3 mx-2 bg-[#202002] text-white p-2 text-xs rounded-xs border border-[#404040] cursor-pointer"
        >
          Remove From Cart
        </button>


      </div>
    </>
  );
};

export default Items;



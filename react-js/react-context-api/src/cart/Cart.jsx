import { useContext } from "react";
import { CartContext } from "./CartContext";

const Cart = () => {
  const cart = useContext(CartContext);
  const totalPrice = cart.item.reduce((a, b) => a + b.price, 0);

  return (
    <div className="p-5">
        <h1 className="text-[#202020] font-semibold text-2xl">
            My Cart 
        </h1>

        <div className=" flex items-center gap-10 justify-between">
            <div className="bg-green-300 p-2 my-1"> 
            Total Price : {totalPrice}
        </div> 
        <div className="bg-green-300 p-2 my-1"> 
            Total Products : {cart.item.length}
        </div> 
        </div>

        <div className="bg-amber-100 p-2 my-1"> 
            Total Products List

            <div className="grid sm:grid-cols-3 md:grid-cols-6 gap-3">
                
                {cart.item.length === 0 ? <h2 className=" text-red-600 bg-red-200 px-2 py-1">Not Product Added</h2> :
                    cart.item.map((data, idx) => (
                        <div key={idx} className="bg-slate-100 flex gap-2  my-1 items-center px-2">
                            <p className="text-xs">1</p>
                            <div>
                                <h4 className="text-xs">{data.name}</h4>
                                <h4 className="text-xs">{data.price}</h4>
                            </div>
                        </div>  
                    ))
                }
                
            </div>
           
           
        </div> 


    </div>
  )
}

export default Cart
import Cart from "./Cart";
import { products } from "./data";
import Items from "./Items";



const AllItem = () => {
  return (
    <>
        <div className="max-w-7xl mx-auto px-5 mt-10">
            <Cart/>

            <div className="grid sm:grid-cols-2 md:grid-cols-4 gap-5">
                {products.map((product) => (
                    <Items key={product.id} name={product.name} price={product.price} />
                ))}
            </div>
        </div>

    </>
  )
}

export default AllItem
// import { ShoppingBag } from "lucide-react";
// import { useEffect } from "react";
// import { useDispatch, useSelector } from "react-redux";
// import { getAllCart } from "../store/cartSlice";

// const Cart = () => {
//   const dispatch = useDispatch();

//   const { cart : allAddItems, loading} = useSelector((state) => state.cart )

//   useEffect(() => {
//     dispatch(getAllCart())
//   }, [dispatch])


//   return (
//     <>
//       <div className="mx-auto max-w-7xl px-4 pt-24 pb-10">
//         {/* Heading */}
//         <div className="mb-8 flex items-center justify-between">
//           <h3 className="flex items-center gap-2 text-3xl font-bold text-gray-800">
//             <ShoppingBag className="text-[#45125f]" />
//             My Cart
//           </h3>

//           <span className="rounded-full bg-[#45125f] px-4 py-2 text-sm font-semibold text-white">
//             {products.length} Items
//           </span>
//         </div>

//         {/* Cart Items */}
//         <div className="space-y-6">
//           {products.map((product, idx) => (
//             <div
//               key={idx}
//               className="flex flex-col items-center gap-6 rounded-xl p-5 bg-[#45125f09] border-[#45125f]/5 border transition hover:shadow-xs md:flex-row"
//             >
//               {/* Image */}
//               <img
//                 src={product.image}
//                 alt={product.title}
//                 className="h-40 w-40 object-contain"
//               />

//               {/* Product Details */}
//               <div className="flex-1">
//                 <h4 className="text-xl font-semibold text-gray-800">
//                   {product.title.length > 40
//                     ? `${product.title.slice(0, 40)}...`
//                     : product.title}
//                 </h4>

//                 <p className="mt-2 text-sm text-gray-600">
//                   {product.description.length > 120
//                     ? `${product.description.slice(0, 120)}...`
//                     : product.description}
//                 </p>

//                 <div className="mt-4 flex flex-wrap items-center gap-4">
//                   <span className="text-2xl font-bold text-[#45125f]">
//                     ₹{product.price}
//                   </span>

//                   <span className="rounded bg-yellow-100 px-3 py-1 text-sm font-medium text-yellow-700">
//                     ⭐ {product.rating.rate}
//                   </span>
//                 </div>
//               </div>

//               {/* Remove Button */}
//               <button
//                 onClick={() => {}}
//                 className="rounded-md bg-[#45125f] px-6 py-3 font-medium text-white transition-colors duration-200 hover:bg-purple-800"
//               >
//                 Remove
//               </button>
//             </div>
//           ))}
//         </div>
//       </div>
//     </>
//   );
// };

// export default Cart;

import { ShoppingBag } from "lucide-react";
import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getAllCart } from "../store/cartSlice";

const Cart = () => {
  const dispatch = useDispatch();

  const { items, loading } = useSelector((state) => state.cart);

  useEffect(() => {
    dispatch(getAllCart());
  }, [dispatch]);

  if (loading) {
    return <h2 className="pt-24 text-center">Loading...</h2>;
  }

  if (items.length === 0) {
    return (
      <div className="pt-24 text-center">
        <h2 className="text-2xl font-semibold">Your cart is empty 🛒</h2>
      </div>
    );
  }

  return (
    <div className="mx-auto max-w-7xl px-4 pb-10 pt-24">
      <div className="mb-8 flex items-center justify-between">
        <h3 className="flex items-center gap-2 text-3xl font-bold text-gray-800">
          <ShoppingBag className="text-[#45125f]" />
          My Cart
        </h3>

        <span className="rounded-full bg-[#45125f] px-4 py-2 text-sm font-semibold text-white">
          {items.length} Items
        </span>
      </div>

      <div className="space-y-6">
        {items.map((product) => (
          <div
            key={product.id}
            className="flex flex-col items-center gap-6 rounded-xl border border-[#45125f]/5 bg-[#45125f09] p-5 transition hover:shadow-sm md:flex-row"
          >
            <img
              src={product.image}
              alt={product.title}
              className="h-40 w-40 object-contain"
            />

            <div className="flex-1">
              <h4 className="text-xl font-semibold text-gray-800">
                {product.title === undefined}
              </h4>

              <p className="mt-2 text-sm text-gray-600">
                {product.description}
              </p>

              <div className="mt-4 flex items-center gap-4">
                <span className="text-2xl font-bold text-[#45125f]">
                  ₹{product.price}
                </span>

                <span className="rounded bg-yellow-100 px-3 py-1 text-sm font-medium text-yellow-700">
                  ⭐ {product.rating?.rate}
                </span>
              </div>
            </div>

            <button
              className="rounded-md bg-[#45125f] px-6 py-3 font-medium text-white transition hover:bg-purple-800"
            >
              Remove
            </button>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Cart;

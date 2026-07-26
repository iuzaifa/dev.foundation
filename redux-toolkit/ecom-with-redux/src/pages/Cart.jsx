import { ShoppingBag } from "lucide-react";
import { useDispatch, useSelector } from "react-redux";
import { remove } from "../store/cartSlice";

const Cart = () => {
  const dispatch = useDispatch();
  const products = useSelector((state) => state.cart);

  const handleRemove = (productId) => {
    dispatch(remove(productId));
  };

  return (
    <>
      <div className="mx-auto max-w-7xl px-4 pt-24 pb-10">
        {/* Heading */}
        <div className="mb-8 flex items-center justify-between">
          <h3 className="flex items-center gap-2 text-3xl font-bold text-gray-800">
            <ShoppingBag className="text-[#45125f]" />
            My Cart
          </h3>

          <span className="rounded-full bg-[#45125f] px-4 py-2 text-sm font-semibold text-white">
            {products.length} Items
          </span>
        </div>

        {/* Cart Items */}
        <div className="space-y-6">
          {products.map((product, idx) => (
            <div
              key={idx}
              className="flex flex-col items-center gap-6 rounded-xl p-5 bg-[#45125f09] border-[#45125f]/5 border transition hover:shadow-xs md:flex-row"
            >
              {/* Image */}
              <img
                src={product.image}
                alt={product.title}
                className="h-40 w-40 object-contain"
              />

              {/* Product Details */}
              <div className="flex-1">
                <h4 className="text-xl font-semibold text-gray-800">
                  {product.title.length > 40
                    ? `${product.title.slice(0, 40)}...`
                    : product.title}
                </h4>

                <p className="mt-2 text-sm text-gray-600">
                  {product.description.length > 120
                    ? `${product.description.slice(0, 120)}...`
                    : product.description}
                </p>

                <div className="mt-4 flex flex-wrap items-center gap-4">
                  <span className="text-2xl font-bold text-[#45125f]">
                    ₹{product.price}
                  </span>

                  <span className="rounded bg-yellow-100 px-3 py-1 text-sm font-medium text-yellow-700">
                    ⭐ {product.rating.rate}
                  </span>
                </div>
              </div>

              {/* Remove Button */}
              <button
                onClick={() => handleRemove(product.id)}
                className="rounded-md bg-[#45125f] px-6 py-3 font-medium text-white transition-colors duration-200 hover:bg-purple-800"
              >
                Remove
              </button>
            </div>
          ))}
        </div>
      </div>
    </>
  );
};

export default Cart;

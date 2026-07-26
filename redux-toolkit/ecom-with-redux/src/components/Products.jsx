import { useEffect } from "react";
import { ShoppingCart } from "lucide-react";
import { useDispatch, useSelector } from "react-redux";
import { add } from "../store/cartSlice";
import { fetchProducts } from "../store/productSlice";

const Products = () => {
  const dispatch = useDispatch();

  const { items :  products, loading} = useSelector((state) => state.product);

  useEffect(() => {
    dispatch(fetchProducts())
  }, [dispatch]);

  const handleAdd = (product) => {
    dispatch(add(product));
  };

  if (loading) return <h2>Loading...</h2>;



  return (
    <>
      <div className="grid grid-cols-1 gap-6 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4">
        {products.map((product) => (
          <div
            key={product.id}
            className="rounded-lg border border-gray-200 bg-[#45125f1b] hover:bg-white p-4 shadow transition hover:shadow-lg"
          >
            <img
              src={product.image}
              alt={product.title}
              className="mx-auto h-52 w-full object-contain"
            />

            <h2 className="mt-4 line-clamp-2 text-md font-semibold">
              {product.title.length > 15 ? `${product.title.slice(0, 25)}...` : product.title }
            </h2>

            <p className="mt-2 line-clamp-3 text-sm text-gray-600">
              {product.description.length > 255 ? `${product.description.slice(0,255)}...` : product.description }
            </p>

            <div className="mt-3 flex items-center justify-between">
              <span className="text-xl font-bold text-[#45125f]">
                ₹{product.price}
              </span>

              <span className="rounded bg-yellow-100 px-2 py-1 text-sm">
                ⭐ {product.rating.rate}
              </span>
            </div>

            <button
              onClick={() => handleAdd(product)}
              className="mt-4 flex w-full cursor-pointer items-center justify-center gap-2 rounded-md bg-[#45125f] py-2.5 font-medium text-white transition-colors duration-200 hover:bg-purple-800 active:scale-95"
            >
              <ShoppingCart size={15} />
              <span>Add to Cart</span>
            </button>
          </div>
        ))}
      </div>
    </>
  );
};

export default Products;

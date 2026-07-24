import type { Product } from "../types/products.type";

interface ProductProps {
    product : Product;
}

function ProductCard({product} : ProductProps) {
  return (
    <>
      <div className="max-w-sm rounded-xl border border-gray-200 bg-white shadow-md overflow-hidden hover:shadow-lg transition-shadow">
        <img src={product.thumbnail} alt={product.title} className="w-full h-56 object-cover" />

        <div className="p-4">
          <span className="inline-block bg-blue-100 text-blue-700 text-xs px-2 py-1 rounded-full">
            {product.category}
          </span>

          <h2 className="text-xl font-semibold mt-3">{product.title}</h2>

          <p className="text-gray-600 text-sm mt-2 line-clamp-2">{product.description}</p>

          <div className="flex items-center justify-between mt-4">
            <div>
              <p className="text-2xl font-bold text-green-600">${product.price}</p>
              <p className="text-sm text-red-500">{product.discountPercentage}% OFF</p>
            </div>

            <div className="text-right">
              <p className="text-yellow-500 font-medium">⭐ {product.rating}</p>
              <p className={`text-sm ${product.stock > 0 ? 'text-green-600' : 'text-red-600'}`}>
                {product.stock > 0 ? `${product.stock} In Stock` : 'Out of Stock'}
              </p>
            </div>
          </div>

          <div className="mt-4">
            <p className="text-sm text-gray-500">
              Brand: <span className="font-medium">{product.brand}</span>
            </p>
          </div>

          <button
            className="w-full mt-5 bg-blue-600 text-white py-2 rounded-lg hover:bg-blue-700 transition"
            disabled={product.stock === 0}
          >
            {product.stock > 0 ? 'Add to Cart' : 'Unavailable'}
          </button>
        </div>
      </div>
    </>
  );
}

export default ProductCard;

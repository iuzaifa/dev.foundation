import { NavLink } from "react-router-dom";
import { ShoppingCart } from "lucide-react";
import { useSelector } from "react-redux";

const Navbar = () => {
  const item = useSelector((state) => state.cart);
  return (
    <nav className="fixed top-0 left-0 z-50 w-full border-white/10 bg-white/20 backdrop-blur-lg text-[#303030] shadow-xs ">
      <div className="mx-auto flex max-w-7xl items-center justify-between px-6 py-4">
        {/* Logo */}
        <NavLink
          to="/"
          className="text-2xl font-bold tracking-wide text-[#45125f]"
        >
          Redux Store
        </NavLink>

        {/* Navigation */}
        <div className="flex items-center gap-6">
          <NavLink
            to="/"
            end
            className={({ isActive }) =>
              `transition-colors ${
                isActive
                  ? "text-purple-800 font-semibold "
                  : "text-[#303030] text-sm font-semibold hover:text-purple-800"
              }`
            }
          >
            Home
          </NavLink>

          <NavLink
            to="/cart"
            className={({ isActive }) =>
              `transition-colors ${
                isActive
                  ? "text-purple-800 font-semibold "
                  : "text-[#303030] text-sm font-semibold hover:text-purple-800"
              }`
            }
          >
            Cart
          </NavLink>

          {/* <div className="flex items-center gap-2 rounded-full bg-blue-600 px-4 py-2 text-white transition hover:bg-blue-700">
            <ShoppingCart size={20} />
            <span className="font-medium">Cart</span>

            <span className="flex h-6 w-6 items-center justify-center rounded-full bg-white text-sm font-bold text-blue-600">
              {item.length}
            </span>
          </div> */}
          <NavLink to="/cart">

            <span className="relative flex h-11 w-11 cursor-pointer items-center justify-center rounded-full border border-white/20 bg-[#45125f]/10 backdrop-blur-md transition-all duration-300 hover:bg-white/20">
            <ShoppingCart size={22} className="text-[#202020]" />

            <span className="absolute -right-1 -top-1 flex h-5 w-5 items-center justify-center rounded-full bg-red-500 text-xs font-bold text-white">
              {item.length}
            </span>
          </span>
          </NavLink>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;

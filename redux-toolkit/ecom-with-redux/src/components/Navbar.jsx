import { NavLink, useLocation } from "react-router-dom";
import { ShoppingCart } from "lucide-react";
import { useSelector } from "react-redux";

const Navbar = () => {
  const { isLoggedIn, user } = useSelector((state) => state.auth);
  

  const item = useSelector((state) => state.cart);
  const location = useLocation();
  return (
    <nav className={`${location.pathname === "/login" ? "hidden" : "fixed"} fixed top-0 left-0 z-50 w-full border-white/10 bg-white/20 backdrop-blur-lg text-[#303030] shadow-xs`}>
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

          

          
          <NavLink to="/cart">

            <span className="relative flex h-11 w-11 cursor-pointer items-center justify-center rounded-full border border-white/20 bg-[#45125f]/10 backdrop-blur-md transition-all duration-300 hover:bg-white/20">
            <ShoppingCart size={22} className="text-[#202020]" />

            <span className="absolute -right-1 -top-1 flex h-5 w-5 items-center justify-center rounded-full bg-red-500 text-xs font-bold text-white">
              {item.length === 0 ? 0: 0}
            </span>
          </span>
          </NavLink>


          
          {!isLoggedIn ? 
          <NavLink
            to="/login"
            className={ "transition-colors text-xs py-2 px-4 rounded-md font-semibold  bg-purple-800 text-white"}
          >
            Login
          </NavLink> : 

          `Hi! ${user?.name?.firstname === undefined}`} 

          
        </div>
      </div>
    </nav>
  );
};

export default Navbar;

import { NavLink } from "react-router-dom";

const Header = () => {

  const navLinkClass = ({ isActive }) =>
    `rounded-lg px-4 py-2 text-sm font-medium transition-all duration-200 ${
      isActive
        ? "bg-[#101010] text-[#909090]"
        : "text-[#909090]"
    }`;

  return (
    <header className="fixed top-0 z-50 h-16 w-full shadow-xs bg-[#161616]">
      <div className="mx-auto flex h-full max-w-7xl items-center justify-between px-4">
        <NavLink to="/" className="text-xl font-bold text-[#909090]">
          Tanstack<span className="text-emerald-600">Query</span>
        </NavLink>

        <nav className="flex items-center gap-2">
          <NavLink to="/" end className={navLinkClass}>
            Home
          </NavLink>

          <NavLink to="/fetch-old" className={navLinkClass}>
            Fetch Old
          </NavLink>

          <NavLink to="/fetch-rq" className={navLinkClass}>
            Fetch RQ
          </NavLink>
        </nav>
      </div>
    </header>
  );
};

export default Header;

import { useContext } from "react";
import { NavLink } from "react-router-dom";
import { counterContext } from "../context/CounterContext";

const Header = () => {
  const theme = useContext(counterContext);
  console.log( "theme",theme.theme)
  return (
    <>
      <header className="header">
        <nav>
          <NavLink className={`navlink`} to={"/"}>
            Home
          </NavLink>
          <NavLink className={`navlink`} to={"/about"}>
            About
          </NavLink>
          <NavLink className={`navlink`} to={"/contact"}>
            Contact
          </NavLink>
          <NavLink className={`navlink`} to={"/portfolio"}>
            Portfolio
          </NavLink>
        </nav>
        <button onClick={() => theme.setTheme(!theme.theme)}>
          {theme.theme ? "Dark Mode" : "Light Mode"}
        </button>
      </header>
    </>
  );
};

export default Header;

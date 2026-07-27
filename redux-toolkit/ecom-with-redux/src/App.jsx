import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import Cart from "./pages/Cart";
import Navbar from "./components/Navbar";
import { Provider } from "react-redux";
import store from "./store/store";
import Login from "./pages/Login";

function App() {
  return (
    <>
      <Provider store={store}>
        <BrowserRouter>
          <Navbar />
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/cart" element={<Cart />} />
            <Route path="/login" element={<Login />} />
          </Routes>
        </BrowserRouter>
      </Provider>
      
    </>
  );
}

export default App;

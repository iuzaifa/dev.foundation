import { createBrowserRouter, RouterProvider } from "react-router-dom";
import MainLayout from "./components/MainLayout";
import Home from "./pages/Home";
import About from "./pages/About";
import Portfolio from "./pages/Portfolio";
import Contact from "./pages/Contact";

const router = createBrowserRouter([
  {
    path: "/",
    element: <MainLayout />,
    children: [
      { index : true, element: <Home/> },// "/" pe Home render hoga
      { path: "about", element: <About/> },  // "/about"
      { path: "portfolio", element: <Portfolio/> },  // "/about"
      { path: "contact", element: <Contact/> },  // "/about"
    ]
  }
])

function App() {
  return  (
    
    <RouterProvider router={router} />

  )
}

export default App
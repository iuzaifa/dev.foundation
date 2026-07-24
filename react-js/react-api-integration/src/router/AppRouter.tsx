import { createBrowserRouter, RouterProvider } from "react-router-dom";
import UsersRandomUsers from "../components/UsersRandomUsers";
import { UserDetails } from "../page/UserDetails";
import { AllProducts } from "../page/AllProducts";
import ProductDetails from "../page/ProductDetails";

const router = createBrowserRouter([
  
  {
    path: "/",
    element: <UsersRandomUsers/>,
  },
  {
    path: "/users/:userId",
    element: <UserDetails />,
  },
  {
    path : "/products",
    element : <AllProducts/> ,
  },
  {
    path : "/products/:productsId",
    element : <ProductDetails/> ,
  }
]);

const AppRouter = () => {
  return <RouterProvider router={router} />;
};

export default AppRouter;
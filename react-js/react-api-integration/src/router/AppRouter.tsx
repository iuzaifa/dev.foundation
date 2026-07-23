import { createBrowserRouter, RouterProvider } from "react-router-dom";
import UsersRandomUsers from "../components/UsersRandomUsers";
import { UserDetails } from "../page/UserDetails";

const router = createBrowserRouter([
  
  {
    path: "/",
    element: <UsersRandomUsers/>,
  },
  {
    path: "/users/:userId",
    element: <UserDetails />,
  },
  
]);

const AppRouter = () => {
  return <RouterProvider router={router} />;
};

export default AppRouter;
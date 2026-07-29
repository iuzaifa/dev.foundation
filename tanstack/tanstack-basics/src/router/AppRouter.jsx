import { createBrowserRouter } from "react-router-dom";
import Home from "../pages/Home";
import FetchOld from "../pages/FetchOld";
import FetchRQ from "../pages/FetchRQ";
import MainLayout from "../components/layout/MainLayout";
import SinglePost from "../components/ui/SinglePost";

export const router = createBrowserRouter([
  {
    path: "/",
    element: <MainLayout />,
    children: [
      { index: true, element: <Home /> },
      { path: "/fetch-old", element: <FetchOld /> },
      { path: "/fetch-rq", element: <FetchRQ /> },
      { path: "/fetch-rq/:id", element: <SinglePost /> },
    ],
  },
]);

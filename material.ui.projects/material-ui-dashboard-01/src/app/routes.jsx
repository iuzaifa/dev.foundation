import { createBrowserRouter } from "react-router-dom";
import DashboardLayout from "../layouts/DashboardLayout"
import NotFound from "../pages/NotFound";
import Dashboard from "../pages/admin/dashboard/Dashboard";
import SalesReport from "../pages/admin/reports/SalesReport";
import LeadsReport from "../pages/admin/reports/LeadsReport";
import TImesheetReports from "../pages/admin/reports/TImesheetReports";
import ProjectReports from "../pages/admin/reports/ProjectReports";

export const router = createBrowserRouter([
  {
    path: "/",
    element: <DashboardLayout />,
    children: [
      { index: true, element: <Dashboard /> }, // default route

      // reports
      { path: "reports/sales-reports", element: <SalesReport/> },
      { path: "reports/leads-reports", element: <LeadsReport/> },
      { path: "reports/project-reports", element: <ProjectReports/> },
      { path: "reports/timesheet-reports", element: <TImesheetReports/> },
    ],
  },

  {
    path: "*",
    element: <NotFound />,
  },
]);
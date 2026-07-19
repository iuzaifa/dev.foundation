import React, { useState, useEffect } from 'react'
import Sidebar from '../components/common/Sidebar'
import Header from '../components/common/Header'
import { useMediaQuery } from '@mui/material'
import { Outlet } from 'react-router-dom'


const DRAWER_WIDTH = 240;
const COLLAPSED_WIDTH = 72;

const DashboardLayout = () => {

  const isMobile = useMediaQuery("(max-width:900px)")

  const [collapsed, setCollapsed] = useState(false);
  const [mobileOpen, setMobileOpen] = useState(false);


  useEffect(() => {
    if (isMobile) {
      setCollapsed(false); // reset collapse on mobile
    }
  }, [isMobile]);

  const toggleSidebar = () => {
    if (isMobile){
      setMobileOpen(!mobileOpen);
    }else {
      setCollapsed(!collapsed)
    }
  }

  const sidebarwidth = collapsed ? COLLAPSED_WIDTH : DRAWER_WIDTH;


  return (
    <>
      <div style={{ display: "flex", height: "100vh" }}>
        {/* 280px it should be  */}
        <Sidebar width={sidebarwidth} collapsed={collapsed} mobileOpen={mobileOpen} onClose={() => setMobileOpen(false)} isMobile={isMobile}/>
        <div style={{ flex: 1, display: "flex", flexDirection: "column", position : "relative" }}>
          <Header onMenuClick={toggleSidebar} collapsed={collapsed} />
          <main style={{ flex: 1, marginLeft : sidebarwidth }}>
            <Outlet />
          </main>
        </div>
      </div>
    </>
  );
}

export default DashboardLayout
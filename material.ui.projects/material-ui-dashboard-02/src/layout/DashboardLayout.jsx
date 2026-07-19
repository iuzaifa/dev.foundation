import React from 'react'
import Sidebar from '../components/common/Sidebar'
import Header from '../components/common/Header'
import { Outlet } from 'react-router-dom'
import { Grid } from '@mui/material'

const DashboardLayout = () => {
  return (
    <>
      <Grid container sx={{ height: "100vh", background: "#ffffff" ,}}>
        <Grid size={2}>
          <Sidebar />
        </Grid>
        <Grid size={10}>
          <Header />
          <main style={{ background: "#f7f7f7" }}>
            <Outlet />
          </main>
        </Grid>
      </Grid>
    </>
  );
}

export default DashboardLayout
import React from "react";
import HeroSection from "../components/sections/HeroSection";
import PaltefromSection from "../components/sections/PaltefromSection";
import FeatureModule from "../components/sections/FeatureModule";
import { Box, Grid } from "@mui/material";
import OfficeActions from "../components/sections/OfficeActions";
import Detection from "../components/sections/Detection";
import Testomonial from "../components/sections/Testomonial";
import Security from "../components/sections/Security";
import Team from "../components/sections/Team";
import MYAccordion from "../components/sections/MYAccordion";
import Action from "../components/sections/Action";
import Footer from "../components/sections/Footer";

const Home = () => {
  return (
    <>
      <Grid
        container
        maxWidth={`xl`}
        component={`div`}
        sx={{ flexDirection: "column", margin: "auto" }}
      >
        <Box>
          <HeroSection />
        </Box>
        <Box>
          <PaltefromSection />
        </Box>
        <Box>
          <FeatureModule />
        </Box>
        <Box>
          <OfficeActions />
        </Box>
        <Box>
          <Detection />
        </Box>
        <Box>
          <Testomonial />
        </Box>
        <Box sx={{ background: "#101010", color: "#fff", my: "50px " }}>
          <Security />
        </Box>
        <Box>
          <Team />
        </Box>
        <Box sx={{ marginTop: "50px" }}>
          <MYAccordion />
        </Box>
        <Box sx={{ marginTop: "50px" }}>
          <Action />
        </Box>
        <Box sx={{background : "#101010", color : "#dcdcdc"}}>
          <Footer />
        </Box>
      </Grid>
    </>
  );
};

export default Home;

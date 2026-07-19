import { Grid, Button } from "@mui/material";
import React from "react";
import SectionHeading from "./SectionHeading";
const Action = () => {
  return (
    <>
      <Grid
        container
        sx={{
          px: { xs: 2, md: 10 },
          backgroundImage: "url('/cl.png')",
          backgroundSize: "cover",
          backgroundRepeat: "no-repeat",
          backgroundPosition: "center",
          height: "80vh",
          width: "100%",

          display : "flex",
          alignItems :"center",
          justifyContent : "center"
        }}
      >
        <Grid size={{ xs: 12, md: 5 }} textAlign={"center"}>
          <SectionHeading
            heading={"Get your AI Operating System for Patents today"}
          />
          <Button
            variant="contained"
            sx={{
              borderRadius: "0",
              background: "#101010",
            }}
          >
            Book Demo
          </Button>
        </Grid>
      </Grid>
    </>
  );
};

export default Action;

import React from "react";
import { Container, Grid, Box, Typography, Button } from "@mui/material";
import ContactForm from "../ui/ContactForm";
import SectionHeading from "./SectionHeading";
import SectionDesctiption from "./SectionDesctiption";



const HeroSection = () => {
  return (
    <>
      <Container maxWidth="xl" sx={{ marginTop: `2.5rem` }}>
        <Grid
          container
          spacing={10}
          padding={5}
          sx={{ display: `flex`, alignItems: " center" }}
        >
          <Grid size={{ xs: 12, md: 7 }} padding={7}>
            <Box>
              <SectionHeading
                heading={`We Are a Software Development Agency`}
              />
              <SectionDesctiption
                description={` We build scalable, secure, and high-performance web and mobile
                applications using modern technologies to help businesses grow
                faster.`}
              />

              <Box sx={{ padding: "30px 0", display: "flex", gap: `32px` }}>
                
                <Button
                  variant="contained"
                  sx={{
                    background: "#101010",
                    borderRadius: "0",
                    fontSize: "12px",
                    fontWeight: 400,
                    marginTop: "30px",
                  }}
                >
                  More Infor
                </Button>
                <Button
                  variant="contained"
                  sx={{
                    background: "#2645b5",
                    borderRadius: "0",
                    fontSize: "12px",
                    fontWeight: 400,
                    marginTop: "30px",
                    variant : "outlined"
                  }}
                >
                  Get Contact
                </Button>

               
              </Box>
            </Box>
          </Grid>

          <Grid size={{ xs: 12, md: 5 }}>
            <Box>
              <ContactForm />
            </Box>
          </Grid>
        </Grid>
      </Container>
    </>
  );
};

export default HeroSection;

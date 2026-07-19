import { Box, Button, Grid } from '@mui/material'
import React from 'react'
import SectionTitle from './SectionTitle'
import SectionHeading from './SectionHeading';
import SectionDesctiption from './SectionDesctiption';

const OfficeActions = () => {
  return (
    <>
     
      <Grid
        container
        sx={{
          padding: "20px 100px",
          justifyContent: "space-between",
          alignItems: `center`,
        }}


        spacing={10}
      >
        <Grid size={{ xs: 12, md: 6 }}>
          <Box component="img" src="o.png" alt="image" width={450}></Box>
        </Grid>

        <Grid size={{ xs: 12, md: 6 }}>
          <Box>
            <SectionHeading heading={`Office Actions`} />

            <SectionDesctiption
              description={`Turn disclosures into claims and claims into full drafts, with configurable styles and strategies to adapt to your team's needs and citations to source documents.`}
            />

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
              Book a Demo
            </Button>
          </Box>
        </Grid>
      </Grid>
    </>
  );
}

export default OfficeActions
import { Grid, Typography, Box } from "@mui/material";
import React from 'react'


const product = [
  { title: "Patent Drafting" },
  { title: "Office Actions" },
  { title: "Infringement Detection" },
];
const company = [ {title: "Security"}, {title : "About US"}, {title : "Careers"}]
const resources = [{title: "Case studies"}, {title: "Newsroom"}, {title: "Blog"}, {title: "Community" }];


const Footer = () => {
  return (
    <>
      <Grid container sx={{ p: { xs: 2, md: 10 } }} spacing={2}>
        <Grid size={{ xs: 12, md: 5 }}>
          <Box
            component={"img"}
            alt="image"
            src="logo.png"
            height={50}
            marginBottom={1}
          ></Box>
          <Typography
            sx={{
              color: "#e1dfdf",
              fontSize: 12,
              width: { xs: "200px", md: "210px" },
            }}
          >
            © 2026 Ankar AI - AI Operating System for Patents
          </Typography>
        </Grid>

        <Grid size={{ xs: 12, md: 7 }} spacing={4} sx={{display : "flex", }}>
          <Grid size={{ xs: 12, md: 4 }}>
            <Typography sx={{fontFamily :"monospace", fontSize :16, color : "#747474", letterSpacing : .5 , marginBottom : 1, textTransform : "uppercase" }}>PRODUCT</Typography>
              {product.map((item, idx) => (
                <Typography key={idx} sx={{fontSize : 14 , color : "#c5c0c0", letterSpacing : .4}}>
                    {item.title}
                </Typography>
              ))}
          </Grid>
          <Grid size={{ xs: 12, md: 4 }}>
            <Typography sx={{fontFamily :"monospace", fontSize :16, color : "#747474", letterSpacing : .5 , marginBottom : 1, textTransform : "uppercase" }}>company</Typography>
                {company.map((item, idx) => (
                    <Typography key={idx} sx={{fontSize : 14 , color : "#c5c0c0", letterSpacing : .4}}>
                    {item.title}
                    </Typography>
                ))}
          </Grid>
          <Grid size={{ xs: 12, md: 4 }}>
            <Typography sx={{fontFamily :"monospace", fontSize :16, color : "#747474", letterSpacing : .5 , marginBottom : 1, textTransform : "uppercase" }}>Resources</Typography>
                 {resources.map((item, idx) => (
                    <Typography key={idx} sx={{fontSize : 14 , color : "#c5c0c0", letterSpacing : .4}}>
                    {item.title}
                    </Typography>
                ))}
          </Grid>
        </Grid>
      </Grid>
    </>
  );
}

export default Footer
import { Box, capitalize, Grid, Typography } from "@mui/material";
import React from 'react'
import HighlightAltIcon from "@mui/icons-material/HighlightAlt";
import LightbulbIcon from "@mui/icons-material/Lightbulb";
import DrawIcon from "@mui/icons-material/Draw";
import DeveloperModeIcon from "@mui/icons-material/DeveloperMode";
import VerifiedUserIcon from "@mui/icons-material/VerifiedUser";
import SectionTitle from "./SectionTitle";
import SectionHeading from "./SectionHeading";
import SectionDesctiption from "./SectionDesctiption";



const data = [
  {
    id: 1,
    title: "Idea Integration",
    description:
      "Transforming ideas into practical and scalable digital solutions.",
    icon: <LightbulbIcon />,
  },
  {
    id: 2,
    title: "Design & Planning",
    description:
      "Creating user-focused designs and well-structured development plans.",
    icon: <DrawIcon />,
  },
  {
    id: 3,
    title: "Development",
    description:
      "Building secure, high-performance applications using modern technologies.",
    icon: <DeveloperModeIcon />,
  },
  {
    id: 4,
    title: "Testing & Launch",
    description: "Ensuring quality, performance, and smooth deployment.",
    icon: <VerifiedUserIcon />,
  },
];


const PaltefromSection = () => {
  return (
    <>


        <Grid container sx={{ padding: "20px 100px" }}>
            <Box>
                <SectionTitle title={`Our Plateform`} />
                <SectionHeading heading={`Transform your planet Lifecycle`} />
                <SectionDesctiption description={` We partner with you to design and deploy the right tools for your team across the entire patent lifecycle`}/>
            </Box>
        </Grid>
      <Grid container spacing={3} maxWidth={`xl`} sx={{ padding: "20px 100px"}}>
        {data.map((d) => (
          <Grid size={{ xs: 12, md: 3, }} key={d.id}>
            <Box position="relative">
              {/* Image */}
              <Box component="img" src="image.png" alt="" sx={{ width: "100%", height: 140, objectFit: "cover",}}/>
              {/* Overlay */}
              <Box sx={{ position: "absolute", inset: 0, display: "flex", alignItems: "center", justifyContent: "center",}}>
                {/* Icon */}
                <Box sx={{ color: "#fff", width: 70, height: 70, display: "flex", alignItems: "center", justifyContent: "center",}}>
                  {d.icon}
                </Box>
              </Box>
            </Box>

            <Typography
              sx={{
                fontSize: `14px`,
                fontWeight: 500,
                color: `#202020`,
                marginBottom: "2px",
              }}
            >
              {d.title}
            </Typography>
            <Typography
              sx={{
                fontSize: `13px`,
                fontWeight: 300,
                color: `#606060`,
                lineHeight: 1.2,
              }}
            >
              {d.description}
            </Typography>
          </Grid>
        ))}
      </Grid>
    </>
  );
}

export default PaltefromSection
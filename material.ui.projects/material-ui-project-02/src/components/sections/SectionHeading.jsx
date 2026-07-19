import React from 'react'
import { Typography } from "@mui/material";

const SectionHeading = ({heading}) => {
  return (
    <>
      <Typography
        variant="h4"
        sx={{
          fontWeight: 300,
          fontFamily: "emoji",
          textTransform: `capitalize`,
          lineHeight : 1.1,
          marginBottom : "20px"
        }}
      >
        {heading}
      </Typography>
    </>
  );
}

export default SectionHeading
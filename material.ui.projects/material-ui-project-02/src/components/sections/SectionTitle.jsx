import React from 'react'
import { Typography } from '@mui/material';
import HighlightAltIcon from "@mui/icons-material/HighlightAlt";


const SectionTitle = ( {title }) => {
  return (
    <>
      <Typography sx={{ fontSize: "11px", fontWeight: 500 }}>
        <HighlightAltIcon sx={{ fontSize: "15px" }} /> {title}
      </Typography>
    </>
  );
}

export default SectionTitle
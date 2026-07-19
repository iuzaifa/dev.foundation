import React from "react";
import { Typography } from "@mui/material";

const SectionDesctiption = ({ description }) => {
  return (
    <>
      <Typography
        component="p"
        sx={{
          fontSize: `13px`,
          color: "#707070",
          fontWeight: 400,
          lineHeight: 1.2,
          fontFamily: "Roboto",
        }}
      >
        {description}
      </Typography>
    </>
  );
};

export default SectionDesctiption;

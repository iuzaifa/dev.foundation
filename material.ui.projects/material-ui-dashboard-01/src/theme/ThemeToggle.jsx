import React, { useContext, useMemo, useState } from 'react'
import { IconButton } from '@mui/material'
import DarkModeRoundedIcon from "@mui/icons-material/DarkModeRounded";
import LightModeRoundedIcon from "@mui/icons-material/LightModeRounded";
import { ColorModeContext } from './ColorModeContext';


const ThemeToggle = () => {
  const {mode, toggleColorMode } = useContext(ColorModeContext);




  return (
    <>
      <IconButton onClick={toggleColorMode}>
        {mode === "light" ? <DarkModeRoundedIcon /> : <LightModeRoundedIcon />}
      </IconButton>
    </>
  );
}

export default ThemeToggle
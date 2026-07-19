import { createTheme } from "@mui/material";
import palette from "./palette";
import typography from "./typography";
import components from "./components";
import darkPalette from "./darkPalette";



export const getTheme = (mode) =>
  createTheme({
    palette : mode === "dark" ? darkPalette : palette,
    typography,
    components,
    shape: {
      borderRadius: 0,
    },
  });
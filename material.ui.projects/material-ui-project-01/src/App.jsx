import React, { useState } from "react";
import Buttons from "./components/mui/Buttons";
import { ThemeProvider, createTheme } from "@mui/material/styles";
import CssBaseline from "@mui/material/CssBaseline";
import MyApp from "./components/mui/MyApp";
import ThemeUISwitch from "./components/mui/ThemeUISwitch";
import { useMemo } from "react";
import ResponsiveAppBar from "./components/mui/ResponsiveAppBar";


const App = () => {

  const [mode, setMode] = useState("light");

   const theme = useMemo(
     () =>
       createTheme({
         palette: {
           mode: mode,
         },
       }),
     [mode]
   );
  return (
    <>
      <ResponsiveAppBar/>
      <div className="aapp">
        <ThemeProvider theme={theme}>

          <CssBaseline />
          <Buttons />
          <MyApp />

          <ThemeUISwitch mode={mode} setMode={setMode} />
        </ThemeProvider>
      </div>
    </>
  );
};

export default App;

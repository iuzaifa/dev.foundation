import { RouterProvider } from "react-router-dom";
import { router } from "./routes";
import { CssBaseline, ThemeProvider } from "@mui/material";
import { useState, useMemo } from "react";
import { getTheme } from "../theme";
import { ColorModeContext } from "../theme/ColorModeContext";



function App() {

  const getInitialMode = () => localStorage.getItem("themeMode" || "light");
  const [mode, setMode] = useState(getInitialMode);

  const colorMode = useMemo(
    () => ({
      mode,
      toggleColorMode: () => setMode((prev) =>  {
        const next = prev === "light" ? "dark" : "light";
        localStorage.setItem("themeMode", next);
        return next;
      }),
    }),
    [mode],
  );

  const theme = useMemo(() => getTheme(mode), [mode]);



  return (
    <>
      <ColorModeContext.Provider value={colorMode}>
        <ThemeProvider theme={theme}>
          <CssBaseline />
          <RouterProvider router={router} />
        </ThemeProvider>
      </ColorModeContext.Provider>
    </>
  );
}

export default App;

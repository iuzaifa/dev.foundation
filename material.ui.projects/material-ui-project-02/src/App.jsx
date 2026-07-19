import { ThemeProvider } from "@emotion/react";
import Header from "./components/Header";
import CssBaseline from "@mui/material/CssBaseline";
import mytheme from "./components/ui/MyTheme";
import Home from "./pages/Home";




function App() {
  return (
    <>
      <ThemeProvider theme={mytheme}>
        <CssBaseline />
        <Header />
        <Home/>
      </ThemeProvider>
    </>
  );
}

export default App;

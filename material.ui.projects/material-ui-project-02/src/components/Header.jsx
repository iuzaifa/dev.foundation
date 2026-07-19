import { Box, Button, Container, IconButton, Link, Menu, MenuItem, Stack, Toolbar, Typography } from "@mui/material";
import AppBar from "@mui/material/AppBar";
import MenuIcon from "@mui/icons-material/Menu";


const pages = [
  { title: "Home", href: "/" },
  { title: "About", href: "/about" },
  { title: "Services", href: "/services" },
  { title: "Products", href: "/products" },
  { title: "Blog", href: "/blog" },
  { title: "Careers", href: "/careers" },
  { title: "Contact", href: "/contact" },
];



const Header = () => {
  return (
    <>
      <AppBar
        position="fixed"
        sx={{
          bgcolor: "white",
          boxShadow: "none",
          borderBottom: "1px solid #e0e0e0",
          color: "black",
        }}
      >
        <Container maxWidth="xl">
          <Toolbar disableGutters>
            <Typography
              sx={{ fontWeight: 700, textDecoration: "none", color: "black" }}
            >
              {/* Bison Global Tech {"🦬"} */}
              <img src="logo.png" alt="" height={45}/>
            </Typography>

            {/* mobile menus  */}
            <Box
              sx={{
                color: "balck",
                flexGrow: 1,
                display: { xs: "flex", md: "none" },
              }}
            >
              <IconButton>
                <MenuIcon />
              </IconButton>

              <Menu>
                {pages.map((page, idx) => (
                  <MenuItem key={idx}>
                    <Typography sx={{ color: "202020" }}>
                      {page.title}
                    </Typography>
                  </MenuItem>
                ))}
              </Menu>
            </Box>

            <Box
              sx={{
                flexGrow: 1,
                display: { xs: "none", md: "flex" },
                justifyContent: "flex-end",
              }}
            >
              <Stack direction="row" spacing={2}>
                {pages.map((page, idx) => (
                  <Link
                    underline="none"
                    href={page.href}
                    key={idx}
                    sx={{
                      color: "#202020",
                      display: "block",
                      fontWeight: 400,
                      fontSize: 14,
                    }}
                  >
                    {page.title}
                  </Link>
                ))}
              </Stack>
            </Box>
          </Toolbar>
        </Container>
      </AppBar>
    </>
  );
};

export default Header;


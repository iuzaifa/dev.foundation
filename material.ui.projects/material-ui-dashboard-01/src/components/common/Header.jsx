// import { AppBar, Grid, IconButton, Toolbar, Typography } from "@mui/material";
// import FormatAlignLeftRoundedIcon from "@mui/icons-material/FormatAlignLeftRounded";
// import ArrowForwardRoundedIcon from "@mui/icons-material/ArrowForwardRounded";
// import ThemeToggle from '../../theme/ThemeToggle';

// const Header = ({ onMenuClick, collapsed }) => {
//   return (
//     <>
//       <AppBar position="static" color="inherit" elevation={1}>
//         <Toolbar sx={{ justifyContent: "space-between" }}>
//           <Grid container justifyContent={"space-between"}>
//             <Grid sx={{display: "flex" , alignContent : "center", gap  : 2}}>
//               <IconButton edge="start" onClick={onMenuClick}>
//                 {!collapsed ? (
//                   <FormatAlignLeftRoundedIcon />
//                 ) : (
//                   <ArrowForwardRoundedIcon />
//                 )}
//               </IconButton>

//               <Typography variant="h6" sx={{ ml: 2 }}>
//                 CRM Dashboard
//               </Typography>
//             </Grid>

//             <ThemeToggle />
//           </Grid>
//         </Toolbar>
//       </AppBar>
//     </>
//   );
// };

// export default Header

import {
  AppBar,
  Box,
  IconButton,
  Toolbar,
  Typography,
  Badge,
} from "@mui/material";
import FormatAlignLeftRoundedIcon from "@mui/icons-material/FormatAlignLeftRounded";
import ArrowForwardRoundedIcon from "@mui/icons-material/ArrowForwardRounded";
import ThemeToggle from "../../theme/ThemeToggle";
import UserProfile from "../user/UserProfile";
import CircleNotificationsRoundedIcon from "@mui/icons-material/CircleNotificationsRounded";

const Header = ({ onMenuClick, collapsed }) => {
  
  return (
    <AppBar
      position="fixed"
      color="inherit"
      sx={{
        bgcolor: "background.default",
        borderBottom: 1,
        borderColor: "divider",
        zIndex: (theme) => theme.zIndex.drawer + 1, // Ensures header stays above sidebar
        width: { md: `calc(100% - ${collapsed ? 72 : 240}px)` }, // Adjusts width based on sidebar state
        ml: { md: collapsed ? "72px" : "240px" }, // Margin left to account for sidebar
        transition: (theme) =>
          theme.transitions.create(["width", "margin"], {
            easing: theme.transitions.easing.sharp,
            duration: theme.transitions.duration.leavingScreen,
          }),
      }}
      elevation={0}
    >
      <Toolbar sx={{ justifyContent: "space-between" }}>
        {/* Left section */}
        <Box sx={{ display: "flex", alignItems: "center", gap: 2 }}>
          <IconButton
            edge="start"
            onClick={onMenuClick}
            sx={{ color: "color.icon" }}
          >
            {collapsed ? (
              <ArrowForwardRoundedIcon />
            ) : (
              <FormatAlignLeftRoundedIcon />
            )}
          </IconButton>

          <Typography variant="h6">CRM Dashboard</Typography>
        </Box>

        {/* Right section */}
        <Box sx={{ display: "flex", alignItems: "center", gap: 2 }}>
          <ThemeToggle />
          <Badge badgeContent={4} background="text.sucess">
            <CircleNotificationsRoundedIcon color="action" />
          </Badge>
          <UserProfile />
        </Box>
      </Toolbar>
    </AppBar>
  );
};

export default Header;

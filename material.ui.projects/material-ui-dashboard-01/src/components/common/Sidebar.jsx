import React, { useState } from "react";
import {
  Drawer,
  List,
  ListItem,
  ListItemButton,
  ListItemIcon,
  ListItemText,
  Collapse,
  Box,
  Typography,
} from "@mui/material";
import { useLocation, NavLink } from "react-router-dom";
import ExpandMoreRoundedIcon from "@mui/icons-material/ExpandMoreRounded";
import ChevronRightRoundedIcon from "@mui/icons-material/ChevronRightRounded";
import { sidebarData } from "../../utils/data";


const Sidebar = ({ width, collapsed, mobileOpen, onClose, isMobile }) => {
  const [openMenuId, setOpenMenuId] = useState(false);
  const [isActive , setIsActive] = useState(false);

  const handleToggle = (id) => {
    setOpenMenuId((prev) => (prev === id ? null : id));
  };


  const content = (
    <List >
      {sidebarData.map((data) => {
        const Icon = data.icon;
        const hasChildren = Boolean(data.children);
        const isOpen = openMenuId === data.id;

        return (
          <React.Fragment key={data.id}>
            <ListItem disablePadding sx={{ width }}>
              <ListItemButton
                component={!hasChildren ? NavLink : "button"}
                to={!hasChildren ? data.href : undefined}
                onClick={hasChildren ? () => handleToggle(data.id) : undefined}
              >
                <ListItemIcon>
                  <Icon />
                </ListItemIcon>
                {!collapsed && <ListItemText primary={data.title} />}
                {hasChildren &&
                  (isOpen ? (
                    <ExpandMoreRoundedIcon />
                  ) : (
                    <ChevronRightRoundedIcon />
                  ))}
              </ListItemButton>
            </ListItem>

            {hasChildren && (
              <Collapse in={isOpen} timeout="auto" unmountOnExit>
                <List component="div" disablePadding>
                  {data.children.map((child) => (
                    <ListItem key={child.href}>
                      <ListItemButton
                        component={NavLink}
                        to={child.href}
                        sx={{
                          "&.active": {
                            bgcolor: "#EEF2FF",
                            color: "#3F51B5",
                            borderLeft: "3px solid #3F51B5",
                          },
                        }}
                      >
                        <ListItemText primary={child.title} />
                      </ListItemButton>
                    </ListItem>
                  ))}
                </List>
              </Collapse>
            )}
          </React.Fragment>
        );
      })}
    </List>
  );
  return (
    <>
      {/* Desktop Menu */}
      {!isMobile && (
        <Drawer
          variant="permanent"
          sx={{
            "& .MuiDrawer-paper": {
              width,
              transition: (theme) =>
                theme.transitions.create("width", {
                  easing: theme.transitions.easing.sharp,
                  duration: theme.transitions.duration.enteringScreen,
                }),
              overflowX: "hidden",
              borderRight: 1,
              borderColor: "divider",
              boxSizing: "border-box",
              position: "fixed",
              height: "100vh",
            },
          }}
        >
          <Box
            borderBottom={"1px solid gray"}
            sx={{
              display: "center",
              alignItems: "center",
              padding: "10px 20px",
              zIndex : "1000",
              bgcolor : "background.default",
              width : "full"
            }}
          >
            <Box
              component={"img"}
              src="logo.png"
              alt="adminlogo"
              height={30}
              width={20}
              
            ></Box>

            {!collapsed && (
              <Typography variant="h6" sx={{ fontFamily: "cursive" }}>
                Dashboard
              </Typography>
            )}
          </Box>

          <Box sx={{marginTop : "40px", position  : "fixed", overflow : "scroll",}}>{content}</Box>
        </Drawer>
      )}

      {/* Mobile Menu */}
      {isMobile && (
        <Drawer
          variant="temporary"
          open={mobileOpen}
          onClose={onClose}
          ModalProps={{ keepMounted: true }}
          sx={{
            "& .MuiDrawer-paper": { width: 240 },
          }}
        >
          {content}
        </Drawer>
      )}
    </>
  );
};

export default Sidebar;

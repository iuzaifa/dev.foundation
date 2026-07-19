import {
  List,
  ListItem,
  ListItemButton,
  ListItemIcon,
  ListItemText,
  Collapse,
  Drawer,
} from "@mui/material";
import ExpandMoreRoundedIcon from "@mui/icons-material/ExpandMoreRounded";
import HomeRoundedIcon from "@mui/icons-material/HomeRounded";
import { useState } from "react";

const Sidebar = () => {

    const [isOpenSubmenu, setIsOpenSubmenu] = useState(false);
  return (
    <>
      <div className="sidebar">
        <Drawer variant={"permanent"} sx={{ borderColor: "divider", height : "100vh" }}>
          <List>
            <ListItem disablePadding>
              <ListItemButton onClick={() => setIsOpenSubmenu((prev) => !prev)}>
                <ListItemIcon sx={{ width: "25px" }}>
                  <HomeRoundedIcon />
                </ListItemIcon>
                <ListItemText primary={"Home"} />
                <ExpandMoreRoundedIcon />
              </ListItemButton>
            </ListItem>
          </List>

          <Collapse in={isOpenSubmenu} timeout="auto" unmountOnExit>
            <List>
              <ListItem>
                <ListItemButton>
                  <ListItemText primary={"Home Sub1"} />
                </ListItemButton>
              </ListItem>
              <ListItem>
                <ListItemButton>
                  <ListItemText primary={"Home Sub2"} />
                </ListItemButton>
              </ListItem>
            </List>
          </Collapse>
        </Drawer>
      </div>
    </>
  );
};

export default Sidebar;

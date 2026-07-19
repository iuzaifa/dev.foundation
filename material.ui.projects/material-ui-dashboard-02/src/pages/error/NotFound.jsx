import React from "react";
import { Box, Typography, Button } from "@mui/material";
import ErrorOutlineIcon from "@mui/icons-material/ErrorOutline";
import { useNavigate } from "react-router-dom";

const NotFound = () => {
  const navigate = useNavigate();

  return (
    <Box
      sx={{
        minHeight: "100vh",
        display: "flex",
        alignItems: "center",
        justifyContent: "center",
        textAlign: "center",
        px: 2,
      }}
    >
      <Box>
        {/* Icon */}
        <ErrorOutlineIcon
          sx={{
            fontSize: 90,
            color: "error.main", // red icon
            mb: 1,
          }}
        />

        {/* 404 Text */}
        <Typography variant="h2" fontWeight={700}>
          404
        </Typography>

        {/* Message */}
        <Typography
          variant="body1"
          sx={{ color: "text.secondary", mt: 1, mb: 3 }}
        >
          Oops! The page you’re looking for doesn’t exist.
        </Typography>

        {/* Action */}
        <Button variant="contained" color="error" onClick={() => navigate("/")}>
          Go Back Home
        </Button>
      </Box>
    </Box>
  );
};

export default NotFound;

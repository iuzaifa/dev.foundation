import React from "react";
import { Box, Typography, Button, Stack } from "@mui/material";
import ErrorOutlineRoundedIcon from "@mui/icons-material/ErrorOutlineRounded";
import { useNavigate } from "react-router-dom";

const NotFound = () => {
  const navigate = useNavigate();

  return (
    <Box
      minHeight="100vh"
      display="flex"
      alignItems="center"
      justifyContent="center"
      bgcolor="#F7F8FA"
    >
      <Stack spacing={2} alignItems="center">
        <ErrorOutlineRoundedIcon
          sx={{ fontSize: 80, color: "text.secondary" }}
        />

        <Typography variant="h3" fontWeight={600}>
          404
        </Typography>

        <Typography variant="h6" color="text.secondary">
          Page not found
        </Typography>

        <Typography
          variant="body2"
          color="text.secondary"
          textAlign="center"
          maxWidth={320}
        >
          The page you’re looking for doesn’t exist or has been moved.
        </Typography>

        <Stack direction="row" spacing={2} mt={2}>
          <Button variant="contained" onClick={() => navigate("/dashboard")}>
            Go to Dashboard
          </Button>

          <Button variant="outlined" onClick={() => navigate(-1)}>
            Go Back
          </Button>
        </Stack>
      </Stack>
    </Box>
  );
};

export default NotFound;

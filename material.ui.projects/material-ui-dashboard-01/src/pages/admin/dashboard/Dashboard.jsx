import React from 'react'
import { Card, CardContent, Typography, Box } from "@mui/material";

const Dashboard = () => {
  return (
    <>
        <Card sx={{ bgcolor: "background.paper", maxWidth: 300 }}>
          <CardContent>
            <Typography variant="h6" color="text.primary">
              Theme Card
            </Typography>

            <Typography variant="body2" color="text.secondary" sx={{ mb: 2 }}>
              Light / Dark preview
            </Typography>

            <Box sx={{ display: "flex", flexDirection: "column", gap: 1 }}>
              <Box sx={{ bgcolor: "primary.main", p: 1, borderRadius: 1 }}>
                <Typography color="#fff">Primary</Typography>
              </Box>

              <Box sx={{ bgcolor: "secondary.main", p: 1, borderRadius: 1 }}>
                <Typography color="text.primary">Secondary</Typography>
              </Box>

              <Box
                sx={{ bgcolor: "background.default", p: 1, borderRadius: 1 }}
              >
                <Typography color="text.primary">Background</Typography>
              </Box>

              <Box sx={{ bgcolor: "action.hover", p: 1, borderRadius: 1 }}>
                <Typography color="text.primary">Hover</Typography>
              </Box>
            </Box>
          </CardContent>
        </Card>
        <Card sx={{ bgcolor: "background.paper", maxWidth: 300 }}>
          <CardContent>
            <Typography variant="h6" color="text.primary">
              Theme Card
            </Typography>

            <Typography variant="body2" color="text.secondary" sx={{ mb: 2 }}>
              Light / Dark preview
            </Typography>

            <Box sx={{ display: "flex", flexDirection: "column", gap: 1 }}>
              <Box sx={{ bgcolor: "primary.main", p: 1, borderRadius: 1 }}>
                <Typography color="#fff">Primary</Typography>
              </Box>

              <Box sx={{ bgcolor: "secondary.main", p: 1, borderRadius: 1 }}>
                <Typography color="text.primary">Secondary</Typography>
              </Box>

              <Box
                sx={{ bgcolor: "background.default", p: 1, borderRadius: 1 }}
              >
                <Typography color="text.primary">Background</Typography>
              </Box>

              <Box sx={{ bgcolor: "action.hover", p: 1, borderRadius: 1 }}>
                <Typography color="text.primary">Hover</Typography>
              </Box>
            </Box>
          </CardContent>
        </Card>
        <Card sx={{ bgcolor: "background.paper", maxWidth: 300 }}>
          <CardContent>
            <Typography variant="h6" color="text.primary">
              Theme Card
            </Typography>

            <Typography variant="body2" color="text.secondary" sx={{ mb: 2 }}>
              Light / Dark preview
            </Typography>

            <Box sx={{ display: "flex", flexDirection: "column", gap: 1 }}>
              <Box sx={{ bgcolor: "primary.main", p: 1, borderRadius: 1 }}>
                <Typography color="#fff">Primary</Typography>
              </Box>

              <Box sx={{ bgcolor: "secondary.main", p: 1, borderRadius: 1 }}>
                <Typography color="text.primary">Secondary</Typography>
              </Box>

              <Box
                sx={{ bgcolor: "background.default", p: 1, borderRadius: 1 }}
              >
                <Typography color="text.primary">Background</Typography>
              </Box>

              <Box sx={{ bgcolor: "action.hover", p: 1, borderRadius: 1 }}>
                <Typography color="text.primary">Hover</Typography>
              </Box>
            </Box>
          </CardContent>
        </Card>
    </>
  );
}

export default Dashboard
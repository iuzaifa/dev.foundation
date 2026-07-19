import { Box, Typography, Button } from "@mui/material";
import InfoOutlinedIcon from "@mui/icons-material/InfoOutlined";

const EmptyState = ({
  title = "No Content Found",
  description = "There is nothing to display here yet.",
  actionText,
  onAction,
}) => {
  return (
    <Box
      sx={{
        height: "100%",
        minHeight: "70vh",
        display: "flex",
        flexDirection: "column",
        alignItems: "center",
        justifyContent: "center",
        textAlign: "center",
        gap: 1.5,
        color: "#6B7280",
      }}
    >
      <InfoOutlinedIcon sx={{ fontSize: 48, color: "#9CA3AF" }} />

      <Typography sx={{ fontSize: 18, fontWeight: 600 }}>{title}</Typography>

      <Typography sx={{ fontSize: 14, maxWidth: 320 }}>
        {description}
      </Typography>

      {actionText && (
        <Button
          size="small"
          variant="outlined"
          onClick={onAction}
          sx={{ mt: 1 }}
        >
          {actionText}
        </Button>
      )}
    </Box>
  );
};

export default EmptyState;

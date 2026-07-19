import React, { useEffect } from "react";
import { Grid, Box, Typography, IconButton, Button, Zoom } from "@mui/material";
import LinkedInIcon from "@mui/icons-material/LinkedIn";
import SkipPreviousIcon from "@mui/icons-material/SkipPrevious";
import SkipNextIcon from "@mui/icons-material/SkipNext";
import useEmblaCarousel from "embla-carousel-react";
import SectionHeading from "./SectionHeading";

const data = [
  {
    id: 1,
    name: "John Doe",
    image:
      "https://images.unsplash.com/photo-1506794778202-cad84cf45f1d?auto=format&fit=crop&w=600&h=400",
    comment:
      "A dependable team member who always delivers clean and efficient solutions.",
  },
  {
    id: 2,
    name: "Sophia Martinez",
    image:
      "https://images.unsplash.com/photo-1494790108377-be9c29b29330?auto=format&fit=crop&w=600&h=400",
    comment:
      "Brings clarity, structure, and strong leadership to every project.",
  },
  {
    id: 3,
    name: "Daniel Wong",
    image:
      "https://images.unsplash.com/photo-1527980965255-d3b416303d12?auto=format&fit=crop&w=600&h=400",
    comment:
      "Detail-oriented and focused on quality, security, and long-term impact.",
  },
  {
    id: 4,
    name: "Emily Johnson",
    image:
      "https://images.unsplash.com/photo-1529626455594-4ff0802cfb7e?auto=format&fit=crop&w=600&h=400",
    comment:
      "Creates thoughtful user experiences with a strong design mindset.",
  },
  {
    id: 5,
    name: "Rahul Verma",
    image:
      "https://images.unsplash.com/photo-1544005313-94ddf0286df2?auto=format&fit=crop&w=600&h=400",
    comment:
      "Solves complex problems with scalable and performance-driven approaches.",
  },
  {
    id: 6,
    name: "Aisha Khan",
    image:
      "https://images.unsplash.com/photo-1502685104226-ee32379fefbe?auto=format&fit=crop&w=600&h=400",
    comment:
      "Highly collaborative and always ready to support the team’s goals.",
  },
  {
    id: 7,
    name: "Michael Brown",
    image:
      "https://images.unsplash.com/photo-1500648767791-00dcc994a43e?auto=format&fit=crop&w=600&h=400",
    comment:
      "Consistent, reliable, and focused on delivering value to clients.",
  },
  {
    id: 8,
    name: "Olivia Parker",
    image:
      "https://images.unsplash.com/photo-1534528741775-53994a69daeb?auto=format&fit=crop&w=600&h=400",
    comment:
      "Creative thinker who brings fresh ideas and positive energy to the team.",
  },
];

const Team = () => {
  const [emblaRef, emblaApi] = useEmblaCarousel({
    loop: true,
    align: "start",
  });

  useEffect(() => {
    if (emblaApi) {
      console.log("Embla Ready");
    }
  }, [emblaApi]);

  return (
    <>
      {/* Heading */}
      <Grid container justifyContent="center" sx={{ py: 4 }}>
        <SectionHeading heading="Ankar's Patent Expert Panel" />
      </Grid>

      {/* Slider */}
      <Box sx={{ px: { xs: 2, md: 10 } }}>
        <div className="embla" ref={emblaRef}>
          <div className="embla__container" style={{ display: "flex" }}>
            {data.map((team) => (
              <div
                key={team.id}
                className="embla__slide"
                style={{
                  flex: "0 0 33.33%", // 3 cards per view
                  paddingRight: "24px",
                }}
              >
                <Box>
                  <Box
                    component="img"
                    src={team.image}
                    alt={team.name}
                    sx={{
                      width: "100%",
                      height: 280,
                      objectFit: "cover",
                      borderRadius: "4px",
                      transition: "transform 0.4s ease",
                      transform: "scale(1)",
                      overflow : "hidden",
                      "&:hover": {
                        transform: "scale(1.06)", // 👈 little zoom
                      },
                    }}
                  />

                  <Box
                    sx={{
                      display: "flex",
                      justifyContent: "space-between",
                      alignItems: "center",
                      mt: 1,
                    }}
                  >
                    <Box>
                      <Typography fontSize={18} fontWeight={500}>
                        {team.name}
                      </Typography>
                      <Typography
                        fontSize={13}
                        color="#4d4c4c"
                        lineHeight={1.3}
                      >
                        {team.comment}
                      </Typography>
                    </Box>

                    <IconButton
                      sx={{
                        border: "1px solid #eee",
                        borderRadius: 0,
                        color: "#101010",
                      }}
                    >
                      <LinkedInIcon />
                    </IconButton>
                  </Box>
                </Box>
              </div>
            ))}
          </div>
        </div>

        {/* Navigation Buttons */}
        <Box display="flex" justifyContent="center" gap={2} mt={4}>
          <Button
            variant="outlined"
            sx={{
              borderRadius: 0,
              minWidth: 40,
              border: "1px solid #101010",
              color: "#101010",
            }}
            onClick={() => emblaApi && emblaApi.scrollPrev()}
            disabled={!emblaApi}
          >
            <SkipPreviousIcon />
          </Button>

          <Button
            variant="outlined"
            sx={{
              borderRadius: 0,
              minWidth: 40,
              border: "1px solid #101010",
              color: "#101010",
            }}
            onClick={() => emblaApi && emblaApi.scrollNext()}
            disabled={!emblaApi}
          >
            <SkipNextIcon />
          </Button>
        </Box>
      </Box>
    </>
  );
};

export default Team;

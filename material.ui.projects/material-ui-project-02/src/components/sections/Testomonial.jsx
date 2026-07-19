import React, { useEffect } from "react";
import { Grid, Box, Container, Typography, Button } from "@mui/material";
import useEmblaCarousel from "embla-carousel-react";
import SectionDesctiption from "./SectionDesctiption";
import SkipPreviousIcon from "@mui/icons-material/SkipPrevious";
import SkipNextIcon from "@mui/icons-material/SkipNext";
const data = [
  {
    id: 1,
    name: "Alexander R.L",
    designation: "Designer & Developer",
    review:
      "Whilst Vorys views AI as a powerful accelerator of quality, its adoption is always guided by client discretion, ethical responsibility, and strict adherence to professional workflow standards.",
    profile: "https://randomuser.me/api/portraits/men/32.jpg",
    backgroundImg: "https://picsum.photos/seed/bg1/800/300",
  },
  {
    id: 2,
    name: "Sophia Martinez",
    designation: "Product Manager",
    review:
      "The team consistently balances innovation with responsibility, ensuring AI-assisted processes align with client expectations, compliance requirements, and long-term business objectives.",
    profile: "https://randomuser.me/api/portraits/women/45.jpg",
    backgroundImg: "https://picsum.photos/seed/bg2/800/300",
  },
  {
    id: 3,
    name: "Daniel Wong",
    designation: "Legal Consultant",
    review:
      "What truly stands out is their commitment to quality and confidentiality, regardless of whether AI tools or traditional methods are applied within the project lifecycle.",
    profile: "https://randomuser.me/api/portraits/men/18.jpg",
    backgroundImg: "https://picsum.photos/seed/bg3/800/300",
  },
  {
    id: 4,
    name: "Emily Johnson",
    designation: "UX Strategist",
    review:
      "Their approach to artificial intelligence is thoughtful and client-centric, ensuring every engagement respects context, usability requirements, and established industry standards.",
    profile: "https://randomuser.me/api/portraits/women/67.jpg",
    backgroundImg: "https://picsum.photos/seed/bg4/800/300",
  },
  {
    id: 5,
    name: "Rahul Verma",
    designation: "Technology Lead",
    review:
      "AI is used strictly as an enabler rather than a replacement, providing flexibility to adapt workflows while maintaining trust, performance, and delivery consistency.",
    profile: "https://randomuser.me/api/portraits/men/52.jpg",
    backgroundImg: "https://picsum.photos/seed/bg5/800/300",
  },
];

const Testomonial = () => {
  const [emblaRef, emblaApi] = useEmblaCarousel({
    loop: true,
    align: "start",
    slidesToScroll: 1,
    skipSnaps: false,
  });

  useEffect(() => {
    if (emblaApi) {
      console.log("Embla ready");
    }
  }, [emblaApi]);

  return (
    <>
      <div className="embla" ref={emblaRef}>
        <div className="embla__container">
          {data.map((dt) => (
            <div className="embla__slide" key={dt.id}>
              <Container maxWidth="md">
                <Grid sx={{ py: "10px" }}>
                  {/* Background Image */}
                  <Box sx={{ width: "100%", overflow: "hidden" }}>
                    <Box
                      component="img"
                      src={dt.backgroundImg}
                      alt="bg"
                      sx={{
                        width: "100%",
                        height: "auto",
                        objectFit: "cover",
                      }}
                    />
                  </Box>

                  {/* Review */}
                  <Box mt={2}>
                    <SectionDesctiption description={dt.review} />
                  </Box>

                  {/* Footer */}
                  <Box
                    mt={4}
                    display="flex"
                    alignItems="center"
                    justifyContent="space-between"
                  >
                    <Box display="flex" alignItems="center" gap={1.5}>
                      <Box
                        component="img"
                        src={dt.profile}
                        alt="profile"
                        height={40}
                        width={40}
                        sx={{ borderRadius: "50%" }}
                      />
                      <Box>
                        <Typography fontSize={12} fontWeight={600}>
                          {dt.name}
                        </Typography>
                        <Typography fontSize={10}>{dt.designation}</Typography>
                      </Box>
                    </Box>

                    <Button
                      variant="contained"
                      sx={{
                        background: "#101010",
                        borderRadius: 0,
                        fontSize: 12,
                        fontWeight: 400,
                      }}
                    >
                      Learn More
                    </Button>
                  </Box>
                </Grid>
              </Container>
            </div>
          ))}
        </div>
      </div>
      {/* Optional Controls */}
      <Box display="flex" justifyContent="center" gap={2}>
        <Button
          variant="outlined"
          sx={{
            borderRadius: 0,
            minWidth: 40,
            border: "1px solid #101010",
            color: "#101010",
          }}
          onClick={() => emblaApi?.scrollPrev()}
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
          onClick={() => emblaApi?.scrollNext()}
        >
          <SkipNextIcon />
        </Button>
      </Box>
    </>
  );
};

export default Testomonial;

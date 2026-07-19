import { Grid, Typography,Link, Box, IconButton } from "@mui/material";
import React from "react";
import SectionHeading from "./SectionHeading";
import Accordion from "@mui/material/Accordion";
import AccordionSummary from "@mui/material/AccordionSummary";
import AccordionDetails from "@mui/material/AccordionDetails";
import ExpandMoreIcon from "@mui/icons-material/ExpandMore";
import MailOutlineTwoToneIcon from "@mui/icons-material/MailOutlineTwoTone";
import { Link as RouterLink } from "react-router-dom";




const faqs = [
  {
    id: 1,
    question: "What services does your team specialize in?",
    answer:
      "Our team specializes in patent research, intellectual property strategy, technical analysis, and innovation-driven legal support tailored to client needs.",
  },
  {
    id: 2,
    question: "How does your team ensure confidentiality?",
    answer:
      "We follow strict confidentiality protocols, secure workflows, and compliance standards to ensure all client information remains protected at every stage.",
  },
  {
    id: 3,
    question: "Do you use AI in your workflows?",
    answer:
      "Yes, we use AI as an assistive tool to improve efficiency and accuracy, always governed by client preferences and ethical guidelines.",
  },
  {
    id: 4,
    question: "Can your services be customized for different industries?",
    answer:
      "Absolutely. Our approach is flexible and tailored to suit industry-specific requirements, workflows, and regulatory standards.",
  },
  {
    id: 5,
    question: "How can clients get started with your team?",
    answer:
      "Clients can get started by contacting us through our website, scheduling a consultation, and discussing their objectives with our expert panel.",
  },
];

const MYAccordion = () => {
  return (
    <>
      <Grid container spacing={2}>
        <Grid sx={{ px: { xs: 2, md: 10 } }} size={{ xs: 12, md: 6 }}>
          <Typography
            sx={{
              fontFamily: "Space Mono,monospace",
              textTransform: "capitalize",
              marginBottom: "60px",
              color: "#909090",
            }}
          >
            frequently asked questions
          </Typography>
          <SectionHeading
            heading={`We’ve Got the Answers You’re Looking For`}
          />
        </Grid>
        <Grid sx={{ px: { xs: 2, md: 10 } }} size={{ xs: 12, md: 6 }}>
          <div>
            {faqs.map((data, index) => (
              <Accordion
                key={data.id}
                defaultExpanded={index === 0} // only first open
                sx={{
                  boxShadow: "none",
                  border: "1px solid #f4f2f2b9",
                  mb: 1,
                  "&:before": { display: "none" }, // remove default line
                }}
              >
                <AccordionSummary expandIcon={<ExpandMoreIcon />}>
                  <Typography
                    sx={{ fontWeight: 400, fontSize: "15px", color: "#202020" }}
                  >
                    {data.question}
                  </Typography>
                </AccordionSummary>

                <AccordionDetails>
                  <Typography
                    sx={{
                      color: "#797979",
                      fontSize: 12,
                      fontWeight: 400,
                      letterSpacing: 0.5,
                    }}
                  >
                    {data.answer}
                  </Typography>
                </AccordionDetails>
              </Accordion>
            ))}
          </div>

          <Box sx={{marginTop : "15px", gap : 1}} display={"flex"} alignItems={"center"}>
            <IconButton sx={{color : "#101010"}}>
              <MailOutlineTwoToneIcon/>
            </IconButton>
            <Typography sx={{fontSize : 12, color: "#909090", letterSpacing : .4}}>Have any more questions?</Typography>
            <Link  component={RouterLink} target="_blank"  to="https://github.com/iuzaifa" sx={{ fontSize: 14, color: "#909090", letterSpacing: 0.4, textDecoration: "none", "&:hover": { color: "#101010", },}}>Contact us</Link>
          </Box>
        </Grid>
      </Grid>
    </>
  );
};

export default MYAccordion;

import { Button, Container, Grid, Box, Typography } from "@mui/material";
import SectionHeading from "./SectionHeading";
import SectionTitle from "./SectionTitle";
import SectionDesctiption from "./SectionDesctiption";
import SecurityIcon from "@mui/icons-material/Security";
import LockIcon from "@mui/icons-material/Lock";
import StorageIcon from "@mui/icons-material/Storage";
import VerifiedIcon from "@mui/icons-material/Verified";



const items = [
  {
    title: "SOC 2",
    icon: <VerifiedIcon sx={{ fontSize: 40 }} />,
  },
  {
    title: "ISO27001",
    icon: <SecurityIcon sx={{ fontSize: 40 }} />,
  },
  {
    title: "No training on your data",
    icon: <StorageIcon sx={{ fontSize: 40 }} />,
  },
  {
    title: "End to end data encryption",
    icon: <LockIcon sx={{ fontSize: 40 }} />,
  },
];

const Security = () => {
  return (
    <>
      <Container maxWidth={`xl`}>
        <Grid container padding={10} spacing={10} sx={{alignItems : "center"}}>
          <Grid size={{ xs: 12, md: 6 }}>
            <SectionTitle title={"Security"} />
            <SectionHeading
              heading={
                "Every layer of Ankar is engineered to meet the highest standards of data protection and security"
              }
            />
            <SectionDesctiption
              description={`Our platform achieved full certification before our first customer. We believe that in IP, trust isn’t optional. It’s foundational.`}
            />
            <Button
              variant="contained"
              sx={{
                background: "#fff",
                color: "#101010",
                borderRadius: 0,
                fontSize: 12,
                fontWeight: 400,
                marginTop: "30px",
              }}
            >
              Read our principles
            </Button>
          </Grid>


          <Grid container size={{ xs: 12, md: 6 }} spacing={1}>
              {items.map((i, idx) => (
                 <Grid key={idx} size={{ xs: 12, md: 6, }} sx={{ display : "flex", justifyContent : "center",background : "#202020" , width : "200px", height : "200px", }}>
                  <Box sx={{ textAlign : "center", width : "200px", height : "200px", alignItems : "center", display : "flex", justifyContent : "center"}}>
                      <div>
                        {i.icon}
                        <Typography sx={{marginTop : "10px", fontWeight : 300, fontSize : "12px"}} >{i.title}</Typography>
                      </div>
                  </Box>
                </Grid>
              ))}
          </Grid>

         
        </Grid>
      </Container>
    </>
  );
};

export default Security;

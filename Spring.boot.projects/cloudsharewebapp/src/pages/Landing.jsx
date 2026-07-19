import React, { useEffect } from "react";
import HeroSection from "../components/landing/HeroSection";
import FeaturesSection from "../components/landing/FeaturesSection";
import PricingSection from "../components/landing/PricingSection";
import TestimonialSection from "../components/landing/TestimonialSection";
import CTASection from "../components/landing/CTASection";
import Footer from "../components/landing/Footer";
import { features, pricePlans, testimonial } from "../assets/data";
import { useClerk, useUser } from "@clerk/clerk-react";
import { useNavigate } from "react-router-dom";

const Landing = () => {
  const { openSignIn, openSignUp } = useClerk();
  const { isSignedIn } = useUser();
   const navigate = useNavigate();

   useEffect(() => {
     if (isSignedIn) {
       navigate("/dashboard");
     }
   }, [isSignedIn, navigate]);

  return (
    <>
      <div className="landing-page bg-gradient-to-b from-gray-50 to-gray-100">
        {/* HeroSection */}
        <HeroSection openSignIn={openSignIn} openSignUp={openSignUp} />

        {/* Features Section */}
        <FeaturesSection features={features} />

        {/* Pricing Section */}
        <PricingSection pricePlans={pricePlans} openSignUp={openSignUp} />

        {/* Testimonial Section */}
        <TestimonialSection testimonial={testimonial} />

        {/* CTASection */}
        <CTASection openSignUp={openSignUp} />

        {/* Footer */}
        <Footer />
      </div>
    </>
  );
};

export default Landing;

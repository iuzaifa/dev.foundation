import React from "react";
import { ArrowRight } from "lucide-react";

const CTASection = ({ openSignUp }) => {
  return (
    <div className="w-full py-20 px-6 bg-gradient-to-r from-purple-500 to-indigo-600">
      <div className="max-w-6xl mx-auto flex flex-col md:flex-row items-center justify-between gap-6">
        {/* Left Text */}
        <div>
          <h2 className="text-3xl md:text-4xl font-bold text-white">
            Ready to get started?
          </h2>
          <p className="text-white/90 mt-2 text-sm md:text-base">
            Sign up for free today and experience fast, secure file sharing.
          </p>
        </div>

        {/* Right Button */}
        <button onClick={()=> openSignUp()} className="flex cursor-pointer items-center gap-2 bg-white text-purple-600 font-semibold px-6 py-3 rounded-sm shadow-lg hover:bg-gray-100 transition">
          Sign Up For Free
          <ArrowRight className="w-5 h-5" />
        </button>
      </div>
    </div>
  );
};

export default CTASection;

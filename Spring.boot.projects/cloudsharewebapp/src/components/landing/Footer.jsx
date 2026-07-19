import React from "react";

const Footer = () => {
  return (
    <footer className="w-full py-6 bg-gray-900">
      <div className="max-w-6xl mx-auto text-center">
        <p className="text-gray-400 text-sm">
          © {new Date().getFullYear()}{" "}
          <span className="font-semibold text-white">Cloud Share</span>. All
          Rights Reserved.
        </p>

        <p className="text-gray-500 text-xs mt-1">
          Developed by{" "}
          <span className="text-purple-400 font-medium">@AbuHuzaifa</span>
        </p>
      </div>
    </footer>
  );
};

export default Footer;

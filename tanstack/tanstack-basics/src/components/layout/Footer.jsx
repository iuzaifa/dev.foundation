const Footer = () => {
  return (
    <footer className="py-5 text-center text-sm text-gray-400">
      {" "}
      <p>
        © {new Date().getFullYear()}{" "}
        <a
          href="mailto:abuhuzaifaw7@gmail.com"
          className="text-blue-400 hover:text-blue-300"
        >
          abuhuzaifaw7@gmail.com{" "}
        </a>
        . All rights reserved.{" "}
      </p>{" "}
    </footer>
  );
};

export default Footer;

import Products from "../components/Products";

const Home = () => {
  return (
    <main className="mx-auto max-w-7xl px-4 pt-24 pb-8 sm:px-6 lg:px-8">
      {/* Hero Section */}
      <div className="text-center">
        <h2 className="text-3xl font-bold text-gray-900 sm:text-4xl lg:text-5xl">
          Welcome to Redux Store
        </h2>

        <p className="mt-4 text-base text-gray-600 sm:text-lg">
          Explore our latest products powered by React, Redux Toolkit, and
        </p>
      </div>

      {/* Products Section */}
      <section className="mt-12">
        <h3 className="mb-6 text-2xl font-semibold text-gray-800 sm:text-3xl">
          Products
        </h3>

        <Products />
      </section>
    </main>
  );
};

export default Home;
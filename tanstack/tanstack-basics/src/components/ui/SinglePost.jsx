const SinglePost = () => {
  return (
    <>
      <div className="max-w-3xl mx-auto">
        <div className="group relative overflow-hidden rounded-sm border bg-[#101010] p-5 shadow-sm transition-all duration-300 hover:-translate-y-1 hover:shadow-lg">
          <div className="pl-2">
            <h3 className="text-md font-semibold text-[#909090]">
              Lorem ipsum dolor sit amet.
            </h3>
            <p className="text-sm leading-relaxed text-[#909090]">
              Lorem ipsum dolor sit, amet consectetur adipisicing elit.
              Doloribus, odit.
            </p>
          </div>
        </div>
      </div>
    </>
  );
};

export default SinglePost;

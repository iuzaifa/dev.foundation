import { keepPreviousData, useQuery } from "@tanstack/react-query";
import { getAllPost } from "../api/postApi";
import LoadingSpinner from "../components/ui/LoadingSpinner";
import { NavLink } from "react-router-dom";
import { useState } from "react";

const FetchRQ = () => {
  const [pageNumber, setPageNumber] = useState(0);
  const pageSize = 8;


  const {isPending,error,data: postData,} = useQuery({
    queryKey: [`posts`, pageNumber, pageSize],
    queryFn: () => getAllPost(pageNumber, pageSize),
    placeholderData : keepPreviousData,
    // refetchInterval : 1000,
    // refetchIntervalInBackground : true
  });


  if (isPending) return <LoadingSpinner />;
  if (error) return <p>An error has occurred: + {error.message}</p>;

  return (
    <>
      <section className="grid grid-cols-1 gap-4 mx-auto sm:grid-cols-2 md:grid-cols-4 max-w-8xl px-5">
        {postData.map((data, idx) => (
          <div
            key={idx}
            className="group relative overflow-hidden rounded-sm border bg-[#101010] p-5 shadow-sm transition-all duration-300 hover:-translate-y-1 hover:shadow-lg"
          >
            <NavLink to={`/fetch-rq/${data.id}`}>
              <div className="pl-2">
                <span className="text-[#505050]">{data.id}</span>
                <h3 className="text-md font-semibold text-[#909090]">
                  {data.title}
                </h3>
                <p className="text-sm leading-relaxed text-[#909090]">
                  {data.body}
                </p>
              </div>
            </NavLink>
          </div>
        ))}

        
      </section>
      <div className="mx-auto gap-3 flex max-w-2xs mb-50 it">
        <button disabled={pageNumber === 0 ? true : false} onClick={() => setPageNumber((prev) => prev - 1)}  className={`${pageNumber === 0 ? "cursor-not-allowed bg-emerald-800" : ""} bg-emerald-600 py-2 px-6 mt-4 rounded-sm text-[#101010]`}>Prev</button>
        <button className={`py-2 px-6 mt-4 rounded-sm text-[#909090] text-nowrap`}>{pageNumber + 1}</button>
        <button onClick={() => setPageNumber((prev) => prev + 1)} className={`bg-emerald-600 py-2 px-6 mt-4 rounded-sm text-[#101010]`}>Next</button>
      </div>
    </>
  );
};

export default FetchRQ;

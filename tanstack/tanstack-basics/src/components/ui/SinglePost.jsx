import { useQuery } from "@tanstack/react-query";
import { NavLink, useParams } from "react-router-dom";
import { getPostById } from "../../api/postApi";
import LoadingSpinner from "./LoadingSpinner";

const SinglePost = () => {
  const {id} = useParams();

  const { data, isPending, error } = useQuery({
    queryKey: ["getPostbyId", id],
    queryFn: () => getPostById(id),
  });


  if (isPending) return <LoadingSpinner />;
  if (error) return <p className="text-[#505050]">An error has occurred: + {error.message}</p>;
  return (
    <>
      <div className="max-w-3xl mx-auto">
        <h3 className="text-[#505050] text-lg py-10 font-semibold">{data.id} Post Details</h3>
        <div className="group relative overflow-hidden rounded-sm border bg-[#101010] p-5 shadow-sm transition-all duration-300 hover:-translate-y-1 hover:shadow-lg">
          <div className="pl-2 mb-5">
            <h3 className="text-md font-semibold text-[#909090]">
              <strong className="text-emerald-700 mr-1.5">Title:</strong>{data.title}
            </h3>
            <p className="text-sm leading-relaxed text-[#909090]">
              <strong className="text-emerald-700  mr-1.5">Desciption: </strong>{data.body}
            </p>
          </div>

          <NavLink to={`/fetch-rq`} className={`bg-emerald-600 py-2 px-6 mt-4 rounded-sm text-[#101010]`}> 
            Go Back 
          </NavLink>
        </div>
      </div>
    </>
  );
};

export default SinglePost;

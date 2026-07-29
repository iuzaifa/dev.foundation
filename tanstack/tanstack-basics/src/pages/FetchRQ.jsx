import { useQuery } from "@tanstack/react-query";
import { getAllPost } from "../api/postApi";
import LoadingSpinner from "../components/ui/LoadingSpinner";

const FetchRQ = () => {
  const { isPending, error, data: postData,} = useQuery({
    queryKey: [`posts`],
    queryFn: getAllPost,
    // refetchInterval : 1000,
    // refetchIntervalInBackground : true
  });

  if (isPending) return <LoadingSpinner />;
  if (error) return <p>An error has occurred: + {error.message}</p>;

  return (
    <>
      <section className="grid grid-cols-1 gap-4 mx-auto sm:grid-cols-2 md:grid-cols-4 max-w-8xl px-5">
        {postData.map((data, idx) => (
          <div key={idx} className="group relative overflow-hidden rounded-sm border bg-[#101010] p-5 shadow-sm transition-all duration-300 hover:-translate-y-1 hover:shadow-lg">
            <div className="pl-2">
              <span className="text-[#505050]">{data.id}</span>
              <h3 className="text-md font-semibold text-[#909090]">
                {data.title}
              </h3>
              <p className="text-sm leading-relaxed text-[#909090]">
                {data.body}
              </p>
            </div>
          </div>
        ))}
      </section>
    </>
  );
};

export default FetchRQ;

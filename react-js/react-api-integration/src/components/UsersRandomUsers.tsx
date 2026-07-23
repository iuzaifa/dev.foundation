import { useQuery } from "@tanstack/react-query";
import { getRandomUsers } from "../features/randomUsers/randomUsers.api";
import { Table, type Column } from "./Table";
import type { User } from "../types/user.types";
import { toast, ToastContainer } from "react-toastify";
import { useEffect, useState } from "react";
import { TableSkeleton } from "./skeletons/SkeletonTable";
import { useNavigate } from "react-router-dom";

const columns: Column<User>[] = [
    {
        header : "Sr No.",
        accessor : "id"
    },
  { 
    header: "Name",
    render: (user) =>
      `${user.name.title} ${user.name.first} ${user.name.last}`,

  },
  {
    header: "Image",
    render: (user) => (
      <img src={user.picture.thumbnail} className="rounded-full border-2 border-green-200 h-10 w-10" alt={user.name.first} />
    ),
  },
  {
    header: "Email",
    accessor: "email",
  },
  {
    header: "Gender",
    accessor: "gender",
  },
  {
    header: "Phone",
    accessor: "phone",
  },
  
  
];


function UsersRandomUsers () {
    const navigate = useNavigate();
    const [page, setPage] = useState(1)
    const limit = 15;

    const {data, isLoading, isError } = useQuery({
        queryKey : ["users", page, limit],
        queryFn : () => getRandomUsers(page, limit),
    });
    useEffect(() => {
        if(isError) {
            toast.error("lFaild to fetch users....")
        }
        if(!isError){
            toast.dismiss();
        }
    })
    if(isLoading) return <TableSkeleton columns={6} rows={10} />;

   


    return (
        <>
            <Table columns={columns} data={data?.data.data ?? []} actions={(user) => (
                <>
                    <div className="flex gap-2 justify-center">
                        <button onClick={() => navigate(`/users/${user.id}`)}
                         className="bg-green-200 text-green-600 h-8 w-8 rounded cursor-pointer">
                             👁
                         </button>
                    </div>

                </>
            )} />

            <div className="flex justify-center gap-5 mt-2">
                <button disabled={page === 1} onClick={() => setPage((prev) => prev - 1) }
                
                className="py-3 w-30 bg-slate-200 text-slate-950 rounded-md cursor-pointer">Previous</button>
                
                <button>Total Pages  {data?.data.totalPages} </button>
                <button>Current Page {data?.data.page}</button>  

                <button onClick={() => setPage((prev) => prev + 1)}
                className="py-3 w-30 bg-green-200 text-green-950 rounded-md cursor-pointer"
                >Next</button>

            </div>
            <ToastContainer/>


        </>
    )
}

export default UsersRandomUsers;
import { useQuery } from "@tanstack/react-query";
import { getRandomUsers } from "../features/randomUsers/randomUsers.api";
import { Table, type Column } from "./Table";
import type { User } from "../types/user.types";
import { toast, ToastContainer } from "react-toastify";
import { useEffect } from "react";

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
    const {data, isLoading, isError } = useQuery({
        queryKey : ["users"],
        queryFn : getRandomUsers,
    });

    useEffect(() => {
        if(isLoading) {
            toast.loading("loading users....")
        }
        if(!isLoading){
            toast.dismiss();
        }
    })

    useEffect(() => {
        if(isError) {
            toast.error("lFaild to fetch users....")
        }
        if(!isError){
            toast.dismiss();
        }
    })
    


    return (
        <>
            <Table columns={columns} data={data?.data.data ?? []} />


            <ToastContainer/>


        </>
    )
}

export default UsersRandomUsers;
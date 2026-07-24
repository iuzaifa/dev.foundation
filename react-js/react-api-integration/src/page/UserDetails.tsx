import { useQuery } from "@tanstack/react-query";
import { useParams } from "react-router-dom";
import UserCard from "../components/UserCard";
import { getUserById } from "../api/randomUsers/randomUsers.api";


export function UserDetails () {

    const {userId} = useParams();
    const {data, isLoading, error} = useQuery({
        queryKey : ["user", userId],
        queryFn : () => getUserById(Number(userId)),
        enabled : !!userId
    })

    if(isLoading) return <>Loading............</>
    if(error) return <>Error............</>

    return (
        <>

            <UserCard user={data!.data} />
        
        </>
    )
} 
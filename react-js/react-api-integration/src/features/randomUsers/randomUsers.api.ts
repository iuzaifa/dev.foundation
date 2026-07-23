import axiosInstance from "../../api/axiosInstance";
import type { UserResponse, UserResponseById } from "../../types/user.types";


// get all random users ; 
// /public/randomusers?page=1&limit=20
export const getRandomUsers = async (page:number, limit:number): Promise<UserResponse> => {
    const response = await axiosInstance.get<UserResponse>(`/public/randomusers?page=${page}&limit=${limit}`);
    return response.data;
}

export const getUserById = async ( userId : number): Promise<UserResponseById> => {
    const response = await axiosInstance.get<UserResponseById>(`/public/randomusers/${userId}`)
    return response.data;
}


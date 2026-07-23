import axiosInstance from "../../api/axiosInstance";
import type { UserResponse } from "../../types/user.types";


// get all random users ; 
export const getRandomUsers = async (): Promise<UserResponse> => {
    const response = await axiosInstance.get<UserResponse>("/public/randomusers");
    return response.data;
}


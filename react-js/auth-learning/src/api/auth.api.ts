import type { LoginRequest, LoginResponse } from "../types/auth.type";
import api from "./axios";
import { ENDPOINTS } from "./endpoints";



// LOGIN API 
export const login = async (payload : LoginRequest) : Promise<LoginResponse> => {
    const response = await api.post<LoginResponse>(ENDPOINTS.AUTH.LOGIN, payload)
    return response.data;
}

// REGISTER API

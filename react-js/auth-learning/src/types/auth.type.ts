import type { ApiResponse } from "./api.response";
import type { User } from "./user.type";



export interface LoginRequest {
  username: string;
  password: string;
}

export interface LoginData {
  user: User;
  accessToken: string;
  refreshToken: string;
}


export type LoginResponse = ApiResponse<LoginData>;
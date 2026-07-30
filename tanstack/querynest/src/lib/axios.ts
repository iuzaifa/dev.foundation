

// https://api.freeapi.app/api/v1/todos

import axios from "axios";



export const axiosApi = axios.create({
  baseURL: `https://api.freeapi.app/api/v1`,
  headers: {
    "Content-Type": "application/json",
  },
//   withCredentials: true, // agar cookies (jaise refresh token) bhejni/receive karni hain
  timeout: 10000, // 10 sec ke baad request timeout ho jaye
});
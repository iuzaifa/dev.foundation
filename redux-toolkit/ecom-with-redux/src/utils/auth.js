import { jwtDecode } from "jwt-decode";

export const getUserId = () => {

    const token = localStorage.getItem("token");
    if(!token) return null;

    const decode= jwtDecode(token);
console.log(jwtDecode(localStorage.getItem("token")));
    return decode.sub;
}
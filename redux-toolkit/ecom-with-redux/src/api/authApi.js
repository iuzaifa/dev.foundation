
import api from "./axios"

export const loginUser = async(credentials) => {
    const {data} = await api.post(`/auth/login`, credentials);
    return data
}


export const getMe = async(id) => {
    const {data} = await api.get(`/users/${id}`)
    return data;
}
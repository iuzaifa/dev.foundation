import type { ProductData, ProductsResponse } from "@src//types/products.type";
import axiosInstance from "../axiosInstance";



// get all procucts 
export const getAllProducts = async (page:number, limit:number) : Promise<ProductsResponse> => {
    const response = await axiosInstance.get<ProductsResponse>(`/public/randomproducts?page=${page}&limit=${limit}`);
    return response.data;
}

export const getProductById = async (id : number) : Promise<ProductData> => {
    const response = await axiosInstance.get<ProductData>(`/public/randomproducts/${id}`);
    return response.data;
}

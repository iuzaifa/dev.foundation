import apiInstance from "../lib/axios";

export const getAllPost = async () => {
  try {
    const response = await apiInstance.get("/posts");
    return response.status === 200 ? response.data : [];
  } catch (error) {
    console.log(error);
  }
};

export const getPostById = async (id) => {
    try {
        const response = await apiInstance.get(`/posts/${id}`)
        return response.status === 200 ? response.data : {}
    } catch (error) {
        console.log(error)
    }
}

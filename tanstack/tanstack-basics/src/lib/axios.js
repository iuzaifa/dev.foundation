import axios from "axios";

const apiInstance = axios.create({
  baseURL: `https://jsonplaceholder.typicode.com`,
  headers: {
    "Content-Type": "application/json",
  },
});

export default apiInstance;

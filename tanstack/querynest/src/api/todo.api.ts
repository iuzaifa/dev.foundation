import { axiosApi } from "../lib/axios";
import type { AllTodosResponse, CreateTodoInput, SingleTodoResponse, TodoType, UpdateTodoType, UppdateTodo } from "../type/todo.type";


export const getAllTodos = async (): Promise<AllTodosResponse> => {
  try {
    const response = await axiosApi.get<AllTodosResponse>(`/todos`);
    return response.data;
  } catch (error) {
    console.log(error);
    throw error; // caller ko pata chale ki request fail hui
  }
};


export const createNewTodo = async (newTodo : CreateTodoInput): Promise<SingleTodoResponse> => {
    try {
        const response = await axiosApi.post<SingleTodoResponse>("/todos", newTodo)
        return response.data ;
    } catch (error) {
        console.log(error)
        throw error
    }
}


export const deleteTodoById = async (id: string): Promise<void> => {
  try {
    // 1. Changed POST -> DELETE
    // 2. Removed unused type parameter since return is Promise<void>
    await axiosApi.delete(`/todos/${id}`);
  } catch (error) {
    console.error(`Failed to delete todo with ID ${id}:`, error);
    throw error;
  }
};


export const updateTodoById = async(id : string, newTodo : UpdateTodoType) : Promise<UpdateTodoType> => {
  try {
    const response = await axiosApi.patch<UpdateTodoType>(`/todos/${id}`, newTodo)
    return response.data;

  } catch (error) {
    console.error(`Failed to update todo with ID ${id}:`, error);
    throw error;
  }

}

export const updateTodoStatus = async(id : string, status : boolean) : Promise<SingleTodoResponse> => {
  try {
    const response = await axiosApi.patch<SingleTodoResponse>(`/todos/toggle/status/${id}`, {isComplete : status})
    return response.data;

  } catch (error) {
    console.error(`Failed to status todo with ID ${id}:`, error);
    throw error;
  }

}
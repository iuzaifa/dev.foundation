

export interface Todo {
  _id: string;
  title: string;
  description: string;
  isComplete: boolean;
  createdAt: Date;
  updatedAt: Date;
}

export interface ApiResponse<T> {
  statusCode: number;
  data: T;
  message: string;
  success: boolean;
}
export interface CreateTodoInput {
  title: string;
  description: string;
}

export type TodoType = {
  _id : string,
  title: string;
  description: string;
}
export type UpdateTodoType = {
  title: string;
  description: string;
}

// Usage:
export type AllTodosResponse = ApiResponse<Todo[]>;
export type SingleTodoResponse = ApiResponse<Todo>;
export type UppdateTodo = ApiResponse<Todo>;
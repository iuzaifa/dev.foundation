import { useMutation, useQuery, useQueryClient } from "@tanstack/react-query";
import { deleteTodoById, getAllTodos, updateTodoStatus } from "../api/todo.api";
import { Edit2, Loader2, Trash2 } from "lucide-react";
import CreateNewTodo from "./CreateNewTodo";
import UpdateTodo from "./UpdateTodo";
import { toast } from "react-toastify";
import { useState } from "react";
import type { TodoType } from "../type/todo.type";

const Todo = () => {
  const [isModelOpen, setIsModelOpen] = useState<boolean>(false);
  const [selectedTodo, setSelectedTodo] = useState<TodoType | null>(null)

  const queryClient = useQueryClient();
  const { data: todos, isPending, error} = useQuery({
    queryKey: ["todos"],
    queryFn: getAllTodos,
  });

  // delete todo
  const { mutate: deleteTodo, isPending: isDeleting, error: isDeletingError, variables,} = useMutation({
    mutationFn: (id: string) => deleteTodoById(id),
    onSuccess: () => {
      toast.success("Successfully deleted");
      queryClient.invalidateQueries({
        queryKey: [`todos`],
      });
    },
    onError : () => {
        toast.error("Failed to delete todo");
    }
  });


  const {mutate : updateStatus, isPending : isUpdatingStatus, variables : statusVariables} = useMutation({
    mutationFn : ({id, status} : {id : string, status : boolean}) => updateTodoStatus(id, status),
    onSuccess: (response) => {
      console.log("Updated response:", response);
      toast.success("Todo status updated");

      queryClient.invalidateQueries({
        queryKey: ["todos"],
      });
    },
    onError: () => {
      toast.error("Failed to update todo status");
    },
  })


  if (error) return <p>Something went wrong {error.message}</p>;
  if (isPending) return <p>Loading.......</p>;

  if (isDeletingError)
    return <p>Something went wrong {isDeletingError.message}</p>;

  return (
    <>
      {/* list of all todos  */}
      <CreateNewTodo />
      <div className="max-w-8xl mx-auto px-5">
        <h1 className="text-3xl text-shadow-mauve-600 font-semibold mt-10">
          List of all todos
        </h1>
        <div className="grid mt-5 grid-cols-1 md:grid-cols-4 text-shadow-mauve-600 gap-3">
          {!todos?.data || todos.data.length === 0 ? (
            <p>
              <span className="bg-red-900/30 font-semibold text-red-700 py-0.5 px-1">
                No data exists
              </span>
            </p>
          ) : (
            todos?.data.map((data, idx) => {
              return (
                <div key={idx} className="bg-[#2323279b] p-4 rounded-sm overflow-hidden text-wrap">
                  {/* {data.isComplete ? (
                    <span className="text-[10px] cursor-pointer float-end bg-green-900/30 font-semibold text-green-700 py-0.5 px-1 rounded-xs">
                      Completed
                    </span>
                  ) : (
                    <span className="text-[10px] cursor-pointer float-end bg-red-900/30 font-semibold text-red-700 py-0.5 px-1 rounded-xs">
                      Not Completed
                    </span>
                  )} */}
                  <button
                    type="button"
                    onClick={() =>
                      
                      updateStatus({id: data._id, status: !data.isComplete,})
                    }
                    disabled={
                      isUpdatingStatus &&
                      statusVariables?.id === data._id
                    }
                    className={
                      data.isComplete
                        ? "text-[10px] cursor-pointer float-end bg-green-900/30 font-semibold text-green-700 py-0.5 px-1 rounded-xs"
                        : "text-[10px] cursor-pointer float-end bg-red-900/30 font-semibold text-red-700 py-0.5 px-1 rounded-xs"
                    }
                  >
                    {isUpdatingStatus &&
                    statusVariables?.id === data._id
                      ? "Updating..."
                      : data.isComplete
                        ? "Completed"
                        : "Not Completed"}
                  </button>

                  <p className="text-sm">ID: {data._id}</p>
                  <h3 className="text-shadow-mauve-600 text-md font-bold pt-3">
                    {data.title}
                  </h3>
                  <p className="text-sm">{data.description}</p>
                  <p className="text-xs mt-3">
                    <span>CreatedAt At:</span>
                    <span className="ml-2 italic">
                      {/* {new Date(data.createdAt).toDateString()} */}
                      {new Date(data.createdAt).toLocaleString("en-IN", {
                        dateStyle: "medium",
                        timeStyle: "short",
                        })}
                    </span>
                  </p>
                  <p className="text-xs">
                    <span>Updated At:</span>
                    <span className="ml-2 italic">
                      {/* {new Date(data.updatedAt).toDateString()} */}
                      {new Date(data.updatedAt).toLocaleString("en-IN", {
                        dateStyle: "medium",
                        timeStyle: "short",
                        })}
                    </span>
                  </p>

                  <div className="float-end">
                    <button
                      onClick={() => deleteTodo(data._id)}
                      disabled={isDeleting && variables === String(data._id)}
                      className="bg-red-900/30 font-semibold mx-1 text-red-700 p-2 rounded-xs cursor-pointer"
                    >
                      {isDeleting && variables === data._id ? (
                        <Loader2
                          size={14}
                          className="animate-spin text-white"
                        />
                      ) : (
                        <Trash2 size={14} />
                      )}
                    </button>

                    {/* <button type="button" onClick={() => {selectedTodo(data); setIsModelOpen(true)}}
                      className="bg-green-900/30 font-semibold mx-1 text-green-700 p-2 rounded-xs cursor-pointer">
                      <Edit2 size={14} />
                    </button> */}
                    <button
                        type="button"
                        onClick={() => {
                          setSelectedTodo(data);
                          setIsModelOpen(true);
                        }}
                        className="bg-green-900/30 font-semibold mx-1 text-green-700 p-2 rounded-xs cursor-pointer"
                      >
                        <Edit2 size={14} />
                      </button>
                  </div>
                </div>
              );
            })
          )}
        </div>
      </div>

      {/*  model of update todo */}
      {isModelOpen && selectedTodo && (
        <UpdateTodo
          todo={selectedTodo}
          onClose={() => {
            setSelectedTodo(null);
            setIsModelOpen(false);
          }}
        />
      )}
      {/* {isModelOpen && <UpdateTodo todo={selectedTodo}  onClose={() => {selectedTodo(null); setIsModelOpen(false)}}/>} */}
    </>
  );
};

export default Todo;

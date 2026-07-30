import { useMutation, useQueryClient } from "@tanstack/react-query";
import { X } from "lucide-react";
import { updateTodoById } from "../api/todo.api";
import type {UpdateTodoType } from "../type/todo.type";
import type React from "react";
import { useState } from "react";

export type UpdateTodoProps = {
  todo: {
    _id: string;
    title: string;
    description: string;
  };
  onClose: () => void;
};

function UpdateTodo({todo, onClose }: UpdateTodoProps) {
  const queryClient = useQueryClient();
  const [title ,setTitle] = useState<string>(todo.title)
  const [description ,setDescription] = useState<string>(todo.description)

  const {mutate : updateTodo, isPending : isUpdating, error : updateError} = useMutation({
    mutationFn : ({id, newTodo} : {id : string, newTodo : UpdateTodoType}) => updateTodoById(id, newTodo),
    
    onSuccess : () => {
      queryClient.invalidateQueries({
        queryKey : [`todos`]
      });
      onClose();
    } 
  })

  function handleSubmit (event : React.FormEvent<HTMLFormElement>) {
    event.preventDefault();
    updateTodo({
      id : todo._id,
      newTodo : {
        title,
        description
      },
    });
  }





  return (
    <div className="fixed inset-0 z-50 flex items-center justify-center bg-black/70 px-4">
      <div className="relative w-full max-w-md rounded-lg bg-[#232327] p-6 shadow-xl">
        {/* Close button */}
        <button
          type="button"
          onClick={onClose}
          className="absolute right-4 top-4 cursor-pointer text-gray-400 hover:text-white"
        >
          <X size={20} />
        </button>

        <h2 className="mb-6 text-2xl font-bold text-white">
          Update Todo <span className="text-xs">{todo._id}</span>
        </h2>

        <form className="space-y-4" onSubmit={handleSubmit}>
          {/* Title */}
          <div>
            <label className="mb-2 block text-sm font-semibold text-gray-300">
              Title
            </label>

            <input
              type="text"
              placeholder="Enter title"
              defaultValue={todo.title}
              value={title}
              onChange={(e) => setTitle(e.target.value)}
              className="w-full rounded-md border border-gray-700 bg-[#18181b] px-4 py-3 text-white outline-none focus:border-purple-500"
            />
          </div>

          {/* Description */}
          <div>
            <label className="mb-2 block text-sm font-semibold text-gray-300">
              Description
            </label>

            <textarea
              placeholder="Enter description"
              rows={4}
              defaultValue={todo.description}
              value={description}
              onChange={(e) => setDescription(e.target.value)}
              className="w-full resize-none rounded-md border border-gray-700 bg-[#18181b] px-4 py-3 text-white outline-none focus:border-purple-500"
            />
          </div>


          {updateError && (
            <p className="text-sm text-red-500">
              Failed to update todo
            </p>
          )}

          {/* Buttons */}
          <div className="flex justify-end gap-3 pt-2">
            <button
              type="button"
              onClick={onClose}
              disabled={isUpdating}
              className="cursor-pointer rounded-md bg-gray-700 px-4 py-2 font-semibold text-white hover:bg-gray-600"
            >
              Cancel
            </button>

            <button
              type="submit"
              className="cursor-pointer rounded-md bg-purple-600 px-4 py-2 font-semibold text-white hover:bg-purple-700"
            >
               {isUpdating
                ? "Updating..."
                : "Update Todo"}
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}

export default UpdateTodo;
import { useMutation, useQueryClient } from "@tanstack/react-query";
import { createNewTodo } from "../api/todo.api";
import {useState } from "react";

const CreateNewTodo = () => {
  const [title, setTitle] = useState<string>("");
  const [description, setDescription] = useState<string>("");
  const [showSuccess, setShowSuccess] = useState<boolean>(false);

  const queryClient = useQueryClient();
  const { mutate, error, isPending, } = useMutation({
    mutationFn: createNewTodo,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: [`todos`] });
      setTitle("");
      setDescription("");

      setShowSuccess(true);

      setTimeout(() => {
        setShowSuccess(false);
      }, 2000);
    },
  });

  return (
    <>
      <div className="max-w-4xl mx-auto px-5 mt-5">
        <input
          type="text"
          name="title"
          id="title"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
          className="p-2 h-10 w-full focus:outline-none focus:ring-1 focus:ring-mauve-600 bg-[#1c1c1d] text-gray-200 text-sm rounded-sm placeholder:text-gray-500"
          placeholder="Enter Todo Title"
          required
        />
        <textarea
          name="description"
          id="description"
          rows={1}
          value={description}
          onChange={(e) => setDescription(e.target.value)}
          className="p-2 h-20  w-full mt-2 focus:outline-none focus:ring-1 focus:ring-mauve-600 bg-[#1c1c1d] text-gray-200 text-sm rounded-sm placeholder:text-gray-500 resize-none"
          placeholder="write something"
          required
        />
        {showSuccess && (
          <p className="bg-green-900/30 font-semibold text-green-700 text-sm py-1 px-3 my-4">
            Successfully Created
          </p>
        )}
        {isPending && (
          <p className="bg-yellow-900/30 font-semibold text-yellow-700 text-sm py-1 px-3">
            Creating Todo
          </p>
        )}
        {error && (
          <p className="bg-red-900/30 font-semibold text-red-70 text-sm py-1 px-3">
            Something went wrong : + {error.message}
          </p>
        )}
        <button
          onClick={() => mutate({ title, description })}
          className="bg-green-900/30 float-right font-semibold text-green-700 px-5 py-2 rounded-sm cursor-pointer hover:bg-green-900/50 transition-colors"
        >
          Save
        </button>
      </div>
    </>
  );
};

export default CreateNewTodo;

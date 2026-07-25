import { useState } from "react";
import { useDispatch } from "react-redux"
import { addTodo } from "../features/todo/todoSlice"
import { Plus } from "lucide-react";

const AddTodo = () => {
    const [input, setInput] = useState('');
    const dispatch = useDispatch();

    const addTodoHandler = (e) => {
        e.preventDefault();
        if (!input.trim()) return;
        dispatch(addTodo(input));
        setInput('')
    }
    return (
        <>
            <form onSubmit={addTodoHandler} className="flex items-center gap-3 mt-12 max-w-md mx-auto">
                <input
                    type="text"
                    className="flex-1 bg-gray-800 rounded border border-gray-700 focus:border-indigo-500
        focus:ring-2 focus:ring-indigo-900 text-base outline-none text-gray-100 py-2 px-3
        transition-colors duration-200 ease-in-out"
                    placeholder="Enter new todo"
                    value={input}
                    onChange={(e) => setInput(e.target.value)}
                />

                <button
                    type="submit"
                    className="text-white bg-indigo-500 border-0 py-2 px-4 focus:outline-none
        hover:bg-indigo-600 rounded text-lg transition-colors duration-200 ease-in-out
        flex items-center justify-center"
                >
                    <Plus size={20} />
                </button>
            </form>
        </>
    )
}

export default AddTodo
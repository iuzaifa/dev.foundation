import { useDispatch, useSelector } from "react-redux";
import { removeTodo } from "../features/todo/todoSlice";
import { Edit, Trash2 } from "lucide-react";

const Todo = () => {
  const todos = useSelector(state => state.todos)
  const dispatch = useDispatch();

  return (
    <>
        {todos.map((todo) => (
            <li key={todo.id} className="bg-slate-600 text-white   px-2 py-1 mt-2 flex justify-between">
                {todo.text}


                <div className="flex gap-2">
                    {/* <button
                    onClick={() => dispatch((updateTodo({id:todo.id , text: todo.text})))}
                    className="text-white bg-green-500 border-0 py-2 px-6 focus:outline-none
                 hover:bg-green-600 rounded text-lg"
                    >
                        <Edit/></button> */}

                <button onClick={() => dispatch(removeTodo(todo.id))}
                    className="text-white bg-red-500 border-0 py-2 px-6 focus:outline-none
                 hover:bg-red-600 rounded text-lg"
                ><Trash2/>
                </button>
                </div>

            </li>
        ))}
    
    
    </>
  )
}

export default Todo
import AddTodo from './components/AddTodo';
import Todo from './components/Todo';

function App() {

  return (
    <>
      <div className="max-w-5xl mx-auto">
        <p className="text-center text-slate-200 text-lg">Learn About Redux Toolkit</p>
        <AddTodo />
        <Todo />

      </div>
    </>
  )
}

export default App

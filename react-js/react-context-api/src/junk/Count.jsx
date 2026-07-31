import { useContext } from "react";
import Counter from "./components/Counter";
import { ConterContext } from "./context/ContextProvider";

const Count = () => {
  const counterState = useContext(ConterContext)
  console.log("Contex", counterState)
  return (
    <div className="app py-5 text-center ">
        <h2 className="text-2xl font-bold">React Context API</h2>
        <h2 className="text-2xl font-bold mt-6">Count is {counterState.count}</h2>

        <Counter/>
        <Counter/>
        <Counter/>
        <Counter/>





      </div>
  )
}

export default Count;
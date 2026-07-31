import { useContext } from "react";
import { ConterContext } from "../context/ContextProvider";

function Counter() {
  const counterContext = useContext(ConterContext);


  function  handleCounter (step) {
    if (step > 0) {
        counterContext.setCount(counterContext.count + 1)
    }else {
        if(counterContext.count === 0) {
            return alert ("Can't be negative value")
        }
        counterContext.setCount(counterContext.count - 1)
    }
  }

  return (  
    <>
      <div className="mt-6">
        <button
          onClick={ ()=> handleCounter(1)}
          className="cursor-pointer rounded-sm py-2 px-6 bg-[#202020] text-slate-100 mx-2 "
        >
          Increment
        </button>
        <button
          onClick={()=> handleCounter(-1)}
          className="cursor-pointer rounded-sm py-2 px-6 bg-[#202020] text-slate-100 mx-2 "
        >
          Decrement
        </button>
      </div>
    </>
  );
}

export default Counter;

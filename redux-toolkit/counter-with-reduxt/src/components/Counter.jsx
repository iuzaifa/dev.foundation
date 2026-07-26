import { Minus, Plus, RefreshCw } from "lucide-react";
import { useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import {
  decrement,
  increment,
  incrementByAmount,
  reset,
  decrementByAmount,
} from "../features/counter/counterSlice";

const Counter = () => {
  const count = useSelector((state) => state.counter.value);
  const dispatch = useDispatch();

  const [spinning, setSpinning] = useState(false);

  // const handleClick = () => {
  //   setSpinning(true);
  //   setTimeout(() => setSpinning(false), 600); // match animation duration
  // };
  const handleReset = () => {
    setSpinning(true); // agar spin animation bhi chahiye

    setTimeout(() => {
      dispatch(reset());
      setSpinning(false);
    }, 600);
  };

  return (
    <>
      <div className="text-center">
        <h1>Count: {count}</h1>

        <button
          onClick={() => dispatch(decrement())}
          className="mr-10 mt-5  bg-gray-300 text-[#202020] py-2 px-4 rounded-md shadow-2xs cursor-pointer hover:bg-gray-200"
        >
          <Minus />
        </button>

        <button
          onClick={() => dispatch(increment())}
          className="mr-10 mt-5 bg-gray-300 text-[#202020] py-2 px-4 rounded-md shadow-2xs cursor-pointer hover:bg-gray-200"
        >
          <Plus />
        </button>

        <button
          onClick={() => dispatch(decrementByAmount(5))}
          className="mr-10 mt-5  bg-gray-300 text-[#202020] py-2 px-4 rounded-md shadow-2xs cursor-pointer hover:bg-gray-200"
        >
          <span className="flex">
            <Minus />5
          </span>
        </button>

        <button
          onClick={() => dispatch(incrementByAmount(5))}
          className="mr-10 mt-5 bg-gray-300 text-[#202020] py-2 px-4 rounded-md shadow-2xs cursor-pointer hover:bg-gray-200"
        >
          <span className="flex">
            <Plus /> 5
          </span>
        </button>

        <button
          onClick={() => {
            handleReset();
          }}
          className="mr-10 mt-5 bg-gray-300 text-[#202020] py-2 px-4 rounded-md shadow-2xs cursor-pointer hover:bg-gray-200"
        >
          <RefreshCw className={spinning ? "animate-spin" : ""} />
        </button>
      </div>
    </>
  );
};

export default Counter;

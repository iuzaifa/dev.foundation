import { useDispatch, useSelector } from "react-redux";

const Counter = () => {
    const count = useSelector((state) => state.counter.value);
    const dispatch = useDispatch();
  return (
    <>
        <div className="text-center">
            <h1>Count: {count}</h1>

        </div>
    
    </>
  )
}

export default Counter
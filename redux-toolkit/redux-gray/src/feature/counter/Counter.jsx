import {useDispatch, useSelector} from "react-redux";
import {decrement, increment, incrementByNumber, reset} from "./counterSlice.js";


function Counter () {
    const count = useSelector((state) => state.counter.count);
    const dispatch = useDispatch();

    return (
        <>
            <section className="counter text-center">

                <h3 className={`text-center font-semibold text-2xl mb-4`}>Redux Counter :  {count}</h3>
                <button className={`mx-1 py-2 px-4 bg-gray-200 text-[#303030]`} onClick={() => dispatch(increment())} >+</button>
                <button className={`mx-1 py-2 px-4 bg-gray-200 text-[#303030]`} onClick={() => dispatch(decrement())} >-</button>
                <button className={`mx-1 py-2 px-4 bg-gray-200 text-[#303030]`} onClick={() => dispatch(reset())} >reset</button>
                <button className={`mx-1 py-2 px-4 bg-gray-200 text-[#303030]`} onClick={() => dispatch(incrementByNumber(5))} >5</button>




            </section>

        </>
    )
}

export default Counter;
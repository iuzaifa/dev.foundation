import {useDispatch, useSelector} from "react-redux";
import {decrement, decrementByAmount, increment, incrementByAmount, reset} from "./counterSlice.js";
import {useState} from "react";


function Counter () {
    const count = useSelector((state) => state.counter.count);
    const dispatch = useDispatch();

    const [incrementAmount, setIncrementAmount] = useState(0);
    const [decrementAmount, setdecrementAmount] = useState(0);


    const addValue = Number(incrementAmount) || 0;
    const decValue = Number(decrementAmount) || 0;

    const resetAll = () => {
        setIncrementAmount(0);
        dispatch(reset());
    }

    const h3 = `text-center font-semibold text-2xl mb-4`;
    const css = `py-2 px-4 h-10 focus:outline-taupe-700 ring-1 ring-taupe-600 rounded-sm`;
    const btn = `mx-1 py-2 px-4 bg-gray-200 text-[#303030]`
    const div = `flex gap-3 items-center max-w-3xl justify-center mt-4 mx-auto `;
    const sec = `counter text-center`;

    return (
        <>
            <section className={sec}>
                <h3 className={h3}>Redux Counter :  {count}</h3>
                <button className={btn} onClick={() => dispatch(increment())} >+</button>
                <button className={btn} onClick={() => dispatch(decrement())} >-</button>
                <button className={btn} onClick={() => dispatch(resetAll)} >reset</button>
                <div className={div}>
                    <input type={`text`} onChange={(e)=> setIncrementAmount(e.target.value)} className={css} placeholder={`Enter Amount.....`}/>
                    <button onClick={() => dispatch(incrementByAmount(addValue))} className={btn}>Add Amount</button>
                </div>
                <div className={div}>
                    <input type={`text`} onChange={(e)=> setdecrementAmount(e.target.value)} className={css} placeholder={`Enter Amount.....`}/>
                    <button onClick={() => dispatch(decrementByAmount(decValue))} className={btn}>Less Amount</button>
                </div>




            </section>

        </>
    )
}

export default Counter;
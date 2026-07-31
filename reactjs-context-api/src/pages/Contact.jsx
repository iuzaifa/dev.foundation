import { useContext } from "react";
import { counterContext } from "../context/CounterContext";

const Contact = () => {
  const counter = useContext(counterContext);
  return (
    <div className="page-container theme-contact">
      <h1 className="page-heading">Count : {counter.count}</h1>
      <button className="page-btn" onClick={() => counter.setCount(counter.count + 5)} >Incriment + 5</button>
    </div>
  )
}

export default Contact
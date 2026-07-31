import { useContext } from "react";
import { counterContext } from "../context/CounterContext";

const Portfolio = () => {
  const counter = useContext(counterContext);

  
  return (
    <div className="page-container theme-portfolio">
      <h1 className="page-heading">Couter Reset {counter.count}</h1>
     
      <button className="page-btn" onClick={() => counter.setCount(0 )} >reset counter </button>
    </div>
  )
}

export default Portfolio
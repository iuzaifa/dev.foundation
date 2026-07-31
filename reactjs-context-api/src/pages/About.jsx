import { useContext } from "react";
import { counterContext } from "../context/CounterContext";

const About = () => {
  const counter = useContext(counterContext);
  return (
    <div className="page-container theme-about">
      <h1 className="page-heading">Count : {counter.count}</h1>
     
      <button className="page-btn" onClick={() => counter.setCount(counter.count + 1)} >Incriment</button>
    </div>
  )
}

export default About
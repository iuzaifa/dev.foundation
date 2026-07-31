import { useContext } from "react";
import { counterContext } from "../context/CounterContext";

const Home = () => {
   const counter = useContext(counterContext);

   function handleDecrement() {
      if (counter.count <= 0) {
        alert(`Value already is ${counter.count}`);
        return;
      }
      counter.setCount(counter.count - 1);
    }
  return (
    <div className="page-container theme-home">
      <h1 className="page-heading">Count : {counter.count}</h1>
      
      <button className="page-btn" onClick={() => handleDecrement(-1)}>Explore More</button>
    </div>
  )
}

export default Home
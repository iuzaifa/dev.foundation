import { useState } from "react";
import {counterContext} from "./CounterContext"


const MainContext = ({children}) => {
    const [count, setCount] = useState(0);
    const [theme, setTheme] = useState(true)


  return (
    <counterContext.Provider value={{count, setCount, setTheme , theme}}>
      <div className={`${theme ? "dark-theme" : "light-theme"}`}>
        {children}

      </div>
    </counterContext.Provider>
  )
}

export default MainContext



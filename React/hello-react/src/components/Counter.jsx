import { useState } from "react";
export default function Counter() {



    let badCount = 0; // does not trigger rerender when updated

    const badIncrement = function() {
        console.log("incrementing")
        badCount++;
        console.log("counter is now", badCount)
    }

    const [count, setCount] = useState(0); 

    const increment = function() {
        console.log("incrementing")
        // Pass the new value to setCount
        setCount(count + 1)
        // Alternative: pass a lambda
        // setCount((oldState) => {
        //     return oldState + 1;
        // });
        console.log("counter is now", count)
    }

    return (<>
        <p>Try 1: Counter Value: {badCount}</p>
        {/** Couple differences between JSX and HTML
        
              use onClick not onclick
              use className not class
              
         */}
        <button className="red" onClick={badIncrement}>Increment</button>

        <p>Try 2: Counter state: {count}</p>
        <button onClick={increment}>Increment</button>
    </>);
}
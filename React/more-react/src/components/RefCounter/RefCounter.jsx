import { useRef } from "react";

/*
  REACT HOOK - useRef()
      similar to useState() because it puts the data under React's control
      different than useState() because doesn't cause rerenders
*/
export const RefCounter = () => {

    // Example 1 - badCount 
    let x = 0;

    // Example 2 - 
    let y = useRef(0)

    return (
        <div>

            <h1>
                Counter Value
            </h1>
            <p>Open the console to see the value of x being logged. (Note if we unmount and remount the count is lost)</p>
            <button onClick={() => { x++; console.log("x=", x) }}>Increment</button>


            <p>Open the console to see the value of y being logged. (Note it is tracked between unmounting and mounting)</p>
            <button onClick={() => { y.current++; console.log("y=", y.current) }}>Increment</button>
        </div>
    )
}

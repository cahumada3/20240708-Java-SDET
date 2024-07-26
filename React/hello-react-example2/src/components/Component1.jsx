import { useState, useEffect } from "react";

export default function Component1() {

    
//   console.log("rerendered?")

    /*
      Lifecycle hooks
        - before when we used classes for components there were methods we could use to run code at certain stages of a components life cycle 
        (legacy methods diagram https://projects.wojtekmaj.pl/react-lifecycle-methods-diagram/)

        - nowadays we can run code at certain stages of a components life 
          cycle using the hook 

              useEffect(setup, dependencies?) 

              - two parameters are setup and dependencies (optional)
              - setup should be a function with no-args
              - dependencies should be an array of Reactive value references
                - Reactive values include 
                  - props
                  - state
                  - all the variables and functions declared directly inside your component body
              - setup lambda can have a return statement that returns another no-arg function

        - usage/purpose: used mainly to synchronize app with external sources


      React Hooks - allow us to "hook" easily into and use different React features
        
        - note, React is handling UI rendering which we may want to customize or interupt etc
        
        - similar to dependency injection because we are asking React for access to
          pieces of its internal workings

        - all built-in hooks are named `use__()`

    */

    // Example 1
    useEffect(() => { console.log(">>>> Hey there, just mounted!") }, []) // this runs once when first mounted

    // Example 2
    useEffect(() => { console.log("---> Wow SOME state changed!") }) // this runs ever time state changes


    const [dummyState, setDummyState] = useState(0);
    const [dummyState2, setDummyState2] = useState(0);

    const triggerRerender = function () {
        setDummyState(dummyState + 1);
    }

    const triggerRerender2 = function () {
        setDummyState2(dummyState2 + 1);
    }

    
    // Example 3
    useEffect(() => {

        // console.log("---> wow DUMMY state changed!")

    }, [dummyState]); // only when dummyState not dummyState2 changes


    // Example 4
    useEffect(() => {     // runs when component mounted
        return () => {
            console.log("<<<< unmounted, see ya later!")
        } // runs when unmounted

    }, [])

    return (<>
        <h1>Component1</h1>
        <button onClick={triggerRerender}>Trigger Rerender</button><br />
        <button onClick={triggerRerender2}>Trigger Rerender2</button>
    </>);

}

import { useState } from "react";

export default function Counter() {
    /*
      Lifecycle hooks
        - before when we used classes for components there were methods we could use to run code at certain stages of a components life cycle

        - nowadays we can run code at certain stages of a components life 
          cycle using the hook 

              useEffect() three versions
              */

        useEffect( () => {console.log("Hey there")} ) // this runs once when first mounted

        useEffect( () => {console.log("Wow rerender again?")}, []) // this runs ever time state changes

        useEffect( () => {
            
            console.log("Okay rerendeing because of dummyState not 2") 

        }, [dummyState]); // only when var1 or var2 change

            //   useEffect( () => {     // runs when component mounted
                
            //     return () => { } // runs when unmounted
                    
            //  })
    

    const [dummyState, setDummyState] = useState(0);
    const [dummyState2, setDummyState2] = useState(0);

    const triggerRerender = function() {
        setDummyState(dummyState + 1);
    }

    const triggerRerender2 = function() {
        setDummyState2(dummyState2 + 1);
    }

        return (<>
            <MyComponent1 />
            <button onClick={triggerRerender}>Trigger Rerender</button><br />
            <button onClick={triggerRerender2}>Trigger Rerender2</button>
        </>);

}

const MyComponent1 = function() {
    return (<><h1>Component1</h1></>);
}

// const MyComponent2 = function() {

//     return (<><h1>Component2</h1></>);
// }
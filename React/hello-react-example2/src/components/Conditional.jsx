import { useEffect, useState } from "react";

export default function Conditional() {

    const [shouldRender, setShouldRender] = useState(true);

    let btnText = shouldRender ? "Hide" : "Reveal";

    let toggle = () => {
        setShouldRender(!shouldRender);
        console.log('should render is now', shouldRender)
    }; 

    return (
        <>
            <div>
                What is the largest state in the USA by land mass?
                {shouldRender && <Answer /> } 
            </div>
            {/* Change button text from Reveal to Hide when Answer is Hidden and Revealed*/}
            <button onClick={toggle}>
                {btnText}
            </button>
        </>);
}

function Answer() {

    // memory leak example - start an interval 
    // let x = 0;
    // let intervalId = setInterval(() => {console.log(x++)}, 1000) // started on every mount

    useEffect(() => {
        console.log("mounted");
        let x = 0;
        let intervalId = setInterval(() => {console.log(x++)}, 1000) // started on every mount

        return () => {
            console.log("unmounted"); 
            clearInterval(intervalId); // stop on every unmount
        };
    }, []); // tracks no state so no rerenders cause effect to run

    return (
    <div>
        Answer: Texas
    </div>);

}

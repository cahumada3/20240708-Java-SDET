import { useState } from "react";
import { useRef } from "react";

export const Movie = () => {
    const myRef = useRef("");

    const [myState, setMyState] = useState("")
    return (
        <>
            <div>Movie</div>
            <form><input value={myState} /></form>
            <input />
        </>

    )
}

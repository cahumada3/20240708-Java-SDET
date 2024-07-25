import catPeeking from "../assets/cat1.png";
import booCat from "../assets/cat2.png";
import { useState } from "react";

export default function Peekaboo() {

    // let boo = false;

    // Tell React boo is state that should trigger a rerender
    const [boo, setBoo] = useState(false);

    return (<>
        <h1>Peekaboo</h1>
        <div>
            <img src={boo ? booCat : catPeeking} />
        </div>
        <button onClick={() => setBoo(!boo)}>Play Peekaboo</button>
    </>);

}
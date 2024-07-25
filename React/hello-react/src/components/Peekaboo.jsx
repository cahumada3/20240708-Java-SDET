import { useState } from "react";
import  cat1  from "../assets/peekaboo-cat1.png";
import  cat2  from "../assets/peekaboo-cat2.png";

export default function Peekaboo() {

    const [boo, setBoo] = useState(false);

    let imgPath = boo ? cat1 : cat2;
    return (<>
    <div>
        <img src={imgPath} />
    </div>
    <button onClick={() => setBoo(!boo)}>Play</button>
    </>);
}
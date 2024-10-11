import { useState } from "react";


function Greeting({ name, message }) {
    const [messageState, setMessage] = useState(message);

    return (
        <div>
            <h2>Hello, {name}!</h2>
            <p>{messageState}</p>
            <button onClick={() => setMessage('Goodbye')}>Change text</button>
        </div>
    );
}

export default Greeting;
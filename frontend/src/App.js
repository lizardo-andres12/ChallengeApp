import logo from './logo.svg';
import './App.css';
import ChallengeList from "./components/ChallengeList";
import {useEffect, useState} from "react";
import axios from 'axios';
import AddChallenge from "./components/AddChallenge";

function App() {
    const [challenges, setChallenges] = useState([]);

    useEffect(() => {
        const fetchChallenges = async () => {
            const response = await axios.get('http://localhost:8080/challenges');
            setChallenges(response.data);
        };
        fetchChallenges();
    }, []);

    return (
        <div className="App">
            <AddChallenge />
            <h1>Monthly Challenges</h1>
            <ChallengeList challenges={challenges}/>
        </div>
    );
}

export default App;

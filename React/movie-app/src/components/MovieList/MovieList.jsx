import { useState } from "react";
import { useEffect } from "react";
import { Table } from '@trussworks/react-uswds';

const MovieList = (props) => {

    // TODO fetch data from backend and display in table
    // when the component is mounted

    const url = "http://localhost:8080/movies";

    const [movies, setMovies] = useState([]);

    useEffect(() => {


        fetch(url)
            .then(data => data.json()) // arrow function notation rules 
            .then(returnedData => setMovies(returnedData))
            .catch(err => { alert(err); console.log(err) })
        // TODO instead show your own alert not builtin 
        //  might MUI snackbar etc
        //  Toast Messages


    }, [])

    return (
        <>
            {/** TODO toggle button between table view and card view */}
            <div>MovieList</div>
            {props.children}

            <button>Toggle View</button>

            <Table striped fullWidth className="bg-primary-light" >
                <thead>
                    <tr>
                        <th>Title</th>
                        <th>Rating</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        movies.map(movie => {
                            return (

                                <tr key={movie.id}> {/** need to set the key so react knows which element in the DOM to modify */}
                                    <td>{movie.title}</td>
                                    <td>{movie.rating}</td>
                                </tr>

                            )
                        })
                    }

                </tbody>
            </Table>

        </>
    );
}

export default MovieList
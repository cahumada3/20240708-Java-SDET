import { useState } from "react";
import { useEffect } from "react";
import { Grid, GridContainer, Table } from '@trussworks/react-uswds';

const MovieList = () => {

    // TODO fetch data from backend and display in table
    // when the component is mounted

    const url = "http://localhost:8080/movies";

    const [movies, setMovies] = useState([]);
    const [loaded, setLoaded] = useState(false);

    useEffect(() => {


        fetch(url)
            .then(data => data.json()) // arrow function notation rules 
            .then(returnedData => {
                setMovies(returnedData);
                setLoaded(true);
            })
            .catch(err => { alert(err); console.log(err) })
        // TODO instead show your own alert not builtin 
        //  might MUI snackbar etc
        //  Toast Messages


    }, []) // only fetch when mounting

    return (
        <>
            {/** TODO toggle button between table view and card view */}
            <h3 >MovieList</h3>
            <GridContainer>
                <Grid row>
                    <Grid col="1"></Grid>
                    <Grid col="10">

                        <Table style={{ borderCollpase: true, borderColor: 0x000, borderWidth: 5 }}>
                            <thead>
                                <tr><th>Title</th><th>Rating</th></tr>
                            </thead>
                            <tbody>
                                {loaded ?
                                    movies.map(
                                        movie => (
                                            <tr key={movie.id}>
                                                <td>{movie.movieTitle}</td>
                                                <td>{movie.rating}</td>
                                            </tr>
                                        )) :
                                    (<tr><td colSpan='2'>Loading...</td></tr>)

                                }
                            </tbody>

                        </Table>

                        <button>Toggle View</button>
                    </Grid>
                    <Grid col="1"></Grid>

                </Grid>
            </GridContainer>

            {/* <Table striped fullWidth className="bg-primary-light" >
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
            {/** </>) <td>{movie.title}</td>
                                    <td>{movie.rating}</td>
                                </tr>

                            )
                        })
                    }

                </tbody>
            </Table> */}

        </>
    );
}

export default MovieList
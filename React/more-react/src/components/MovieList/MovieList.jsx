import Movie from '../Movie/Movie.jsx'

export default const MovieList = () => {

    let num = 10;
    return (
        <>
            <div>MovieList</div>
            <Movie count={num} />
        </>
    )
}

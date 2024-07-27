import './App.css'
import { BrowserRouter, Routes, Route, Link, Navigate } from 'react-router-dom'
import MovieList from './components/MovieList/MovieList'
import { Movie } from './components/Movie/Movie'

function App() {

  return (
    <>
      <h1>Rotten Potatoes Movie Ratings</h1>
      <h2>Uncovering Cinematic Gems in a Sea of Spuds</h2>
      <button onClick={null}>View Movies</button>
      <main>
        <Movie />
        <MovieList ><span>Hello!</span><strong>Friyay!</strong></MovieList>
      </main>
    </>
  )
}

export default App

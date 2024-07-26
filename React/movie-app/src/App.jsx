import './App.css'
import { BrowserRouter, Routes, Route, Link, Navigate } from 'react-router-dom'

function App() {

  return (
    <>
      <h1>Rotten Potatoes Movie Ratings</h1>
      <h2>Uncovering Cinematic Gems in a Sea of Spuds</h2>
      <button onClick={null}>View Movies</button>
      <main>
        <BrowserRouter>
          <nav>
            <Link to="/home">Home</Link>
            <Link to="/movies">Movies</Link>
            <Link to="/entermovie">Movie Form</Link>
            <Link to="/movies/:id">Movie Details</Link>
          </nav>
          <Routes>
            <Route path='/movies' element={<MovieList />} />
            <Route path='/' element={<Home />} />
            <Route path='*' element={<Navigate to='/' />} />
            <Route />
          </Routes>
        </BrowserRouter>
      </main>
    </>
  )
}

export default App

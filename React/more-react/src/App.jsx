import './App.css'
import { BrowserRouter, Routes, Route, Link, Navigate } from 'react-router-dom'
import { Cat, Dog, Home } from './pages' // note I don't need to specify index.js because index is the default file it looks for
import SeeEffects from './pages/SeeEffects/SeeEffects'
import { useState } from 'react'
import { RefCounter } from './components/RefCounter/RefCounter'
import { MovieList } from './components/MovieList/MovieList'

// instead of importing these pages individually
// use BARREL IMPORTS
//   1. create index.js in teh pages folder
//   2. now we can use a comma separated list of pages imports

function App() {


  const [shouldRender, setShouldRender] = useState(true);

  return (
    <>
      <header><h3>My Awesome React App</h3></header>

      <main>
        {shouldRender ? <MovieList /> : null}
        <button onClick={() => setShouldRender(!shouldRender)}>Toggle</button>

        {/* <RefCounter /> */}
      </main>
    </>
  )
}

export default App

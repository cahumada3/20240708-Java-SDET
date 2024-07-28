import './App.css'
import { BrowserRouter, Routes, Route, Link, Navigate } from 'react-router-dom'
import MovieList from './components/MovieList/MovieList'
import { Movie } from './components/Movie/Movie'
import { GridContainer, Header, Title } from '@trussworks/react-uswds'

function App() {

  return (
    <>
      <Header >
        <Title>
          <h1>Rotten Potatoes Movie Ratings</h1>
          <h2>Uncovering Cinematic Gems in a Sea of Spuds</h2>
        </Title>
      </Header>
      <main className="container-center">
        <GridContainer containerSize="desktop">
          <MovieList >
            <span>Hello!</span>
            <strong>Friyay!</strong>
          </MovieList>
        </GridContainer>
      </main>
    </>
  )
}

export default App

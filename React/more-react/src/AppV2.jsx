import './App.css'
import { BrowserRouter, Routes, Route, Link, Navigate } from 'react-router-dom'
import { Cat, Dog, Home, Error } from './pages' // note I don't need to specify index.js because index is the default file it looks for

// instead of importing these pages individually
// use BARREL IMPORTS
//   1. create index.js in teh pages folder
//   2. now we can use a comma separated list of pages imports

function AppV2() {

  return (
    <>
      <header>My Awesome React App</header>

      <main>
        <BrowserRouter>
          <nav>
            <Link to="/home">Home</Link>
            <Link to="/cat">Cat</Link>
            <Link to="/dog">Dog</Link>
          </nav>
          <Routes>
            <Route path='/cat' element={<Cat />} />
            <Route path='/dog' element={<Dog />} />
            <Route path='/' element={<Home />} />
            {/** For any other path that is not defined 
              option 1: display a 404 not found page
              
              option 2: redirect to home page
       */}
            {/* <Route path='*' element={<Error />} /> */}
            <Route path='*' element={<Navigate to='/' />} />
            <Route />
          </Routes>
        </BrowserRouter>
      </main>
    </>
  )
}

export default AppV2
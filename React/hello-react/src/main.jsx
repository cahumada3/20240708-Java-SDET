import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
// import { num, MyButton } from './App'
import './index.css'

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
  {/** Use StrictMode only for development. 
  
  It "mounts", "unmounts", "mounts" each component which is not good peformanc wise, but debugging it is useful to detect memory leaks 
  
  */}
    <App />
  </React.StrictMode>,
)

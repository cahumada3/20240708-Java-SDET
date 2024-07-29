
import { useState } from 'react';
import './App.css'
import { Label, TextInput, Form, Button, Select, Alert } from "@trussworks/react-uswds";

function App() {

  const [message, setMessage] = useState("");
  const [error, setError] = useState("");
  function handleSubmit(e) {


    const url = "http://localhost:8080/movies"; // TODO store in env file instead of hardcoding
    // prevent the page reloading
    e.preventDefault();

    // grab the data from the form
    const data = new FormData(e.target);

    const newMovie = {
      movieTitle: data.get("movieTitle"),
      rating: data.get("movieRating"),
      director: {
        id: data.get("director")
      }
    }

    e.target.reset();

    fetch(url, {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(newMovie)
    })
      .then(data => data.json())
      .then((returnedData) => {
        console.log(returnedData)
        setMessage("Succesfully created new movie with id " + returnedData?.id)
      })
      .catch(err => {
        console.log(err);
        setError(err)
      });

  }

  return (
    <>
      <h1>Form Submission Demo</h1>
      <Form onSubmit={handleSubmit}>
        <Label htmlFor="movie-title">Movie Title</Label>
        <TextInput id="movie-title" name="movieTitle" type="text" />

        {/** Add validation and tooltip to keep it in range 1-10 */}
        <div>
          <Label htmlFor="movie-rating">Movie Rating</Label>
          <TextInput id="movie-rating" name="movieRating" type="number" />
        </div>
        <div>
          <Label htmlFor="director">Director</Label>
          <Select id="director" name="director" required>
            <option>- Select -</option>
            <option value="1">Carma Baine</option>
            <option value="2">Isa Fibb</option>
          </Select>
        </div>
        <Button type="submit">Submit</Button>
      </Form>
      {
        // TODO choose a nicer alert with a close button
        // make sure to reset the message and error state
        message && <Alert type="success" heading="Success status" headingLevel="h4">
          {message}
        </Alert>
      }

    </>
  )
}

export default App

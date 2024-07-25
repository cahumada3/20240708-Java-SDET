// import Counter from "./components/Counter"
import Peekaboo from "./components/Peekaboo";
import './App.css';


// components are functions we are going to write
// (Be careful thrid party tutorials might use classes)


// Make sure use capitalized name and same name as file name
export default function App() {

  /* return a JSX single element

   can't return more than one element so if you do, wrap it in a div or main or etc.

   if you don't want to to have a DOM node of a div or main or etc., 
     use <></>

  */
  return (
    <>
      {/* This is a comment.
      
           JSX does not allow comments
           
           So use { } to "escape back into javascript notation"
           and use javascript comment notation

           Also useful for commenting out jsx code
        */
        
           console.log("this is javascript inside my jsx markup")
      }
      <h1>Hello World</h1>

      {/** Example 1 */}
      {/* <Counter /> */}

      {/** Example 2 */}
      <Peekaboo />


      {/* <MyButton /> */}
      {/* <MyButton></MyButton> */}
    </>
  );
}

// can have multiple components in the same file, but large complex projects put each in its own file
export function MyButton() {
  return (<button>Click Me!</button>);
}

/**
 * A couple other choices for working with module exports and imports
 * 
 *     Named exports - can have as many as you want
 *           imports notation:    import { whatever, whatevers } from "./path/file"
 * 
 *     Default exports - can only have one
 *             imports notation:    import App from "./path/file"
 */

export const num = 10;
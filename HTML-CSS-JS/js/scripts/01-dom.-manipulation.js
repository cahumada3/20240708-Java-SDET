console.log('hello');

// DOM manipulation (document object model)
document.getElementById("1").textContent = "Hello!"

// Using the Web API timout
// we can create callback functions that execute after a set amount of time (or repeatedly at an interval)

setTimeout(() => {
    
    clearInterval(intervalId)
    document.getElementById("1").textContent = ("5 secs has passed");
}, 5000)

// javascript loosely typed 
// variable declarations use var, let, or const
var x = 0;
let intervalId = setInterval(() => {
    x = x + 1;
    console.log(x);
    document.getElementById("2").textContent = x;
}, 1000); // miliseconds

// event handlers and callback functions
// add Event listener to a button
// change the color of the div to blue
let btn = document.querySelector("button"); // assumes first on pg
btn.addEventListener("click", (e) => {
    console.dir(e);
    let greenDiv = document.getElementsByClassName("green")[0];
    greenDiv.classList.remove("green");
    greenDiv.classList.add("blue");
    
})

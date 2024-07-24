console.log('hello');

// DOM manipulation (document object model)
document.getElementById("1").textContent = "Hello!"

// Using the Web API timout
// we can create callback functions that execute after a set amount of time (or repeatedly at an interval)

setTimeout(() => {
    document.getElementById("1").textContent = ("5 secs has passed");
}, 5000)
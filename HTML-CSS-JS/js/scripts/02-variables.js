/////////////////////////
// Three ways to declare a variable
var a = 1; // function scoped - old way of declaring variables
let b = 2; // block scoped
const c = 3; // block scoped
// c = 4; // TypeError: Assignment to constant variable.
console.log(`a = ${a} b = ${b} c = ${c}`);

/////////////////////////
// Variable hoisting

// variable declarations and moved to the top of their scope
console.log(name); // prints undefined
var name = "john";
console.log(name); // prints "john"

// console.log(age); // Cannot access 'age' before initialization
let age = 5;
console.log(age)

// console.log(hungry); // Cannot access 'age' before initialization
const hungry = true;
console.log(hungry); 

// moral of the story: use let and const not var

//////////////////////
// function delcarations - function
hello(); // works
function hello() {
    console.log("hello")
}

// function expressions - functions are first class citizens 
//     (can be treated as any other value - stored in a variable, used as a return value, used as a parameter)
// eat();
let eat = function() {
    console.log("munch munch")
}

// arrow function notation (like lambdas in Java)
let sleep = () => {
    // this keyword is different when using arrow function notation (we don't care right now)
    console.log("zzzzzzzzz");
}


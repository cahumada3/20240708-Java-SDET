function hello() {
    console.log("hello from within scripts page")
}
hello();

// Target an element on the page using JavaScript
const awesomeElement = document.getElementById("awesomeness");

console.log(awesomeElement) // like toString
console.dir(awesomeElement) // lets us expand and see props

// create an element
const list = document.createElement("ul"); 

// side note: 
// "" and '' both work be consitent for style reasons
// nesting '' and ""
let str1 = 'She said "hi"';
let str2 = "He said \"hi\"";

const item1 = document.createElement('li');
item1.textContent = "Coffee";

const item2 = document.createElement('li');
item2.textContent = "The sun is shining"

const item3 = document.createElement('li');
item3.textContent = "Volleyball at lunch!";

const item4 = document.createElement('li');
item4.textContent = "Golf after work"

const item5 = document.createElement('li');
item5.textContent = "It's taco tuesday"

list.appendChild(item1)
list.appendChild(item2)
list.appendChild(item3)
list.appendChild(item4)
list.appendChild(item5)

awesomeElement.appendChild(list);
console.dir(awesomeElement.childNodes)
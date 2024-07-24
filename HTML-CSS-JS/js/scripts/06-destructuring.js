///////////////////////////////////
// destructuring - "unpacking" an object or array

let arr = [1, 2, 3, 4, 5];
let [x, y] = arr;
console.log(`x = ${x} y = ${y}`)
console.log("array contains", arr);

// rest operator

let [a, b, ...other] = arr;
console.log(other);

/////////////////////////////////
// objects
const dog = {name: "Spot", age: 10, favoriteToy: "Tennis ball", favoriteAnimal: "squirrel"};
let {age : years, name : myDog} = dog;
console.log(myDog, "is", years, "years old");


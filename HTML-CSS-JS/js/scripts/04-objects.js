//////////////////////////////////////
// .? operator when used with objects

let dog = {
    name: "Buddy",
    breed: "Husky"
}

console.log(dog.name)
console.log(dog.age);
try {
console.log(dog.age.toPrecision(1)); // throws TypeError
} catch (e) {
    console.log(e.message)
}
console.log(dog.age?.toPrecision(1)); // returns undefined and stops

/////////////////////////////////////////////////////////////
// prototypes: we can add on to objects adding properties after creation

dog.age = 5.5;
console.log(dog.age);

dog.bark = function() {
    console.log("bark bark")
}

dog.bark();
// console.log("---------keys are:------------")
/////////////////////////////////
// looping over objects
// for (let key in dog) { // use "in" for enumerables like objects
//     console.log(key)
//     console.log(typeof key)
//     let value = dog[key] // string that holds the name of the property can be used to access the propety value using bracket notation
//     console.log(value);
// }

console.log(dog.breed);
console.log(dog["breed"]);
// for (let value of dog) { // use "of" when looping over an iterable (collection or array etc.)
//     console.log(value)

// }

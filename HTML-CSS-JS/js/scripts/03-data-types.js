// JavaScript is not strictly typed
//  - It still has data types

///////////////////
// Primitives
/*
number - 64 bit 
boolean
string
bigint - unlimited accuracy

*/
console.log(typeof 1);
console.log(typeof "1");
console.log(typeof false);



//////////////////
// type cohersion
//  - JavaScript isn't picky about types matching when using operators like + - / %
//    + still is string concatenation
//    / * - % will automatically do type cohersion string to number
console.log("1" - 10);
console.log("1" + 10);
console.log(10 + "1");

console.log("1" % 10);
console.log("1" * 5);




/*
undefined - is automatically stored in variables that have been declared but not assigned a value
null - the intentional absence of a value
*/
let age; // undefined
console.log(age)

age = 5;
let drink = null;
if (age > 21) // undefined > 21 was false
    drink = "something"
console.log(drink);
console.log(typeof drink);
console.log(typeof null);

// null coalescence operator
let name = null; // TypeError: Cannot read properties of null (reading 'toUpperCase')
// let name = "john";
// console.log(name.toUpperCase());

if (name == null)
    console.log("unknown")
else
    console.log(name.toUpperCase());

// shortcut: double question mark operator lets me use a default if the first expression is null
console.log((name ?? "unknown").toUpperCase())

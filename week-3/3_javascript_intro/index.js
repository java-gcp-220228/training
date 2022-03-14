console.log('Hello world');

// JavaScript is a programming language that was initially created in 10 days by Brendan Eich
// Because it was created in 10 days, there's a lot of quirks with the programming language
// There's definitely some strange design choices, especially when it comes to arithmetic

console.log(0 == -0); // true
console.log(1 / 0); // Infinity
console.log(1 / -Infinity); // -0
console.log(1 / Infinity); // 0
console.log(false + true); // 1
console.log(true + true); // 2
console.log(null == undefined); // true
console.log(null === undefined); // false
console.log(5 == '5'); // true
console.log(5 === '5'); // false

/*

    3 Variable declarations:
        1. var
        2. let
        3. const

    There are several datatypes in JS:

        1. number (both a decimal or whole number)
        2. string
        3. object
            - array
            - function
        4. null
        5. undefined
        6. boolean

*/

/*
    JavaScript has a concept called "hoisting".

    Any variable declared with var will be hoisted to the top of its scope. Therefore, a already exists anywhere inside of this global scope, even
    before we wrote the var a = ... line of code

    Variable hoisting was not intended as a conscious design choice. Rather it was an artifact of function hoisting, which is actually useful.
    So besides variables being hoisted, functions are also hoisted.
*/

console.log('a: ' + a); // undefined: an initial value has not yet been assigned for the variable

var a = 'some string';

console.log('a: ' + a);

/*

    JavaScript gets updated all the time. One of the more significant updates to JavaScript happened in 2015 with the introduction of ES6

    Originally, the only way to create a variable was using "var". With ES6, "let" and "const" were also introduced.

    Const is the same as "final" in Java in that once you assign a value to a variable, you can't reassign that variable to another value

    Let and const can utilize "block scope", but var cannot. Also let and const do not leverage hoisting (let and const are not hoisted).

*/

// console.log("b: " + b); // NOT ALLOWED because let variables are not hoisted

let b = "another string";
console.log("b: " + b);

const c = 'hello';
// c = 'hi'; // Can't change the value of c once it has already been given a value

/*
    Object

    Objects in JavaScript are made up of key-value pairs
*/

// obj1 is behaving as a reference variable
let obj1 = {
    "firstName": "Bach",
    "lastName": "Tran",
    "age": 24
}; // This will instantiate a new object with 3 key-value pairs. Here we have the firstName, lastName, and age properties
// It's almost like the new keyword in Java, but we don't need to have a class to instantiate from

// Accessing properties
console.log(obj1.firstName);
console.log(obj1.lastName);
console.log(obj1.age);

let obj2 = obj1; // obj2 is now referring to the same object that obj1 is referring to
obj2.age = 50;

console.log(obj1.age); // 50

// Can you add new properties to an object that is already existing at runtime?
obj1.occupation = "Java Developer";

console.log(obj1);

// let choice = prompt('Select a property you would like to retrieve from the obj1 object: ');

// Lots of code
// if (choice == 'firstName') {
//     console.log(obj1.firstName);
// } else if (choice == 'lastName') {
//     console.log(obj1.lastName);
// } else if (choice == 'age') {
//     console.log(obj1.age);
// }

// Can be done in 1 line
// console.log(obj1[choice]);

// let key = prompt('Choose a name for the key you would like to add: ');
// let value = prompt('Choose a value for the ' + key + ' key: ');

// obj1[key] = value;

// console.log(obj1);

// Ways to create Strings
// 1. '' single quotes
// 2. "" double quotes
// 3. `` template literals

/*
    JSON processing
*/
let myJSON = `{
    "key1": 1,
    "key2": true,
    "key3": "${c}"
}`;

console.log(myJSON);

let obj3 = JSON.parse(myJSON); // Convert a JSON string into a JavaScript object
console.log(obj3);

let myJSON2 = JSON.stringify(obj3); // Convert a JavaScript object into JSON
console.log(myJSON2);


let studentObject = JSON.parse(`{
    "id": 5,
    "firstName": "Bill",
    "lastName": "Rodriguez",
    "age": 25
}`);

console.log(studentObject);

/*
    Truthy/Falsy

    JavaScript like many programming languages has the concept of truthy v. falsy. Java DOES NOT have this concept
*/

// Falsy values:
//  1. empty strings
//  2. 0
//  3. null
//  4. undefined
//  5. NaN
//  6. false

// Falsy
if ('') {
    console.log('An empty string is falsy, so this should not print')
}

// Falsy
if (0) {
    console.log('The value 0 is falsy, so this should not print');
}

// Falsy
if (null) {
    console.log('Null is a falsy value, so this should not print');
}

// Falsy
if (undefined) {
    console.log('Undefined is a falsy value, so this should not print');
}

// Falsy
if (false) {
    console.log('False is a falsy value, so this should not print');
}

// Falsy
if (NaN) {
    console.log('NaN is falsy, so this should not print');
}

// Truthy
if ('abc') {
    console.log('Any non-empty string is truthy, so this should print');
}

// Truthy
if (-100) {
    console.log('Any value that is not 0 is truthy (even negative numbers), so this should print');
}

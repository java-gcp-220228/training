/*

    Scopes

    In JavaScript, we have 3 different available scopes:
        1. Global Scope (var, const, let)
        2. Function Scope (var, const, let)
        3. Block Scope (const, let) (added in ES6, not available w/ the var declaration)

    Besides var not being able to be block scoped, it depends on the context of where a variable is defined in terms of what scope it has

*/

var i = 1000;

for (var i = 0; i < 100; i++) { // var is not block scoped
}

console.log(i); // 100

// =======================

let j = 1000; // global-scoped j

// block-scoped j
for (let j = 0; j < 100; j++) { // j in the for loop is a different variable than j in the global scope
}

console.log(j); // 1000



function myFunc() {
    // k is function scoped
    var k = 100; // Recall that var is hoisted to the top of the scope it is declared in

    console.log(z);
    if (false) {
        var z = 5; // function scoped, NOT block scoped (because var doesn't have block scope)
    }

    z = 200;
    console.log(z);

    if (true) {
        let y = 400; // block-scoped and also not hoisted
        console.log(y);
    }

}

myFunc();


function outer() {

    let x = 1000;

    // Unlike in Java, you can nest functions inside of other functions in JavaScript
    function inner() {
        console.log(x); // I should be able to access variables from the outer function
    }

    inner();
}

outer();

console.log('Type of outer(): ' + typeof(outer))


/*
    Ways of declaring functions in JavaScript:
    1. Named function
            function functionName(...) { }
    2. Anonymous function
            function(...) { }
    3. Arrow function
            (...) => { }
            the 'this' keyword works differently from a named function or anonymous function
*/

function a() {
    console.log('Hi, I am a named function');
}

a();

// b is a reference variable to this anonymous function. b is not the actual name of the function
let b = function() {
    console.log('Hi, I am an anonymous function');
}

b();

// Immediately invoked function expression (IIFE)
// In the past, commonly used to encapsulate var variables so that a file with a bunch of code doesn't get conflicted based on variable names
// vars can at least be function scoped, so you can scope them accordingly to achieve encapsulation
(function() {
    console.log('Hi, I am an anonymous function that is immediately invoked');
})();

// Closures
// From Mozilla: "A closure is the combination of a function bundled together (enclosed) with references to its surrounding state (lexical environment)"
let myFunctions = (function() {

    var x;
    var y;

    function getX() {
        return x;
    }

    function getY() {
        return y;
    }

    function setX(value) {
        x = value;
    }

    function setY(value) {
        y = value;
    }

    // Return an array that contains these 4 functions
    return [ getX, getY, setX, setY ]; // Functions are considered "First-class citizens" in JavaScript unlike in Java
    // a "first-class citizen" is a construct that can be assigned to a variable, passed around as arguments, and returned as values
})();

// Even though the IIFE already returned (and hence you would expect x and y to no longer exist since they were function scoped),
// JavaScript has this idea of closures whereby it maintains the values of x and y for the functions that we have returned in the array
myFunctions[2](10); // setX(10)
myFunctions[3](100); // setY(100)

console.log(myFunctions[0]()); // getX()
console.log(myFunctions[1]()); // getY()

/*
    Arrow functions v. named + anonymous functions (this keyword)
    - The this keyword inside of arrow functions receives its meaning from the scope the arrow function is defined within
        - If the lexical scope of the arrow function is global scope, the this keyword will refer to the `Window` object
        - If the lexical scope of the arrow function is another function, it will receive its meaning from that other functions' this keyword
    - The this keyword inside of named or anonymous functions receives its meaning from whatever object is invoking the method
        - myObj3.someFunction() <- someFunction's this keyword is myObj3
*/
let myObj = {
    'x': 0,
    'y': 0,
            // Anonymous functions (as well as named functions) will use the this keyword based on what is calling the function
    'setX': function(value) { // anonymous function
        this.x = value;
    },
    'setY': function(value) { // anonymous function
        this.y = value;
    }
}

myObj.setX(100);
myObj.setY(1000);

console.log(myObj);

let myObj2 = {
    'x': 0,
    'y': 0
};

// Borrow a function from myObj
myObj2.a = myObj.setX;
myObj2.b = myObj.setY;

myObj2.a(13423); // The purpose of this is to demonstrate that 'this' does not get its meaning from where the function is declared,
// but rather from what is calling that function. So, this could refer to myObj or myObj2
myObj2.b(123);

console.log(myObj2);

// Arrow functions

console.log(this);

let myObj3 = {
    'firstName': 'Bach',
    'greet': () => { // FOR ARROW FUNCTIONS: 
        // An arrow function will use the 'this' keyword from its "lexical" scope
        // Lexically, the scope of this function is global scope
        console.log(this);

        console.log(`${this.firstName} says hi!`);
    }
}

myObj3.greet();

let myObj4 = {
    'firstName': 'Jane',
    'greet': function() { 

        console.log(this);

        // Arrow function being immediately invoked inside the anonymous function
        // This arrow function's lexical scope is the function scope
        let myArrowFunction = () => {
            console.log(`${this.firstName} says hi!`);
        }
        myArrowFunction();

    }
}

myObj4.greet();


// Call, Apply, Bind
// Call is the same as Apply, except for Call takes var-args for the arguments, while Apply takes an array of arguments instead
let myObj5 = {
    'firstName': 'Bill'
}

let myObj6 = {
    'firstName': 'John'
}

function greet(greeting) {
    console.log(`${this.firstName} says ${greeting}!`)
}

// Call
greet.call(myObj5, 'hola');
greet.call(myObj6, 'howdy');

// Apply
greet.apply(myObj5, ['hola']);
greet.apply(myObj6, ['howdy']);

// Bind will permanently bind a function's this keyword to a particular object
function greet2(greeting) {
    console.log(`${this.firstName} says ${greeting}!`)
}

let bindedFunction = greet2.bind(myObj5, 'howdy');

bindedFunction(); // the this keyword here is binded to myObj5
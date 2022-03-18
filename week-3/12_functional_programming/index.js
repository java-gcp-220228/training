// Given an array, increment each element's value by 1

const arr = [1, 2, 3];

console.log(incrementElementsByOne(arr)); // 2, 3, 4


function incrementElementsByOne(arr) {
    const returnArray = [];

    for (let i = 0; i < arr.length; i++) {
        returnArray[i] = arr[i] + 1;
    }

    return returnArray;
}

console.log('hello');


/*
    Pure function
*/
let myNumbers = [11, 12, 13];

// declarative, because we're just declaring that we want for every element in the array
// to be doubled
let newArray = myNumbers.map(num => num * 2); // does not change array in place, creates a new one
console.log(newArray);



let myNumbers2 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

let evenArray = myNumbers2.filter(num => num % 2 == 0);
console.log(evenArray);

let oddArray = myNumbers2.filter(num => num % 2 == 1);
console.log(oddArray);



let arraySum = myNumbers2.reduce((acc, num) => {
    return acc + num;
}, 0);
console.log(arraySum);

//

// Impure because it has side effects (writes to standard out)
function myFunction() {
    console.log('Hello');
}

// Pure
function myFunction2() {
    return 10;
}

// Pure
function add(a, b) {
    return a + b;
}

// Impure
let number = 10;
function subtract(a, b) {
    number = a - b;
    return a - b;
}

// Pure
const z = 10;
function subtractFrom10(a) {
    return z - a;
}
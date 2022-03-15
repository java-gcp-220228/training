// Arrays in JavaScript are different from Arrays in Java in that they:
// 1. Can have different datatypes inside the array
// 2. They can change in size (continuously add elements to a JS array)

let myArr = []; // Instantiate an empty array

let myArr2 = [ 'string 1', 25, { "firstName": "Bach", "lastName": "Tran" } ]; // Creating an array with pre-populated values


// Array operations
// 1. .push(...) add a new element to the end of the array (right)
// 2. .pop() remove an element from the end of the array (right)
// 3. .unshift(...) add a new element to the beginning of the array (left)
// 4. .shift() remove an element from the beginning of the array (left)

myArr.push(10);
myArr.push(25);
myArr.push(-100);
myArr.push(56.7);

for (let i = 0; i < myArr.length; i++) {
    console.log(myArr[i]);
}

// for..of: iterate over the values
// for..in: iterate over the keys

for (let element of myArr) {
    console.log(element);
}

for (let index in myArr) {
    console.log(index);
    console.log(myArr[index]);
}

// for..of v. for..in with objects
let myObj = {
    "firstName": "John",
    "lastName": "Doe",
    "age": 25,
    "favoriteColor": "blue"
}

// for..of only works on "Iterable" objects like Arrays
// for (let i of myObj) {
//     console.log(i);
// }

// "firstName", "lastName", "age", "favoriteColor"
for (let key in myObj) {
    console.log(key);
    console.log(myObj[key]);
}

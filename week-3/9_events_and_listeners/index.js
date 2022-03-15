// Events & Listeners
// Events are usually user interactions that occur within the browser. We can write code that will execute whenever these events occur
// on certain elements

// For example, we have a type of event called the "click" event

// We can add an "event listener" to an element such as a button, which will listen for that event, and when the event occurs, execute a particular function
// that has been defined for that event listener

// querySelector: returns the first element that is found for a particular selector
// querySelectorAll: return an array of elements that were found to match a particular selector
let btn = document.querySelector('button'); // CSS tag name selector

// .addEventListener takes in two arguments (the first is the type of event, and the second is a callback function)
// callback function: a function that is passed as an argument into another function that will be invoked at some point in the future
//      in essence, it is "called" later

// Recall 3 types of functions:
//  1. Arrow
//  2. Anonymous
//  3. Named function

// We can choose to define an event parameter for our callback function
// This event parameter represents an event object that will contain information about that event
// It is especially useful when listening for keypress events and checking what key was actually pressed

// In the case of the click event, you can check the x and y coordinates of the pointer whenever you clicked
// the button, as an example
function whenClickMeButtonIsClicked(event) {
    console.log(event);
    alert('Click me button clicked!');
}

btn.addEventListener('click', whenClickMeButtonIsClicked);

// btn.addEventListener('click', function(event) {
//     alert('Click me button clicked!');
// })

// btn.addEventListener('click', (event) => {
//     alert('Click me button clicked!');
// });

/*
    Event Bubbling & Capturing
*/

let aElement = document.querySelector('#A');
let bElement = document.querySelector('#B');
let cElement = document.querySelector('#C');

// Listening for click event while it is in the bubbling phase
aElement.addEventListener('click', (event) => {
    if (aElement == event.target) {
        alert('A element clicked');
        event.target.style.backgroundColor = 'black';
    }
});

// Listening for click event while it is in the bubbling phase
bElement.addEventListener('click', (event) => {
    if (bElement == event.target) {
        alert('B element clicked');
        event.target.style.backgroundColor = 'black';
    }
});

// Listening for click event while it is in the bubbling phase
cElement.addEventListener('click', (event) => {
    if (cElement == event.target) {
        alert('C element clicked');
        event.target.style.backgroundColor = 'black';
    }
    // event.stopPropagation(); // you can use .stopPropagation on the event object to stop it from continuing to 
    // the next element
});

// ===============================

// Listening for click event while it is in the capturing phase
aElement.addEventListener('click', (event) => {
    if (aElement == event.target) {
        alert('A element clicked');
        event.target.style.backgroundColor = 'black';
    }
}, true);

// Listening for click event while it is in the capturing phase
bElement.addEventListener('click', (event) => {
    if (bElement == event.target) {
        alert('B element clicked');
        event.target.style.backgroundColor = 'black';
    }
}, true);

// Listening for click event while it is in the capturing phase
cElement.addEventListener('click', (event) => {
    if (cElement == event.target) {
        alert('C element clicked');
        event.target.style.backgroundColor = 'black';
    }
}, true);


// // bubbling phase
// document.querySelector('html').addEventListener('click', () => {
//     alert('html element clicked');
// });

// // capturing phase
// document.querySelector('html').addEventListener('click', () => {
//     alert('html element clicked');
// }, true);

// Ways to select elements
// 1. getElementsByTagName
// 2. getElementsByClassName
// 3. getElementsByName
// 4. getElementById
// 5. querySelector <- CSS selectors

let h1Array = document.getElementsByTagName('h1'); // An array of h1 elements
let h1Element = h1Array[0];
// Changing the content of an element
// .innerHTML <- properties (represents the HTML inside of a particular element)
// .innerText <- properties (represents the "rendered" text for an element, ignores spacing and line breaks, etc.)
// .textContent <- properties (represents the text with the line breaks, spaces, etc. included)
h1Element.innerHTML = 'hello world';

let divOne = document.getElementById('one');
divOne.innerText = '<h1>abc</h1>'; 
// innerText will not interpret HTML tags as actual HTML elements on the page, just as plain text
// This is different than innerHTML which does interpret tags as HTML elements

/*
    Appending elements to another element
*/
let pTag = document.createElement('p');
pTag.innerText = 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Optio, rem?';

divOne.appendChild(pTag); // add the p element that was just created to the divOne

/*
    Styling an element
*/
pTag.style.backgroundColor = 'blue'; // CSS property: background-color -> backgroundColor
pTag.style.color = 'white'; // CSS property: color -> color
// pTag.style.borderStyle = 'solid'; // CSS property: border-style -> borderStyle
// pTag.style.borderColor = 'black'; // CSS property: border-color -> borderColor
// pTag.style.borderWidth = '5px'; // CSS property: border-width -> borderWidth
pTag.style.border = '5px solid black';

/*
    Modifying element attributes

    <img src="..." /> <- src attribute
*/
let imgElement = document.createElement('img');
imgElement.setAttribute('src', 'https://www.feroot.com/wp-content/uploads/1200px-Unofficial_JavaScript_logo_2.svg.png');
imgElement.style.width = '100px';

let imageContainerOne = document.querySelector('#two > .image-container');
imageContainerOne.appendChild(imgElement);

let imgElement2 = document.createElement('img');
imgElement2.setAttribute('src', 'https://upload.wikimedia.org/wikipedia/en/thumb/3/30/Java_programming_language_logo.svg/1200px-Java_programming_language_logo.svg.png')
imgElement2.style.width = '100px';

let imageContainerTwo = document.querySelector('#three > .image-container');
imageContainerTwo.appendChild(imgElement2);

/*
    Example of XSS (Cross-site scripting)
    It is a security vulnerability highlighted by the OWASP top 10

    Ways to avoid XSS:
    1. Minimize usage of innerHTML (use innerText) when possible (especially for user input that will be displayed (such as blog posts / social media posts))
    2. Sanitize input (a lot of frontend frameworks like Angular do this automatically)
*/
let blogPost = `<img src="x" onerror='alert("test")' />`;

// Create a new element
let divElement = document.createElement('div');
divElement.innerHTML = blogPost;

// Add the new div into the div with id one
divOne.appendChild(divElement);

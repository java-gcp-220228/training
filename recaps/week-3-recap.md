# Week 3 Recap

## Day 1
- HTML Intro
    - [demo](https://github.com/java-gcp-220228/training/blob/main/week-3/1_html_intro/index.html)
- Boilerplate tags
    - `<!DOCTYPE html>`
    - `html`
    - `head`
    - `body`
- Heading elements
    - [demo](https://github.com/java-gcp-220228/training/blob/main/week-3/1_html_intro/index.html#L9-L14)
- p tag
    - [demo](https://github.com/java-gcp-220228/training/blob/main/week-3/1_html_intro/index.html#L16)
- b v. strong, i v. em
    - [demo](https://github.com/java-gcp-220228/training/blob/main/week-3/1_html_intro/index.html#L18-L21)
- Semantic elements
    - [comments](https://github.com/java-gcp-220228/training/blob/main/week-3/1_html_intro/index.html#L29-L33)
- Tag types
    - Self-closing tags
    - Non-self-closing tags
- Block v. Inline
    - Div (block)
    - Span (inline)
- 3 ways to include CSS
    - [comments](https://github.com/java-gcp-220228/training/blob/main/week-3/2_css_intro/index.html#L109-L113)
    - Inline example
        - [demo](https://github.com/java-gcp-220228/training/blob/main/week-3/2_css_intro/index.html#L123-L124)
    - Internal example
        - [demo](https://github.com/java-gcp-220228/training/blob/main/week-3/2_css_intro/index.html#L10-L103)
    - External example
        - [demo](https://github.com/java-gcp-220228/training/blob/main/week-3/2_css_intro/index.html#L105-L106)
        - [style.css](https://github.com/java-gcp-220228/training/blob/main/week-3/2_css_intro/style.css)
- Class v. Id
    - [comments](https://github.com/java-gcp-220228/training/blob/main/week-3/2_css_intro/index.html#L115-L121)
- HTML v. CSS v. JavaScript
    - [comments](https://github.com/java-gcp-220228/training/blob/main/week-3/3_javascript_intro/index.html#L13-L15)
- Including JS with HTML page
    - [demo](https://github.com/java-gcp-220228/training/blob/main/week-3/3_javascript_intro/index.html#L18)
- JavaScript
    - 3 variable declarations
        - [var, let, const](https://github.com/java-gcp-220228/training/blob/main/week-3/3_javascript_intro/index.js#L20-L23)
    - Datatypes in JS
        - [comments](https://github.com/java-gcp-220228/training/blob/main/week-3/3_javascript_intro/index.js#L27-L34)
    - Hoisting
        - [comments](https://github.com/java-gcp-220228/training/blob/main/week-3/3_javascript_intro/index.js#L38-L46)
        - [accessing the var a variable before declaration line](https://github.com/java-gcp-220228/training/blob/main/week-3/3_javascript_intro/index.js#L48-L50)
    - [let and const (not hoisted)](https://github.com/java-gcp-220228/training/blob/main/week-3/3_javascript_intro/index.js#L66-L71)
    - Objects
        - [example](https://github.com/java-gcp-220228/training/blob/main/week-3/3_javascript_intro/index.js#L80-L101)
    - JSON Processing
        - [turning JSON string into an object example #1](https://github.com/java-gcp-220228/training/blob/main/week-3/3_javascript_intro/index.js#L132-L141)
        - [turning JSON string into an object example #2](https://github.com/java-gcp-220228/training/blob/main/week-3/3_javascript_intro/index.js#L147-L154)
        - [turning object into a JSON string](https://github.com/java-gcp-220228/training/blob/main/week-3/3_javascript_intro/index.js#L143-L144)
    - Truthy v. Falsy
        - [falsy values](https://github.com/java-gcp-220228/training/blob/main/week-3/3_javascript_intro/index.js#L162-L168)
    - Variable scopes
        - [comments](https://github.com/java-gcp-220228/training/blob/main/week-3/4_javascript_scopes_and_functions/index.js#L1-L12)
        - [var issue (since no block scope exists)](https://github.com/java-gcp-220228/training/blob/main/week-3/4_javascript_scopes_and_functions/index.js#L14-L19)
        - [let variable global v. block scope](https://github.com/java-gcp-220228/training/blob/main/week-3/4_javascript_scopes_and_functions/index.js#L23-L29)
        - [function scoped var k](https://github.com/java-gcp-220228/training/blob/main/week-3/4_javascript_scopes_and_functions/index.js#L34-L35)
        - [var z hoisted inside of function](https://github.com/java-gcp-220228/training/blob/main/week-3/4_javascript_scopes_and_functions/index.js#L37-L40)
        - [let y block scoped](https://github.com/java-gcp-220228/training/blob/main/week-3/4_javascript_scopes_and_functions/index.js#L45-L48)
    - Function inside a function
        - [demo](https://github.com/java-gcp-220228/training/blob/main/week-3/4_javascript_scopes_and_functions/index.js#L55-L65)
    - Ways of declaring functions
        - [comments](https://github.com/java-gcp-220228/training/blob/main/week-3/4_javascript_scopes_and_functions/index.js#L72-L81)
        - [named function example](https://github.com/java-gcp-220228/training/blob/main/week-3/4_javascript_scopes_and_functions/index.js#L83-L87)
        - [anonymous function example](https://github.com/java-gcp-220228/training/blob/main/week-3/4_javascript_scopes_and_functions/index.js#L89-L94)
        - [IIFE (immediately invoked function expression)](https://github.com/java-gcp-220228/training/blob/main/week-3/4_javascript_scopes_and_functions/index.js#L96-L101)
    - Closure
        - [demo](https://github.com/java-gcp-220228/training/blob/main/week-3/4_javascript_scopes_and_functions/index.js#L103-L137)
    - `This` keyword behavior (Arrow function v. named + anonymous functions)
        - [comments](https://github.com/java-gcp-220228/training/blob/main/week-3/4_javascript_scopes_and_functions/index.js#L139-L146)
        - [anonymous function defined as values for object properties](https://github.com/java-gcp-220228/training/blob/main/week-3/4_javascript_scopes_and_functions/index.js#L147-L160)
        - [another object borrowing the functions](https://github.com/java-gcp-220228/training/blob/main/week-3/4_javascript_scopes_and_functions/index.js#L164-L175)
        - [arrow function (undefined says hi!)](https://github.com/java-gcp-220228/training/blob/main/week-3/4_javascript_scopes_and_functions/index.js#L179-L194)
        - [arrow function inside an anonymous function (Jane says hi!)](https://github.com/java-gcp-220228/training/blob/main/week-3/4_javascript_scopes_and_functions/index.js#L196-L212)
    - Call, Apply, and Bind
        - [demo](https://github.com/java-gcp-220228/training/blob/main/week-3/4_javascript_scopes_and_functions/index.js#L215-L244)

# Questions
* What is HTML?
* When you create an HTML file, what are some of the important boilerplate tags?
* What are some elements you may use on a webpage?
* What are semantic v. non-semantic elements?
* What is the difference between a div and a span element?
* What is a block v. inline element?
* What are 3 ways of including CSS on a webpage?
* What is the difference between a class and id in HTML?
* Describe the difference between HTML, CSS, and JavaScript
* How do you include a .js file to an HTML webpage?
* What are the 3 ways of declaring variables? How are they each different from each other?
* What are the datatypes in JavaScript?
* What is the difference between == and ===?
* What is hoisting?
* Describe an object in JavaScript?
* How do you create an object in JS?
* What are the Falsy values in JS?
* What variable scopes exist in JS?
* Which variable scope was added in JS? What variable declarations support this scope? Which one does not?
* What are 3 ways of declaring functions in JS?
* What are closures?
* How does an arrow function get the meaning of the `this` differently than a named or anonymous function?
* What is call, apply, and bind used for?
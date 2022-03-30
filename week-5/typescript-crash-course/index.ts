/* All JavaScript is valid TypeScript because TypeScript is a superset of JavaScript */

console.log('hello world');

/*

    JS Datatypes:
    1. string
    2. null
    3. boolean
    4. object
    5. undefined
    6. number

    TS Datatypes:
    1. any (a variable of type any can take on any value)
    2. void (this is specifically for the return type of a function, if it doesn't return anything)

    Within TypeScript, we can provide types for our variables
    TypeScript is basically a strongly typed version of JS

    When we transpile from TS to JS, we are able to catch issues early on regarding
    the potential mis-assignment of values of different types to different variables
    It's all about maintaining consistency in what datatype a variable can hold

    TypeScript simply makes our lives easier as developers

    Because TypeScript is commonly used in many code editors such as VSCode, we
    can make use of intellisense features and error linting

*/

let a: string;
a = 'hi there!';
console.log(a);

function myFunction() {
    let i: number = 10; // function scoped

    if (true) {
        let i: number = 100; // block scoped

        console.log(i);
    }
}

// Type inferencing
let b = 'Another string'; // string
// If you declare a variable and assign it a value on the same line,
// the variable will automatically have the type of that value
// In other words, b must always correspond to storing a string

// b = 100; // Not possible!!!!

let c; // any
c = 'hello';
c = 100;
c = {};
c = 'world';

let d: any = 'hello';
d = 20;

let e: boolean | string = true; // e can store either a boolean or string
e = 'test';

/*
    Functions

    TypeScript adds
    - Parameter types
    - Return types
*/
myFunc('abcdef');
function myFunc(a: string): boolean { // types for parameters and return type of boolean
    return a.startsWith("abc");
}

printSum(5, 7);
function printSum(a: number, b: number): void {
    console.log(a + b);
}

function sum(a: number, b: number): number {
    return a + b;
}

/*
    Objects
*/
let person =  {
    'firstName': 'Jane',
    'lastName': 'Doe',
    'age': 20
} // type inferencing

// The type of person is { firstName: string, lastName: string, age: number }

person = { 
    'firstName': 'John',
    'lastName': 'Doe',
    'age': 30
}


function printPersonDetails1(p: { firstName: string, lastName: string, age: number }): void {
    console.log(`The person's name is ${p.firstName} ${p.lastName} and they are ${p.age} years old`)
}

printPersonDetails1({ 'firstName': 'Bach', 'lastName': 'Tran', 'age': 24 });


/*
    Interfaces
    - Added in TS (does not exist in JS)
    - If we have a lot of properties for the objects that we would like to define types for,
    we can create an interface that defines all of the properties and the types of those properties
*/
interface Organism {
    age: number;
}

interface Person extends Organism { // Not to be confused with concepts of Java interfaces, which are totally different
    firstName: string,
    lastName: string,
}

let p: Person = {
    'firstName': 'Tom',
    'lastName': 'Rodriguez',
    'age': 41
}

let o: Organism = p;
console.log(o.age);

printPersonDetails2(p);
function printPersonDetails2(person: Person): void {
    console.log(`The person's name is ${person.firstName} ${person.lastName} and they are ${person.age} years old`)
}

/*
    Arrays

    <type>[] to indicate an array of a particular type
*/

let myNumbers: number[] = [];
myNumbers.push(10);
myNumbers.push(12);

let myPeople: Person[] = [];
myPeople.push(p);
myPeople.push(person);

/*
    JavaScript does have classes as well

    They are pretty similar to each other

    TypeScript does add, however, the idea of access modifiers

    public: we can access the property outside of the class
    private: we can only access from within the class
    protected: we can only access within the class or subclasses

    -> If you leave off a keyword (unlike in Java), it will be public
*/

class Animal {
    age: number; // by default, it is public

    constructor(age: number) {
        this.age = age;
    }
}

let a1 = new Animal(3); // a1 is of type Animal because of type inferencing

class Dog extends Animal {

    private name: string;

    constructor(name: string, age: number) {
        super(age);
        this.name = name;
    }

    makeNoise() { // public
        console.log(`${this.name}: bark!`);
    }

    getName() { // public
        return this.name;
    }
}

let d1 = new Dog('Fido', 4);
d1.makeNoise();
console.log(d1.getName());



/* 
    Constructor + property declaration shorthand
*/
class Rectangle {
    constructor(public width: number, public height: number) {}
}

let r = new Rectangle(10, 20);
console.log(r.width);
console.log(r.height);

// V.s. the long way
/*

class Rectangle {

    public width: number;
    public height: number;

    constructor(width: number, height: number) {
        this.width = width;
        this.height = height;
    }

}

*/

/*

    Generics: parameterized types

*/

// class generics
// This class isn't really useful, it's just to demonstrate how the class generics work
class MyWrapper<T> {
    value: T;

    constructor(value: T) {
        this.value = value;
    }
}

let numberWrapper = new MyWrapper<number>(100);
let stringWrapper = new MyWrapper<string>('hello');

// function generics
function myFunc2<T>(value: T): T[] {
    return [ value ];
} // this function takes a single and places it into an array that we return



/*

    Decorators are something you will see all the time in Angular
    @Component
    @NgModule

    Decorators look similar to annotations in Java, but they work significantly differently behind the scenes

    But, in both cases (decorators + Java annotations), they are used to add additional information

*/

// Decorators are really just functions in JavaScript
// the target represents whatever you place the decorator on top of
const MyDecorator = (target: any) => {
    console.log(target);
}

@MyDecorator
class SomeClass {
}
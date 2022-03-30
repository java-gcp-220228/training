/* All JavaScript is valid TypeScript because TypeScript is a superset of JavaScript */
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
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
var a;
a = 'hi there!';
console.log(a);
function myFunction() {
    var i = 10; // function scoped
    if (true) {
        var i_1 = 100; // block scoped
        console.log(i_1);
    }
}
// Type inferencing
var b = 'Another string'; // string
// If you declare a variable and assign it a value on the same line,
// the variable will automatically have the type of that value
// In other words, b must always correspond to storing a string
// b = 100; // Not possible!!!!
var c; // any
c = 'hello';
c = 100;
c = {};
c = 'world';
var d = 'hello';
d = 20;
var e = true; // e can store either a boolean or string
e = 'test';
/*
    Functions

    TypeScript adds
    - Parameter types
    - Return types
*/
myFunc('abcdef');
function myFunc(a) {
    return a.startsWith("abc");
}
printSum(5, 7);
function printSum(a, b) {
    console.log(a + b);
}
function sum(a, b) {
    return a + b;
}
/*
    Objects
*/
var person = {
    'firstName': 'Jane',
    'lastName': 'Doe',
    'age': 20
}; // type inferencing
// The type of person is { firstName: string, lastName: string, age: number }
person = {
    'firstName': 'John',
    'lastName': 'Doe',
    'age': 30
};
function printPersonDetails1(p) {
    console.log("The person's name is ".concat(p.firstName, " ").concat(p.lastName, " and they are ").concat(p.age, " years old"));
}
printPersonDetails1({ 'firstName': 'Bach', 'lastName': 'Tran', 'age': 24 });
var p = {
    'firstName': 'Tom',
    'lastName': 'Rodriguez',
    'age': 41
};
var o = p;
console.log(o.age);
printPersonDetails2(p);
function printPersonDetails2(person) {
    console.log("The person's name is ".concat(person.firstName, " ").concat(person.lastName, " and they are ").concat(person.age, " years old"));
}
/*
    Arrays

    <type>[] to indicate an array of a particular type
*/
var myNumbers = [];
myNumbers.push(10);
myNumbers.push(12);
var myPeople = [];
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
var Animal = /** @class */ (function () {
    function Animal(age) {
        this.age = age;
    }
    return Animal;
}());
var a1 = new Animal(3); // a1 is of type Animal because of type inferencing
var Dog = /** @class */ (function (_super) {
    __extends(Dog, _super);
    function Dog(name, age) {
        var _this = _super.call(this, age) || this;
        _this.name = name;
        return _this;
    }
    Dog.prototype.makeNoise = function () {
        console.log("".concat(this.name, ": bark!"));
    };
    Dog.prototype.getName = function () {
        return this.name;
    };
    return Dog;
}(Animal));
var d1 = new Dog('Fido', 4);
d1.makeNoise();
console.log(d1.getName());
/*
    Constructor + property declaration shorthand
*/
var Rectangle = /** @class */ (function () {
    function Rectangle(width, height) {
        this.width = width;
        this.height = height;
    }
    return Rectangle;
}());
var r = new Rectangle(10, 20);
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
var MyWrapper = /** @class */ (function () {
    function MyWrapper(value) {
        this.value = value;
    }
    return MyWrapper;
}());
var numberWrapper = new MyWrapper(100);
var stringWrapper = new MyWrapper('hello');
// function generics
function myFunc2(value) {
    return [value];
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
var MyDecorator = function (target) {
    console.log(target);
};
var SomeClass = /** @class */ (function () {
    function SomeClass() {
    }
    SomeClass = __decorate([
        MyDecorator
    ], SomeClass);
    return SomeClass;
}());

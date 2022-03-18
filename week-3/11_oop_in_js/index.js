// 1st way of creating an object
//      Object literals {}: you are actually instantiating an object
let person1 = {
    "firstName": "Bach",
    "lastName": "Tran",
    "greet": function() {
        console.log(`${this.firstName} ${this.lastName} says hi!`);
    }
};

let person2 = {
    "firstName": "Jane",
    "lastName": "Doe",
    "greet": function() {
        console.log(`${this.firstName} ${this.lastName} says hi!`);
    }
}

person1.greet();
person2.greet();

// 2nd way of creating objects
//    new keyword
//    new <function constructor>

// Function constructor (pre-ES6)
function Person(firstName, lastName) {
    this.firstName = firstName;
    this.lastName = lastName;

    // Remember that functions are actually objects in JS. So, for every Person object that you construct,
    // you will have the same number of function instances being created
    // The below is therefore a waste of memory. Why not just have one copy of this function somewhere?
    // SOLUTION: prototypal inheritance
    // this.greet = function() {
    //     console.log(`${this.firstName} ${this.lastName} says hi!`);
    // }
}

// In this case, only one instance of the function exists, therefore saving memory
// All of the properties defined inside the "prototype" object belonging to the function constructor will be
// inherited by objects created from that function constructor
Person.prototype.greet = function() {
    console.log(`${this.firstName} ${this.lastName} says hi!`);
}

Person.prototype.printPersonInfo = function() {
    console.log(`firstName: ${this.firstName}, lastName: ${this.lastName}`);
}

let person3 = new Person('John', 'Doe');
person3.greet();
person3.printPersonInfo();

let person4 = new Person('Bill', 'Jones');
person4.greet();
person4.printPersonInfo();

console.log(person3);
console.log(person4);

// 3rd way of creating objects
//      new keyword
//      new <class>

// Classes were introduced in ES6. They are essentially "syntactic sugar", which means that it's just syntax that in reality
// simply "sugarcoats" something else. Classes in JS are not really true classes, it's still using prototypal inheritance
// and function constructors under the hood
class Car {

    constructor(make, model, year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    printCarInfo() {
        console.log(`The car is a ${this.year} ${this.make} ${this.model}`)
    }

}

let car1 = new Car('Toyota', 'Supra', 1994);
car1.printCarInfo();

let car2 = new Car('BMW', '330i', 2019);
car2.printCarInfo();


class Rectangle {
    constructor(width, height) {
        this._width = width;
        this._height = height;
    }

    get area() {
        console.log('Invoking the area getter');
        return this._width * this._height;
    }

    set width(width) {
        console.log('width setter invoked')
        this._width = width;
    }

    set height(height) {
        console.log('height setter invoked')
        this._height = height;
    }
}

let rectangle1 = new Rectangle(10, 20); // 2 properties: _width and _height
console.log(rectangle1.area); // since I defined the area() function as a getter, it behaves as if it were a property

rectangle1.width = 25; // rectangle1.width(25)
rectangle1.height = 30; // rectangle1.height(30)

console.log(rectangle1.area); // rectangle1.area()

/*

    Inheritance without function constructors OR classes

*/
let parentObj = {
    methodA: function() {
        console.log(`The value of a is ${this.a}`);
    },
    methodB: function() {
        console.log(`The value of b is ${this.b}`);
    }
}

let childObj = {
    "a": 1,
    "b": 2
}

// The __proto__ property of an object refers to the object that you are inheriting the properties of
childObj.__proto__ = parentObj; // inherit from parentObj

childObj.methodA();
childObj.methodB();


// Object.create()

let childObj2 = Object.create(parentObj);

childObj2.a = 1000;
childObj2.b = 2000;

childObj2.methodA();
childObj2.methodB();
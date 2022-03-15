let btn = document.querySelector('#btn');
btn.addEventListener('click', retrievePokemonInformation_asyncAwait); // Web APIs

// Web APIs
// every 1000 milliseconds, place the callback function into the message queue
setInterval(() => {
    console.log('hi');
}, 1000)

// After 10000 milliseconds, place the callback function ONCE into the message queue
setTimeout(() => {
    console.log('hello')
}, 10000);

function retrievePokemonInformation_traditionalPromiseHandling() {
    let inputElement = document.querySelector('#pokemon-id');
    
    let id = inputElement.value;
    let url = `https://pokeapi.co/api/v2/pokemon/${id}`;


    // The fetch API returns a promise
    //
    // Promises were introduced in ES6 (ES 2015)
    // 
    // A promise represents a future value that may or may not come
    //      Initially, a promise will be in the pending state
    //      
    //      Eventually, the promise will move on to either fulfilled or rejected      
    //
    //      1. Fulfilled: you do get back a value (operation succeeded)
    //      2. Rejected: you don't get back a value (operation failed)
    //
    //      You supply two callback functions: one that executes if the Promise is fulfilled
    //      and one that executes if the promise is rejected

    fetch(url, {
        'method': 'GET'
    }).then((res) => {
        console.log('response received');
        return res.json();
    }).then((pokemon) => {
        console.log('JSON converted into JS object')

        let id = pokemon.id;
        let name = pokemon.name;
        let imageUrl = pokemon.sprites.front_default;

        insertPokemonIntoTable(id, name, imageUrl);

    }).catch((err) => {
        console.log(err);
    });

    console.log('Invoked fetch()');
}

// Async-await was introduced in ES7 (ES 2016)
// An async function will run line by line, and be put on hold whenever it reaches an "await" line
// At this point, if the promise is not yet fulfilled, it will exit the async function to run other code
// that is necessary to be run
// Whenever the promise is fulfilled, the async function will start executing again to the subsequent lines
async function retrievePokemonInformation_asyncAwait() {
    let inputElement = document.querySelector('#pokemon-id');
    
    let id = inputElement.value;
    let url = `https://pokeapi.co/api/v2/pokemon/${id}`;

    try {
        let res = await fetch(url, {
            'method': 'GET'
        }); // await for the promise to be fulfilled and get the value from the promise
        console.log('retrieved response');

        let pokemon = await res.json(); // await for the promise to be fulfilled and get the value from the promise
        console.log('converted JSON into JS object');

        let pokemonId = pokemon.id;
        let name = pokemon.name;
        let imageUrl = pokemon.sprites.front_default;

        insertPokemonIntoTable(pokemonId, name, imageUrl);
    } catch (err) { 
        // if the promise you are awaiting is rejected, then enter the catch block and print out the rejection value
        console.log(err);
    }
    
    console.log('done with inserting pokemon');
}

function insertPokemonIntoTable(id, name, imageUrl) {
    let pokemonTable = document.querySelector('#pokemon-table');
    let pokemonTableTbody = pokemonTable.querySelector('tbody');

    let tr = document.createElement('tr');

    let td1 = document.createElement('td');
    td1.innerText = id;

    let td2 = document.createElement('td');
    td2.innerText = name;

    let td3 = document.createElement('td');
    let imgElement = document.createElement('img');
    imgElement.setAttribute('src', imageUrl);
    td3.appendChild(imgElement);

    tr.appendChild(td1);
    tr.appendChild(td2);
    tr.appendChild(td3);

    pokemonTableTbody.appendChild(tr);
}
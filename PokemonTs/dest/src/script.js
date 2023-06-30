var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
const API = "https://pokeapi.co/api/v2/pokemon?limit=50";
let POKEMONS = [];
let POKEMONS_DETAILS = [];
const pokemonContainerEl = document.querySelector(".pokemon-container");
const searchEl = document.querySelector(".search");
//Fetches All Pokemons
function getPokemons() {
    return __awaiter(this, void 0, void 0, function* () {
        //If LocalStorage Does Not Exist
        if (!localStorageExists('pokemons')) {
            //Fetch Pokemons
            const response = yield fetch(API);
            const pokemons = yield response.json();
            POKEMONS = pokemons.results;
            //Set LocalStorage
            localStorage.setItem('pokemons', JSON.stringify(POKEMONS));
        }
        else {
            //Fetch Pokemons From LocalStorage
            POKEMONS = JSON.parse(localStorage.getItem('pokemons'));
        }
        //Fetch Pokemons Details
        getPokemonsDetails(POKEMONS);
    });
}
//Fetches Pokemon Details
function getPokemonsDetails(pokemons) {
    return __awaiter(this, void 0, void 0, function* () {
        //If LocalStorage Does Not Exist
        if (!localStorageExists('pokemons-details')) {
            //Loop Pokemons Array
            for (const pokemon of pokemons) {
                //Fetch Pokemon Detail
                const response = yield fetch(pokemon.url);
                const data = yield response.json();
                //Extract values
                const { id, name, order, height, sprites: { front_default: image } } = data;
                //Push to Array
                POKEMONS_DETAILS.push({ id, name, order, height, image });
            }
            //Create LocalStorage
            localStorage.setItem('pokemons-details', JSON.stringify(POKEMONS_DETAILS));
        }
        else {
            //Fetch Pokemons Details From LocalStorage
            POKEMONS_DETAILS = JSON.parse(localStorage.getItem('pokemons-details'));
        }
        //Create Pokemon DOM
        createPokemonDOM(POKEMONS_DETAILS);
    });
}
//Creates HTML DOM
function createPokemonDOM(pokemons) {
    //Loop Pokemons
    pokemons.forEach(pokemon => {
        //Create Element
        const pokemonEl = document.createElement('div');
        pokemonEl.classList.add('pokemon');
        //Inside Pokemon Element
        const html = `
          <h4 class="name">${pokemon.name}</h4>
          <button class="btn delete " data-name="${pokemon.name}">X</button>
          <img src="${pokemon.image}" class="image">
        `;
        //Append to Pokemon Element
        pokemonEl.innerHTML = html;
        //Append to Pokemon Container
        pokemonContainerEl === null || pokemonContainerEl === void 0 ? void 0 : pokemonContainerEl.appendChild(pokemonEl);
        const deleteBtn = pokemonEl.querySelector(".delete");
        deleteBtn === null || deleteBtn === void 0 ? void 0 : deleteBtn.addEventListener("click", (e) => {
            const name = e.target.dataset.name;
            deletePokemon(name);
            pokemonEl.remove();
        });
        const imageEl = pokemonEl.querySelector(".image");
        imageEl === null || imageEl === void 0 ? void 0 : imageEl.addEventListener("click", () => {
            window.location.href = `src/details/pokemon-details.html?id=${pokemon.id}`;
        });
    });
}
//Checks If LocalStorage Exists
function localStorageExists(key) {
    return localStorage.getItem(key) !== null;
}
//Fetch All Pokemons
getPokemons();
//Filters Pokemons On Search Change
searchEl === null || searchEl === void 0 ? void 0 : searchEl.addEventListener('input', e => {
    //Get Value From Search Input
    const searchValue = e.target.value.trim().toLowerCase();
    //Filter Pokemons By Name
    const filteredPokemons = POKEMONS_DETAILS.filter((pokemon) => {
        return pokemon.name.trim().toLowerCase().includes(searchValue);
    });
    //Empty PokemonContainer First
    pokemonContainerEl.innerHTML = "";
    createPokemonDOM(filteredPokemons);
});
//Deletes Pokemon By Name
function deletePokemon(name) {
    //Filters Array And Removes Matching Name From POKEMONS
    POKEMONS = POKEMONS.filter(pokemon => {
        return pokemon.name != name;
    });
    //Filters Array And Removes Matching Name From POKEMONS_DETAILS
    POKEMONS_DETAILS = POKEMONS_DETAILS.filter(pokemon => {
        return pokemon.name != name;
    });
    //Update LocalStorage
    localStorage.setItem('pokemons', JSON.stringify(POKEMONS));
    localStorage.setItem('pokemons-details', JSON.stringify(POKEMONS_DETAILS));
}
export {};

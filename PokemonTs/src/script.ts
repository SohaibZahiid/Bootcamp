import IPokemon from "../interfaces/Pokemon";
import IPokemonDetails from "../interfaces/PokemonDetail"

const API: string = "https://pokeapi.co/api/v2/pokemon?limit=50";
let POKEMONS: IPokemon[] = []
let POKEMONS_DETAILS: IPokemonDetails[] = []

const pokemonContainerEl = document.querySelector(".pokemon-container");
const searchEl = document.querySelector(".search");

//Fetches All Pokemons
async function getPokemons() {
    //If LocalStorage Does Not Exist
    if (!localStorageExists('pokemons')) {
        //Fetch Pokemons
        const response = await fetch(API)
        const pokemons = await response.json()
        POKEMONS = <IPokemon[]>pokemons.results
        //Set LocalStorage
        localStorage.setItem('pokemons', JSON.stringify(POKEMONS))
    } else {
        //Fetch Pokemons From LocalStorage
        POKEMONS = JSON.parse(localStorage.getItem('pokemons')!)
    }
    //Fetch Pokemons Details
    getPokemonsDetails(POKEMONS)


}

//Fetches Pokemon Details
async function getPokemonsDetails(pokemons: IPokemon[]) {
    //If LocalStorage Does Not Exist
    if (!localStorageExists('pokemons-details')) {
        //Loop Pokemons Array
        for (const pokemon of pokemons) {
            //Fetch Pokemon Detail
            const response = await fetch(pokemon.url)
            const data = await response.json()
            //Extract values
            const { id, name, order, height, sprites: { front_default: image } } = data
            //Push to Array
            POKEMONS_DETAILS.push({ id, name, order, height, image } as IPokemonDetails)
        }
        //Create LocalStorage
        localStorage.setItem('pokemons-details', JSON.stringify(POKEMONS_DETAILS))
    } else {
        //Fetch Pokemons Details From LocalStorage
        POKEMONS_DETAILS = JSON.parse(localStorage.getItem('pokemons-details')!)
    }
    //Create Pokemon DOM
    createPokemonDOM(POKEMONS_DETAILS)

}

//Creates HTML DOM
function createPokemonDOM(pokemons: IPokemonDetails[]) {
    //Loop Pokemons
    pokemons.forEach(pokemon => {
        //Create Element
        const pokemonEl = document.createElement('div')
        pokemonEl.classList.add('pokemon')
        //Inside Pokemon Element
        const html = `
          <h4 class="name">${pokemon.name}</h4>
          <button class="btn delete " data-name="${pokemon.name}">X</button>
          <img src="${pokemon.image}" class="image">
        `;
        //Append to Pokemon Element
        pokemonEl.innerHTML = html;
        //Append to Pokemon Container
        pokemonContainerEl?.appendChild(pokemonEl)

        const deleteBtn = pokemonEl.querySelector(".delete");
        deleteBtn?.addEventListener("click", (e) => {
            const name = (e.target as HTMLDataElement).dataset.name;
            deletePokemon(name!);
            pokemonEl.remove()
        });

        const imageEl = pokemonEl.querySelector(".image");
        imageEl?.addEventListener("click", () => {
            window.location.href = `src/details/pokemon-details.html?id=${pokemon.id}`;
        });

    })
}

//Checks If LocalStorage Exists
function localStorageExists(key: string) {
    return localStorage.getItem(key) !== null;
}

//Fetch All Pokemons
getPokemons()

//Filters Pokemons On Search Change
searchEl?.addEventListener('input', e => {
    //Get Value From Search Input
    const searchValue = (e.target as HTMLInputElement).value.trim().toLowerCase();
    //Filter Pokemons By Name
    const filteredPokemons = POKEMONS_DETAILS.filter((pokemon: IPokemonDetails) => {
        return pokemon.name.trim().toLowerCase().includes(searchValue)
    })
    //Empty PokemonContainer First
    pokemonContainerEl!.innerHTML = ""
    createPokemonDOM(filteredPokemons)
    
})

//Deletes Pokemon By Name
function deletePokemon(name: string) {
    //Filters Array And Removes Matching Name From POKEMONS
    POKEMONS = POKEMONS.filter(pokemon => {
        return pokemon.name != name
    })
    //Filters Array And Removes Matching Name From POKEMONS_DETAILS
    POKEMONS_DETAILS = POKEMONS_DETAILS.filter(pokemon => {
        return pokemon.name != name
    })
    //Update LocalStorage
    localStorage.setItem('pokemons', JSON.stringify(POKEMONS))
    localStorage.setItem('pokemons-details', JSON.stringify(POKEMONS_DETAILS))
    
    
}
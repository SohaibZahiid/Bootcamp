window.addEventListener("DOMContentLoaded", () => {
    const API = "https://pokeapi.co/api/v2/pokemon?limit=50";

    const pokemonContainerEl = document.querySelector(".pokemon-container");
    const searchEl = document.querySelector(".search");

    const getPokemons = async () => {
        try {
            const response = await fetch(API);
            const data = await response.json();
            const pokemons = data.results;

            for (const pokemon of pokemons) {
                const pokemonDetails = await fetchPokemonDetails(pokemon.url);
                const pokemonEl = createPokemonElement(
                    pokemonDetails.id,
                    pokemon.name,
                    pokemonDetails.sprites.front_default
                );
                pokemonContainerEl.appendChild(pokemonEl);
                addPokemonClickListener(pokemonEl, pokemonDetails.id);
            }
        } catch (err) {
            console.log(err);
        }
    };

    const fetchPokemonDetails = async (url) => {
        try {
            const response = await fetch(url);
            const data = await response.json();
            return data;
        } catch (err) {
            throw new Error("Failed to fetch Pokémon details");
        }
    };

    const createPokemonElement = (id, name, image) => {
        const pokemonEl = document.createElement("div");
        pokemonEl.classList.add("pokemon");
        pokemonEl.setAttribute("data-id", id);

        const html = `
            <h4 class="name">${name}</h4>
            <img src="${image}" alt="" class="image">
        `;
        pokemonEl.innerHTML = html;

        return pokemonEl;
    };

    const addPokemonClickListener = (pokemonEl, pokemonId) => {
        pokemonEl.addEventListener("click", () => {
            window.location.href = `pokemon-details.html?id=${pokemonId}`;
        });
    };

    searchEl.addEventListener("input", async (e) => {
        const searchValue = e.target.value.trim().toLowerCase();

        if (searchValue) {
            try {
                const pokemonDetails = await fetchPokemonDetails(
                    `https://pokeapi.co/api/v2/pokemon/${searchValue}`
                );

                pokemonContainerEl.innerHTML = "";

                const pokemonEl = createPokemonElement(
                    pokemonDetails.id,
                    pokemonDetails.name,
                    pokemonDetails.sprites.front_default
                );
                pokemonContainerEl.appendChild(pokemonEl);
                addPokemonClickListener(pokemonEl, pokemonDetails.id);
            } catch (err) {
                console.log(err.message);
            }
        } else {
            getPokemons();
        }
    });

    getPokemons();
});


























// window.addEventListener("DOMContentLoaded", () => {
//     const API = "https://pokeapi.co/api/v2/pokemon?limit=50";

//     let pokemonContainerEl = document.querySelector(".pokemon-container");
//     const searchEl = document.querySelector(".search");

//     const getPokemons = () => {
//         fetch(API)
//             .then((res) => res.json())
//             .then((pokemons) => {
//                 pokemons.results.forEach((pokemon) => {
//                     fetch(pokemon.url)
//                         .then((res) => res.json())
//                         .then((p) => {
//                             const pokemonEl = createPokemon(
//                                 p.id,
//                                 pokemon.name,
//                                 p.sprites.front_default
//                             );
//                             pokemonContainerEl.appendChild(pokemonEl);
//                             addPokemonClickListener(pokemonEl, p.id);
//                         });
//                 });
//             })
//             .catch((err) => console.log(err));
//     };

//     const createPokemon = (id, name, image) => {
//         const pokemonEl = document.createElement("div");
//         pokemonEl.classList.add("pokemon");
//         pokemonEl.setAttribute("data-id", id);

//         const html = `
//         <h4 class="name">${name}</h4>
//         <img src="${image}" alt="" class="image">
//         `;
//         pokemonEl.innerHTML = html;

//         return pokemonEl;
//     };

//     const addPokemonClickListener = (pokemonEl, pokemonId) => {
//         pokemonEl.addEventListener("click", () => {
//             //   const pokemonId = pokemonEl.getAttribute("data-id");
//             //   fetch(`https://pokeapi.co/api/v2/pokemon/${pokemonId}`)
//             //   .then(res => res.json())
//             //   .then(data => {
//             //     console.log(data);
//             //   })

//             window.location.href = `pokemon-details.html?id=${pokemonId}`;
//         });
//     };

//     getPokemons();

//     searchEl.addEventListener("input", (e) => {
//         if (e.target.value) {
//             const input = e.target.value.toLowerCase();
//             fetch(`https://pokeapi.co/api/v2/pokemon/${input}`)
//                 .then((res) => res.json())
//                 .then((p) => {
//                     if (p) {
//                         pokemonContainerEl.innerHTML = "";
//                         const pokemonEl = createPokemon(
//                             p.id,
//                             p.name,
//                             p.sprites.front_default
//                         );
//                         pokemonContainerEl.appendChild(pokemonEl);
//                         addPokemonClickListener(pokemonEl, p.id);
//                     } else {
//                         return
//                     }
//                 }).catch((err) => {
//                     console.log(err.message);
//                 });
//         } else {
//             getPokemons()
//         }
//     });
// });

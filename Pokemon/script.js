window.addEventListener("DOMContentLoaded", () => {
    const API = "https://pokeapi.co/api/v2/pokemon?limit=50";

    const pokemonContainerEl = document.querySelector(".pokemon-container");

    let pokemonDetails;

    const getPokemons = () => {
        fetch(API)
            .then((res) => res.json())
            .then((pokemons) => {
                pokemons.results.forEach((pokemon) => {
                    fetch(pokemon.url)
                        .then((res) => res.json())
                        .then((p) => {
                            const pokemonEl = createPokemon(
                                p.id,
                                pokemon.name,
                                p.sprites.front_default
                            );
                            pokemonContainerEl.appendChild(pokemonEl);
                            addPokemonClickListener(pokemonEl, p.id);
                        });
                });
            })
            .catch((err) => console.log(err));
    };

    const createPokemon = (id, name, image) => {
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
            //   const pokemonId = pokemonEl.getAttribute("data-id");
            //   fetch(`https://pokeapi.co/api/v2/pokemon/${pokemonId}`)
            //   .then(res => res.json())
            //   .then(data => {
            //     console.log(data);
            //   })

            window.location.href = `pokemon-details.html?id=${pokemonId}`;
        });
    };

    getPokemons();
});

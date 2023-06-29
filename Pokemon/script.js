window.addEventListener("DOMContentLoaded", () => {
    const API = "https://pokeapi.co/api/v2/pokemon?limit=50";
    let ALL_POKEMONS = JSON.parse(localStorage.getItem('pokemons')) || [];
    let ALL_POKEMONS_DETAILS = JSON.parse(localStorage.getItem('pokemons-details')) || [];
    let CURRENT_PAGE = 1;
    const ITEMS_PER_PAGE = 8;

    const pokemonContainerEl = document.querySelector(".pokemon-container");
    const searchEl = document.querySelector(".search");
    const ul = document.querySelector("ul");

    const deletePokemon = (id) => {
        ALL_POKEMONS = ALL_POKEMONS.filter((p) => p.id != id);
        ALL_POKEMONS_DETAILS = ALL_POKEMONS_DETAILS.filter(p => p.id != id)
        localStorage.setItem("pokemons", JSON.stringify(ALL_POKEMONS));
        localStorage.setItem("pokemons-details", JSON.stringify(ALL_POKEMONS_DETAILS));

        paginatePokemons();
    };

    const paginatePokemons = () => {
        pokemonContainerEl.innerHTML = "";

        const startIndex = (CURRENT_PAGE - 1) * ITEMS_PER_PAGE;
        const endIndex = startIndex + ITEMS_PER_PAGE;

        const paginatedPokemons = ALL_POKEMONS_DETAILS.slice(
            startIndex,
            endIndex
        );

        paginatedPokemons.forEach(async (pokemon) => {
            const pokemonDetails = ALL_POKEMONS_DETAILS.find(
                (p) => p.id === pokemon.id
            );

            if (pokemonDetails) {
                const pokemonEl = createPokemonDOM(
                    pokemonDetails.id,
                    pokemonDetails.name,
                    pokemonDetails.image
                );
                pokemonContainerEl.appendChild(pokemonEl);
            } else {
                await getPokemonDetails(pokemon);
            }
        });

        generatePaginationButtons();
    };

    const generatePaginationButtons = () => {
        ul.innerHTML = "";

        const totalPages = Math.ceil(ALL_POKEMONS.length / ITEMS_PER_PAGE);

        let li = "";

        if (CURRENT_PAGE > 1) {
            li += `<li class="btn prev"><i class="fas fa-angle-left"></i></li>`;
        }

        for (let page = 1; page <= totalPages; page++) {
            const liActive = page === CURRENT_PAGE ? "active" : "";
            li += `<li class="num ${liActive} specButton" data-page="${page}"><span>${page}</span></li>`;
        }

        if (CURRENT_PAGE < totalPages) {
            li += `<li class="btn next"><i class="fas fa-angle-right"></i></li>`;
        }

        ul.innerHTML = li;

        const prevButton = document.querySelector(".prev");
        const nextButton = document.querySelector(".next");
        const pageButtons = document.querySelectorAll(".specButton");

        prevButton?.addEventListener("click", () => {
            if (CURRENT_PAGE > 1) {
                CURRENT_PAGE--;
                paginatePokemons();
            }
        });

        nextButton?.addEventListener("click", () => {
            if (CURRENT_PAGE < totalPages) {
                CURRENT_PAGE++;
                paginatePokemons();
            }
        });

        pageButtons?.forEach((button) => {
            button.addEventListener("click", () => {
                const selectedPage = parseInt(button.getAttribute("data-page"));
                if (selectedPage !== CURRENT_PAGE) {
                    CURRENT_PAGE = selectedPage;
                    paginatePokemons();
                }
            });
        });
    };

    const displayFilteredPokemons = (filteredPokemons) => {
        pokemonContainerEl.innerHTML = "";

        ALL_POKEMONS = filteredPokemons;

        ALL_POKEMONS_DETAILS = JSON.parse(
            localStorage.getItem("pokemons-details")
        );
        filteredPokemons.forEach((pokemon) => {
            const pokemonEl = createPokemonDOM(
                pokemon.id,
                pokemon.name,
                pokemon.image
            );
            pokemonContainerEl.appendChild(pokemonEl);
        });

        paginatePokemons();
    };

    searchEl.addEventListener("input", async (e) => {
        const searchValue = e.target.value.trim().toLowerCase();

        if (searchValue) {
            const filteredPokemons = ALL_POKEMONS_DETAILS.filter((pokemon) =>
                pokemon.name.trim().toLowerCase().includes(searchValue)
            );
            displayFilteredPokemons(filteredPokemons);
        } else {
            getAllPokemons();
        }
    });

    const createPokemonDOM = (id, name, image) => {
        const pokemonEl = document.createElement("div");
        pokemonEl.classList.add("pokemon");
        pokemonEl.setAttribute("data-id", id);

        const html = `
          <h4 class="name">${name}</h4>
          <button class="btn delete " data-id="${id}">X</button>
          <img src="${image}" alt="" class="image">
        `;
        pokemonEl.innerHTML = html;

        const deleteBtn = pokemonEl.querySelector(".delete");
        deleteBtn.addEventListener("click", (e) => {
            const pid = e.target.dataset.id;
            deletePokemon(pid);
        });

        const imageEl = pokemonEl.querySelector(".image");
        imageEl.addEventListener("click", () => {
            window.location.href = `pokemon-details.html?id=${id}`;
        });

        return pokemonEl;
    };

    const getPokemonDetails = async (pokemon) => {
        try {
            const res = await fetch(pokemon.url);
            const data = await res.json();
            const pokemonData = {
                id: data.id,
                name: data.name,
                order: data.order,
                image: data.sprites.front_default,
            };
            ALL_POKEMONS_DETAILS.push(pokemonData);

            const pokemonEl = createPokemonDOM(
                data.id,
                data.name,
                data.sprites.front_default
            );
            pokemonContainerEl.appendChild(pokemonEl);
        } catch (error) {
            console.log(error);
        }
    };

    const checkLocalStorage = (key) => {
        return localStorage.getItem(key) !== null;
    };

    const getAllPokemons = async () => {
        CURRENT_PAGE = 1;

        if (!checkLocalStorage("pokemons")) {
            try {
                const res = await fetch(API);
                const data = await res.json();
                ALL_POKEMONS = data.results;

                localStorage.setItem("pokemons", JSON.stringify(ALL_POKEMONS));
            } catch (error) {
                console.log(error);
                return;
            }
        } else {
            ALL_POKEMONS = JSON.parse(localStorage.getItem("pokemons"));
        }


        if (!checkLocalStorage("pokemons-details")) {
            for (const pokemon of ALL_POKEMONS) {
                await getPokemonDetails(pokemon);
            }
            localStorage.setItem(
                "pokemons-details",
                JSON.stringify(ALL_POKEMONS_DETAILS)
            );
        } else {
            ALL_POKEMONS_DETAILS = JSON.parse(
                localStorage.getItem("pokemons-details")
            );

            ALL_POKEMONS_DETAILS.sort((a, b) => a.id - b.id);

            for (const pokemonData of ALL_POKEMONS_DETAILS) {
                const pokemonEl = createPokemonDOM(
                    pokemonData.id,
                    pokemonData.name,
                    pokemonData.image
                );
                pokemonContainerEl.appendChild(pokemonEl);
            }
        }

        paginatePokemons();
    };

    getAllPokemons();
});

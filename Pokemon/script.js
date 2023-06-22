window.addEventListener("DOMContentLoaded", () => {
    const API = "https://pokeapi.co/api/v2/pokemon?limit=50";
    let ALL_POKEMONS;
    let CURRENT_PAGE = 1;
    const ITEMS_PER_PAGE = 9;

    const pokemonContainerEl = document.querySelector(".pokemon-container");
    const searchEl = document.querySelector(".search");
    const ul = document.querySelector("ul");

    const getPokemons = async () => {
        try {
            const response = await fetch(API);
            const data = await response.json();
            ALL_POKEMONS = data.results;
            paginatePokemons();
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

    const paginatePokemons = () => {
        pokemonContainerEl.innerHTML = "";

        const startIndex = (CURRENT_PAGE - 1) * ITEMS_PER_PAGE;
        const endIndex = startIndex + ITEMS_PER_PAGE;

        const paginatedPokemons = ALL_POKEMONS.slice(startIndex, endIndex);

        paginatedPokemons.forEach(async (pokemon) => {
            const pokemonDetails = await fetchPokemonDetails(pokemon.url);
            const pokemonEl = createPokemonElement(
                pokemonDetails.id,
                pokemon.name,
                pokemonDetails.sprites.front_default
            );
            pokemonContainerEl.appendChild(pokemonEl);
            addPokemonClickListener(pokemonEl, pokemonDetails.id);
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

    searchEl.addEventListener("input", async (e) => {
        const searchValue = e.target.value.trim().toLowerCase();

        if (searchValue) {
            const filteredPokemons = ALL_POKEMONS.filter((pokemon) =>
                pokemon.name.toLowerCase().includes(searchValue)
            );

            ALL_POKEMONS = filteredPokemons;
            CURRENT_PAGE = 1;

            paginatePokemons();
        } else {
            getPokemons();
        }
    });

    getPokemons();
});

// window.addEventListener("DOMContentLoaded", () => {
//     const API = "https://pokeapi.co/api/v2/pokemon?limit=50";

//     let ALL_POKEMONS;

//     const pokemonContainerEl = document.querySelector(".pokemon-container");
//     const searchEl = document.querySelector(".search");

//     const getPokemons = async () => {
//         try {
//             const response = await fetch(API);
//             const data = await response.json();
//             const pokemons = data.results;
//             ALL_POKEMONS = pokemons;

//             for (const pokemon of pokemons) {
//                 const pokemonDetails = await fetchPokemonDetails(pokemon.url);
//                 const pokemonEl = createPokemonElement(
//                     pokemonDetails.id,
//                     pokemon.name,
//                     pokemonDetails.sprites.front_default
//                 );
//                 pokemonContainerEl.appendChild(pokemonEl);
//                 addPokemonClickListener(pokemonEl, pokemonDetails.id);
//             }
//         } catch (err) {
//             console.log(err);
//         }
//     };

//     const fetchPokemonDetails = async (url) => {
//         try {
//             const response = await fetch(url);
//             const data = await response.json();
//             return data;
//         } catch (err) {
//             throw new Error("Failed to fetch Pokémon details");
//         }
//     };

//     const createPokemonElement = (id, name, image) => {
//         const pokemonEl = document.createElement("div");
//         pokemonEl.classList.add("pokemon");
//         pokemonEl.setAttribute("data-id", id);

//         const html = `
//             <h4 class="name">${name}</h4>
//             <img src="${image}" alt="" class="image">
//         `;
//         pokemonEl.innerHTML = html;

//         return pokemonEl;
//     };

//     const addPokemonClickListener = (pokemonEl, pokemonId) => {
//         pokemonEl.addEventListener("click", () => {
//             window.location.href = `pokemon-details.html?id=${pokemonId}`;
//         });
//     };

//     searchEl.addEventListener("input", async (e) => {
//         const searchValue = e.target.value.trim().toLowerCase();

//         if (searchValue) {
//             const filteredPokemons = ALL_POKEMONS.filter((pokemon) =>
//                 pokemon.name.toLowerCase().includes(searchValue)
//             );
//             pokemonContainerEl.innerHTML = "";

//             console.log(filteredPokemons);

//             pokemonContainerEl.innerHTML = "";

//             filteredPokemons.forEach(async (pokemon) => {
//                 const pokemonDetails = await fetchPokemonDetails(
//                     `https://pokeapi.co/api/v2/pokemon/${pokemon.name}`
//                 );

//                 const pokemonEl = createPokemonElement(
//                     pokemonDetails.id,
//                     pokemonDetails.name,
//                     pokemonDetails.sprites.front_default
//                 );
//                 pokemonContainerEl.appendChild(pokemonEl);
//                 addPokemonClickListener(pokemonEl, pokemonDetails.id);
//             });
//         } else {
//             getPokemons();
//         }
//     });

//     getPokemons();

//     const ul = document.querySelector("ul");

//     function elem(allPages, page) {
//         let li = "";

//         let beforePages = page - 1;
//         let afterPages = page + 1;
//         let liActive;

//         if (page > 1) {
//             li += `<li class="btn prev"><i class="fas fa-angle-left"></i></li>`;
//         }

//         for (
//             let pageLength = beforePages;
//             pageLength <= afterPages;
//             pageLength++
//         ) {
//             if (pageLength > allPages) {
//                 continue;
//             }

//             if (pageLength === 0) {
//                 pageLength++;
//             }

//             if (page === pageLength) {
//                 liActive = "active";
//             } else {
//                 liActive = "";
//             }

//             li += `<li class="num ${liActive} specButton" data-page="${pageLength}"><span>${pageLength}</span></li>`;
//         }

//         if (page < allPages) {
//             li += `<li class="btn next"><i class="fas fa-angle-right"></i></li>`;
//         }

//         ul.innerHTML = li;

//         const prevButton = document.querySelector(".prev");
//         const nextButton = document.querySelector(".next");
//         const activeButtons = document.querySelectorAll(".specButton");

//         if (prevButton) {
//             prevButton.addEventListener("click", () => {
//                 elem(allPages, page - 1);
//             });
//         }

//         if (nextButton) {
//             nextButton.addEventListener("click", () => {
//                 elem(allPages, page + 1);
//             });
//         }

//         if (activeButtons) {
//             activeButtons.forEach((button) => {
//                 button.addEventListener("click", () => {
//                     const selectedPage = parseInt(
//                         button.getAttribute("data-page")
//                     );
//                     elem(allPages, selectedPage);
//                 });
//             });
//         }
//     }

//     elem(12, 2)

// });

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

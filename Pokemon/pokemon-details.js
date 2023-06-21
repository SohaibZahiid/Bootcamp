window.addEventListener("DOMContentLoaded", () => {

    const nameEl = document.querySelector('.name')
    const imageEl = document.querySelector('.image')
    const baseExpEl = document.querySelector('.base-exp')
    const heightEl = document.querySelector('.height')
    const weightEl = document.querySelector('.weight')
    const hpEl = document.querySelector('.hp')

    const params = new URLSearchParams(window.location.search);
    const pokemonId = params.get("id");

    const getPokemon = (id) => {
        fetch(`https://pokeapi.co/api/v2/pokemon/${id}`)
        .then((res) => res.json())
        .then((data) => {
            console.log(data);
            nameEl.innerHTML = data.name
            imageEl.src = data.sprites.front_default
            baseExpEl.innerHTML = data.base_experience
            heightEl.innerHTML = data.height
            weightEl.innerHTML = data.weight
            hpEl.innerHTML = data.hp
        });
    };

    getPokemon(pokemonId)


});

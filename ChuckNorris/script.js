const imgEl = document.querySelector('.img')
const jokeEl = document.querySelector('.joke')
const btn = document.querySelector('.btn')

btn.addEventListener('click', e => {
    fetch("https://api.chucknorris.io/jokes/random")
        .then(res => res.json())
        .then(data => {
            jokeEl.textContent = data.value
        })
})
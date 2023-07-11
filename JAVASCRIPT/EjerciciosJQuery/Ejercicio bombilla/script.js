window.addEventListener('DOMContentLoaded', () => {
    const bulb = document.querySelector('.bulb')
    const btn = document.querySelector('.btn')
    const level = document.querySelector('.level')
    
    let active = false

    btn.addEventListener('click', (e) => {

        if(!active) {
            bulb.src = "on.jpg"
            btn.src = "bon.jpg"
            active = true

        } else {
            bulb.src = "off.jpg"
            btn.src = "boff.jpg"
            active = false
        }
    })

    level.addEventListener('input', e => {
        if(active) {
            console.log(e.target.value);
            bulb.style.opacity = `0.${e.target.value}`
        }
    })

})
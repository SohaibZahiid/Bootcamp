document.addEventListener('keypress', e => {
    if(e.key == 'w') {
        let audio = new Audio('./sounds/Darbuka_06_76_SP.mp3')
        audio.play()
        whichKey('w')
    }
    if(e.key == 'a') {
        let audio = new Audio('./sounds/Darbuka_18_76_SP.mp3')
        audio.play()
        whichKey('a')
    }
    if(e.key == 'd') {
        let audio = new Audio('./sounds/Darbuka_42_76_SP.mp3')
        audio.play()
        whichKey('d')
    }
    if(e.key == 's') {
        let audio = new Audio('./sounds/Darbuka_48_76_SP.mp3')
        audio.play()
        whichKey('s')
    }
    if(e.key == 'e') {
        let audio = new Audio('./sounds/Darbuka_66_76_SP.mp3')
        audio.play()
        whichKey('e')
    }
    
})

const whichKey = key => {
    const keysEl = document.querySelectorAll('.img-box') 
    keysEl.forEach(el => {
        if(el.dataset.id == key) {
            el.classList.add('shake-img')
            setTimeout(() => {
                el.classList.remove('shake-img')
            }, 100);
        }
    })
}
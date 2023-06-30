window.addEventListener('DOMContentLoaded', () => {
    const btnContainer = document.querySelector('.btn-container')
    const display = document.querySelector('.display')

    btnContainer.addEventListener('click', e => {
        if (e.target.matches('button')) {


            if(display.textContent.length <= 9) {
                display.textContent += e.target.value
            }


            if (e.target.value == '=') {
                display.textContent = eval(display.textContent.slice(0, -1))
            } else if (e.target.value == 'del') {
                display.textContent = display.textContent.slice(0, -4)
            } else if (e.target.value == "reset") {
                display.textContent = ""
            }
        }
    })

})
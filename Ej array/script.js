const push = document.querySelector('.push')
const unshift = document.querySelector('.unshift')
const insertAt = document.querySelector('.insert-at')

const pop = document.querySelector('.pop')
const shift = document.querySelector('.shift')
const removeAt = document.querySelector('.remove-at')
const deleteVal = document.querySelector('.delete-value')

const arrContainer = document.querySelector('.array-container')

let ARR = ['🍕','🍕','🍕','🍕']

arrContainer.innerHTML = `[${ARR}]`

push.addEventListener('click', e => {
    ARR.push('🍌')
    updateARR()

})

unshift.addEventListener('click', e => {
    ARR.unshift('🍌')
    updateARR()

})

insertAt.addEventListener('click', e => {
    const insertVal = document.querySelector('.insert-value').value
    if (insertVal) {
        ARR.splice(insertVal, 0, '🍌')
        updateARR()
    }
})

pop.addEventListener('click', e => {
    ARR.pop('🍌')
    updateARR()
})

shift.addEventListener('click', e => {
    ARR.shift('🍌')
    updateARR()
})

removeAt.addEventListener('click', e => {
    const removeVal = document.querySelector('.remove-value').value
    if (removeVal) {
        ARR.splice(removeVal, 1)
        updateARR()
    }
})

const updateARR = () => {
    arrContainer.innerHTML = `[${ARR}]`
}
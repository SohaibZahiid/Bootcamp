window.addEventListener('DOMContentLoaded', () => {
    const btnContainer = document.querySelector('.btn-container')
    // const middle = document.querySelector('.middle')
    const input = document.querySelector('.input')

    let num1, num2, operator, result

    btnContainer.addEventListener('click', e => {
        if (e.target.matches('button')) {

            console.log('click');
            console.log(e.target.textContent);


            input.textContent += e.target.textContent

            if(e.target.textContent == '+') {
                num1 = e.target.textContent
                console.log(num1)
            }
            


            // const key = e.target
            // const action = key.dataset.action
            // const keyContent = key.textContent
            // const displayedNum = input.textContent
            // const previousKeyType = middle.dataset.previousKeyType

            // if (!action) {
            //     if (displayedNum == '0' || previousKeyType == 'operator') {
            //         input.textContent = keyContent
            //     } else {
            //         input.textContent = displayedNum + keyContent
            //     }
            // } else if (
            //     action === '+' ||
            //     action === '-' ||
            //     action === '*' ||
            //     action === '/') {
            //     middle.dataset.previousKeyType = 'operator'
            //     middle.dataset.firstValue = displayedNum
            //     middle.dataset.operator = action
            // }

            // if (action == '.') {
            //     console.log('decimal');
            //     input.textContent = displayedNum + '.'
            // }

            // if (action == 'del') {
            //     console.log('del');
            // }

            // if (action == 'reset') {
            //     console.log('reset');
            // }

            // if (action == '=') {
            //     const firstValue = middle.dataset.firstValue
            //     const operator = middle.dataset.operator
            //     const secondValue = displayedNum

            //     input.textContent = calculate(firstValue, operator, secondValue)
            // }
        }
    })

    const calculate = (n1, operator, n2) => {
        let result = ''

        if (operator === '+') {
            result = parseFloat(n1) + parseFloat(n2)
        } else if (operator === '-') {
            result = parseFloat(n1) - parseFloat(n2)
        } else if (operator === '*') {
            result = parseFloat(n1) * parseFloat(n2)
        } else if (operator === '/') {
            result = parseFloat(n1) / parseFloat(n2)
        }

        return result
    }

})
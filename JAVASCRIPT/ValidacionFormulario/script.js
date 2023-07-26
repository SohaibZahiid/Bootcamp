const firstName = document.querySelector('.first-name');
const lastName = document.querySelector('.last-name');
const username = document.querySelector('.username');
const city = document.querySelector('.city');
const state = document.querySelector('.state');
const zip = document.querySelector('.zip');
const terms = document.querySelector('.terms');
const btnSubmit = document.querySelector('.submit');

btnSubmit.addEventListener('click', e => {
    e.preventDefault();

  
    const errorElements = document.querySelectorAll('.error');
    errorElements.forEach(element => element.textContent = '');

    
    if (firstName.value.trim() === '') {
        displayErrorMessage('.first-name-error', 'Please enter your first name.');
       
    }

    if (lastName.value.trim() === '') {
        displayErrorMessage('.last-name-error', 'Please enter your last name.');
    }

 
    if (username.value.trim() === '') {
        displayErrorMessage('.username-error', 'Please enter your username.');
        
    }

  
    if (city.value.trim() === '') {
        displayErrorMessage('.city-error', 'Please enter your city.');
        
    }

    
    if (state.value.trim() === '') {
        displayErrorMessage('.state-error', 'Please enter your state.');
    }


    if (!(/^\d{5}$/.test(zip.value.trim()))) {
        displayErrorMessage('.zip-error', 'Please enter a valid ZIP code (5 digits).');
    }


    if (!terms.checked) {
        displayErrorMessage('.terms-error', 'Please agree to the terms and conditions.');
    }

    
});

function displayErrorMessage(selector, message) {
    const errorElement = document.querySelector(selector);
    errorElement.textContent = message;
}

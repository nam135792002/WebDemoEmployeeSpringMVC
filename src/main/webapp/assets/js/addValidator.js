function displayError(inputField, errorMessage) {
    inputField.classList.add('invalid');
    const errorElement = inputField.nextElementSibling;
    if (errorElement) {
        errorElement.textContent = errorMessage;
    }
}

function removeError(inputField) {
    inputField.classList.remove('invalid');
    const errorElement = inputField.nextElementSibling;
    if (errorElement) {
        errorElement.textContent = '';
    }
}

function validateForm() {
    var name = document.getElementById('name');
    var gender = document.querySelector('input[name="gender"]:checked');
    var dateOfBirth = document.getElementById('dateOfBirth');
    var option = document.getElementById('country');

    let isValid = true;

    // Clear previous error messages
    const errorMessages = document.querySelectorAll('.error-message');
    errorMessages.forEach((errorMessage) => {
        errorMessage.textContent = '';
    });

    // Add event listeners to remove 'invalid' class and clear error messages when user starts typing
    name.addEventListener('input', function () {
        removeError(name);
    });

    var genderInputs = document.querySelectorAll('input[name="gender"]');
    genderInputs.forEach(function (input) {
        input.addEventListener('change', function () {
            const genderError = document.getElementById('gender-error');
            genderError.textContent = '';
            removeError(document.querySelector('.radio-group'));
        });
    });

    dateOfBirth.addEventListener('input', function () {
        removeError(dateOfBirth);
    });

    option.addEventListener('input', function () {
        removeError(option);
    });

    if (name.value.trim() === '') {
        displayError(name, 'Fullname cannot be empty');
        isValid = false;
    }

    if (!gender) {
        const genderError = document.getElementById('gender-error');
        genderError.textContent = 'Please select a gender';
        isValid = false;
    }

    if (dateOfBirth.value.trim() === '') {
        displayError(dateOfBirth, 'Date of birth cannot be empty');
        isValid = false;
    }

    if (option.value.trim() === 'NULL') {
        displayError(option, 'Department cannot be empty');
        isValid = false;
    }

    return isValid;
}
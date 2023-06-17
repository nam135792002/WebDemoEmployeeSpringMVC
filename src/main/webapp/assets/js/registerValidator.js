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

function isValidEmail(email) {
    // Regular expression for email validation
    const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    return emailRegex.test(email);
}

function validateForm() {
    var firstName = document.getElementById('firstName');
    var lastName = document.getElementById('lastName');
    var email = document.getElementById('email');
    var uname = document.getElementById('userName');
    var psw = document.getElementById('passWord');
    var pswRepeat = document.getElementById('psw-repeat');

    let isValid = true;

    // Clear previous error messages
    const errorMessages = document.querySelectorAll('.error-message');
    errorMessages.forEach((errorMessage) => {
        errorMessage.textContent = '';
    });

    // Add event listeners to remove 'invalid' class and clear error messages when the user starts typing
    firstName.addEventListener('input', function () {
        removeError(firstName);
    });

    lastName.addEventListener('input', function () {
        removeError(lastName);
    });

    uname.addEventListener('input', function () {
        removeError(uname);
    });

    email.addEventListener('input', function () {
        removeError(email);
    });

    psw.addEventListener('input', function () {
        removeError(psw);
    });

    pswRepeat.addEventListener('input', function () {
        removeError(pswRepeat);
    });

    if (firstName.value.trim() === '') {
        displayError(firstName, 'First name cannot be empty');
        isValid = false;
    }

    if (lastName.value.trim() === '') {
        displayError(lastName, 'Last name cannot be empty');
        isValid = false;
    }

    const emailValue = email.value.trim();
    if (emailValue === '') {
        displayError(email, 'Email cannot be empty');
        isValid = false;
    } else if (!isValidEmail(emailValue)) {
        displayError(email, 'Invalid email format');
        isValid = false;
    }

    if (uname.value.trim() === '') {
        displayError(uname, 'Username cannot be empty');
        isValid = false;
    }

    if (psw.value.trim() === '') {
        displayError(psw, 'Password cannot be empty');
        isValid = false;
    }
    
    if (pswRepeat.value.trim() === '') {
        displayError(pswRepeat, 'Confirm password cannot be empty');
        isValid = false;
    }

    if (psw.value !== pswRepeat.value) {
        displayError(pswRepeat, 'Passwords do not match');
        isValid = false;
    }
    
    return isValid;
}
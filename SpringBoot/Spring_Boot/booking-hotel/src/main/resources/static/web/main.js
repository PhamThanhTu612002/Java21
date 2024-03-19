const inputPlace = document.getElementById("place");
const inputNoAdult = document.getElementById("no-adult");
const inputNoChildren = document.getElementById("no-children");

const formSearch = document.getElementById("formSearch");


function validateForm(){
    var valid = true;
    resetErrorMessages();

    if(inputPlace.value.trim() === ''){
        valid = false;
        displayErrorMessage('error-place','Hãy nhập điểm đến');
    }
    if (inputNoAdult.value === ''){
        valid = false;
        displayErrorMessage('error-noAdult','Hãy chọn số lượng người lớn');
    }
    if (inputNoChildren.value === ''){
        valid = false;
        displayErrorMessage('error-noChildren','Hãy chọn số lượng trẻ em');
    }

    return valid;

}
function resetErrorMessages(){
    var errorMessages = document.querySelectorAll('.msg-error');
    errorMessages.forEach(function (msg) {
        msg.textContent = '';
    });
}
function displayErrorMessage(elementId , message) {
    var errorMessageElement = document.querySelector("#"+elementId);
    errorMessageElement.textContent = message;
}
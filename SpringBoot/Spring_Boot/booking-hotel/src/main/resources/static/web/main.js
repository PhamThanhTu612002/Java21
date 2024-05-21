const inputPlace = document.getElementById("place");
const inputNoAdult = document.getElementById("no-adult");
const inputNoChildren = document.getElementById("no-children");
const inputCheckInDate = document.getElementById("from");
const inputCheckOutDate = document.getElementById("to");
const formSearch = document.getElementById("formSearch");
inputPlace.addEventListener('change',function (){
    console.log(inputPlace.value);
})
document.getElementById('no-adult').addEventListener('keypress', function (e) {
    e.preventDefault();
});
document.getElementById('no-children').addEventListener('keypress', function (e) {
    e.preventDefault();
});
document.getElementById('from').addEventListener('keypress', function (e) {
    e.preventDefault();
});
document.getElementById('to').addEventListener('keypress', function (e) {
    e.preventDefault();
});
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
    }else if(inputNoAdult.value === '0' && inputNoChildren.value.trim() === '0'){
        valid = false;
        displayErrorMessage('error-noAdult','Hãy chọn số lượng người lớn');
    }
    if (inputNoChildren.value === ''){
        valid = false;
        displayErrorMessage('error-noChildren','Hãy chọn số lượng trẻ em');
    }else if(inputNoChildren.value === '0' && inputNoAdult.value.trim() === '0'){
        valid = false;
        displayErrorMessage('error-noChildren','Hãy chọn số lượng trẻ em');
    }
    if (inputCheckInDate.value ===''){
        valid = false;
        displayErrorMessage('error-checkin','Hãy chọn ngày đến');
    }
    if (inputCheckOutDate.value ===''){
        valid = false;
        displayErrorMessage('error-checkout','Hãy chọn ngày đi');
    }
    localStorage.setItem("noAdult",inputNoAdult.value);
    localStorage.setItem("noChildren",inputNoChildren.value);
    localStorage.setItem("checkInDate",inputCheckInDate.value);
    localStorage.setItem("checkOutDate",inputCheckOutDate.value);

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
new Choices(document.querySelector(".choices-single"));
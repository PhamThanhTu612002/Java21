const btnRegister = document.getElementById("btn-register");
const name = document.getElementById("input-fullname");
const email = document.getElementById("input-email");
const password = document.getElementById("input-password");
const confirmedPaswword = document.getElementById("input-confirmedPassword");
btnRegister.addEventListener('click',() =>{
    const data = {
        email: email.value,
        name : name.value,
        password: password.value,
        confirmPassword: confirmedPaswword.value
    }
    axios.post('/api/auth/register', data)
        .then(function (response){
            toastr.success('Đăng ký thành công')
            window.location.href = '/login';
        })
        .catch(function (error) {
            console.log(error);
            toastr.error(error.response.data.message)
        })
})
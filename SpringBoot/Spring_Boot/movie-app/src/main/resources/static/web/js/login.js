const inputEmail = document.getElementById("input-email");
const inputPassword = document.getElementById("input-password")
const btnLogin = document.getElementById("btnLogin")
const navbar = document.querySelector(".navbar-nav");
const linkLogin = document.getElementById("login")
const linkRegiser = document.getElementById("register")
btnLogin.addEventListener("click", () => {
    const data = {
        email: inputEmail.value,
        password: inputPassword.value
    }
    console.log(data);
    axios.post('/api/auth/login', data)
        .then(function (response){
            toastr.success('Đăng nhập thành công')
            window.location.href = '/';
        })
        .catch(function (error) {
            console.log(error);
            toastr.error(error.response.data.message)
        })
})


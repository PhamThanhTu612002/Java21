const inputEmail = document.getElementById("input-email");
const inputPassword = document.getElementById("input-password")
const btnLogin = document.getElementById("btnLogin")
btnLogin.addEventListener("click", () => {
    const data = {
        email: inputEmail.value,
        password: inputPassword.value
    }
    console.log(data);
    axios.post('/api/auth/login', data)
        .then(function (response){
            if(response.status === 200){
                toastr.success('Đăng nhập thành công');
                setTimeout(() =>{
                    window.location.href = '/';
                },1500)
            }
        })
        .catch(function (error) {
            console.log(error);
            toastr.error(error.response.data.message)
        })
})


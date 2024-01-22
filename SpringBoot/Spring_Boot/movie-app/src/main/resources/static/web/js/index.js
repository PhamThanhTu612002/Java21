function logout(){
    console.log("1213")
    axios.get('http://localhost:8081/api/auth/logout')
        .then(function (response){
            toastr.success('Đăng xuất thành công')
            window.location.href = '/';
        })
        .catch(function (error) {
            console.log(error);
            toastr.error(error.response.data.message)
        })
}
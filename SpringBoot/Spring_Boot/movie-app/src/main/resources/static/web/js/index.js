function logout(){
    console.log("1213")
    axios.get('http://localhost:8081/api/auth/logout')
        .then(function (response){
            if(response.status === 200){
                toastr.success('Đăng xuất thành công')
                setTimeout(() => {
                    window.location.href = '/';
                },1500)
            }
        })
        .catch(function (error) {
            console.log(error);
            toastr.error(error.response.data.message)
        })
}
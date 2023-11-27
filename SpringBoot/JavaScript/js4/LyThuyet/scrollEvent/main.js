// ẩn hiện btn
const btn = document.getElementById('btn');
window.addEventListener('scroll', function () {
    if(document.documentElement.scrollTop > 100){
        btn.classList.add('show');
    }else{
        btn.classList.remove('show');
    }
})

// ấn vào trở về đầu trang

const show = document.getElementById('show');
const input = document.querySelector('.input');
show.addEventListener('click',function(){
    if(input.type == 'password'){
        input.type = 'text';
        show.innerText = 'Hide';
    }else{
        input.type = 'password';
        show.innerText = 'Show';
    }
    
})
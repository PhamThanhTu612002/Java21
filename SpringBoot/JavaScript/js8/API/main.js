const API = " https://jsonplaceholder.typicode.com/";
const list = document.querySelector('.list');
const btnPost = document.querySelector('#btn1');
const btnPhoto = document.querySelector('#btn2');
const btnAlbum = document.querySelector('#btn3');
const h1 = document.querySelector('h1');
const btn = document.querySelectorAll('button');
console.log(btn);
const activeBtn = (button) =>{
    btn.forEach(but => {
        but.classList.remove('active');
    })
    button.classList.add('active');
}
const getAllPosts = async () => {
    try {
        const res = await axios.get(API+'posts');
        let html ="";
        console.log(res);
        res.data.forEach(post => {
            html += `<li>${post.title}</li>`;
        })
        list.innerHTML = html;
        h1.innerHTML = `<h1>Type: posts</h1>`;
    } catch (error) {
        console.log(error);
    }
}
getAllPosts();
btnPost.addEventListener('click', async () =>{
    getAllPosts();
    activeBtn(btnPost);
});
btnPhoto.addEventListener('click',async () =>{
    try {
        const res = await axios.get(API+'photos');
        let html ="";
        console.log(res);
        res.data.forEach(photo => {
            html += `<li>${photo.title}</li>`;
        })
        list.innerHTML = html;
        h1.innerHTML = `<h1>Type: photos</h1>`;
        activeBtn(btnPhoto);
    } catch (error) {
        console.log(error);
    }
});

btnAlbum.addEventListener('click', async() => {
    try {
        const res = await axios.get(API+'albums');
        let html ="";
        console.log(res);
        res.data.forEach(album => {
            html += `<li>${album.title}</li>`;
        })
        list.innerHTML = html;
        h1.innerHTML = `<h1>Type: albums</h1>`;
        activeBtn(btnAlbum);
    } catch (error) {
        console.log(error);
    }
});

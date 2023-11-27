let colors = [
    '#3498db',
    '#9b59b6',
    '#e74c3c',
    '#2c3e50',
    '#d35400',
]

const boxList = document.querySelector(".boxes");
//Hiện ra 5 box ban đầu
const renderBox = (colors) => {
    let htmlBox = "";
    colors.forEach(color => {
        htmlBox += `<div class="box" style="background-color:${color};"></div>`
    });
    boxList.innerHTML += htmlBox;
}
renderBox(colors);


const btn = document.querySelector('#btn');

let box = document.querySelectorAll('.box');
// Hiển thị tổng số box
let points = document.querySelector(".points");
points.innerText = box.length;

const boxList2 = document.querySelector(".boxes");
btn.addEventListener('click',function(){
    // Khi ấn more box thì thêm 5 box tiếp
    renderBox(colors);
    // Hiển thị lại tổng số box
    let box = document.querySelectorAll('.box');
    points.innerText = box.length;
    box.forEach(b => {
        b.addEventListener('click',function(){
            //Xóa box khi đã ấn btn more box
            boxList2.removeChild(b);
            box.length -= 1;
            //Sau khi xóa hiển thị lại tổng số box
            let box2 = document.querySelectorAll('.box');
            points.innerText = box2.length;
        })
    });
});

//Xóa box khi chưa ấn btn more box
box.forEach(b => {
    b.addEventListener('click',function(){
        boxList2.removeChild(b);
        let box2 = document.querySelectorAll('.box');
        points.innerText = box2.length;
    })
});




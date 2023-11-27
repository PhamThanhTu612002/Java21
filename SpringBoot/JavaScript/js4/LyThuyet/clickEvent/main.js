const para = document.querySelector("#text");
const btn1 = document.querySelector("#btn1");
const btn2 = document.querySelector("#btn2");

function changeContent(){
    const quotes = ["1","2","3","4"];
    const random = Math.floor(Math.random() * quotes.length);
    const quotesRandom = quotes[random];
    para.innerText = quotesRandom;
}

function randomHexColor() {
    let randomColor = Math.floor(Math.random() * 16777215).toString(16);

    while (randomColor.length < 6) {
        randomColor = '0' + randomColor;
    }

    return '#' + randomColor;
}

btn1.onclick = function() {
    para.style.color = randomHexColor();
}

function getRandomRgbColor() {
    let red = Math.floor(Math.random() * 256);
    let green = Math.floor(Math.random() * 256);
    let blue = Math.floor(Math.random() * 256);

    return `rgb(${red}, ${green}, ${blue})`;
}
btn2.addEventListener('click',function(){
    para.style.backgroundColor = getRandomRgbColor();
})
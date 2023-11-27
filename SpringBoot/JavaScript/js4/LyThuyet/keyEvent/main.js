document.addEventListener('keydown', function(event){
    if(event.key == 'Enter'){
        drawCircle();
    }
    else if(event.key == ' '){
        drawSquare();
    }else if(event.key == 'ArrowUp'){
        const circle =  document.querySelector('.circle');
        circle.style.top = (circle.offsetTop - 20) + 'px';
        if(circle.offsetTop < 0){
            circle.style.top = '0px';
        }
        console.log(event);
    }
    else if(event.key == 'ArrowDown'){
        const circle =  document.querySelector('.circle');
        circle.style.top = (circle.offsetTop + 20) + 'px';
        console.log(event);
    }
    else if(event.key == 'ArrowLeft'){
        const circle =  document.querySelector('.circle');
        circle.style.left = (circle.offsetLeft - 20) + 'px';
        if(circle.offsetLeft < 0){
            circle.style.left = '0px';
        }
        console.log(event);
    }
    else if(event.key == 'ArrowRight'){
        const circle =  document.querySelector('.circle');
        circle.style.left = (circle.offsetLeft + 20) + 'px';
        console.log(event);
    }
    else{
        changeBackground();
    }
})
const drawCircle = () => {
    const curCir = document.querySelector('.circle');
    if(curCir){
        curCir.parentElement.removeChild(curCir);
    }
    const circle = document.createElement('div');
    circle.classList.add('circle');

    const minX = 0;
    const maxX = 1500;
    const minY = 0;
    const maxY = 600;

    // gan vi tri va them vao dom
    const axisX = (Math.floor(Math.random() * (maxX - minX + 1)) + minX) - 25 + 'px';
    const axisY = (Math.floor(Math.random() * (maxY - minY + 1)) + minY) - 25 + 'px';
    circle.style.left = axisX;
    circle.style.top = axisY;

    document.body.appendChild(circle);
}
const drawSquare = () => {
    const curSqua = document.querySelector('.square');
    if(curSqua){
        curSqua.parentElement.removeChild(curSqua);
    }
    const square = document.createElement('div');
    square.classList.add('square');

    const minX = 0;
    const maxX = 1500;
    const minY = 0;
    const maxY = 600;

    // gan vi tri va them vao dom
    const axisX = (Math.floor(Math.random() * (maxX - minX + 1)) + minX) - 25 + 'px';
    const axisY = (Math.floor(Math.random() * (maxY - minY + 1)) + minY) - 25 + 'px';
    square.style.left = axisX;
    square.style.top = axisY;

    document.body.appendChild(square);
}
const changeBackground = () => {
    function getRandomRgbColor() {

        let red = Math.floor(Math.random() * 256);
        let green = Math.floor(Math.random() * 256);
        let blue = Math.floor(Math.random() * 256);
    
        return `rgb(${red}, ${green}, ${blue})`;
    }
    document.body.style.backgroundColor = getRandomRgbColor();
}
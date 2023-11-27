// document.addEventListener('click', function(event) {
//     console.log(event);
// })

// document.addEventListener('mousedown', function() {
// console.log('mousedown');
// })

// document.addEventListener('mousemove', function() {
// console.log('mousemove');
// })

// document.addEventListener('mouseup', function() {
// console.log('mouseup');
// })

document.addEventListener('click',function(event){
    const curCir = document.querySelector('.circle');
    if(curCir){
        curCir.parentElement.removeChild(curCir);
    }
    const circle = document.createElement('div');
    circle.classList.add('circle');

    // gan vi tri va them vao dom
    const axisX = event.offsetX - 25 + 'px';
    const axisY = event.offsetY - 25 + 'px';
    circle.style.left = axisX;
    circle.style.top = axisY;

    document.body.appendChild(circle);

})

document.addEventListener('click', function(event) {
    console.log(event);
})
   
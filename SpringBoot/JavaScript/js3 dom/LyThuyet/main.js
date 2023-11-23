const heading = document.getElementById('heading');
console.log(heading);

// trans color 
heading.style.color = 'red';
heading.style.backgroundColor = 'black';

const para = document.querySelectorAll('p');
console.log(para);

para.forEach(element => {
    element.style.color = "blue";
    element.style.fontSize = "24px";
});
const para1 = document.querySelector('p');
console.log(para1);
const para2 = document.querySelector('p:nth-child(3)');
console.log(para2);
const para3 = document.querySelector('p:nth-child(4)');
console.log(para3);

//get/set content
console.log(heading.innerHTML);
console.log(heading.innerText);
console.log(heading.textContent);

heading.innerHTML = "<p>Hehe</p>";
heading.innerText = "HEHE";

//truy cập vào thẻ cha rồi chèn vào vị trí
// document.body.insertBefore(para3,para1);


// targetElement.insertAdjacentHTML(position, text);
// targetElement.insertAdjacentElement(position, element);
// targetElement.insertAdjacentText(position, text);
heading.insertAdjacentElement("afterend",para3);

// const btn = document.createElement("button");
// btn.innerText = 'Click me';

// document.body.insertBefore(btn,para2);

para1.insertAdjacentHTML("afterend","<button>Click Me</button>");

// document.body.removeChild(para1);
para1.parentElement.removeChild(para1);

const input = document.createElement("input");
input.type = "text";
input.placeholder = "Enter Name";

para2.parentNode.replaceChild(input,para2);

para3.classList.add('text-red','text-center','text-bold');

para3.classList.remove('text-bold');

console.log(para3.classList.contains('text-red'));

//toggle

setInterval(() => {
    para3.classList.toggle("text-bold");
}, 1000); 
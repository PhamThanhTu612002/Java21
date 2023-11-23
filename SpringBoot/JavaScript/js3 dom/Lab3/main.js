// bài 1
const para = document.getElementById("text");
para.style.color = "#777";
para.style.fontSize = "2rem";
para.innerHTML = "Tôi có thể làm <em> bất cứ điều gì </em> tôi muốn với JavaScript.";
console.log(para);

// bài 2
const liList =  document.querySelectorAll(".list li");
liList.forEach(element => {
    element.style.color = "blue";
    
});
//console.log(liList);
// bài 3
const li7 = document.querySelector("#list li:nth-child(7)");
li7.insertAdjacentHTML("afterend","<li>Item 8</li>");
const li8 = document.querySelector("#list li:nth-child(8)");
li8.insertAdjacentHTML("afterend","<li>Item 9</li>");
const li9 = document.querySelector("#list li:nth-child(9)");
li9.insertAdjacentHTML("afterend","<li>Item 10</li>");
const li1 = document.querySelector("#list li:nth-child(1)");
li1.style.color = "red";
const li3 = document.querySelector("#list li:nth-child(3)");
li3.style.backgroundColor = "blue";
const li4 = document.querySelector("#list li:nth-child(4)");
li4.parentElement.removeChild(li4);
li3.insertAdjacentHTML("afterend","<li>Item 11</li>")
console.log(li7);
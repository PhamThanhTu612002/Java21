// Truy cập vào thẻ h1 có id=“heading” thay đổi màu chữ thành ‘red’, và in hoa nội dung của thẻ đó
const heading1 = document.querySelector("h1");
heading1.style.color = 'red';
heading1.style.textTransform = 'uppercase';
// Thay đổi màu chữ của tất cả thẻ có class “para” thành màu “blue” và có font-size = “20px”
const paraList = document.querySelectorAll(".para");
paraList.forEach(element => {
    element.style.color = 'blue';
    element.style.fontSize = '20px';
});
// Thêm thẻ a link đến trang ‘facebook’ ở đằng sau thẻ có class “para-3”
const para3 = document.querySelector(".para-3");
para3.insertAdjacentHTML("afterend",'<a href="facebook.com">Facebook</a>')
// Thay đổi nội dung của thẻ có id=“title” thành “Đây là thẻ tiêu đề”
const title = document.getElementById('title');
title.innerText ="Đây là thẻ tiêu đề";
// Thêm class “text-bold” vào thẻ có class=“description” (định nghĩa class “text-bold” có tác dụng in đậm chữ)
const desc = document.querySelector(".description");
desc.classList.add("text-bold");
// Thay thế thẻ có class=“para-3” thành thẻ button có nội dung là “Click me”
const input = document.createElement('button');
input.innerText = 'Click me';
para3.parentElement.replaceChild(input,para3);
// Copy thẻ có class=“para-2” và hiển thị ngay đằng sau thẻ đó
const para2 = document.querySelector(".para-2");
para2.insertAdjacentElement("afterend",para2.cloneNode(true));
// Xóa thẻ có class=“para-1”
const para1 = document.querySelector(".para-1");
document.body.removeChild(para1);
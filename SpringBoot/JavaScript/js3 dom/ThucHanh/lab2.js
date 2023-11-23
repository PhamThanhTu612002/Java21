// Highlight tất cả các từ có độ dài lớn hơn hoặc bằng 5 ký tự trong đoạn văn (background = “yellow”)
let para = document.querySelector('p');
let doanVanBan =para.innerText;

let tuArray = doanVanBan.split(' ');


for (let i = 0; i < tuArray.length; i++) {
  let tu = tuArray[i];
  
  if (tu.length >= 5) {
    let spanElement = document.createElement('span');
    
    spanElement.innerText = tu;
    
    spanElement.classList.add("bgyellow");
    doanVanBan = doanVanBan.replace(tu,spanElement);
  }
}

// In ra kết quả

// Thêm link hiển thị text “facebook” link đến trang facebook.com ở sau thẻ p
para.insertAdjacentHTML("afterend",'<a href="facebook.com">Facebook</a>');
// Đếm số từ có trong đoạn văn. Tạo 1 thẻ div để hiển thị số từ
const div = document.createElement('div');
div.innerText ="Đoạn văn có " + tuArray.length +" từ";
para.insertAdjacentElement("afterend",div);
// Thay thế ký hiệu (, - dấu phẩy) => 🤔 và (. - dấu chấm) => 😲
for (let i = 0; i < array.length; i++) {
    const element = array[i];
    
}
//Bài 1: Viết function truyền vào 1 số nguyên dường. Tính giai thừa của số đó
function calculateFactorial(num){
    let gt = 1;
    for(let i = num; i > 0; i--){
        gt *= i;
    }
    console.log(gt);
}
calculateFactorial(3);

//Bài 2: Viết function truyền vào 1 chuỗi. In ra chuỗi đảo ngược của chuỗi đó
function reverseString(str){
    let temp = "";
    for(let i = str.length; i >= 0; i--){
        temp += str.charAt(i);
    }
    console.log(temp);
}
reverseString("hello");
//Bài 3: Viết function truyền vào mã quốc gia. Trả về message có ý nghĩa là “Xin chào”, tương ứng với mã quốc gia được truyền vào
function  translate(country){
    switch (country) {
        case "VN":
            console.log("Xin Chào");
            break;
        case "EN":
            console.log("Hello");
            break;
        case "JP":
            console.log("Konichowa");
            break;
        default:
            break;
    }
}
translate("JP");
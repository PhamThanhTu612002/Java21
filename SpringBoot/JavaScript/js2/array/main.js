let numbers = [1,2,3,4,5];
numbers.forEach(element => {
    console.log(element);
});

//pop: xóa vào cuối mảng
//push: thêm vào cuối mảng
//shift: xóa vào đầu mảng
//unshift: thêm vào đầu mảng
numbers.unshift(9);
numbers.pop();
numbers.forEach(element => {
    console.log(element);
});
// tách chuỗi con
let sub = numbers.slice(1,3);
console.log(sub);
// sort
let myArr = [6,11,4,6,3,99];
console.log(myArr.sort((a,b) => a - b));
// Đảo ngược
console.log(myArr.reverse());

// split: tách chuỗi thành mảng ký tự dựa trên regex
let char = "a-a-a-a-a-a-a";
let arrChar = char.split("-");
console.log(arrChar);
// join: nối các phần tử của mảng dựa trên regex
let char2 = arrChar.join(",");
console.log(char2);

let arr1 = [1, 2, 3];
let arr2 = [1, 2, 3];
let arr3 = [3, 2, 1];
let str = "1,2,3";

console.log(arr2 == arr2.reverse());

function max(arr){
    arr.sort((a,b) => b-a);
    return arr[0];
}
console.log(max(myArr));

function min(arr){
    arr.sort((a,b) => a-b);
    return arr[0];
}
console.log(min(myArr));
//Viết function cho phép truyền vào 1 mảng các số, kết quả trả về là 1 mảng mới với các số là số dư tương ứng khi chia mảng cũ cho 2
function binary(arr){
    let bin = [];
    arr.forEach(e => {
        if(e % 2 == 0){
            bin.push(0);
        }else{
            bin.push(1);
        }
    });
    return bin;
}
console.log(binary(myArr));

function repeatString(str){
    let arrA = [];
    for(let i = 0; i < 10; i++){
        arrA.push(str);
    }
    return arrA.join("");
}
console.log(repeatString("a"));

function repeatString2(str){
    let arrA = [];
    for(let i = 0; i < 10; i++){
        arrA.push(str);
    }
    return arrA.join("-");
}
console.log(repeatString2("a"));

function isSymmetricString(string){
    let sub = [];
    for(let i = 0; i < string.length; i++){
        if(string[i] != " "){
            sub.push(string[i]);
        }
    }
    if (string.toLocaleUpperCase().split(" ").join("") == sub.reverse().join("").toLocaleUpperCase()){
        return true;
    }else{
        return false;
    }
}
console.log(isSymmetricString("Race car"));
//Viết function truyền vào 1 số nguyên, hãy sắp xếp lại các chữ số trong số nguyên đó sao cho ra 1 số nhỏ nhất có thể (không tính số 0 đầu tiên).
function arrSort(num){
    let arr = [];
    while(num > 10){
        arr.push(num % 10);
        num = parseInt(num / 10);
    }
    arr.push(num);
    arr.sort((a,b) => a-b);
    for( let i = 0; i < arr.length; i ++){
        if(arr[i] != 0){
            let temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            break;
        }
    }
    return arr.join("");
}
console.log(arrSort(14350));

//map() giống stream().map() trong java
// Duyệt qua các phần tử của mảng và thực hiện các thao tác trên các phần tử này.
// Trả về mảng mới có độ dài bằng mảng ban đầu

// filter() giống stream().filter()
// Lặp qua các phần tử của mảng và lọc ra các phần tử thỏa mãn điều kiện nào đó
// Trả về mảng mới

// Danh sách các sản phẩm có trong giỏ hàng
let products = [
    {
        name: "Iphone 13 Pro Max", // Tên sản phẩm
        price: 3000000, // Giá mỗi sản phẩm
        brand: "Apple", // Thương hiệu
        count: 2, // Số lượng sản phẩm trong giỏ hàng
    },
    {
        name: "Samsung Galaxy Z Fold3",
        price: 41000000,
        brand: "Samsung",
        count: 1,
    },
    {
        name: "IPhone 11",
        price: 15500000,
        brand: "Apple",
        count: 1,
    },
    {
        name: "OPPO Find X3 Pro",
        price: 19500000,
        brand: "OPPO",
        count: 3,
    },
]

// 1. In ra thông tin các sản phẩm trong giỏ hàng theo cấu trúc sau
// Tên - Giá - Thương Hiệu - Số lượng
// Ví dụ : OPPO Find X3 Pro - 19500000 - OPPO - 3
console.log(products[3].name +"-"+ products[3].brand +"-"+ products[3].price +"-"+ products[3].count);

// 2. Tính tổng tiền tất cả sản phẩm trong giỏ hàng
// Tổng tiền mỗi sản phẩm = price * count
function sumPrice(){
    let sum = 0;
    for(let i = 0; i < products.length; i++){
        sum = sum + (products[i].price * products[i].count);
    }
    return sum;
}
console.log(sumPrice());
// 3. Tìm các sản phẩm của thuơng hiệu "Apple"

// 4. Tìm các sản phẩm có giá > 20000000

// 5. Tìm các sản phẩm có chữ "pro" trong tên (Không phân biệt hoa thường)

// 6. Thêm 1 sản phẩm bất kỳ vào trong mảng product

// 7. Xóa tất cả sản phẩm của thương hiệu "Samsung" trong giỏ hàng

// 8. Sắp xếp giỏ hàng theo price tăng dần

// 9. Sắp xếp giỏ hàng theo count giảm dần

// 10. Lấy ra 2 sản phẩm bất kỳ trong giỏ hàng

console.log("Hello world");
// alert("Hello world");
// document.write("Hello world");

let age;
console.log(age);// undified;
age = 45;// number

age = "Str";// String

let email = "pttu612002@gmail.com";

const PI = 3.14;

let variable = 0;
console.log(variable);

// template String
let name = "Tú";
let age2 = 18;

console.log(`Xin chào ${name} - ${age2} tuổi`);

let firstName = "Phạm";
let lastName = "Thanh Tú";
let fullName = firstName + " " + lastName;
console.log(fullName);

//Function
//C1: regular funtion
function sum(a,b){
    return a + b;
}

console.log(sum(1,2));

//C2: funtion expression

const sum2 = function(a,b) {
    return a + b;
}
console.log(sum2(4,5));

//C3: arrow function - es6 // lamda expression java 8
// const sum3 = (a,b) => {
//     return a + b;
// }
const sum3 = (a,b) => a+b;
console.log(sum3(5,6));

// default parameters - es6
const sum4 = (a = 10 ,b = 20) => a+b;
console.log(sum4(2));
console.log(sum4());
console.log(sum4(2,3));

// so sánh
console.log(2 == "2");// Number("2")
console.log(2 == 2);

console.log(2 === "2"); // kiểu dữ liệu + giá trị
console.log(1 + "0"); // 1.toString -> "1" + "0" = "10"
console.log("9" / 3);// Number("9") -> 9 / 3 = 3

//lab2
function getMark(mark){
    if (mark >= 85){
        console.log("A");
    }else if (70 <= mark && mark < 85){
        console.log("B");
    }else if(40 <= mark && mark <70){
        console.log("C");
    }else{
        console.log("D");
    }
}
getMark(100);
//Viết function truyền vào 2 số a, b. In ra màn hình số có giá trị lớn hơn

function maxNumber(a,b,c){
    if(c > a && c > b){
        return c;
    }else if(a > b && a > c){
        return a;
    }else{
        return b;
    }
}
console.log(maxNumber(5,4,3));

function findDay(day){
    switch (day) {
        case 0:
            console.log("Hôm nay là chủ nhật");
            break;
        case 1:
            console.log("Hôm nay là thứ 2");
            break;
        case 2:
            console.log("Hôm nay là thứ 3");
            break;
        case 3:
            console.log("Hôm nay là thứ 4");
            break;
        case 4:
            console.log("Hôm nay là thứ 5");
            break;
        case 5:
            console.log("Hôm nay là thứ 6");
            break;
        case 6:
            console.log("Hôm nay là thứ 7");
            break;
        default:
            break;
    }
}
findDay(4);

function seasonMonth(month){
    switch (month) {
        case 1:
        case 2:
        case 3:
            console.log("Mùa xuân");
            break;
        case 4:
        case 5:
        case 6:
            console.log("Mùa hạ");
            break;
        case 7:
        case 8:
        case 9:
            console.log("Mùa thu");
            break;
        case 10:
        case 11:
        case 12:
            console.log("Mùa đông");
            break;
        default:
            break;
    }
}
seasonMonth(11);

function repeatString(string){
    result = "";
    for (let i = 0; i < 10; i++){
        result += string;
    }
    console.log(result);
}
repeatString("a");

function repeatString2(string){
    result = string;
    for (let i = 0; i < 9; i++){
        result += "-"+ string;
    }
    console.log(result);
}
repeatString2("a");

function repeatString3(string,num){
    result = string;
    for (let i = 0; i < num-1; i++){
        result += "-"+ string;
    }
    console.log(result);
}
repeatString3("a",5);

//Tính tổng các số chia hết cho 5 từ 0 -> 100
function sum5(){
    sum = 0;
    for(let i = 0; i <= 100; i++){
        if(i % 5 == 0){
            sum+=i;
        }
    }
    console.log(sum);
}
sum5();

function calVol(r){
    return (4/3)*Math.PI*r*r*r;
}
console.log(calVol(3));

//Viết hàm truyền vào 2 số nguyên, tính tổng tất cả các số nguyên nằm giữa chúng. Ví dụ với tham số 3 và 8 ta có kết quả là 22 (bằng 4 + 5 + 6 + 7).
function sumMid(a,b){
    if(a>b){
        sum = 0;
        for( let i = b+1; i < a; i++){
            sum += i;
        }
    }else if(a<b){
        sum = 0;
        for( let i = a+1; i < b; i++){
            sum += i;
        }
    }else{
        sum=0;
    }
    console.log(sum);
}
sumMid(8,3);
sumMid(3,8);
//Cho 1 số, kiểm tra xem số đó có phải là số nguyên tố hay không, kết quả trả về true hoặc false.
function checkSNT(num){
    if (num < 2) {
        return false;
    }
    // check so nguyen to khi n >= 2
    squareRoot = Math.sqrt(num);
    for (let i = 2; i <= squareRoot; i++) {
        if (num % i == 0) {
            return false;
        }
    }
    return true;
}
console.log(checkSNT(2));

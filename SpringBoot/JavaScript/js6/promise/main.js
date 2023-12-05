// const promise = new Promise (function (resolve,reject){

// });
// console.log(promise);
// const promiseSucces = new Promise (function (resolve,reject){
//     resolve("Mua xe thành công");
// });
// console.log(promiseSucces); // stare : fullfilled , result: Mua xe thành công

// const promiseFail = new Promise (function (resolve,reject){
//     reject("Mua xe thất bại");
// });
// console.log(promiseFail); // state : rejected, result: Mua xe thất bại

// Thực hiện công việc nối chuỗi nhau
// 1. Làm bài tập (3s)
// 2. Đá bóng (4s)
// 3. Nấu cơm (5s)
const doTask1 = (name) =>{
    return new Promise((resolve,reject) =>{
        console.log("Bắt đầu công việc");
        console.log(`Thực hiện công việc ${name}`);
        setTimeout(function () {
            resolve(`Hoàn thành công việc ${name}`);
        }, 3000);
    })
}

const doTask2 = (name) =>{
    return new Promise((resolve,reject) =>{
        console.log(`Thực hiện công việc ${name}`);
        setTimeout(function () {
            resolve(`Hoàn thành công việc ${name}`);
        }, 4000);
    })
}

const doTask3 = (name) =>{
    return new Promise((resolve,reject) =>{
        console.log(`Thực hiện công việc ${name}`);
        setTimeout(function () {
            resolve(`Hoàn thành công việc ${name}`);
        }, 5000);
    })
}
//TH1: Nhặt rau - Rửa rau - Luộc rau
// doTask1("Nhặt rau")
//    .then(result => {
//     console.log(result);
//         return doTask2("Rửa rau");    
//    })
//   .then(result => {
//     console.log(result);
//         return doTask3("Luộc rau");    
//    })
//    .then(result => {
//         console.log(result);
//         console.log("Kết thúc công việc");
//    })
//    .catch(err => console.log(err))

//TH2: Ăn cơm - Xem TV - Lướt FB
Promise.all([doTask1("Ăn cơm"),doTask2("Xem TV"),doTask3("Lướt FB")])
   .then((values) => {
        console.log(values);
   })
   .catch((err) => console.log(err));
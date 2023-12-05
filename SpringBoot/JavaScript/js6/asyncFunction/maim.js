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
            // resolve(`Hoàn thành công việc ${name}`);
            reject("Vẩy rau lỗi"); 
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

const doTask = async () =>{
    try {
        let rs1 = await doTask1("Nhặt rau");
        console.log(rs1);
        let rs2 = await doTask2("Rửa rau");
        console.log(rs2);
        let rs3 = await doTask3("Luộc rau");
        console.log(rs3);
        console.log("Hoàn thành công việc");
    } catch (error) {
        console.log(error);
    }
}

doTask();

//TH2: Ăn cơm - Xem TV - Lướt FB

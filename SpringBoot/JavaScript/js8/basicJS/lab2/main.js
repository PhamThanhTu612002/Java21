users = [
    {
        name: "Bùi Công Sơn",
        age: 30,
        isStatus: true
    },
    {
        name: "Nguyễn Thu Hằng",
        age: 27,
        isStatus: false
    },
    {
        name: "Phạm Văn Dũng",
        age: 20,
        isStatus: false
    }
]
function filterUser(users) {
    let listUser =[];
    users.forEach(user => {
        if(user.age > 25  && user.isStatus == true){
            listUser.push(user);
        }
    });
    console.log(listUser);
}
function sortByAge(users) {
    users.sort((a, b) => a.age - b.age);
    console.log(users);
}
sortByAge(users);
filterUser(users);
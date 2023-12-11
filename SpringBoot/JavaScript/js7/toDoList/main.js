const API_URL = "http://localhost:8000/todos";
const todolist = document.getElementById("todolist");
const btnAdd = document.getElementById("btn-add");
const btnSearch = document.getElementById("btn-search");
const getAllToDo = async () => {
    try {
        const allToDO = await axios.get(API_URL);
        console.log(allToDO);
        renderTodo(allToDO);
    } catch (error) {
        console.log(error);
    }
}
function renderTodo(allToDO) {
    let html ="";
    let allTitle = allToDO.data;
    allTitle.forEach(todo => {
        html += `<li>
                    <input type="checkbox" ${todo.status == true ? 'checked' : ''} onchange="toggleStatus(${todo.id})">
                    <span class="${todo.status == true ? 'active' : ''}">${todo.title}</span>
                    <button id="btnEdit" onclick="editToDo(${todo.id})">Sửa</button>
                    <button id="btnDelete" onclick="deleteToDo(${todo.id})">Xóa</button>
                </li>`
    });
    todolist.innerHTML = html;
}
getAllToDo();
const toDoTxt = document.getElementById("todo-input");
btnAdd.addEventListener("click",async () =>{
    if(toDoTxt.value.trim() === ""){
        alert("Không được để trống");
        return;
    }
    try {
        let res = await axios.post(API_URL,{
            title:toDoTxt.value.trim(),
            status: false
        });
    } catch (error) {
        console.log(error);
    }
    getAllToDo();
})
async function deleteToDo(id) {
    try {
        await axios.delete(API_URL+"/"+id);
    } catch (error) {
        console.log(error);
    }
    getAllToDo();
}
async function toggleStatus(id) {
    try {
        let res = await axios.get(API_URL+"/"+id);
        let currentToDo = res.data;
        currentToDo.status = !currentToDo.status;
        await axios.put(API_URL+"/"+id,currentToDo);
    } catch (error) {
        console.log(error);
    }
    getAllToDo();
}
async function editToDo(id) {
    try {
        let res = await axios.get(API_URL+"/"+id);
        let currentToDo = res.data;
        console.log(currentToDo);

        let todoNew = prompt("Nhập toDo mới:",currentToDo.title);
        await axios.put(API_URL+"/"+id,{
            title:todoNew
        });
    } catch (error) {
        console.log(error);
    }
    getAllToDo();
}
const toDoTxt2 = document.getElementById("todo-search");
const listsearch = document.getElementById("listSearch");
btnSearch.addEventListener("click",async () =>{
    if(toDoTxt2.value.trim() === ""){
        alert("Không được để trống");
        return;
    }
    try {
        let res = await axios.get(API_URL+`/?title_like=${toDoTxt2.value.trim()}`);
        const listSearch = res.data;
        let html = "";
        if(listSearch.length > 0){
            listSearch.forEach(toDo => {
                html += `<li>
                        <input type="checkbox" ${toDo.status == true ? 'checked' : ''} onchange="toggleStatus(${toDo.id})">
                        <span class="${toDo.status == true ? 'active' : ''}">${toDo.title}</span>
                        <button id="btnEdit" onclick="editToDo(${toDo.id})">Sửa</button>
                        <button id="btnDelete" onclick="deleteToDo(${toDo.id})">Xóa</button>
                        </li>`
            })
            listsearch.innerHTML = html;
        }else{
            listsearch.innerHTML = `<li>Không tìm thấy</li>`;
        }
    } catch (error) {
        console.log(error);
    }
})
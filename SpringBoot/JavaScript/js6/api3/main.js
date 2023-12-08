const btn = document.getElementById('btn');
const select = document.getElementById('breed-list');
const subList = document.querySelector('.result ul');
const img = document.getElementById("image");

async function getBreedList() {
    let res = await axios.get("https://dog.ceo/api/breeds/list/all");
    renderBreed(res.data.message)
}
function renderBreed(breeds) {
    var keys = Object.keys(breeds);
    keys.forEach(function (key) {
        var option = document.createElement('option');
        option.value = key;
        option.innerHTML = key;
        select.appendChild(option);
    });
}
getBreedList();

btn.addEventListener("click", async () => {
    try {
        
        var selectedOption = select.options[select.selectedIndex];
        var selectedValue = selectedOption.value;
        var api = "https://dog.ceo/api/breed/"+selectedValue+ "/list";
        const rs = await axios.get(api);
        console.log(rs);
        if (rs.data.message.length == 0){
            subList.innerHTML = "<li>Không có sub breed</li>";
        }else{
            var subBreedList = Object.values(rs.data.message);
            let html = "";
            subBreedList.forEach(subBreed => {
                
                html += `<li><a href="#">${subBreed}</a></li>`;
            })
            subList.innerHTML = html;
        }
        const tagA = document.querySelectorAll('a');
        tagA.forEach(tag => {
            tag.addEventListener('click', async () => {
                console.log(tag.innerText);
                let api = "https://dog.ceo/api/breed/"+selectedValue+"/"+tag.innerText+"/images/random";
                const rs = await axios.get(api);
                img.src = rs.data.message;
                console.log(rs);
            })
        })
    } catch (error) {
        console.log(error);
    }
})

